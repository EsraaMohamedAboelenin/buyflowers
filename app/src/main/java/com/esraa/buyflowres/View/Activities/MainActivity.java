package com.esraa.buyflowres.View.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.esraa.buyflowres.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavController navController=Navigation.findNavController(this,R.id.nav_host);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bootom_nav);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }
}
