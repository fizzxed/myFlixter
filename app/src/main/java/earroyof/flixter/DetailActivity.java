package earroyof.flixter;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import earroyof.flixter.models.Movie;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class DetailActivity extends AppCompatActivity {
    Movie movie;
    ImageView ivMovieImage;
    TextView tvTitle;
    RatingBar rbRating;
    TextView tvPopularity;
    TextView tvOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        movie = (Movie) getIntent().getSerializableExtra("movie");

        ActionBar bar = getSupportActionBar();

        assert bar != null;
        bar.setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#606060"))); // Set Color
        bar.setTitle(""); // clear title
        bar.setDisplayHomeAsUpEnabled(true);

        // Find views
        ivMovieImage = (ImageView) findViewById(R.id.ivMovieImage);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        rbRating = (RatingBar) findViewById(R.id.rbRating);
        tvPopularity = (TextView) findViewById(R.id.tvPopularity);
        tvOverview = (TextView) findViewById(R.id.tvOverview);

        // TextView tvTest = (TextView) findViewById(R.id.tvTest);
        // tvTest.setText(movie.getOriginalTitle());

        // Populate the TextViews and RatingBars
        tvTitle.setText(movie.getOriginalTitle());
        String pop = "Popularity: " + ((int) movie.getPopularity());
        tvPopularity.setText(pop);
        tvOverview.setText(movie.getOverview());
        rbRating.setRating((float) movie.getRating());


        // Set ImageView
        Picasso.with(this).load(movie.getBackdropPath()).transform(new RoundedCornersTransformation(15, 15))
                .placeholder(R.drawable.movie_placeholder).into(ivMovieImage);



        /* Change RatingBar color
        LayerDrawable stars = (LayerDrawable) rbRating.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(0).setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        */

        //Drawable drawable = rbRating.getProgressDrawable();
        //drawable.setColorFilter(Color.parseColor("#e1c323"), PorterDuff.Mode.SRC_ATOP);
    }


    // Handle back button in action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}
