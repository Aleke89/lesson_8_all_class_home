package com.example.lesson_8.sms_call;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lesson_8.R;
import com.soundcloud.android.crop.Crop;
import com.soundcloud.android.crop.CropImageActivity;

import java.io.File;

public class List_of_Persons extends AppCompatActivity {
    TextView phone_number_first_person,phone_number_second_person,phone_number_third_person;
    Button first_call_btn,second_call_btn,third_call_btn,first_sms_btn,second_sms_btn,third_sms_btn,btn_camera;
    Uri fileUri;
    ImageView photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_persons);
        phone_number_first_person = findViewById(R.id.phone_number_first_person);
        phone_number_second_person = findViewById(R.id.phone_number_second_person);
        phone_number_third_person = findViewById(R.id.phone_number_third_person);
        first_call_btn = findViewById(R.id.first_call_btn);
        second_call_btn = findViewById(R.id.second_call_btn);
        third_call_btn = findViewById(R.id.third_call_btn);
        first_sms_btn = findViewById(R.id.first_sms_btn);
        second_sms_btn = findViewById(R.id.second_sms_btn);
        third_sms_btn = findViewById(R.id.third_sms_btn);
        btn_camera = findViewById(R.id.btn_camera);
        photo = findViewById(R.id.photo);

        first_call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phone_number_first_person.getText()));
                startActivity(intent);
            }
        });
        first_sms_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("smsto:"+phone_number_first_person.getText());
                Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
                intent.putExtra("sms_body","Whassup");
                startActivity(intent);
            }
        });

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePhoto();
            }
        });
    }
    public void takePhoto(){
        if(checkPermission()){
            requestPermission();
        }else{
            Crop.pickImage(this);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent result) {
        super.onActivityResult(requestCode, resultCode, result);
        if (requestCode == Crop.REQUEST_PICK && resultCode == RESULT_OK) {
            beginCrop(result.getData());
        } else if (requestCode == Crop.REQUEST_CROP) {
            handleCrop(resultCode, result);
        }
    }

    private void beginCrop(Uri source) {
        Uri destination = Uri.fromFile(new File(getCacheDir(), "cropped"));
        Crop.of(source, destination).asSquare().start(this);
    }

    private void handleCrop(int resultCode, Intent result) {
        if (resultCode == RESULT_OK) {
            photo.setImageURI(Crop.getOutput(result));
        } else if (resultCode == Crop.RESULT_ERROR) {
            Toast.makeText(this, Crop.getError(result).getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkPermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!=
        PackageManager.PERMISSION_GRANTED){
            return false;
        }
        return true;
    }
    private static final int PERMISSION_REQUEST_CODE=200;
    private void requestPermission(){
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},PERMISSION_REQUEST_CODE);
    }
}