package com.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


import com.movies.repository.*;
import com.movies.service.MovieService;
import com.movies.model.*;

@SpringBootApplication
public class MovieApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

	

	// @Autowired
	// private MovieRepository movieRepository;
	 
	@Autowired
	private MovieService service;
	@Override
	public void run(String...args) throws Exception {

	String path =args[0];
	service.ReadDataFromExcel(path);

	// -------------- if want to use custom objects comment upper code and use below code--------------------------------//
	//-----------------  upper code is populating database using Excel Template  and below is for Custom input --------------------------------//


	// this.movieRepository.save(new MovieModel("s1","TV Show","3%"," ","JoÃ£o Miguel, Bianca Comparato, Michel Gomes, Rodolfo Valente, Vaneza Oliveira, Rafael Lozano, Viviane Porto, Mel Fronckowiak, Sergio Mamberti, ZezÃ© Motta, Celso Frateschi","USA"));
	// this.movieRepository.save(new MovieModel("s2","Movie","7:19","Jorge Michel"," Grau DemiÃ¡n Bichir, HÃ©ctor Bonilla, Oscar Serrano, Azalia Ortiz, Octavio Michel, Carmen Beato","USA"));
	// this.movieRepository.save(new MovieModel("s3", "Movie","23:59","Gilbert Chan","Tedd Chan, Stella Chung, Henley Hii, Lawrence Koh, Tommy Kuan, Josh Lai, Mark Lee, Susan Leong, Benjamin Lim","USA"));
	// this.movieRepository.save(new MovieModel("s5119","Movie","Real Steel","Shawn Levy","Hugh Jackman, Dakota Goyo, Evangeline Lilly, Anthony Mackie, Kevin Durand, Hope Davis, James Rebhorn, Karl Yune, Olga Fonda, John Gatins","USA"));
	// this.movieRepository.save(new MovieModel("s5949","Movie","Swordfish","Dominic Sena","John Travolta, Hugh Jackman, Halle Berry, Don Cheadle, Sam Shepard, Vinnie Jones, Drea de Matteo, Rudolf Martin, Zach Grenier, Camryn Grimes","USA"));
	// this.movieRepository.save(new MovieModel("s2394","Movie","Ghayal","Rajkumar Santoshi","Sunny Deol, Meenakshi Sheshadri, Amrish Puri, Moushumi Chatterjee, Kulbhushan Kharbanda, Om Puri, Raj Babbar, Shabbir Khan","India"));
	// this.movieRepository.save(new MovieModel("s2396","TV Show","Ghost in the Shell: SAC_2045","Atsuko"," Tanaka, Osamu Saka, Akio Otsuka, Koichi Yamadera, Yutaka Nakano, Toru Okawa, Takashi Onozuka, Taro Yamaguchi, Sakiko Tamagawa, Megumi Han, Kenjiro Tsuda, Kaiji Soze, Shigeo Kiyama","Japan"));
	// this.movieRepository.save(new MovieModel("s2306","Movie","Fukrey","Mrighdeep Singh Lamba","Pulkit Samrat, Manjot Singh, Ali Fazal, Varun Sharma, Richa Chadda, Priya Anand, Vishakha Singh, Pankaj Tripathi","India"));
	// this.movieRepository.save(new MovieModel("s2297","Movie","Froning: The Fittest Man in History","Heber Cannon","Rich Froning","Japan"));
	//


	}
	}

