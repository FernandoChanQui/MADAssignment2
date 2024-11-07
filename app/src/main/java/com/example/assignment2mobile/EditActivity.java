package com.example.assignment2mobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {
    private DBHandler dbHandler;
    private EditText addressInput, latitudeInput, longitudeInput;
    private Button saveButton, cancelButton, deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        dbHandler = new DBHandler(this);

        addressInput = findViewById(R.id.addressInput);
        latitudeInput = findViewById(R.id.latitudeInput);
        longitudeInput = findViewById(R.id.longitudeInput);
        saveButton = findViewById(R.id.saveButton);
        cancelButton = findViewById(R.id.cancelButton);
        deleteButton = findViewById(R.id.deleteButton);

        cancelButton.setOnClickListener(v -> finish());
        saveButton.setOnClickListener(v -> updateLocation());
        deleteButton.setOnClickListener(v -> deleteLocation());
    }

    private void updateLocation() {
        String address = addressInput.getText().toString().trim();
        String latitudeText = latitudeInput.getText().toString().trim();
        String longitudeText = longitudeInput.getText().toString().trim();

        if (address.isEmpty() || latitudeText.isEmpty() || longitudeText.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double latitude;
        double longitude;
        try {
            latitude = Double.parseDouble(latitudeText);
            longitude = Double.parseDouble(longitudeText);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid latitude or longitude", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean success = dbHandler.updateLocationByAddress(address, latitude, longitude);
        if (success) {
            Toast.makeText(this, "Location updated successfully", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Location not found", Toast.LENGTH_SHORT).show();
        }

    }

    private void deleteLocation() {
        String address = addressInput.getText().toString().trim();

        if (address.isEmpty()) {
            Toast.makeText(this, "Please enter an address", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean success = dbHandler.deleteLocationByAddress(address);
        if (success) {
            Toast.makeText(this, "Location deleted successfully", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Location not found", Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}
