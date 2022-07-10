package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .map(movie ->movie.getBoxarts())
                .flatMap(boxArts -> boxArts.stream())
                .reduce((a,b)->(a.getHeight()* a.getWidth()> b.getHeight()* b.getHeight()) ? a:b)
                .get().getUrl();
    }
}
