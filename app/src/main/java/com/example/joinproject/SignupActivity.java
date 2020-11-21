package com.example.joinproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int PICK_FROM_ALBUM = 10;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();

    private EditText mEmailText, mPasswordText , mPasswordText2, mNameText;
    private ImageView profile;
    private Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        profile = (ImageView)findViewById(R.id.signupActivity_imageview_profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent,PICK_FROM_ALBUM);
            }
        });
        mEmailText = findViewById(R.id.password_email);
        mPasswordText = findViewById(R.id.sign_password);
        mPasswordText2=findViewById(R.id.sign_password2);
        mNameText=findViewById(R.id.signupActivity_edittext_name);

        findViewById(R.id.send_button).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.send_button:
                String x=mEmailText.getText().toString();
                String a=mPasswordText.getText().toString();
                String b=mPasswordText2.getText().toString();
                String c=mNameText.getText().toString();

                if(x.equals(null) || a.equals(null) || b.equals(null)){
                    Toast.makeText(SignupActivity.this, "값을 입력하세요.",Toast.LENGTH_SHORT).show();
                }
                else if(!a.equals(b)){
                    Toast.makeText(SignupActivity.this, "입력한 두 비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    mAuth.createUserWithEmailAndPassword(mEmailText.getText().toString(), mPasswordText.getText().toString())
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser user = mAuth.getCurrentUser();

                                        //채팅때매 추가한 부분
                                        final String uid = task.getResult().getUser().getUid();
                                        FirebaseStorage.getInstance().getReference().child("userImages").child(uid).putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                                                @SuppressWarnings("VisibleForTests")
                                                String imageUrl = task.getResult().getMetadata().getReference().getDownloadUrl().toString();
                                                        //getDownloadUrl().toString(); <예전버전
                                                UserModel userModel = new UserModel();
                                                userModel.userName = mNameText.getText().toString();
                                                userModel.uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                                userModel.profileImageUrl = imageUrl;

                                                FirebaseDatabase.getInstance().getReference().child("users").child(uid).setValue(userModel);

                                            }
                                        });


                                        if (user != null) {
                                            Map<String, Object> userMap = new HashMap<>();
                                            userMap.put(FirebaseID.documentID, user.getUid());
                                            userMap.put(FirebaseID.email, mEmailText.getText().toString());
                                            userMap.put(FirebaseID.password, mPasswordText.getText().toString());
                                            mStore.collection(FirebaseID.user).document(user.getUid()).set(userMap, SetOptions.merge());
                                            Toast.makeText(SignupActivity.this, "회원가입 완료", Toast.LENGTH_SHORT).show();
                                            finish();
                                        }
                                    } else {
                                        Toast.makeText(SignupActivity.this, "회원가입 오류",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                    break;
                }
            case R.id.back:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FROM_ALBUM && resultCode == RESULT_OK) {
            profile.setImageURI(data.getData()); //가운데뷰를 바꿈
            imageUri = data.getData(); //이미지 경로 원본
        }

    }
}