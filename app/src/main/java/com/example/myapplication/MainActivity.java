package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView=findViewById(R.id.bottomNavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new ImageFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment=null;
                switch (item.getItemId()){
                    case  R.id.home:
                        fragment=new ImageFragment();
                        break;
                    case  R.id.list:
                        fragment=new ListFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                return false;
            }
        });
    }
}