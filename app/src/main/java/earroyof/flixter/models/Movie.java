package earroyof.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by earroyof on 6/15/16.
 */
public class Movie implements Serializable {
    String posterPath;
    String originalTitle;
    String overview;
    String backdropPath;
    String id;
    double rating;
    double popularity;
    double videoURL;

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle + " id: " + id;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdropPath() { return String.format("https://image.tmdb.org/t/p/w1280/%s", backdropPath); }

    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.id = jsonObject.getString("id");
        this.rating = jsonObject.getDouble("vote_average");
        this.popularity = jsonObject.getDouble("popularity");
    }

    public static ArrayList<Movie> fromJsonArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();

        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(new Movie(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

    public static ArrayList<Movie> getFakeMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        return movies;
    }
}
