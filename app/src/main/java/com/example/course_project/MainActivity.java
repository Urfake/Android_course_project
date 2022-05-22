package com.example.course_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.course_project.Adapters.CategoryAdapter;
import com.example.course_project.Adapters.PopularAdapter;
import com.example.course_project.Domains.CategoryDomain;
import com.example.course_project.Domains.MaterialDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Кирпичи", "cat_1"));
        category.add(new CategoryDomain("Плитка", "cat_2"));
        category.add(new CategoryDomain("Цемент", "cat_3"));
        category.add(new CategoryDomain("Материал", "cat_4"));
        category.add(new CategoryDomain("Цемент", "cat_5"));

        adapter = new CategoryAdapter(category);
        recyclerViewCategoryList.setAdapter(adapter);

    }

    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<MaterialDomain> materialList = new ArrayList<>();
        materialList.add(new MaterialDomain("Какой-то текст", "mat_1", "Какое то длинное описание продукта", 4.14));
        materialList.add(new MaterialDomain("Какой-то текст", "mat_1", "Какое то длинное описание продукта", 4.14));
        materialList.add(new MaterialDomain("Какой-то текст", "mat_1", "Какое то длинное описание продукта", 4.14));

        adapter2 = new PopularAdapter(materialList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}