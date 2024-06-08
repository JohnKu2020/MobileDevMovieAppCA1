package com.example.mobiledevca1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
// Class handles Feedback Activity
public class FeedbackActivity extends AppCompatActivity {
    private EditText nameEditText, emailEditText, feedbackEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        //Caching pointers for later use
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        feedbackEditText = findViewById(R.id.feedbackEditText);
        submitButton = findViewById(R.id.submitButton);

        // extract a title from intend and set header text in feedback form
        Intent i = getIntent();
        String movieTitle = i.getStringExtra("title");
        TextView orderTextView = findViewById(R.id.feedbackTextView);
        orderTextView.setText(movieTitle);

        //On Submit button click event function
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Convert field values into strings
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String feedback = feedbackEditText.getText().toString();

                // Validate that the user has filled all the form
                if (name.isEmpty() || email.isEmpty() || feedback.isEmpty() ) {

                    Toast.makeText(FeedbackActivity.this, "Please fill in all the fields!", Toast.LENGTH_SHORT).show();

                } else {

                    // Show user results. ToDO: send via API to a server or save in Database + email user to notify
                    String message = "Feedback Details:\n" +
                            "Name: " + name + "\n" +
                            "Email: " + email + "\n" +
                            "Feedback: " + feedback;
                    Toast.makeText(FeedbackActivity.this, message, Toast.LENGTH_LONG).show();
                    finish();
                }
            }

        });
    }
}
