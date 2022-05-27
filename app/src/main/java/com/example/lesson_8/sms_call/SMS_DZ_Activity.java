package com.example.lesson_8.sms_call;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.lesson_8.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class SMS_DZ_Activity extends AppCompatActivity {
    CircleImageView user_photo,user2_photo,user3_photo,user4_photo,user5_photo;
    ImageView message_img,message2_img,message3_img,message4_img,message5_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_dz);
        user_photo = findViewById(R.id.user_photo);
        user2_photo = findViewById(R.id.user2_photo);
        user3_photo = findViewById(R.id.user3_photo);
        user4_photo = findViewById(R.id.user4_photo);
        user5_photo = findViewById(R.id.user5_photo);

        message_img = findViewById(R.id.message_img);
        message2_img = findViewById(R.id.message_img2);
        message3_img = findViewById(R.id.message_img3);
        message4_img = findViewById(R.id.message_img4);
        message5_img = findViewById(R.id.message_img5);

        Glide.with(this)
                .load("https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/John_Cena_July_2018.jpg/640px-John_Cena_July_2018.jpg")
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_person_24)
                .into(user_photo);
        Glide.with(this)
                .load("https://upload.wikimedia.org/wikipedia/commons/c/cd/2018-05-12-_Cannes-L%27acteur_Michael_B._Jordan-2721_%2842075892224%29.jpg")
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_person_24)
                .into(user2_photo);

        Glide.with(this)
                .load("https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Joe_Biden_presidential_portrait.jpg/1200px-Joe_Biden_presidential_portrait.jpg")
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_person_24)
                .into(user3_photo);

        Glide.with(this)
                .load("https://upload.wikimedia.org/wikipedia/commons/8/8d/President_Barack_Obama.jpg")
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_person_24)
                .into(user4_photo);

        Glide.with(this)
                .load("https://upload.wikimedia.org/wikipedia/commons/8/8d/President_Barack_Obama.jpg")
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_person_24)
                .into(user5_photo);

        message_img.setOnClickListener(new View.OnClickListener() {
            Boolean ff = true;
            @Override
            public void onClick(View view) {
                if(ff){
                    message_img.setImageResource(R.drawable.ic_baseline_message_active_24);
                    ff=false;
                }else{
                    ff=true;
                    message_img.setImageResource(R.drawable.ic_baseline_message_24_gray);
                }
            }
        });
    }
}