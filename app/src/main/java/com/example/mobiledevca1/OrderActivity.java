package com.example.mobiledevca1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// Class handles Order Activity
public class OrderActivity extends AppCompatActivity {
    private EditText nameEditText, emailEditText, phoneEditText, seatEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //Caching pointers for later use
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        seatEditText = findViewById(R.id.seatEditText);
        submitButton = findViewById(R.id.submitButton);

        // extract a title from intend and set header text in order form
        Intent i = getIntent();
        String movieTitle = i.getStringExtra("title");
        TextView orderTextView = findViewById(R.id.orderTextView);
        orderTextView.setText(movieTitle);

        //On Submit button push function
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Convert them to strings
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String seat = seatEditText.getText().toString();

                // Validate that the user has filled all the form
                if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || seat.isEmpty()) {

                    Toast.makeText(OrderActivity.this, "Please fill in all the fields!", Toast.LENGTH_SHORT).show();

                } else {
                    // Show user results. ToDO: send via API to a server or save in Database + email user to notify
                    String message = "Order Details:\n" +
                            "Name: " + name + "\n" +
                            "Email: " + email + "\n" +
                            "Phone: " + phone + "\n" +
                            "Seat: " + seat;
                    Toast.makeText(OrderActivity.this, message, Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }
}

