package com.stephentuso.welcome.ui.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.stephentuso.welcome.R;
import com.stephentuso.welcome.ui.WelcomeScreenPage;

/**
 * Created by stephentuso on 11/15/15.
 * A simple fragment that shows an image, a heading, and a description.
 */
public class BasicWelcomeFragment extends Fragment implements WelcomeScreenPage.OnChangeListener {

    public static final String KEY_DRAWABLE_ID = "drawable_id";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_TITLE = "title";

    private ImageView imageView = null;
    private TextView titleView = null;
    private TextView descriptionView = null;

    public static BasicWelcomeFragment newInstance(@DrawableRes int drawableId, String title, String description) {
        Bundle args = new Bundle();
        args.putInt(KEY_DRAWABLE_ID, drawableId);
        args.putString(KEY_TITLE, title);
        args.putString(KEY_DESCRIPTION, description);
        BasicWelcomeFragment fragment = new BasicWelcomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basic, container, false);

        Bundle args = getArguments();

        imageView = (ImageView) view.findViewById(R.id.image);
        titleView = (TextView) view.findViewById(R.id.title);
        descriptionView = (TextView) view.findViewById(R.id.description);

        if (args == null)
            return view;

        imageView.setImageResource(args.getInt(KEY_DRAWABLE_ID));

        if (args.getString(KEY_TITLE) != null)
            titleView.setText(args.getString(KEY_TITLE));

        if (args.getString(KEY_DESCRIPTION) != null)
            descriptionView.setText(args.getString(KEY_DESCRIPTION));


        return view;
    }


    @Override
    public void onScrolled(int pageIndex, float offset, int offsetPixels) {
        if (Build.VERSION.SDK_INT >= 11 && imageView != null) {
            imageView.setX(-offsetPixels * 0.8f);
        }
    }

    @Override
    public void onSelected(int pageIndex) {

    }

    @Override
    public void onScrollStateChanged(int state) {

    }
}
