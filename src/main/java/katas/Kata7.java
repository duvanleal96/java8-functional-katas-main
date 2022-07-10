package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                        .map(movieList -> movieList.getVideos())
                                .flatMap(movies -> movies.stream())
                                        .map(movie ->
                                                ImmutableMap.of("id",movie.getId(),"tille",movie.getTitle(),"boxart",movie.getBoxarts().stream()
                                                        .reduce((a,b)->(a.getHeight()* a.getWidth()> b.getHeight()* b.getWidth())? a:b)
                                                        .get().getUrl()))
                .collect(Collectors.toList());
    }
}
