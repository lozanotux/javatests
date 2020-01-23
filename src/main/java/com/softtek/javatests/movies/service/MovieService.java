package com.softtek.javatests.movies.service;

import com.softtek.javatests.movies.data.MovieRepository;
import com.softtek.javatests.movies.model.Genre;
import com.softtek.javatests.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());

    }

    public Collection<Movie> findMoviesByLength(int length) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }

    public Collection<Movie> findByName(String name) {
        return movieRepository.findByName(name).stream()
                .filter(movie -> (movie.getName()).contains(name)).collect(Collectors.toList());
    }

    public Collection<Movie> findByDirector(String director) {
        return movieRepository.findByDirector(director).stream()
                .filter(movie -> (movie.getDirector()).contains(director)).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByTemplate(Movie template) {
        Collection<Movie> returnMovies = movieRepository.findAll();

        if (template.getMinutes() < 0) {
            throw new IllegalArgumentException("This value is not allowed");
        } else {
            returnMovies = returnMovies.stream().filter(movie -> movie.getMinutes() < template.getMinutes())
                    .collect(Collectors.toList());
        }

        if (template.getName() != null) {
            returnMovies = returnMovies.stream().filter(movie -> movie.getName().toLowerCase()
                    .contains(template.getName().toLowerCase())).collect(Collectors.toList());
        }

        if(template.getGenre() != null) {
            returnMovies = returnMovies.stream().filter(movie -> movie.getGenre()
                    .equals(template.getGenre())).collect(Collectors.toList());
        }

        if (template.getDirector() != null) {
            returnMovies = returnMovies.stream().filter(movie -> movie.getDirector()
                    .toLowerCase().contains(template.getDirector().toLowerCase())).collect(Collectors.toList());
        }

        return returnMovies;
    }

}
