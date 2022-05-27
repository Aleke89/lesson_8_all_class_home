package com.example.lesson_8.authentification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_8.R;
import com.example.lesson_8.fragment.fragment1;
import com.example.lesson_8.fragment.fragment2;
import com.example.lesson_8.fragment.fragment3;
import com.example.lesson_8.fragment.fragment4;

public class Navigation_Activity extends AppCompatActivity implements View.OnClickListener{
    Button ata_btn,apa_btn,ake_btn,ana_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        ata_btn = findViewById(R.id.ata_btn);
        apa_btn = findViewById(R.id.apa_btn);
        ake_btn = findViewById(R.id.ake_btn);
        ana_btn = findViewById(R.id.ana_btn);


         ata_btn.setOnClickListener(this);
         apa_btn.setOnClickListener(this);
         ake_btn.setOnClickListener(this);
         ana_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ata_btn:
                changeFragment(new fragment1());
                break;
            case R.id.apa_btn:
                changeFragment(new fragment2());
                break;
            case R.id.ake_btn:
                changeFragment(new fragment3());
                break;
            case R.id.ana_btn:
                changeFragment(new fragment4());
                break;
        }
    }
    public void changeFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();

        if(fragmentManager !=null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment,fragment);
            fragmentTransaction.commit();
        }
    }
}