/**
 * @Author: Yevhen Kuropiatnyk (sba23066)
 * @Description: A simple movie application to comply with CA1 requrements
 */

package com.example.mobiledevca1;

// Standard imports

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.List;

// This import is to efficiently display large sets of data like in my project
// I can add more movies into array easily and it will display them all
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements MovieContract.View {
    private MoviePresenter presenter;
    private MovieModel model;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init Recycler
        recyclerView = findViewById(R.id.recyclerView);

        // Set Layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Init our model
        model = new MovieModel();

        // Init our presenter with current view and model
        presenter = new MoviePresenter(this, model);

        // Get, load and show movies
        presenter.loadMovies();

        // Get, load and show offers
        presenter.loadOffers();
    }

    @Override
    public void showMovies(List<Movie> movies) {

        // Set adapter to recycler
        MovieAdapter adapter = new MovieAdapter(movies, this::onOrderClicked, this::onFeedbackClicked);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showOffers(List<String> offers) {

        // Find the LinearLayout container where to add our offers
        LinearLayout offersContainer = findViewById(R.id.offersContainer);

        // Add offers Header
        TextView offerTextViewHeader = new TextView(this);
        offerTextViewHeader.setClickable(false);
        offerTextViewHeader.setFocusable(false);
        offerTextViewHeader.setText("Special Offers for You Today:");
        offerTextViewHeader.setTextSize(16);
        offerTextViewHeader.setTextColor(Color.parseColor("#FF5722"));
        offersContainer.addView(offerTextViewHeader);

        // Dynamically adding TextViews for each offer we have
        for (String offer : offers) {
            TextView offerTextView = new TextView(this);
            offerTextView.setText("● " + offer);
            offerTextView.setTextSize(18);
            offerTextView.setPadding(0, 16, 0, 16);
            offerTextView.setClickable(true);
            offerTextView.setFocusable(true);
            offerTextView.setBackgroundResource(android.R.drawable.list_selector_background);

            // Set an click listener for each new TextView
            offerTextView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    // Show corresponding offer on click
                    showMessage(offer);
                }

            });

            // Add the TextView to the LinearLayout container
            offersContainer.addView(offerTextView);
        }

    }

    @Override
    public void showOrderForm(Movie movie) {
        // Show Order form
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("title", movie.getTitle());
        startActivity(intent);
    }

    @Override
    public void showFeedbackForm(Movie movie) {
        // Show Feedback form
        Intent intent = new Intent(this, FeedbackActivity.class);
        // Pass a movie title
        intent.putExtra("title", movie.getTitle());
        startActivity(intent);
    }

    @Override
    public void showMessage(String message) {
        // To shorten code: shows messages via Toast
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void onOrderClicked(Movie movie) {
        // Inform our Presenter of user's activity: order button
        presenter.onOrderClicked(movie);
    }

    private void onFeedbackClicked(Movie movie) {
        // Inform our Presenter of user's activity: feedback button
        presenter.onFeedbackClicked(movie);
    }
}
