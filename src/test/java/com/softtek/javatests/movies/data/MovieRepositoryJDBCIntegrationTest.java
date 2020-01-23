package com.softtek.javatests.movies.data;

import com.softtek.javatests.movies.model.Genre;
import com.softtek.javatests.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MovieRepositoryJDBCIntegrationTest {

    private MovieRepositoryJDBC movieRepositoryJDBC;
    private DriverManagerDataSource dataSource;

    @Before
    public void setUp() throws Exception {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        movieRepositoryJDBC = new MovieRepositoryJDBC(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {
        Collection<Movie> movies = movieRepositoryJDBC.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "John Doe"),
                new Movie(2, "Memento", 113, Genre.THRILLER, "Aston Parrish"),
                new Movie(3, "Matrix", 136, Genre.ACTION, "John Doe")
        )));
    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepositoryJDBC.findById(2);

        assertThat(movie, is(new Movie(2, "Memento", 113, Genre.THRILLER, "Aston Parrish")));
    }

    @Test
    public void insert_a_movie() {
        Movie movie = new Movie("Super 8", 112, Genre.THRILLER, "Richard Donner");
        movieRepositoryJDBC.saveOrUpdate(movie);

        Movie movieFromDb = movieRepositoryJDBC.findById(4);

        assertThat(movieFromDb, is(new Movie(4, "Super 8", 112, Genre.THRILLER, "Richard Donner")));
    }

    @Test
    public void load_movies_by_name() {
        Movie movie = new Movie("Super 8", 112, Genre.THRILLER, "Richard Donner");
        movieRepositoryJDBC.saveOrUpdate(movie);
        movie = new Movie("Superman", 143, Genre.ACTION, "Lilly Nolan");
        movieRepositoryJDBC.saveOrUpdate(movie);

        Collection<Movie> movies = movieRepositoryJDBC.findByName("super");

        assertThat(movies, is(Arrays.asList(
                new Movie(4, "Super 8", 112, Genre.THRILLER, "Richard Donner"),
                new Movie(5, "Superman", 143, Genre.ACTION, "Lilly Nolan")
        )));
    }

    @Test
    public void load_movies_by_director() {
        Collection<Movie> movies = movieRepositoryJDBC.findByDirector("john");

        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "John Doe"),
                new Movie(3, "Matrix", 136, Genre.ACTION, "John Doe")
        )));
    }

    @After
    public void tearDown() throws Exception {
        // Remove H2 files -- https://stackoverflow.com/a/51809831/1121497
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files"); // "shutdown" is also enough for mem db
    }
}