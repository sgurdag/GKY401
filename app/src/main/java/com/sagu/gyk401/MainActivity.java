package com.sagu.gyk401;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements ListFragment.OnFragmentInteractionListener {
    BottomNavigationView bottomNavigationView;

    Fragment selectedFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomBar);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        selectedFragment = new HomeFragment();

                        break;
                    case R.id.navigation_health:

                        selectedFragment = new HealthFragment();
                        break;
                    case R.id.navigation_diet:
                        ListFragment listFragment = new ListFragment();
                        listFragment.mParam1 = "parametre 1";
                        listFragment.mParam2 = "parametre 2";

                        selectedFragment = listFragment;
                        break;
                }

                pushFragment(selectedFragment);
                return false;
            }
        });

    }

    private void pushFragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();

    }

    @Override
    public void onFragmentInteraction(Diet diet) {

        HealthFragment fragment = new HealthFragment();
        fragment.diet = diet;

        pushFragment(fragment);
    }
}
