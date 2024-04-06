package com.example.raahatapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BailProb extends AppCompatActivity {

    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bail_prob);

        sendButton = findViewById(R.id.button4);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Execute SendRequestTask when the button is clicked
                SendRequestTask sendRequestTask = new SendRequestTask();
                sendRequestTask.execute();
            }
        });
    }

    private class SendRequestTask extends AsyncTask<Void, Void, Integer> {

        @Override
        protected Integer doInBackground(Void... voids) {
            HttpURLConnection urlConnection = null;
            Integer result = null;
            try {
                // URL of the Flask server
                URL url = new URL("http://172.27.49.99:5000/process");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.setDoOutput(true);

                // Create JSON object with parameters
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("param1", 5);
                jsonParam.put("param2", 7);
                jsonParam.put("param3", 3);

                // Write JSON object to the request body
                urlConnection.getOutputStream().write(jsonParam.toString().getBytes());

                // Read response from the server
                InputStream in = urlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parse JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());
                result = jsonResponse.getInt("result");

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return result;
        }

        @Override
        protected void onPostExecute(Integer result) {
            // Handle the result
            if (result != null) {
                // Log the result
                Log.d("BailProb", "Result: " + result);
                // You can use 'result' variable here as needed
            } else {
                Log.e("BailProb", "Failed to retrieve result");
            }
        }
    }
}
