package com.example.course_project.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.course_project.R;

public class MoneyActivity extends AppCompatActivity {

    private TextView total_price;
    private Button btn_accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);

        init();

        Intent intent = getIntent();
        String price = intent.getStringExtra("total_price");
        total_price.setText("Ваша сумма составила: "+price);

        btn_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Мы вас ожидаем", Toast.LENGTH_LONG);
                startActivity(new Intent(MoneyActivity.this, MainActivity.class));
            }
        });
    }

    private void init(){
        total_price = findViewById(R.id.tv_total_price);
        btn_accept = findViewById(R.id.btn_accept);
    }
}