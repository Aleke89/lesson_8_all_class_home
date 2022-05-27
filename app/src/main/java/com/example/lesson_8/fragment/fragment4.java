package com.example.lesson_8.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.lesson_8.R;

public class fragment4 extends Fragment {
    Button first_call_btn,first_sms_btn;
    TextView phone_number_first_person;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment4, container, false);
        phone_number_first_person = view.findViewById(R.id.phone_number_first_person);
        first_call_btn = view.findViewById(R.id.first_call_btn);
        first_sms_btn = view.findViewById(R.id.first_sms_btn);
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
        return view;
    }
}