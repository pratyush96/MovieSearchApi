# MovieSearchApi

This is Movie search api implemented using Spring Boot ,JPA and RestApi
and H2(In Memory DataBase) DataBase Get Populated by data from Excel Template.

Please Provide your own  Path In ( Run Configuration in Eclipse/STS) or as Argument before running

Excel Template has been placed in src/main/resource.

All searches are Case Insensitive  .


---Data is populated using Excel or new object are written in comments.
---Search Can be perforn on multiple fields.
---Sorting based on title
---Pagintion has been Implemented for getAllMovie.

Implementations :

>MovieController class:This is the rest controller which accepts requests and call endpoints as
per request.

Please Find Specific Example URL to hit RestEndPoints

In this we can search for movies based on various conditions :
. getMovie()--> Return List of movies in page of capacity 5 and sorted based on title .
Increment page number to view diffrent resouce.
url:- { http://localhost:8080/api/movie/0}

. getMovieById()-->Return specific Movie eith the given Id.
url:-  { http://localhost:8080/api/s1 }
     
.getMovieByTitle()--> Search movie on the basis of title if it returns null a
     User defined message will be thrown as a exception
url:-     { http://localhost:8080/api//movie/title?title=Fukrey }

.getMovieByDirector()-> return list of movies based on director
url:- { http://localhost:8080/api//movie/director?director=Gilbert Chan }

.getMovieByCast()--> return list of movies in which the given cast is present. Cast can be search as single or substring of cast.
url:-       { http://localhost:8080/api//movie/Cast/Hugh Jackman }

.getMovieByDirectorAndTitle()--> return particular movie of director
url:-   { http://localhost:8080/api//movie/Mrighdeep Singh Lamba/title?title=Fukrey }

.getMovieByCastAndDirector() ---> return movies in which director and cast are same
url:-   { http://localhost:8080/api//movie/Cast//Hugh Jackman/Director?Director=Shawn Levy }

*Any method which return null will be handeled with user defined exception message.

>MovieException : this package contains UserDefined Exception class and Handler class
alongth with proper error object .

>MovieModel : Contains the Entity class with for mapping to database .

>MovieRepository: This the Repository class which will persist data into the InMemory Database

>MovieService : This is the service class which take input from Excel Template and Populate data to object and
Persist to DataBase.

HOW TO RUN :

You Can Run This Application From Eclipse/STS(Preffer) Run as SpringBootApplication Before That provide Excel path as Argument in CMD or Run Configuration.

Hit The URL from PostMan or directly from Browser and check the result returned as JSON Reposnse.

