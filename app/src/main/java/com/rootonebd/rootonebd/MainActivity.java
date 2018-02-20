package com.rootonebd.rootonebd;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;

import com.rootonebd.rootonebd.Fragments.HomeFragment;
import com.rootonebd.rootonebd.Utilities.RootOneAppPref;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout rootOneDrawerLayout;
    private FragmentManager manager;
    private NavigationDrawer drawerFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpNavigationDrawer();
        /*Use for Login Check*/
        RootOneAppPref appPref = new RootOneAppPref(this);
        if(appPref.isLogIn()){

        }else{
            finish();
            startActivity(new Intent(getApplicationContext(),LogInActivity.class));
        }

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.main_container,new HomeFragment()).commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void setUpNavigationDrawer() {
        setUpToolbar();
        manager = getSupportFragmentManager();
        rootOneDrawerLayout = findViewById(R.id.drawer_layout);
        drawerFragment =(NavigationDrawer) manager.findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer,rootOneDrawerLayout,toolbar);
        rootOneDrawerLayout.closeDrawer(Gravity.LEFT);
    }

    private void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
