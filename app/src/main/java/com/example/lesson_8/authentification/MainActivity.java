package com.example.lesson_8.authentification;

import static com.example.lesson_8.database.Store_Database.COLUMN_EMAIL;
import static com.example.lesson_8.database.Store_Database.COLUMN_NAME;
import static com.example.lesson_8.database.Store_Database.COLUMN_PASSWORD;
import static com.example.lesson_8.database.Store_Database.DATABASE_TABLE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lesson_8.my_cabinet.MyCabinetActivity;
import com.example.lesson_8.R;
import com.example.lesson_8.database.Store_Database;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText edit_email,edit_password;
    Button btn_sign_in,btn_register;
    Boolean email,pass;
    Store_Database storeDatabase;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btn_sign_in = findViewById(R.id.btn_sing_in);
        btn_register = findViewById(R.id.btn_register);
        edit_email = findViewById(R.id.log_email);
        edit_password = findViewById(R.id.log_password);
        storeDatabase = new Store_Database(this);
        sqLiteDatabase = storeDatabase.getWritableDatabase();

        btn_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent registrationIntent = new Intent(MainActivity.this,regiter.class);
                startActivity(registrationIntent);
            }
        });
        btn_sign_in.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(TextUtils.isEmpty(edit_email.getText())){
                    edit_email.setError(getString(R.string.notification_empthy_enter_all));
                    return;
                }
                if(TextUtils.isEmpty(edit_password.getText())){
                    edit_password.setError(getString(R.string.notification_empthy_enter_all));
                    return;
                }
                String uEmail = edit_email.getText().toString();
                String uPassword = edit_password.getText().toString();
                Cursor loginCursor = sqLiteDatabase.rawQuery("SELECT * FROM "+DATABASE_TABLE+ " WHERE "+
                        COLUMN_EMAIL+" =? AND "+ COLUMN_PASSWORD + "=?",new String[]{uEmail,uPassword});
                if(loginCursor != null && loginCursor.getCount()>0){
                    loginCursor.moveToFirst();
                    @SuppressLint("Range")
                    String userName = loginCursor.getString(loginCursor.getColumnIndex(COLUMN_NAME));
                    Toast.makeText(MainActivity.this, "Welcome "+userName, Toast.LENGTH_LONG).show();
                    Intent sign= new Intent(MainActivity.this, MyCabinetActivity.class);
                    sign.putExtra("name",userName);
                    sign.putExtra("email",uEmail);
                    sign.putExtra("password",uPassword);
                    startActivity(sign);
                }else{
                    Toast.makeText(MainActivity.this, "Incorrect email address or password", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
    public void multi_Language(String localeCode){
        Resources resources = getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
            config.setLocale(new Locale(localeCode.toLowerCase()));
        }else{
            config.locale = new Locale(localeCode.toLowerCase());

        }
        resources.updateConfiguration(config,dm);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.multiple_language_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.kaz:
                multi_Language("kk");
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                break;
            case R.id.rus:
                multi_Language("ru");
                Intent intent2 = getIntent();
                finish();
                startActivity(intent2);
                break;
        }
        return true;
    }
}