package User;

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

import Database.UserHelperClass;

public class UserSignup extends AppCompatActivity {
    private TextInputLayout name, phone, email, password1,password2;
    public Button button;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);
        name = (TextInputLayout) findViewById(R.id.UserName1);
        phone = (TextInputLayout)findViewById(R.id.UserPhone);
        email =(TextInputLayout) findViewById(R.id.UserMail);
        password1 = (TextInputLayout)findViewById(R.id.UserPassword1);
        password2 = (TextInputLayout)findViewById(R.id.UserPassword2);
        button = findViewById(R.id.URegister);
        progressBar = findViewById(R.id.pbar);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    // Login Authentication phase
    public void UserLoginPage(final View View)
    {


        String _email = email.getEditText().getText().toString();
        String _password = password1.getEditText().getText().toString();


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
                    Toast.makeText(UserSignup.this, "User created..", Toast.LENGTH_SHORT).show();
                    writeToDatabase();
                    activity();
                    progressBar.setVisibility(View.GONE);

                }
                else
                {
                    Toast.makeText(UserSignup.this, "error!" + task.getException(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);

                }
            }
        });
    }



    // New Intent

    private void activity() {
        Intent intent2 = new Intent(this, UserLogin.class);
        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent2);
    }

    // Write data into the database

    private void writeToDatabase() {
        String _name = name.getEditText().getText().toString();
        String _phone = phone.getEditText().getText().toString();
        String _email = email.getEditText().getText().toString();
        String _password = password1.getEditText().getText().toString();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");
        UserHelperClass addNewUser = new UserHelperClass(_name,_phone, _email, _password);
        myRef.child(_name).setValue(addNewUser);

    }


    // validation methods

    private boolean ValidateName() {
        String val = name.getEditText().getText().toString().trim();
        String checkSpaces = "\\A\\w{1,20}\\z";
        if(val.isEmpty())
        {
            name.setError("Field cannot be empty");
            return false;
        } else if(val.length()>20)
        {
            name.setError("username is too large");
            return false;
        } else if (!val.matches(checkSpaces))
        {
            name.setError("No white spaces are allowed");
            return false;

        }
        else
        {
            name.setError(null);
            name.setErrorEnabled(false);
            return true;
        }
    }

    private boolean ValidatePhone() {
        String val = phone.getEditText().getText().toString().trim();
        String checkSpaces = "\\A\\w{1,20}\\z";
        if(val.isEmpty())
        {
            phone.setError("Field cannot be empty");
            return false;
        }
        else if(val.length()>10)
        {
            phone.setError("Enter valid phone number");
            return false;
        }
        else if(val.length()<10)
        {
            phone.setError("Enter valid phone number");
            return false;
        }
        else if (!val.matches(checkSpaces))
        {
            phone.setError("No white spaces are allowed");
            return false;
        }
        else
        {
            phone.setError(null);
            phone.setErrorEnabled(false);
            return true;
        }
    }

    private boolean ValidateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkemail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty())
        {
            email.setError("Field cannot be empty");
            return false;
        }
        else if(!val.matches(checkemail))
        {
            email.setError("Invalid email");
            return false;
        }
        else
        {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }



    private boolean ValidatePassword() {
        String val1 = password1.getEditText().getText().toString();
        String val2 = password2.getEditText().getText().toString();

        if(val1.isEmpty())
        {
            password1.setError("Field cannot be empty");
            return false;
        }
        else if(!val1.matches(val2))
        {
            password2.setError("Password do not match");
            return false;
        }
        else
        {
            password2.setErrorEnabled(true);
            return true;
        }

    }
}