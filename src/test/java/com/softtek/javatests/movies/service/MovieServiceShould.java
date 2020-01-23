package com.softtek.javatests.movies.service;

import com.softtek.javatests.movies.data.MovieRepository;
import com.softtek.javatests.movies.model.Genre;
import com.softtek.javatests.movies.model.Movie;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {

    private MovieRepository movieRepository;
    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION, "John Doe"),
                        new Movie(2, "Memento", 113, Genre.THRILLER, "Aston Parrish"),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY, "Scot William"),
                        new Movie(4, "Super 8", 112, Genre.THRILLER, "Quentin Tarantino"),
                        new Movie(5, "Scream", 111, Genre.HORROR, "Sam Raimi"),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY, "Richard Donner"),
                        new Movie(7, "Matrix", 136, Genre.ACTION, "John Doe")
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        assertThat(getMovieIds(movies), is(Arrays.asList(3, 6)));

    }

    @Test
    public void return_movies_by_length() {
        Collection<Movie> movies = movieService.findMoviesByLength(119);
        assertThat(getMovieIds(movies), is(Arrays.asList(2, 3, 4, 5, 6)));
    }

    @Test
    public void return_movies_by_template() {
        String name = null; // no queremos buscar por nombre
        int minutes = 150; // 2h 30m
        Genre genre = Genre.ACTION;
        assertThat(getMovieIds(movieService.findMoviesByTemplate(
                new Movie(name, minutes, genre, null))),
                is(Arrays.asList(7)) );
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}