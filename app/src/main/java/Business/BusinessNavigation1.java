package Business;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.automotiveassistantfinal.R;

public class BusinessNavigation1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_navigation1);
    }
    public void callCreateBusiness(View View)
    {
        Intent callBn1 = new Intent(this, BusinessNavigation2.class);
        startActivity(callBn1);
    }

    public void Edit(View view) {
        Intent callEdit = new Intent(getApplicationContext(), EditBusiness.class);
        startActivity(callEdit);
    }
}