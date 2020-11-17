package com.example.joinproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class page_4 extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Company> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View v=inflater.inflate(R.layout.fragment_page_4, container, false);

        recyclerView=v.findViewById(R.id.recyclerView); //id연결
        recyclerView.setHasFixedSize(true);//리사이클러뷰 기존성능강화 별로 안중요
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        arrayList= new ArrayList<>();  //Company 객체를 담을 어레이리스트(어뎁터쪽으로)

        database=FirebaseDatabase.getInstance(); //파이어베이스 DB 연동

        databaseReference=database.getReference("Company"); //DB 테이블 연경
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear(); //기존 배열리스트가 존재하지않게 초기화
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){//반복문으로 데이터 List를 추출해냄
                    Company company=snapshot.getValue(Company.class); //만들어뒀던 Company객체에 데이터를 담는다
                    arrayList.add(company);//담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼준비
                }
                adapter.notifyDataSetChanged(); //리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("fragment_page_4",String.valueOf(error.toException()));
            }
        });

        adapter = new CompanyAdapter(arrayList, getActivity());
        recyclerView.setAdapter(adapter);

        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
