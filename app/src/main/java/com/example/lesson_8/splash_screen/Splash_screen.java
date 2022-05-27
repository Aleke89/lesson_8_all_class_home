package com.example.lesson_8.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.lesson_8.R;

public class Splash_screen extends AppCompatActivity {
    ImageView imageView;
    Animation rotateanim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imageView = findViewById(R.id.splash_logo_screen);
        rotateanim = AnimationUtils.loadAnimation(this,R.anim.splash_screen);
        imageView.startAnimation(rotateanim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash_screen.this, ListActivity.class));
            }
        },3000);
    }
}