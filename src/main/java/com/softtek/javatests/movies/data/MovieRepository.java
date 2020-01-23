package com.softtek.javatests.movies.data;

import com.softtek.javatests.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {

    Movie findById(long id);
    Collection<Movie> findByName(String name);
    Collection<Movie> findByDirector(String director);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);

}
