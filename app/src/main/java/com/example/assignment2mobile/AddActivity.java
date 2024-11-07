package com.example.assignment2mobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class AddActivity extends AppCompatActivity {
    private DBHandler dbHandler;
    private EditText addressInput, latitudeInput, longitudeInput;
    Button cancelButton, addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        dbHandler = new DBHandler(this);

        addButton = findViewById(R.id.addButton);
        cancelButton = findViewById(R.id.cancelButton);

        addressInput = findViewById(R.id.addressInput);
        latitudeInput = findViewById(R.id.latitudeInput);
        longitudeInput = findViewById(R.id.longitudeInput);

        cancelButton.setOnClickListener(v -> finish());
        addButton.setOnClickListener(v -> addLocation());

    }
    private void addLocation() {
        String address = addressInput.getText().toString();
        double latitude = Double.parseDouble(latitudeInput.getText().toString());
        double longitude = Double.parseDouble(longitudeInput.getText().toString());

        dbHandler.addLocation(address, latitude, longitude);

        Toast.makeText(this, "Location added", Toast.LENGTH_SHORT).show();
        finish();
    }
}