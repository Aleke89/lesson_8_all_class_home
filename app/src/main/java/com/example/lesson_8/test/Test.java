package com.example.lesson_8.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson_8.R;

public class Test extends AppCompatActivity {
    TextView surak1,surak2,surak3,surak4;
    RadioButton rb_surak_1_jauap_1,rb_surak_1_jauap_2,rb_surak_2_jauap_1,rb_surak_2_jauap_2;
    RadioButton rb_surak_3_jauap_1,rb_surak_3_jauap_2,rb_surak_4_jauap_1,rb_surak_4_jauap_2;
    RadioButton rb_surak_1_jauap_3,rb_surak_1_jauap_4,rb_surak_2_jauap_3,rb_surak_2_jauap_4;
    RadioButton rb_surak_3_jauap_3,rb_surak_3_jauap_4,rb_surak_4_jauap_3,rb_surak_4_jauap_4;
    Button btn_check;
    String [] suraktar={"1+1=?","1+2=?","1+3=?","1+4=?"};
    String [][] varianttar = {
            {"2","784","888","999"},
            {"89","3","777","666"},
            {"145","4","895","451"},
            {"999","5","212","356"},
    };
    String [] jauaptar = {"2","3","4","5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_lesson_8);

        surak1 = findViewById(R.id.surak);
        surak2 = findViewById(R.id.surak2);
        surak3 = findViewById(R.id.surak3);
        surak4 = findViewById(R.id.surak4);

        btn_check = findViewById(R.id.btn_check);


        rb_surak_1_jauap_1 = findViewById(R.id.rb_surak_1_jauap_1);
        rb_surak_1_jauap_2 = findViewById(R.id.rb_surak_1_jauap_2);
        rb_surak_2_jauap_1 = findViewById(R.id.rb_surak_2_jauap_1);
        rb_surak_2_jauap_2 = findViewById(R.id.rb_surak_2_jauap_2);
        rb_surak_3_jauap_1 = findViewById(R.id.rb_surak_3_jauap_1);
        rb_surak_3_jauap_2 = findViewById(R.id.rb_surak_3_jauap_2);
        rb_surak_4_jauap_1 = findViewById(R.id.rb_surak_4_jauap_1);
        rb_surak_4_jauap_2 = findViewById(R.id.rb_surak_4_jauap_2);

        rb_surak_1_jauap_3 = findViewById(R.id.rb_surak_1_jauap_3);
        rb_surak_1_jauap_4 = findViewById(R.id.rb_surak_1_jauap_4);
        rb_surak_2_jauap_3 = findViewById(R.id.rb_surak_2_jauap_3);
        rb_surak_2_jauap_4 = findViewById(R.id.rb_surak_2_jauap_4);
        rb_surak_3_jauap_3 = findViewById(R.id.rb_surak_3_jauap_3);
        rb_surak_3_jauap_4 = findViewById(R.id.rb_surak_3_jauap_4);
        rb_surak_4_jauap_3 = findViewById(R.id.rb_surak_4_jauap_3);
        rb_surak_4_jauap_4 = findViewById(R.id.rb_surak_4_jauap_4);

//        1)
        surak1.setText(suraktar[0]);
        rb_surak_1_jauap_1.setText(varianttar[0][0]);
        rb_surak_1_jauap_2.setText(varianttar[0][1]);
        rb_surak_1_jauap_3.setText(varianttar[0][2]);
        rb_surak_1_jauap_4.setText(varianttar[0][3]);
//        2)
        surak2.setText(suraktar[1]);
        rb_surak_2_jauap_1.setText(varianttar[1][0]);
        rb_surak_2_jauap_2.setText(varianttar[1][1]);
        rb_surak_2_jauap_3.setText(varianttar[0][2]);
        rb_surak_2_jauap_4.setText(varianttar[0][3]);
//        3)
        surak3.setText(suraktar[2]);
        rb_surak_3_jauap_1.setText(varianttar[2][0]);
        rb_surak_3_jauap_2.setText(varianttar[2][1]);
        rb_surak_3_jauap_3.setText(varianttar[0][2]);
        rb_surak_3_jauap_4.setText(varianttar[0][3]);
//        4)
        surak4.setText(suraktar[3]);
        rb_surak_4_jauap_1.setText(varianttar[3][0]);
        rb_surak_4_jauap_2.setText(varianttar[3][1]);
        rb_surak_4_jauap_3.setText(varianttar[0][2]);
        rb_surak_4_jauap_4.setText(varianttar[0][3]);

        btn_check.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(rb_surak_1_jauap_1.isChecked()&&
                        rb_surak_1_jauap_1.getText().toString().equals(jauaptar[0])){
                        surak1.setText(suraktar[0]+"\n"+"Correct");
                        surak1.setTextColor(getResources().getColor(R.color.green));
                }else if(rb_surak_1_jauap_2.isChecked()&&
                        rb_surak_1_jauap_2.getText().toString().equals(jauaptar[0])){
                    surak1.setText(suraktar[0]+"\n"+"Correct");
                    surak1.setTextColor(getResources().getColor(R.color.green));
                }else if(rb_surak_1_jauap_3.isChecked()&&
                        rb_surak_1_jauap_3.getText().toString().equals(jauaptar[0])){
                    surak1.setText(suraktar[0]+"\n"+"Correct");
                    surak1.setTextColor(getResources().getColor(R.color.green));
                }else if(rb_surak_1_jauap_4.isChecked()&&
                        rb_surak_1_jauap_4.getText().toString().equals(jauaptar[0])) {
                    surak1.setText(suraktar[0] + "\n" + "Correct");
                    surak1.setTextColor(getResources().getColor(R.color.green));
                } else{
                    surak1.setText(suraktar[0]+"\n"+"Incorrect");
                    surak1.setTextColor(getResources().getColor(R.color.red));
                }
                if(rb_surak_2_jauap_1.isChecked()&&
                        rb_surak_2_jauap_1.getText().toString().equals(jauaptar[1])){
                    surak2.setText(suraktar[1]+"\n"+"Correct");
                    surak2.setTextColor(getResources().getColor(R.color.green));
                }else if(rb_surak_2_jauap_2.isChecked()&&
                        rb_surak_2_jauap_2.getText().toString().equals(jauaptar[1])){
                    surak2.setText(suraktar[1]+"\n"+"Correct");
                    surak2.setTextColor(getResources().getColor(R.color.green));
                }else if(rb_surak_2_jauap_3.isChecked()&&
                        rb_surak_2_jauap_3.getText().toString().equals(jauaptar[0])){
                    surak2.setText(suraktar[0]+"\n"+"Correct");
                    surak2.setTextColor(getResources().getColor(R.color.green));
                }else if(rb_surak_2_jauap_4.isChecked()&&
                        rb_surak_2_jauap_4.getText().toString().equals(jauaptar[0])) {
                    surak2.setText(suraktar[0] + "\n" + "Correct");
                    surak2.setTextColor(getResources().getColor(R.color.green));
                } else{
                    surak2.setText(suraktar[1]+"\n"+"Incorrect");
                    surak2.setTextColor(getResources().getColor(R.color.red));
                }
                if(rb_surak_3_jauap_1.isChecked()&&
                        rb_surak_3_jauap_1.getText().toString().equals(jauaptar[2])){
                    surak3.setText(suraktar[2]+"\n"+"Correct");
                    surak3.setTextColor(getResources().getColor(R.color.green));
                }else if(rb_surak_3_jauap_2.isChecked()&&
                        rb_surak_3_jauap_2.getText().toString().equals(jauaptar[2])){
                    surak3.setText(suraktar[2]+"\n"+"Correct");
                    surak3.setTextColor(getResources().getColor(R.color.green));
                }else if(rb_surak_3_jauap_3.isChecked()&&
                        rb_surak_3_jauap_3.getText().toString().equals(jauaptar[0])){
                    surak3.setText(suraktar[0]+"\n"+"Correct");
                    surak3.setTextColor(getResources().getColor(R.color.green));
                }else if(rb_surak_3_jauap_4.isChecked()&&
                        rb_surak_3_jauap_4.getText().toString().equals(jauaptar[0])) {
                    surak3.setText(suraktar[0] + "\n" + "Correct");
                    surak3.setTextColor(getResources().getColor(R.color.green));
                }
                else{
                    surak3.setText(suraktar[2]+"\n"+"Incorrect");
                    surak3.setTextColor(getResources().getColor(R.color.red));
                }
                if(rb_surak_4_jauap_1.isChecked()&&
                        rb_surak_4_jauap_1.getText().toString().equals(jauaptar[3])){
                    surak4.setText(suraktar[3]+"\n"+"Correct");
                    surak4.setTextColor(getResources().getColor(R.color.green));
                }else if(rb_surak_4_jauap_2.isChecked()&&
                        rb_surak_4_jauap_2.getText().toString().equals(jauaptar[3])){
                    surak4.setText(suraktar[3]+"\n"+"Correct");
                    surak4.setTextColor(getResources().getColor(R.color.green));
                }else if(rb_surak_4_jauap_3.isChecked()&&
                        rb_surak_4_jauap_3.getText().toString().equals(jauaptar[0])){
                    surak4.setText(suraktar[0]+"\n"+"Correct");
                    surak4.setTextColor(getResources().getColor(R.color.green));
                }else if(rb_surak_4_jauap_4.isChecked()&&
                        rb_surak_4_jauap_4.getText().toString().equals(jauaptar[0])) {
                    surak4.setText(suraktar[0] + "\n" + "Correct");
                    surak4.setTextColor(getResources().getColor(R.color.green));
                }

                else{
                    surak4.setText(suraktar[3]+"\n"+"Incorrect");
                    surak4.setTextColor(getResources().getColor(R.color.red));
                }




            }
        });

    }
}