package com.example.lesson_8.my_cabinet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.lesson_8.R;
import com.example.lesson_8.test.Test;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyCabinetActivity extends AppCompatActivity {
    Button btn_start_test;
    CircleImageView user_photo;
    TextView user_email,user_password,user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cabinet);
        btn_start_test = findViewById(R.id.btn_test_start);
        user_photo = findViewById(R.id.user_photo);
        user_email = findViewById(R.id.user_email);
        user_name = findViewById(R.id.user_name);
        user_password = findViewById(R.id.user_password);
        Intent intent = getIntent();
        String uEmail = intent.getStringExtra("email");
        String uName = intent.getStringExtra("name");
        String uPassword = intent.getStringExtra("password");
        user_email.setText("User email: "+uEmail);
        user_name.setText("User name: " + uName);
        user_password.setText("User password: "+uPassword);

        Glide.with(this)
                .load("https://c4.wallpaperflare.com/wallpaper/529/555/624/mask-neon-person-photography-wallpaper-preview.jpg")
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_person_24)
                .into(user_photo);

        btn_start_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_test = new Intent(MyCabinetActivity.this, Test.class);
                startActivity(start_test);
            }
        });
    }
}