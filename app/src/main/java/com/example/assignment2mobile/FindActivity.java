package com.example.assignment2mobile;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FindActivity extends AppCompatActivity {
    private DBHandler dbHandler;
    private EditText addressInput, latitudeInput, longitudeInput, idInput;
    Button doneButton, findButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        dbHandler = new DBHandler(this);
        findButton = findViewById(R.id.findButton);
        doneButton = findViewById(R.id.doneButton);
        addressInput = findViewById(R.id.addressInput);
        latitudeInput = findViewById(R.id.latitudeInput);
        longitudeInput = findViewById(R.id.longitudeInput);

        doneButton.setOnClickListener(v -> finish());
        findButton.setOnClickListener(v -> findLocation());

    }
    private void findLocation() {
        String address = addressInput.getText().toString().trim();

        if (address.isEmpty()) {
            Toast.makeText(this, "Please enter an address", Toast.LENGTH_SHORT).show();
            return;
        }

        // Query the database for the given address
        Cursor cursor = dbHandler.getLocationByAddress(address);
        if (cursor != null && cursor.moveToFirst()) {
            // Retrieve latitude and longitude from the cursor
            double latitude = cursor.getDouble(cursor.getColumnIndex("latitude"));
            double longitude = cursor.getDouble(cursor.getColumnIndex("longitude"));

            // Display the results in the EditText fields
            latitudeInput.setText(String.valueOf(latitude));
            longitudeInput.setText(String.valueOf(longitude));

            cursor.close();
        } else {
            // Show a message if the location is not found
            Toast.makeText(this, "Location not found", Toast.LENGTH_SHORT).show();
        }
    }
}