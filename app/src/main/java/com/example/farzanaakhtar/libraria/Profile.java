package com.example.farzanaakhtar.libraria;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import utils.arrays;

public class Profile extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView welcome;
    public static TextView books[] = new TextView[9];
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        books[0] = (TextView) findViewById(R.id.book1);
        books[1] = (TextView) findViewById(R.id.book2);
        books[2] = (TextView) findViewById(R.id.book3);
        books[3] = (TextView) findViewById(R.id.book4);
        books[4] = (TextView) findViewById(R.id.book5);
        books[5] = (TextView) findViewById(R.id.book6);
        books[6] = (TextView) findViewById(R.id.book7);
        books[7] = (TextView) findViewById(R.id.book8);
        books[8] = (TextView) findViewById(R.id.book9);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                visitCatalog();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Bundle b = getIntent().getExtras();
        String identify[] = b.getStringArray("id");
        String name = arrays.combo.get(identify[0]);

        int numberOfBooks = arrays.top;
        welcome = (TextView) findViewById(R.id.welcome);
        welcome.setText("Hi, "+ name + ". You can issue upto " + (9 - numberOfBooks) + " books right now.");

        // visibility for fab button
        int fabVis = fab.getVisibility();
        if (fabVis == View.VISIBLE)
        {
            if (numberOfBooks == 9)
                fab.setVisibility(View.GONE);
        }
        else
        {
            if (numberOfBooks != 9)
                fab.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Toast.makeText(Profile.this, "Item selected", Toast.LENGTH_SHORT).show();
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            //Toast.makeText(Profile.this, "Item selected", Toast.LENGTH_SHORT).show();
            visitCatalog();
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void visitCatalog()
    {
        Intent i = new Intent(this, Catalouge.class);
        startActivity(i);
    }
}
