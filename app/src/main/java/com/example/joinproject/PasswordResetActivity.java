package com.example.joinproject;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PasswordResetActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth= FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_rest);


        findViewById(R.id.send_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.send_button:
                String email=((EditText)findViewById(R.id.password_email)).getText().toString();
                mAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText  (PasswordResetActivity.this,"이메일을 보냈습니다.",Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                                else{
                                    Toast.makeText(PasswordResetActivity.this,"이메일을 다시 입력해주세요.",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                break;
        }
    }
}