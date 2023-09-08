package Business;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.automotiveassistantfinal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Database.BusinessHelperClass;

public class BusinessSignup extends AppCompatActivity {
    private TextInputLayout Bname, Bphone, Bemail, Bpassword1,Bpassword2;
    public Button button;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_signup);
        Bname = (TextInputLayout) findViewById(R.id.BSname);
        Bphone = (TextInputLayout)findViewById(R.id.Bsphone);
        Bemail =(TextInputLayout) findViewById(R.id.BSmail);
        Bpassword1 = (TextInputLayout)findViewById(R.id.BSpassword1);
        Bpassword2 = (TextInputLayout)findViewById(R.id.BSpassword2);
        button = findViewById(R.id.URegister);
        progressBar = findViewById(R.id.pbar);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    // Login Authentication phase
    public void CallBsLogin(final View View)
    {


        String _email = Bemail.getEditText().getText().toString();
        String _password = Bpassword1.getEditText().getText().toString();


        if(!ValidateName() | !ValidatePhone() | !ValidateEmail() | !ValidatePassword())
        {
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        firebaseAuth.createUserWithEmailAndPassword(_email,_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    Toast.makeText(BusinessSignup.this, "User created..", Toast.LENGTH_SHORT).show();
                    writeToDatabase();
                    Bactivity();
                    progressBar.setVisibility(View.GONE);

                }
                else
                {
                    Toast.makeText(BusinessSignup.this, "error!" + task.getException(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);

                }
            }
        });
    }

    // New Intent

    private void Bactivity() {
        Intent intent2 = new Intent(this, BusinessLogin.class);
        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent2);
    }

    // Write data into the database

    private void writeToDatabase() {
        String _name = Bname.getEditText().getText().toString();
        String _phone = Bphone.getEditText().getText().toString();
        String _email = Bemail.getEditText().getText().toString();
        String _password1 = Bpassword1.getEditText().getText().toString();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("BusinessUsers");
        BusinessHelperClass addNewUser = new BusinessHelperClass(_name,_phone, _email, _password1);
        myRef.child(_name).setValue(addNewUser);

    }


    // validation methods

    private boolean ValidateName() {
        String val = Bname.getEditText().getText().toString().trim();
        String checkSpaces = "\\A\\w{1,20}\\z";
        if(val.isEmpty())
        {
            Bname.setError("Field cannot be empty");
            return false;
        } else if(val.length()>20)
        {
            Bname.setError("username is too large");
            return false;
        } else if (!val.matches(checkSpaces))
        {
            Bname.setError("No white spaces are allowed");
            return false;

        }
        else
        {
            Bname.setError(null);
            Bname.setErrorEnabled(false);
            return true;
        }
    }

    private boolean ValidatePhone() {
        String val = Bphone.getEditText().getText().toString().trim();
        String checkSpaces = "\\A\\w{1,20}\\z";
        if(val.isEmpty())
        {
            Bphone.setError("Field cannot be empty");
            return false;
        }
        else if(val.length()>10)
        {
            Bphone.setError("Enter valid phone number");
            return false;
        }
        else if(val.length()<10)
        {
            Bphone.setError("Enter valid phone number");
            return false;
        }
        else if (!val.matches(checkSpaces))
        {
            Bphone.setError("No white spaces are allowed");
            return false;
        }
        else
        {
            Bphone.setError(null);
            Bphone.setErrorEnabled(false);
            return true;
        }
    }

    private boolean ValidateEmail() {
        String val = Bemail.getEditText().getText().toString().trim();
        String checkemail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty())
        {
            Bemail.setError("Field cannot be empty");
            return false;
        }
        else if(!val.matches(checkemail))
        {
            Bemail.setError("Invalid email");
            return false;
        }
        else
        {
            Bemail.setError(null);
            Bemail.setErrorEnabled(false);
            return true;
        }
    }



    private boolean ValidatePassword() {
        String val1 = Bpassword1.getEditText().getText().toString();
        String val2 = Bpassword2.getEditText().getText().toString();

        if(val1.isEmpty())
        {
            Bpassword1.setError("Field cannot be empty");
            return false;
        }
        else if(!val1.matches(val2))
        {
            Bpassword2.setError("Password do not match");
            return false;
        }
        else
        {
            Bpassword2.setErrorEnabled(true);
            return true;
        }

    }
}