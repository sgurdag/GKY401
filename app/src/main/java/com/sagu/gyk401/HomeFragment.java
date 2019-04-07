package com.sagu.gyk401;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        final TextView info = view.findViewById(R.id.info);
        final TextInputEditText weightET = view.findViewById(R.id.weight_input_et);
        final TextInputEditText heightET = view.findViewById(R.id.height_input_et);


        ((Button)view.findViewById(R.id.save_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (weightET.getText().toString().length() > 0
                        && heightET.getText().toString().length() >0){


                    float weight = Float.parseFloat(weightET.getText().toString());
                    float height = Float.parseFloat(heightET.getText().toString());

                    height = height / 100;

                    float result = (weight / ((height * height)));



                    String resultDescription = "";

                    if (result < 15) {
                        resultDescription = "Aşırı Zayıf";
                    } else if (result > 15 && result <= 30) {
                        resultDescription = "Zayıf";
                    } else if (result > 30 && result <= 40) {
                        resultDescription = "Normal";
                    } else if (result > 40) {
                        resultDescription = "Aşırı Şişman (Morbid Obez)";
                    } else {
                        resultDescription = "Aşırı Şişman (Morbid Obez)";
                    }

                    info.setText(resultDescription);


                }else{

                    Toast.makeText(getActivity(), "Kilo ve boy bilgisi giriniz", Toast.LENGTH_SHORT).show();
                }


            }
        });



        return view;
    }
}
