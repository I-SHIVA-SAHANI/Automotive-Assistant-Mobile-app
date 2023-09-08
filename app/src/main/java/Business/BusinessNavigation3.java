package Business;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.automotiveassistantfinal.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BusinessNavigation3 extends AppCompatActivity {
    private TextInputLayout Bname, Mname, Bservices, Bavailability, state, city, address, pinCode, phone;
    private Button button;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_navigation3);

        Bname = findViewById(R.id.BSname2);
        Mname = findViewById(R.id.mechanics);
        Bservices = findViewById(R.id.services);
        Bavailability = findViewById(R.id.Availability);
        state = findViewById(R.id.state);
        city = findViewById(R.id.city);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.BSphone);
        pinCode = findViewById(R.id.pin);
        progressbar = findViewById(R.id.pbar);
    }

    public void Create(View View) {
        if (!validate1() | !validate2() | !validate3() | !validate4() | !validate5() | !validate6() | !validate7() | !validate8()) {
            return;
        } else {

            Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show();
            writeData();


        }


    }

    // write to database
    private void writeData() {

        String val1 = Bname.getEditText().getText().toString();
        String val2 = Mname.getEditText().getText().toString();
        String val3 = Bservices.getEditText().getText().toString();
        String val4 = Bavailability.getEditText().getText().toString();
        String val5 = state.getEditText().getText().toString();
        String val6 = city.getEditText().getText().toString();
        String val7 = address.getEditText().getText().toString();
        String val8 = phone.getEditText().getText().toString();
        String val9 = pinCode.getEditText().getText().toString();

        FirebaseDatabase Database2 = FirebaseDatabase.getInstance();
        DatabaseReference myRef2 = Database2.getReference("GarageBusiness");
        BusinessHelper2 addNewUser2 = new BusinessHelper2(val1, val2, val3, val4, val5, val6, val7, val8, val9);
        myRef2.child(val1).setValue(addNewUser2);


    }

    private boolean validate1() {
        String val1 = Bname.getEditText().getText().toString();

        if (val1.isEmpty()) {
            Bname.setError("Field cannot be empty");
            return false;
        } else {
            Bname.setError(null);
            Bname.setErrorEnabled(false);
            return true;

        }
    }

    private boolean validate2() {
        String val1 = Mname.getEditText().getText().toString();

        if (val1.isEmpty()) {
            Mname.setError("Field cannot be empty");
            return false;
        } else {
            Mname.setError(null);
            Mname.setErrorEnabled(false);
            return true;

        }
    }

    private boolean validate3() {
        String val1 = Bservices.getEditText().getText().toString();

        if (val1.isEmpty()) {
            Bservices.setError("Field cannot be empty");
            return false;
        } else {
            Bservices.setError(null);
            Bservices.setErrorEnabled(false);
            return true;

        }
    }

    private boolean validate4() {
        String val1 = Bavailability.getEditText().getText().toString();

        if (val1.isEmpty()) {
            Bavailability.setError("Field cannot be empty");
            return false;
        } else {
            Bavailability.setError(null);
            Bavailability.setErrorEnabled(false);
            return true;

        }
    }

    private boolean validate5() {
        String val1 = state.getEditText().getText().toString();

        if (val1.isEmpty()) {
            state.setError("Field cannot be empty");
            return false;
        } else {
            state.setError(null);
            state.setErrorEnabled(false);
            return true;

        }
    }

    private boolean validate6() {
        String val1 = city.getEditText().getText().toString();

        if (val1.isEmpty()) {
            city.setError("Field cannot be empty");
            return false;
        } else {
            city.setError(null);
            city.setErrorEnabled(false);
            return true;

        }
    }

    private boolean validate7() {
        String val1 = address.getEditText().getText().toString();

        if (val1.isEmpty()) {
            address.setError("Field cannot be empty");
            return false;
        } else {
            address.setError(null);
            address.setErrorEnabled(false);
            return true;

        }
    }

    private boolean validate8() {
        String val1 = phone.getEditText().getText().toString();

        if (val1.isEmpty()) {
            phone.setError("Field cannot be empty");
            return false;
        } else if (val1.length() < 9) {
            phone.setError("Invalid Number");
            return false;
        } else if (val1.length() > 10) {
            phone.setError("Invalid Number");
            return false;
        } else {
            phone.setError(null);
            phone.setErrorEnabled(false);
            return true;

        }
    }
}