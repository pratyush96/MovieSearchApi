package com.movies.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.poi.ss.usermodel.Row;

@Entity
@Table(name="movie")
public class MovieModel {
@Id
//@Column(name="Id")
// @GeneratedValue(strategy = GenerationType.IDENTITY)
//private Long id;
@Column(name="MovieId")
private String movieId;
@Column(name="MovieType")
private String movieType;
@Column(name="Title")
private String title;
@Column(name="Director")
private String director;
@Column(name="Cast")
private String cast;
@Column(name= "Country")
private String country;

//Default
public MovieModel() {}

//Arguement Constructor
public MovieModel(String movieId, String movieType, String title, String director, String cast,String country) {
super();
this.movieId = movieId;
this.movieType = movieType;
this.title = title;
this.director = director;
this.cast = cast;
this.country=country;
}

//Populating row from excel using Constructor takes row as a args
public MovieModel(Row row) {
super();
this.movieId = row.getCell(0).toString();
this.movieType = row.getCell(1).toString();
this.title =row.getCell(2).toString();
this.director = row.getCell(3).toString();
this.cast = row.getCell(4).toString();
this.country=row.getCell(5).toString();
}

//Generic Population strategy of model object using excel

// public void objectMapper(Row row) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
// setCast(row.getCell(0).toString());
// //final Object o1="";
// int count=0;
// MovieModel o=new MovieModel();
// for (Method m : o.getClass().getMethods()) {
//    if (m.getName().startsWith("set")) {
//     m.invoke(o,row.getCell(count).toString());
//     count++;
//     System.out.println(count);
//    }
// }
// }

//Getter nad Setters

public String getMovieId() {
return movieId;
}
public void setMovieId(String movieId) {
this.movieId = movieId;
}
public String getMovieType() {
return movieType;
}
public void setMovieType(String movieType) {
this.movieType = movieType;
}
public String getTitle() {
return title;
}
public void setTitle(String title) {
this.title = title;
}
public String getDirector() {
return director;
}
public void setDirector(String director) {
this.director = director;
}
public String getCast() {
return cast;
}
public void setCast(String cast) {
this.cast = cast;
}


public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}


}
