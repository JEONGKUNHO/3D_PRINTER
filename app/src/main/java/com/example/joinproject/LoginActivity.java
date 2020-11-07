package com.example.joinproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth= FirebaseAuth.getInstance();

    private EditText mEmail, mPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail=findViewById(R.id.login_email);
        mPassword=findViewById(R.id.login_password);


        findViewById(R.id.login_signup).setOnClickListener(this);
        findViewById(R.id.login_success).setOnClickListener(this);
        findViewById(R.id.login_passwordReset).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.login_signup:
                startActivity(new Intent(this, SignupActivity.class));
                break;

            case R.id.login_success:
                mAuth.signInWithEmailAndPassword(mEmail.getText().toString() , mPassword.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    if (user!=null){
                                        Toast.makeText(LoginActivity.this, "로그인 성공: "+user.getUid(),
                                                Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(LoginActivity.this, "로그인 오류",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                break;

            case R.id.login_passwordReset:
                startActivity(new Intent(this, PasswordResetActivity.class));
                break;
        }
    }
}