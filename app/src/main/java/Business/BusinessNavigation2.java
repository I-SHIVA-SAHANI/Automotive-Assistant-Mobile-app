package Business;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.automotiveassistantfinal.R;

public class BusinessNavigation2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_navigation2);
    }
    public void callGarage(View View)
    {
        Intent callG = new Intent(this, BusinessNavigation3.class);
        startActivity(callG);
    }

    public void callFuelBunk(View View) {
        Intent callF = new Intent(this, BunkCreation.class);
        startActivity(callF);

    }

    public void csllRechargeBunk(View view) {
        Intent callE = new Intent(this, ElectricBunkCreation.class);
        startActivity(callE);
    }
}