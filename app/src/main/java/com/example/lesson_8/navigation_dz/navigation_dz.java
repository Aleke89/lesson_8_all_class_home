package com.example.lesson_8.navigation_dz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.lesson_8.R;
import com.example.lesson_8.fragment.fragment1;
import com.example.lesson_8.fragment.fragment2;
import com.example.lesson_8.fragment.fragment3;
import com.example.lesson_8.fragment.fragment4;

public class navigation_dz extends AppCompatActivity implements View.OnClickListener {
    ImageView favorite, music, place, news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_dz);
        favorite = findViewById(R.id.favorite);
        music = findViewById(R.id.music);
        place = findViewById(R.id.place);
        news = findViewById(R.id.news);

        favorite.setOnClickListener(this);
        music.setOnClickListener(this);
        place.setOnClickListener(this);
        news.setOnClickListener(this);

    }

    public void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_dz, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onClick(View view) {
        defaultmenu();
        switch (view.getId()) {
            case R.id.favorite:

                favorite.setImageResource(R.drawable.ic_baseline_favorite_24_active);


                changeFragment(new dz_fragment1());
                break;
            case R.id.music:

                music.setImageResource(R.drawable.ic_baseline_library_music_24_active);


                changeFragment(new dz_fragment2());
                break;
            case R.id.place:

                place.setImageResource(R.drawable.ic_baseline_place_24_active);


                changeFragment(new dz_fragment3());
                break;
            case R.id.news:

                news.setImageResource(R.drawable.ic_baseline_fiber_new_24_active);


                changeFragment(new dz_fragment4());
                break;
        }

    }

    public void defaultmenu() {
        news.setImageResource(R.drawable.ic_baseline_fiber_new_24);
        favorite.setImageResource(R.drawable.ic_baseline_favorite_24);
        music.setImageResource(R.drawable.ic_baseline_library_music_24);
        place.setImageResource(R.drawable.ic_baseline_place_24);
    }
}