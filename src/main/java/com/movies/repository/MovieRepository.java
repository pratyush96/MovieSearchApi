package com.movies.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movies.model.*;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, String>{


//Find List of all Movies  In a Page with capacity 5 and Sort data by title of the movie
//@Query("SELECT c FROM movie c")
Page<MovieModel> findAll(Pageable pageable);

//Find List of Movie Using Movie Id
Optional<MovieModel> findByMovieIdIgnoreCase(String movieId);

//Find List Of Movie using Title
Optional<MovieModel> findByTitleIgnoreCase(String Title);

//Find List of Movie based on Director , In controller we use filter that only dirctor , title and Type will be shown
List<MovieModel> findByDirectorIgnoreCase(String Director);

//Find List of movies Of the Cast which can substring
//@Query("SELECT c FROM movie c WHERE c.Cast like '% :Cast%' ")
Optional<MovieModel>findByCastContainingIgnoreCase(String CastName);

//Find List of Movies by Director and Title name
Optional<MovieModel> findByDirectorIgnoreCaseAndTitleIgnoreCase(String director,String title);

//Find List Of  movies Based On Cast and Director name
List<MovieModel> findByCastContainingIgnoreCaseAndDirector(String cast,String director);



}

