package com.sagu.gyk401;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthFragment extends Fragment {

    public Diet diet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_health, container, false);

        ImageView imageView = view.findViewById(R.id.health_picture);
        TextView title = view.findViewById(R.id.title);

        if (diet != null) {
            imageView.setImageResource(diet.getFoodPicture());
            title.setText(diet.getFoodName());
        }
        return view;
    }


}
