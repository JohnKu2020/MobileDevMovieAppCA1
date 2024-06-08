package com.example.mobiledevca1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

//Show movies from array using RecyclerView
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private final List<Movie> movies;
    private final OnItemClickListener orderClickListener;
    private final OnItemClickListener feedbackClickListener;

    public interface OnItemClickListener {
        void onItemClick(Movie movie);
    }

    // Init Adapter itself
    public MovieAdapter(List<Movie> movies, OnItemClickListener orderClickListener, OnItemClickListener feedbackClickListener) {
        this.movies = movies;
        this.orderClickListener = orderClickListener;
        this.feedbackClickListener = feedbackClickListener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    // Init all fields with movie data
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.titleTextView.setText(movie.getTitle());
        holder.descriptionTextView.setText(movie.getDescription());
        Glide.with(holder.movieImageView.getContext()).load(movie.getImageResId()).into(holder.movieImageView);
        holder.orderButton.setOnClickListener(v -> orderClickListener.onItemClick(movie));
        holder.feedbackButton.setOnClickListener(v -> feedbackClickListener.onItemClick(movie));
    }

    // Get count of movies in array
    @Override
    public int getItemCount() {
        return movies.size();
    }

    // MovieViewHolder class
    static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;
        ImageView movieImageView;
        Button orderButton;
        Button feedbackButton;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            //Caching all pointers
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            movieImageView = itemView.findViewById(R.id.movieImageView);
            orderButton = itemView.findViewById(R.id.orderButton);
            feedbackButton = itemView.findViewById(R.id.feedbackButton);
        }
    }
}
