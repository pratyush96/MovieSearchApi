package com.movies.controller;




import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.movies.repository.*;
import com.movies.exception.ApiException;
import com.movies.model.*;


	@RestController
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping("api")
	public class MovieController {

	@Autowired
	private MovieRepository movieRepository;
	// private MovieModel movieModel;
	// @Autowired
	// private Environment environment;

	// -----------ALL SEARCHES ARE CASE INSENSITIVE AND EXAMPLE URL ARE GIVEN AS COMMENT JUST ABOVE THE REST ENDPOINTS--------   //
	//--------Added Optional class and method  to handle null and give specification message-------------------//

	@GetMapping("/movie/{page}")
	//Find List of all Movies  In a Page with capacity 5 and Sort data by title of the movie
	public ResponseEntity<Page<MovieModel>> getMovie(@PathVariable("page") Integer page){
	Sort sort=Sort.by("title");
	Pageable pageable= PageRequest.of(page, 5,sort);
	return new ResponseEntity<>(movieRepository.findAll(pageable),HttpStatus.OK);
	}

	//(url=http://localhost:8080/api/s3)
	@GetMapping("/{movieId}")
	//Find List of Movie Using Movie Id
	public Optional<MovieModel> getMovieById(@PathVariable("movieId") String movieId) throws ApiException {
	Optional<MovieModel> optional =movieRepository.findByMovieIdIgnoreCase(movieId) ;
	optional.orElseThrow(()-> new ApiException("No Movie found with given id : "+movieId));
	return movieRepository.findByMovieIdIgnoreCase(movieId);


	}

	//  (url=http://localhost:8080/api//movie/title?title=Fukrey)
	@GetMapping("/movie/title")
	//Find List Of Movie using Title
	public ResponseEntity<Optional<MovieModel>> getMovieByName(@RequestParam("title") String title){
	Optional<MovieModel> movieModel= movieRepository.findByTitleIgnoreCase(title);
	movieModel.orElseThrow(()-> new ApiException(title+" not present please search for another title"));
	return new ResponseEntity<>(movieRepository.findByTitleIgnoreCase(title),HttpStatus.OK);
	}


	//(url= http://localhost:8080/api//movie/director?director=Gilbert Chan)
	@GetMapping("/movie/director")
	//Find List of Movie based on Director , In controller we use filter that only dirctor , title and Type will be shown
	public List<String> getMovieByDirector(@RequestParam String director){
	return movieRepository.findByDirectorIgnoreCase(director).stream().map((e)->"Director : " +e.getDirector()+" Title : "+e.getTitle()+" Type : "+e.getMovieType()).collect(Collectors.toList());
	}

	// (url=http://localhost:8080/api//movie/Cast/Hugh Jackman)
	@GetMapping("/movie/Cast/{CastName}")
	//Find List of movies Of the Cast which can substring
	public ResponseEntity<Optional<MovieModel>> getMovieByCast(@PathVariable String CastName){
	Optional<MovieModel> movieByCast=movieRepository.findByCastContainingIgnoreCase(CastName);
	movieByCast.orElseThrow(()->new ApiException(CastName+" not present please search for another"));
	return new ResponseEntity<>(movieRepository.findByCastContainingIgnoreCase(CastName),HttpStatus.OK);
	}

	//  (url=http://localhost:8080/api//movie/Mrighdeep Singh Lamba/title?title=Fukrey)
	@GetMapping("/movie/{director}/title")
	//Find List of Movies by Title and  Director name
	public ResponseEntity<Optional<MovieModel>> getMovieByTitleAndDirector(@PathVariable String director,@RequestParam("title") String title){
	Optional<MovieModel> movieModel = movieRepository.findByDirectorIgnoreCaseAndTitleIgnoreCase(director,title);
	movieModel.orElseThrow(()->new ApiException("Exception raised"));
	return new ResponseEntity<>(movieRepository.findByDirectorIgnoreCaseAndTitleIgnoreCase(director,title),HttpStatus.OK);
	}

	// (url=http://localhost:8080/api//movie/Cast//Hugh Jackman/Director?Director=Shawn Levy)
	@GetMapping("/movie/Cast/{CastName}/Director")
	//Find List Of  movies Based On Cast and Director name
	public ResponseEntity<List<MovieModel>> getMovieByCastAndDirector(@PathVariable String CastName,@RequestParam String Director){
	return new ResponseEntity<>(movieRepository.findByCastContainingIgnoreCaseAndDirector(CastName,Director),HttpStatus.OK);
	}

	}



