import pandas as pd
import numpy as np
from pandas import read_csv
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelEncoder
from sklearn.neural_network import MLPClassifier
from sklearn.metrics import accuracy_score

def filter_data_by_budget_range(data, min_budget, max_budget):
    filtered_data = data[(data['budget'] >= min_budget) & (data['budget'] <= max_budget)]
    return filtered_data

def recommend_lawyer(filtered_data_sorted, prioritize_yoe):
    if prioritize_yoe:
        recommended_lawyer = filtered_data_sorted.iloc[0]
    else:
        recommended_lawyer = filtered_data_sorted.iloc[-1]
    return recommended_lawyer

# Load data from CSV file
url = "resources/ids_31-2081.csv"
names = ['unique-id', 'budget', 'yoe', 'complexity', 'duration', 'location']
data = read_csv(url, names=names)

# Check if the dataset is empty
if data.empty:
    print("Error: Dataset is empty!")
    exit()

# Determine the budget range in the dataset
min_budget = data['budget'].min()
max_budget = data['budget'].max()

# Prompt the user to enter the budget range
print(f"Enter the budget range (Minimum: {min_budget}, Maximum: {max_budget}):")
min_budget_input = float(input("Enter the minimum budget: "))
max_budget_input = float(input("Enter the maximum budget: "))

# Check if the user input is within the dataset's budget range
if min_budget_input < min_budget or max_budget_input > max_budget:
    print("Error: Entered budget range is outside the dataset's range!")
    exit()

# Filter data based on budget range
filtered_data = filter_data_by_budget_range(data, min_budget_input, max_budget_input)

# Prompt the user to choose their preference for prioritizing yoe or duration
prioritize_yoe = input("Do you want to prioritize years of experience (yoe)? (yes/no): ").lower() == 'yes'

# Sort filtered data based on years of experience (yoe) or duration
if prioritize_yoe:
    filtered_data_sorted = filtered_data.sort_values(by='yoe', ascending=False)
else:
    filtered_data_sorted = filtered_data.sort_values(by='duration', ascending=True)

# Convert location labels to numerical values using LabelEncoder
label_encoder = LabelEncoder()
filtered_data_sorted['location'] = label_encoder.fit_transform(filtered_data_sorted['location'])

# Recommend the lawyer based on the user's preference
recommended_lawyer = recommend_lawyer(filtered_data_sorted, prioritize_yoe)

# Print the recommended lawyer's information
print("Recommended Lawyer:")
print(recommended_lawyer)

# Assuming the last column is the label and the rest are features
X = filtered_data_sorted.iloc[:, :-1].values
y = filtered_data_sorted.iloc[:, -1].values.astype(np.int64)  # Convert to int64
unique_ids = filtered_data_sorted['unique-id'].values.astype(str)  # Convert to string if not already

# Normalize features
X = (X - X.mean()) / X.std()

# Split data into training and testing sets
X_train, X_test, y_train, y_test, unique_ids_train, unique_ids_test = train_test_split(X, y, unique_ids, test_size=0.2, random_state=42)

# Define the MLP classifier
model = MLPClassifier(hidden_layer_sizes=(128, 128), activation='relu', solver='adam', max_iter=1000, random_state=42)

# Train the model
model.fit(X_train, y_train)

# Evaluate the model
y_pred = model.predict(X_test)
accuracy = accuracy_score(y_test, y_pred)
print("Accuracy:", accuracy)

# Print unique IDs associated with matched instances
matched_ids = unique_ids_test[y_pred == 1]
if len(matched_ids) > 0:
    print("Unique IDs of matched instances:")
    for unique_id in matched_ids:
        print(unique_id)
else:
    print("No matches found.")
