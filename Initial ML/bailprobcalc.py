import pandas as pd

# Load the CSV data into a DataFrame
data = pd.read_csv("resources/bailprobdata.csv")

def get_bail_probability(first_section, second_section=None, third_section=None):
    # Initialize condition based on the presence of second and third sections
    if second_section is None and third_section is None:
        condition = (data['Column 1'] == first_section) | (data['Column 2'] == first_section)
    elif second_section is not None and third_section is None:
        condition = ((data['Column 1'] == first_section) | (data['Column 2'] == first_section)) & ((data['Column 1'] == second_section) | (data['Column 2'] == second_section))
    else:
        condition = ((data['Column 1'] == first_section) & ((data['Column 2'] == second_section) | (data['Column 3'] == second_section)) & ((data['Column 2'] == third_section) | (data['Column 3'] == third_section)))

    # Filter the data
    filtered_data = data[condition]

    if filtered_data.empty:
        print("No matching rows found.")
    else:
        # Calculate the estimated probability
        total_rows = len(data)
        matching_rows = len(filtered_data)
        estimated_probability = matching_rows / total_rows
        print("The estimated bail probability is:", estimated_probability)

# Take input for the first section
first_section = int(input("Enter the first section: "))

# Ask if the user wants to enter another section (second section)
enter_another_section = input("Do you want to enter another section? (yes/no): ").lower()
if enter_another_section == 'yes':
    second_section = int(input("Enter the next section: "))
else:
    second_section = None

# Ask if the user wants to enter another section (third section)
if second_section is not None:
    enter_another_section = input("Do you want to enter another section? (yes/no): ").lower()
    if enter_another_section == 'yes':
        third_section = int(input("Enter the next section: "))
    else:
        third_section = None
else:
    third_section = None

# Call the function to search and print the result
get_bail_probability(first_section, second_section, third_section)
