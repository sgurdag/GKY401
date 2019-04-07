package com.sagu.gyk401;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    private ArrayList<Diet> diets;
    private Context context;

    public ListAdapter(ArrayList<Diet> diets, Context context) {
        this.diets = diets;
        this.context = context;
    }

    @Override
    public int getCount() {
        return (diets != null) ? diets.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return diets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_diet_layout,null);

        ImageView foodPicture =  view.findViewById(R.id.custom_diet_food_picture);
        TextView foodName =  view.findViewById(R.id.custom_diet_food_name);
        TextView foodCalorie =  view.findViewById(R.id.custom_diet_food_calorie);

        Diet diet = diets.get(position);
        foodPicture.setImageResource(diet.getFoodPicture());
        foodName.setText(diet.getFoodName());
        foodCalorie.setText(diet.getTotalCalorie());

        return view;
    }
}
