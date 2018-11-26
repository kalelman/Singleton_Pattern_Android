package com.kalelman.singleton_pattern_android;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer)
    DrawerLayout drawerLayout;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(R.string.toolbar_title);
        }

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()) {
                    case R.id.comedy:
                        ContentFragment fragment = new ContentFragment();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment, fragment);
                        transaction.addToBackStack(null); // just for remember the capacity to come back to the previus fragment
                        transaction.commit();

                        Toast.makeText(MainActivity.this, "Comedy", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.drama:
                        ContentFragmentDrama fragmentDrama = new ContentFragmentDrama();
                        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
                        t.replace(R.id.fragment, fragmentDrama);
                        t.addToBackStack(null);
                        t.commit();

                        Toast.makeText(MainActivity.this, "Drama", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.mistery:
                        ContentFragmentMistery fragmentMistery = new ContentFragmentMistery();
                        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
                        trans.replace(R.id.fragment, fragmentMistery);
                        trans.addToBackStack(null);
                        trans.commit();

                        Toast.makeText(MainActivity.this, "Mistery", Toast.LENGTH_SHORT).show();
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }
}
