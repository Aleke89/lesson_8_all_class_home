package com.example.lesson_8.authentification;

import static com.example.lesson_8.database.Store_Database.COLUMN_EMAIL;
import static com.example.lesson_8.database.Store_Database.COLUMN_NAME;
import static com.example.lesson_8.database.Store_Database.COLUMN_PASSWORD;
import static com.example.lesson_8.database.Store_Database.DATABASE_TABLE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lesson_8.R;
import com.example.lesson_8.database.Store_Database;


public class regiter extends AppCompatActivity {
    EditText edt_name,edt_email,edt_pass;
    Button btn_sign_in;
    Store_Database storeDatabase;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        btn_sign_in = findViewById(R.id.btn_tirkelu);
        edt_email = findViewById(R.id.edit_email_register);
        edt_name = findViewById(R.id.edit_name_register);
        edt_pass = findViewById(R.id.edit_password_register);
        storeDatabase = new Store_Database(this);
        sqLiteDatabase = storeDatabase.getWritableDatabase();

        btn_sign_in.setOnClickListener(new View.OnClickListener() {


            private Object ContentValues;

            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(edt_name.getText())){
                    edt_name.setError("Pls enter all");
                    return;
                }
                if(TextUtils.isEmpty(edt_email.getText())){
                    edt_email.setError("Pls enter all");
                    return;
                }
                if(TextUtils.isEmpty(edt_pass.getText())){
                    edt_pass.setError("Pls enter all");
                    return;
                }
                ContentValues values = new ContentValues();
                values.put(COLUMN_NAME,edt_name.getText().toString());
                values.put(COLUMN_EMAIL,edt_email.getText().toString());
                values.put(COLUMN_PASSWORD,edt_pass.getText().toString());
                sqLiteDatabase.insert(DATABASE_TABLE,null,values);

                Intent back = new Intent(regiter.this,MainActivity.class);
                startActivity(back);
            }
        });
    }
}