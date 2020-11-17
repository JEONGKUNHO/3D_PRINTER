package com.example.joinproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class company1 extends Fragment {

    TextView a;
    ImageView b;
    DatabaseReference ref;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        LayoutInflater lf=getActivity().getLayoutInflater();
        View view=lf.inflate(R.layout.fragment_company1,container,false);

        a=(TextView)view.findViewById(R.id.intro);
        b=(ImageView)view.findViewById(R.id.comp_image);


        ref= FirebaseDatabase.getInstance().getReference().child("Company").child("Company_1");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String image=snapshot.child("comp_image").getValue().toString();
                String intro=snapshot.child("comp_intro").getValue().toString();
                a.setText(intro);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return inflater.inflate(R.layout.fragment_company1, container, false);
    }
    ;}