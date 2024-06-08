package com.example.mobiledevca1;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Yevhen K (sba23066)
 * @Date: 05.06.2024
 */

// This class implements Model part of our MPV pattern

public class MovieModel implements MovieContract.Model {

    public MovieModel() {
        // Init with defaults. Created for the future development
    }

    // Emulate API or Database query and get movies data for presenter
    @Override
    public List<Movie> getMovies() {
        return  Arrays.asList(
                new Movie("M3GAN, 2022", "A brilliant toy company roboticist uses artificial intelligence to develop M3GAN, a life-like doll programmed to emotionally bond with her newly orphaned niece. But when the doll’s programming works too well, she becomes overprotective of her new friend with terrifying results", R.drawable.m3gan),
                new Movie("Barbie, 2023", "Barbie and Ken are having the time of their lives in the colorful and seemingly perfect world of Barbie Land. However, when they get a chance to go to the real world, they soon discover the joys and perils of living among humans", R.drawable.barbie),
                new Movie("Challengers, 2024", "Tennis player turned coach Tashi Duncan has taken her husband, Art, and transformed him into a world-famous Grand Slam champion. To jolt him out of his recent losing streak, she signs him up for a ‘Challenger’ event — close to the lowest level of pro tournament — where he finds himself standing across the net from Patrick Zweig, his former best friend and Tashi’s ex-boyfriend", R.drawable.challengers),
                new Movie("M.F.A., 2017", "After the accidental death of her rapist, an art student becomes an unlikely vigilante, set out to avenge college girls whose rapists were not charged", R.drawable.mfa),
                new Movie("Dune: Part Two, 2024", "Follow the mythic journey of Paul Atreides as he unites with Chani and the Fremen while on a path of revenge against the conspirators who destroyed his family. Facing a choice between the love of his life and the fate of the known universe, Paul endeavors to prevent a terrible future only he can foresee.", R.drawable.dune2)
        );
    }

    // Emulate API or Database query and get offers data for presenter
    @Override
    public List<String> getOffers() {
        return Arrays.asList("Buy one get one free", "20% off on weekends");
    }

}