package com.example.fragment_ryuza_29;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.navbar_bottom);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new DashboardFragment()).commit();
        navigationView.setSelectedItemId(R.id.dahsboard);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.dahsboard:
                        fragment = new DashboardFragment();
                        break;
                    case R.id.info:
                        fragment = new InfoFragment();
                        break;
                    case R.id.pesan:
                        fragment = new PesanFragment();
                        break;
                    case R.id.profile:
                        fragment = new UserFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();

                return false;
            }
        });
    }
}