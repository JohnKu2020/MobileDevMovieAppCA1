package com.example.mobiledevca1;

import java.util.List;

// Contract keeps all our interfaces

public interface MovieContract {

    // Interface for our Model
    interface Model {
        List<Movie> getMovies();
        List<String> getOffers();
    }

    // Interface for our View
    interface View {
        void showMovies(List<Movie> movies);
        void showOffers(List<String> offers);
        void showOrderForm(Movie movie);
        void showFeedbackForm(Movie movie);
        void showMessage(String message);
    }

    // Interface for our Presenter
    interface Presenter {
        void loadMovies();
        void loadOffers();
        void onOrderClicked(Movie movie);
        void onFeedbackClicked(Movie movie);
    }

}

