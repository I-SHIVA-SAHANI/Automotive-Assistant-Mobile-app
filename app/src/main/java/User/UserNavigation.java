package User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.automotiveassistantfinal.MainActivity;
import com.example.automotiveassistantfinal.R;
import com.google.android.material.navigation.NavigationView;

import java.util.concurrent.TimeUnit;

import BunkRecyclerDatabase.BunkRecycler;
import ElectricBunkDatabase.ElectricBunkRecycler;
import MechanicAdapter.MechanicRecylcer;

public class UserNavigation extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    NavigationView navigationView;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_navigation);

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                    //Here call you fragmentManager
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void MechanicRecycler(View view) {

        Intent callMecRec = new Intent(getApplicationContext(), MechanicRecylcer.class);
        startActivity(callMecRec);
    }


    public void BunkRecycler(View view) {

        Intent callBunkRec = new Intent(getApplicationContext(), BunkRecycler.class);
        startActivity(callBunkRec);
    }

    public void callElectric(View view) {
        Intent callEleRec = new Intent(getApplicationContext(), ElectricBunkRecycler.class);
        startActivity(callEleRec);
    }

    public void Logout(MenuItem item) {

        Intent lintent = new Intent(getApplicationContext(), MainActivity.class);
        lintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(lintent);
    }
}