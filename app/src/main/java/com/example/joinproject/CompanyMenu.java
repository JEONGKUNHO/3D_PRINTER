package com.example.joinproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CompanyMenu extends AppCompatActivity implements View.OnClickListener {
    private Button button1, button2, button3, button4;
    TextView companyName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_menu);
        companyName = findViewById(R.id.companyName);
        companyName.setText(getIntent().getStringExtra("comp_name"));
        findViewById(R.id.intro).setOnClickListener(this);
        findViewById(R.id.gallery).setOnClickListener(this);
        findViewById(R.id.review).setOnClickListener(this);
        findViewById(R.id.chat).setOnClickListener(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.intro:
                if (getIntent().getStringExtra("comp_name").equals("기업1")) {
                    Intent intent = new Intent(this, companyIntro.class);
                    intent.putExtra("comp_intro", getIntent().getStringExtra("comp_intro"));
                    intent.putExtra("comp_image", getIntent().getStringExtra("comp_image"));
                    startActivity(intent);
                    break;
                } else if (getIntent().getStringExtra("comp_name").equals("기업2")) {
                    Intent intent = new Intent(this, companyIntro2.class);
                    intent.putExtra("comp_intro", getIntent().getStringExtra("comp_intro"));
                    intent.putExtra("comp_image", getIntent().getStringExtra("comp_image"));
                    startActivity(intent);
                    break;
                } else if (getIntent().getStringExtra("comp_name").equals("기업3")) {
                    Intent intent = new Intent(this, companyIntro3.class);
                    intent.putExtra("comp_intro", getIntent().getStringExtra("comp_intro"));
                    intent.putExtra("comp_image", getIntent().getStringExtra("comp_image"));
                    startActivity(intent);
                    break;
                } else if (getIntent().getStringExtra("comp_name").equals("기업4")) {
                    Intent intent = new Intent(this, companyIntro4.class);
                    intent.putExtra("comp_intro", getIntent().getStringExtra("comp_intro"));
                    intent.putExtra("comp_image", getIntent().getStringExtra("comp_image"));
                    startActivity(intent);
                    break;
                }

            case R.id.gallery:
                if (getIntent().getStringExtra("comp_name").equals("기업1")) {
                    Intent intent = new Intent(this, companyGallery.class);
                    intent.putExtra("comp_intro", getIntent().getStringExtra("comp_intro"));
                    intent.putExtra("comp_image", getIntent().getStringExtra("comp_image"));
                    intent.putExtra("comp_name", getIntent().getStringExtra("comp_name"));
                    startActivity(intent);
                    break;
                } else if (getIntent().getStringExtra("comp_name").equals("기업2")) {
                    Intent intent = new Intent(this, companyGallery2.class);
                    intent.putExtra("comp_intro", getIntent().getStringExtra("comp_intro"));
                    intent.putExtra("comp_image", getIntent().getStringExtra("comp_image"));
                    intent.putExtra("comp_name", getIntent().getStringExtra("comp_name"));
                    startActivity(intent);
                    break;
                } else if (getIntent().getStringExtra("comp_name").equals("기업3")) {
                    Intent intent = new Intent(this, companyGallery3.class);
                    intent.putExtra("comp_intro", getIntent().getStringExtra("comp_intro"));
                    intent.putExtra("comp_image", getIntent().getStringExtra("comp_image"));
                    intent.putExtra("comp_name", getIntent().getStringExtra("comp_name"));
                    startActivity(intent);
                    break;
                } else if (getIntent().getStringExtra("comp_name").equals("기업4")) {
                    Intent intent = new Intent(this, companyGallery4.class);
                    intent.putExtra("comp_intro", getIntent().getStringExtra("comp_intro"));
                    intent.putExtra("comp_image", getIntent().getStringExtra("comp_image"));
                    intent.putExtra("comp_name", getIntent().getStringExtra("comp_name"));
                    startActivity(intent);
                    break;
                }

            case R.id.review:
                if (getIntent().getStringExtra("comp_name").equals("기업1")) {
                    Intent intent = new Intent(this, companyReview.class);
                    intent.putExtra("comp_intro", getIntent().getStringExtra("comp_intro"));
                    intent.putExtra("comp_image", getIntent().getStringExtra("comp_image"));
                    intent.putExtra("comp_name", getIntent().getStringExtra("comp_name"));
                    startActivity(intent);
                    break;
                } else if (getIntent().getStringExtra("comp_name").equals("기업2")) {
                    Intent intent = new Intent(this, companyReview2.class);
                    intent.putExtra("comp_intro", getIntent().getStringExtra("comp_intro"));
                    intent.putExtra("comp_image", getIntent().getStringExtra("comp_image"));
                    intent.putExtra("comp_name", getIntent().getStringExtra("comp_name"));
                    startActivity(intent);
                    break;
                } else if (getIntent().getStringExtra("comp_name").equals("기업3")) {
                    Intent intent = new Intent(this, companyReview3.class);
                    intent.putExtra("comp_intro", getIntent().getStringExtra("comp_intro"));
                    intent.putExtra("comp_image", getIntent().getStringExtra("comp_image"));
                    intent.putExtra("comp_name", getIntent().getStringExtra("comp_name"));
                    startActivity(intent);
                    break;
                } else if (getIntent().getStringExtra("comp_name").equals("기업4")) {
                    Intent intent = new Intent(this, companyReview4.class);
                    intent.putExtra("comp_intro", getIntent().getStringExtra("comp_intro"));
                    intent.putExtra("comp_image", getIntent().getStringExtra("comp_image"));
                    intent.putExtra("comp_name", getIntent().getStringExtra("comp_name"));
                    startActivity(intent);
                    break;
                }

            case R.id.chat:

                if (getIntent().getStringExtra("comp_name").equals("기업1")) {
                    startActivity(new Intent(this, MainActivity1.class));
                    break;
                } else if(getIntent().getStringExtra("comp_name").equals("기업2")) {
                startActivity(new Intent(this, MainActivity2.class));
                break;
            }
                else if(getIntent().getStringExtra("comp_name").equals("기업3")) {
                startActivity(new Intent(this, MainActivity3.class));
                break;
            }
                else if(getIntent().getStringExtra("comp_name").equals("기업4")) {
                startActivity(new Intent(this, MainActivity4.class));
                break;
            }


        }


    }
}