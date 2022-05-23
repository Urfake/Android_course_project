package com.example.course_project.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.course_project.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SupportActivity extends AppCompatActivity {

    TextView tv_email, tv_subject, tv_description;
    EditText et_email, et_subject, et_description;
    Button btn_send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        init();
        bottomNavigation();

        if( et_email.getText().toString().length() == 0 )
            et_email.setError( "Требуется email!" );
        if( et_subject.getText().toString().length() == 0 )
            et_subject.setError( "Требуется тема сообщения!" );
        if( et_description.getText().toString().length() == 0 )
            et_description.setError( "Требуется сообщение!" );
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }

    private void init(){

        tv_email = findViewById(R.id.tv_email);
        tv_subject = findViewById(R.id.tv_subject);
        tv_description = findViewById(R.id.tv_description);

        et_email = findViewById(R.id.et_email);
        et_subject = findViewById(R.id.et_subject);
        et_description = findViewById(R.id.et_description);

        btn_send = findViewById(R.id.btn_send);

    }

    protected void sendEmail() {
        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_EMAIL,  new String[] {et_email.getText().toString()});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, et_subject.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT, et_description.getText().toString());
        try {
            startActivity(Intent.createChooser(emailIntent, "Отправка email'а..."));
            finish();
            Log.i("Завершение", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(SupportActivity.this, "Не установлен email клиент.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout supportBtn = findViewById(R.id.supportBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupportActivity.this, CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupportActivity.this, MainActivity.class));
            }
        });

        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupportActivity.this, SupportActivity.class));
            }
        });
    }
}