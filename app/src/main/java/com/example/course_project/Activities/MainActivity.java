package com.example.course_project.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.course_project.Adapters.CategoryAdapter;
import com.example.course_project.Adapters.PopularAdapter;
import com.example.course_project.Domains.CategoryDomain;
import com.example.course_project.Domains.MaterialDomain;
import com.example.course_project.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button catBtn;
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();


//        catBtn = findViewById(R.id.categoryName);

//        catBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, NatureActivity.class)
//                );
//            }
//        });

    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout supportBtn = findViewById(R.id.supportBtn);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SupportActivity.class));
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.rv_category);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Натуральные", "nature_cat"));
        category.add(new CategoryDomain("Вяжущие", "vyazh_cat"));
        category.add(new CategoryDomain("Искусственные", "art_cat"));
        category.add(new CategoryDomain("Лесные", "forest_cat"));
        category.add(new CategoryDomain("Металлические", "metal_cat"));

        adapter = new CategoryAdapter(category);
        recyclerViewCategoryList.setAdapter(adapter);
        CategoryAdapter adapter_cat = new CategoryAdapter(category);

        adapter_cat.setOnItemClickListener(new CategoryAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                startActivity(new Intent(MainActivity.this, NatureActivity.class));
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.rv_popular);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<MaterialDomain> foodList = new ArrayList<>();
        foodList.add(new MaterialDomain("Песок", "nature_sand", "Этот песок прямиком из Африки", 9.76));
        foodList.add(new MaterialDomain("Дерево", "wood", "Это дерево прямиком из Канады", 8.79));
        foodList.add(new MaterialDomain("Щебень", "nature_sheb", "Этот щебень прямиком из Баткена", 8.5));

        adapter2 = new PopularAdapter(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}