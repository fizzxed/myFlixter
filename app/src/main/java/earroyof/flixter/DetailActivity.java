package earroyof.flixter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import earroyof.flixter.models.Movie;

public class DetailActivity extends AppCompatActivity {
    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        movie = (Movie) getIntent().getSerializableExtra("movie");

        getSupportActionBar().hide(); // Hide ActionBar

        // TextView tvTest = (TextView) findViewById(R.id.tvTest);
        // tvTest.setText(movie.getOriginalTitle());
    }
}
