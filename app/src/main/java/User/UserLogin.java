package User;

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

public class UserLogin extends AppCompatActivity {
    private TextInputLayout email,password;
    private Button button;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        email = findViewById(R.id.mail);
        password = findViewById(R.id.pass);
        progressBar = findViewById(R.id.pbar);
        firebaseAuth = FirebaseAuth.getInstance();
    }
    // Login  Authentication  Phase

    public void callUserNavigation(final View View)
    {

        String _email = email.getEditText().getText().toString().trim();
        String _password = password.getEditText().getText().toString().trim();
        if(TextUtils.isEmpty(_email))
        {
            email.setError("Email is required");
            return;
        }
        if (TextUtils.isEmpty(_password))
        {
            password.setError("Enter password");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        firebaseAuth.signInWithEmailAndPassword(_email,_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(UserLogin.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                    activity();
                    progressBar.setVisibility(View.GONE);
                }
                else
                {
                    Toast.makeText(UserLogin.this, "Error!" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

    }

    // New Activity

    private void activity() {
        Intent intent4 = new Intent(this, UserNavigation.class);
        intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent4);
    }

    //  goto Register page

    public void CallUsRegister(View View)
    {
        Intent callURegister = new Intent(getApplicationContext(), UserSignup.class);
        startActivity(callURegister);
    }

//    public  void CallUserForgotPassword(View View)
//    {
//        Intent callForgotPassword = new Intent(this, ForgotPassword.class);
//        startActivity(callForgotPassword);
//    }
}