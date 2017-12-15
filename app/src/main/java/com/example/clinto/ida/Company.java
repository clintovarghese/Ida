package com.example.clinto.ida;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Company extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,OnFragmentInteractionListener{
    Button bt1,bt2;
    ImageView im1,im2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setContentInsetsAbsolute(0,0);
        bt1=(Button)findViewById(R.id.btn1);
        bt2=(Button)findViewById(R.id.btn2);
        im1=(ImageView)findViewById(R.id.gal);
        im2=(ImageView)findViewById(R.id.news);
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment obj=NewsandEventsFragment.newInstance();
                replacefragmentfornews(obj);

            }
        });
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment obj=ImageFragment.newInstance();
                replacefragment(obj);
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment obj=MemberListfragment.newInstance();
                replacefragmentmember(obj);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment obj=ExecutiveMembers.newInstance();
                replacefragmentmember(obj);
            }
        });

      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.company, menu);
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Fragment obj=ExecutiveMembers.newInstance();
            replacefragmentforExecutivemembers(obj);

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Fragment obj=MemberListfragment.newInstance();
            replacefragmentmember(obj);

        } else if (id == R.id.nav_slideshow) {
            Fragment obj=MyProfile1Fragment.newInstance();
            replacefragment(obj);

        } else if (id == R.id.nav_manage) {
            Fragment obj=NewsandEventsFragment.newInstance();
            replacefragmentfornews(obj);


        } else if (id == R.id.gallery) {
            Fragment obj=ImageFragment.newInstance();
            replacefragment(obj);

        } else if (id == R.id.notification) {
            Fragment obj=NotificationFragment.newInstance();
            replacefragmentfornotification(obj);


        } else if(id ==R.id.contacts){
            Intent iii=new Intent(getApplicationContext(),DemoAcivity.class);
            startActivity(iii);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replacefragmentforExecutivemembers(Fragment obj5) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.relav,obj5);
        ft.commit();
    }

    private void replacefragmentfornotification(Fragment obj3) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.relav,obj3);
        ft.commit();

    }

    private void replacefragmentfornews(Fragment obj2) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.relav,obj2);
        ft.commit();
    }

    private void replacefragmentmember(Fragment obj1) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.relav,obj1);
        ft.commit();

    }

    private void replacefragment(Fragment obj) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.relav,obj);
        ft.commit();
    }
    @Override
    public void onFragmentInteraction(String uri) {
        getSupportActionBar().setTitle(uri);

    }
    @Override
    public void changeTitle(String title) {
        getSupportActionBar().setTitle(title);

    }


}