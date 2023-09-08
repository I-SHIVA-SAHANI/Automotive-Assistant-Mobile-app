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

import Database.BunkHelper;

public class BunkCreation extends AppCompatActivity {
    private TextInputLayout bunkname, bunkavailability, bunkstate, bunkcity, bunkaddress, bunkpinCode, bunkphone, bunklandmark;
    private Button bunkcreate;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bunk_creation);

        bunkname = findViewById(R.id.bunkName);
        bunkavailability = findViewById(R.id.bunkAvailability);
        bunkstate= findViewById(R.id.bunkstate);
        bunkcity = findViewById(R.id.bunkcity);
        bunkaddress = findViewById(R.id.bunkaddress);
        bunkpinCode = findViewById(R.id.bunkpin);
        bunkphone = findViewById(R.id.bunkphone);
        bunklandmark = findViewById(R.id.bunklandmark);
    }

    public void CreateBunk(View view) {
        if (!Bvalidate1() | !Bvalidate2() | !Bvalidate3() | !Bvalidate4() | !Bvalidate5() | !Bvalidate6() | !Bvalidate7() | !Bvalidate8()) {
            return;
        } else {

            Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show();
            writeBunkData();


        }
    }

    private void writeBunkData() {
        String bval1 = bunkname.getEditText().getText().toString();
        String bval2 = bunkavailability.getEditText().getText().toString();
        String bval3 = bunkstate.getEditText().getText().toString();
        String bval4 = bunkcity.getEditText().getText().toString();
        String bval5 = bunkaddress.getEditText().getText().toString();
        String bval6 = bunkpinCode.getEditText().getText().toString();
        String bval7 = bunkphone.getEditText().getText().toString();
        String bval8 = bunklandmark.getEditText().getText().toString();

        FirebaseDatabase BunkDatabase = FirebaseDatabase.getInstance();
        DatabaseReference BunkMyRef = BunkDatabase.getReference("BunkBusiness");
        BunkHelper addNewBunk = new BunkHelper(bval1, bval2, bval3, bval4, bval5, bval6, bval7, bval8);
        BunkMyRef.child(bval1).setValue(addNewBunk);


    }

    private boolean Bvalidate1() {
        String val1 = bunkname.getEditText().getText().toString();

        if (val1.isEmpty()) {
            bunkname.setError("Field cannot be empty");
            return false;
        } else {
            bunkname.setError(null);
            bunkname.setErrorEnabled(false);
            return true;

        }
    }

    private boolean Bvalidate2() {
        String val1 = bunkavailability.getEditText().getText().toString();

        if (val1.isEmpty()) {
            bunkavailability.setError("Field cannot be empty");
            return false;
        } else {
            bunkavailability.setError(null);
            bunkavailability.setErrorEnabled(false);
            return true;

        }
    }

    private boolean Bvalidate3() {
        String val1 = bunkstate.getEditText().getText().toString();

        if (val1.isEmpty()) {
            bunkstate.setError("Field cannot be empty");
            return false;
        } else {
            bunkstate.setError(null);
            bunkstate.setErrorEnabled(false);
            return true;

        }
    }

    private boolean Bvalidate4() {
        String val1 = bunkcity.getEditText().getText().toString();

        if (val1.isEmpty()) {
            bunkcity.setError("Field cannot be empty");
            return false;
        } else {
            bunkcity.setError(null);
            bunkcity.setErrorEnabled(false);
            return true;

        }
    }

    private boolean Bvalidate5() {
        String val1 = bunkaddress.getEditText().getText().toString();

        if (val1.isEmpty()) {
            bunkaddress.setError("Field cannot be empty");
            return false;
        } else {
            bunkaddress.setError(null);
            bunkaddress.setErrorEnabled(false);
            return true;

        }
    }

    private boolean Bvalidate6() {
        String val1 = bunkpinCode.getEditText().getText().toString();

        if (val1.isEmpty()) {
            bunkpinCode.setError("Field cannot be empty");
            return false;
        } else {
            bunkpinCode.setError(null);
            bunkpinCode.setErrorEnabled(false);
            return true;

        }
    }

    private boolean Bvalidate7() {
        String val1 = bunklandmark.getEditText().getText().toString();

        if (val1.isEmpty()) {
            bunklandmark.setError("Field cannot be empty");
            return false;
        } else {
            bunklandmark.setError(null);
            bunklandmark.setErrorEnabled(false);
            return true;

        }
    }

    private boolean Bvalidate8() {
        String val1 = bunkphone.getEditText().getText().toString();

        if (val1.isEmpty()) {
            bunkphone.setError("Field cannot be empty");
            return false;
        } else if (val1.length() < 9) {
            bunkphone.setError("Invalid Number");
            return false;
        } else if (val1.length() > 10) {
            bunkphone.setError("Invalid Number");
            return false;
        } else {
            bunkphone.setError(null);
            bunkphone.setErrorEnabled(false);
            return true;

        }
    }
}