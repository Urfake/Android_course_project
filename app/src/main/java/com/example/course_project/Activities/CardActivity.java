package com.example.course_project.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.course_project.R;

public class CardActivity extends AppCompatActivity {

    EditText et_card_number;
    TextView tv_total;
    Button btn_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        init();

        String price = getIntent().getStringExtra("total_price");
        tv_total.setText("Ваша сумма составила: "+price);

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), MainActivity.class));
            }
        });
    }

    private void init(){
        tv_total = findViewById(R.id.tv_total_price_card);
        btn_pay = findViewById(R.id.btn_pay);
    }
}