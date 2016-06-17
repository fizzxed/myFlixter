package earroyof.flixter.adapters;

import android.content.Context;
import android.content.res.Configuration;
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
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by earroyof on 6/15/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    private static class ViewHolder{
        ImageView poster;
        TextView title;
        TextView description;
    }

    public MovieArrayAdapter (Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Movie movie = getItem(position);

        ViewHolder viewHolder; // view lookup cache stored in tag
        // Check to see if the existing view is being reused
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            // Find textViews
            viewHolder.title = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.description = (TextView) convertView.findViewById(R.id.tvOverview);
            // Find the imageView
            viewHolder.poster = (ImageView) convertView.findViewById(R.id.ivMovieImage);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        // not needed now that using ViewHolder:
        // ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        // TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        // TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        //clear out the image here
        viewHolder.poster.setImageResource(0);


        // Now we populate the data

        viewHolder.title.setText(movie.getOriginalTitle());
        viewHolder.description.setText(movie.getOverview());

        /* Custom Font Testing
        Typeface customFont = Typeface.createFromAsset(getContext().getAssets(), "fonts/Wisdom Script AJ.ttf");
        tvTitle.setTypeface(customFont);
        */

        // Is current orientation landscape?
        boolean isLandscape = getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        // populating the image into ivImage
        String deltaPoster;
        if (isLandscape) {
            deltaPoster = movie.getBackdropPath();
        } else {
            deltaPoster = movie.getPosterPath();
        }
        Picasso.with(getContext()).load(deltaPoster).transform(new RoundedCornersTransformation(15, 15))
                .fit().placeholder(R.drawable.movie_placeholder).into(viewHolder.poster);


        // return the view
        return convertView;
    }
}
