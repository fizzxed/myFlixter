package earroyof.flixter.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import earroyof.flixter.R;
import earroyof.flixter.models.Movie;

/**
 * Created by earroyof on 6/15/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter (Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Movie movie = getItem(position);

        // Check to see if the existing view is being reused
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
        }

        // Find the imageView
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        //clear out the image here
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        // Now we populate the data

        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());

        // populating the image into ivImage
        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);

        //getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE

        // return the view
        return convertView;
    }
}
