package com.example.ea.prolink;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class DrawerActivity extends AppCompatActivity {

        protected DrawerLayout mDrawerLayout;
        public ActionBarDrawerToggle mtoggle;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_drawer);
            mDrawerLayout=findViewById(R.id.drawer);
            mtoggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
            mDrawerLayout.addDrawerListener(mtoggle);
            mtoggle.syncState();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if(mtoggle.onOptionsItemSelected(item)){
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

        public void dashboard(MenuItem item) {
            startActivity(new Intent(this,HomeActivity.class));
        }

        public void chat(MenuItem item) {
            startActivity(new Intent(this,UsersActivity.class));
        }

    public void profile(View view) {
            startActivity(new Intent(DrawerActivity.this,StudentActivity.class));
    }
    public void appointments(MenuItem item) {
        startActivity(new Intent(DrawerActivity.this,ShowAppointmentsActivity.class));
       }
}
