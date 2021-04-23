package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.MovieDto;
import pl.edu.pwsztar.domain.entity.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class MovieListMapper implements Converter<List<MovieDto>, List<Movie>> {

    @Override
    public List<MovieDto> convert(List<Movie> movies) {
        List<MovieDto> moviesDto = new ArrayList<>();
        Stream<Movie> movieStream = movies.stream();

        movieStream.forEach(movie ->

             moviesDto.add( new MovieDto.Builder()
                    .movieId(movie.getMovieId())
                    .title(movie.getTitle())
                    .image(movie.getImage())
                    .year(movie.getYear())
                    .build()
        ));
       //moviesStream.map(MoviesDto::from).collectors.CollectToList()

        return moviesDto;
    }
}
