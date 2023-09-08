package Business;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class BusinessLogin extends AppCompatActivity {
    private TextInputLayout email, password;
    public Button button;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_login);
        email = findViewById(R.id.mail);
        password = findViewById(R.id.pass);
        button = findViewById(R.id.loginbutton);
        progressBar = findViewById(R.id.pbar);
        firebaseAuth = FirebaseAuth.getInstance();
    }
    //  goto Register page

    public void CallBRegister(View View)
    {
        Intent BRegister = new Intent(this, BusinessSignup.class);
        startActivity(BRegister);
    }

    // Goto forgotPassword Page
//    public void CallUserForgotPassword(View View)
//    {
//        Intent UserPass = new Intent(this, ForgotPassword.class);
//        startActivity(UserPass);
//    }

    // Login  Authentication  Phase

    public void callBusinessNavigation( View View)
    {
        String emailText = email.getEditText().getText().toString().trim();
        String passText = password.getEditText().getText().toString().trim();

        if(TextUtils.isEmpty(emailText))
        {
            email.setError("Email is required");
            return;
        }
        if (TextUtils.isEmpty(passText))
        {
            password.setError("Enter password");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        firebaseAuth.signInWithEmailAndPassword(emailText,passText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if (task.isSuccessful())
                {
                    Toast.makeText(BusinessLogin.this, "Logged in Successfully!!", Toast.LENGTH_SHORT).show();
                    activity();
                    progressBar.setVisibility(View.GONE);
                }
                else
                {
                    Toast.makeText(BusinessLogin.this, "error!" +task.getException().getMessage() , Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });


    }

    // New Activity

    private void activity() {
        Intent intent3 = new Intent(this, BusinessNavigation1.class);
        intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent3);

    }
}