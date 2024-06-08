package com.example.mobiledevca1;

// Implementation of our presenter here

public class MoviePresenter implements MovieContract.Presenter {
    private final MovieContract.View view;
    private final MovieContract.Model model;

    // Initialization
    public MoviePresenter(MovieContract.View view, MovieContract.Model model) {
        this.view = view;
        this.model = model;
    }

    // Get movies from Model and pass to the View
    @Override
    public void loadMovies() {
        view.showMovies(model.getMovies());
    }

    // Get offers from Model and pass to the View
    @Override
    public void loadOffers() {
        view.showOffers(model.getOffers());
    }

    // Show Order form
    @Override
    public void onOrderClicked(Movie movie) {
        view.showOrderForm(movie);
    }

    // Show Feedback form
    @Override
    public void onFeedbackClicked(Movie movie) {
        view.showFeedbackForm(movie);
    }

}
