package com.example.joinproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class companyGallery2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Gallery2> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private FirebaseAuth mauth=FirebaseAuth.getInstance();

    Button WriteGallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_gallery2);

        WriteGallery=findViewById(R.id.WriteGallery);

        if(mauth.getUid().equals(getIntent().getStringExtra("comp_bossId"))){
            WriteGallery.setVisibility(View.VISIBLE);
        }
        WriteGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), plusGallery2.class));
            }
        });

        recyclerView = findViewById(R.id.recyclerView); //id연결
        recyclerView.setHasFixedSize(true);//리사이클러뷰 기존성능강화 별로 안중요
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();  //Company 객체를 담을 어레이리스트(어뎁터쪽으로)

        database = FirebaseDatabase.getInstance(); //파이어베이스 DB 연동

        databaseReference = database.getReference("Gallery2");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear(); //기존 배열리스트가 존재하지않게 초기화
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {//반복문으로 데이터 List를 추출해냄
                    Gallery2 gallery = snapshot.getValue(Gallery2.class); //만들어뒀던 Company객체에 데이터를 담는다
                    arrayList.add(gallery);//담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼준비
                }
                adapter.notifyDataSetChanged(); //리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("companyGallery", String.valueOf(error.toException()));
            }
        });

        adapter = new GalleryAdapter2(arrayList, this);
        recyclerView.setAdapter(adapter);
    }

}

