package Business;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.automotiveassistantfinal.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Database.ElectricBunkHelper;

public class ElectricBunkCreation extends AppCompatActivity {

    public TextInputLayout elBunkName, elBunkAvailability, elAddress, elstate, elcity, elpin;

    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric_bunk_creation);
        elBunkName = findViewById(R.id.ElBunkName);
        elBunkAvailability = findViewById(R.id.ElBunkAvailability);
        elAddress = findViewById(R.id.ElBunkAddress);
        elstate = findViewById(R.id.ElBunkState);
        elcity = findViewById(R.id.ElBunkCity);
        elpin = findViewById(R.id.ElBunkPin);
        button = findViewById(R.id.ElCreate);
    }

    public void ElBunkCreate(View View) {
        if(!ElValidate1() | !ElValidate2() | !ElValidate3() | !ElValidate4() | !ElValidate5() | !ElValidate6()) {
            return;
        } else {
            Toast.makeText(this, "Data Uploaded", Toast.LENGTH_SHORT).show();
            WriteElToDatabase();
        }

    }

    private void WriteElToDatabase() {
        String ElVal1 = elBunkName.getEditText().getText().toString();
        String ElVal2 = elBunkAvailability.getEditText().getText().toString();
        String ElVal3 = elAddress.getEditText().getText().toString();
        String ElVal4 = elstate.getEditText().getText().toString();
        String ElVal5 = elcity.getEditText().getText().toString();
        String ElVal6 = elpin.getEditText().getText().toString();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("ElectricBusiness");
        ElectricBunkHelper addNewElectric = new ElectricBunkHelper(ElVal1,ElVal2, ElVal3,ElVal4, ElVal5, ElVal6);
        myRef.child(ElVal1).setValue(addNewElectric);


    }


    private boolean ElValidate1() {
        String val1 = elBunkName.getEditText().getText().toString();

        if (val1.isEmpty()) {
            elBunkName.setError("Field cannot be empty");
            return false;
        } else {
            elBunkName.setError(null);
            elBunkName.setErrorEnabled(false);
            return true;

        }
    }

    private boolean ElValidate2() {
        String val1 = elBunkAvailability.getEditText().getText().toString();

        if (val1.isEmpty()) {
            elBunkAvailability.setError("Field cannot be empty");
            return false;
        } else {
            elBunkAvailability.setError(null);
            elBunkAvailability.setErrorEnabled(false);
            return true;

        }
    }

    private boolean ElValidate3() {
        String val1 = elAddress.getEditText().getText().toString();

        if (val1.isEmpty()) {
            elAddress.setError("Field cannot be empty");
            return false;
        } else {
            elAddress.setError(null);
            elAddress.setErrorEnabled(false);
            return true;

        }
    }

    private boolean ElValidate4() {
        String val1 = elstate.getEditText().getText().toString();

        if (val1.isEmpty()) {
            elstate.setError("Field cannot be empty");
            return false;
        } else {
            elstate.setError(null);
            elstate.setErrorEnabled(false);
            return true;

        }
    }

    private boolean ElValidate5() {
        String val1 = elcity.getEditText().getText().toString();

        if (val1.isEmpty()) {
            elcity.setError("Field cannot be empty");
            return false;
        } else {
            elcity.setError(null);
            elcity.setErrorEnabled(false);
            return true;

        }
    }

    private boolean ElValidate6() {
        String val1 = elpin.getEditText().getText().toString();

        if (val1.isEmpty()) {
            elpin.setError("Field cannot be empty");
            return false;
        } else {
            elpin.setError(null);
            elpin.setErrorEnabled(false);
            return true;

        }
    }
}