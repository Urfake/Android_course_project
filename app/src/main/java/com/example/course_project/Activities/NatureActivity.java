package com.example.course_project.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.course_project.Adapters.NatureAdapter;
import com.example.course_project.Domains.NatureDomain;
import com.example.course_project.R;

import java.util.ArrayList;

public class NatureActivity extends AppCompatActivity {

    RecyclerView.Adapter adapter;
    RecyclerView recyclerViewItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature);

        recyclerViewItem();
    }

    private void recyclerViewItem() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerViewItem =  findViewById(R.id.rv_category_item);
        recyclerViewItem.setLayoutManager(linearLayoutManager);

        ArrayList<NatureDomain> natureDomains = new ArrayList<>();

        natureDomains.add(new NatureDomain("Бутовый камень", 2.44, "nature_1"));
        natureDomains.add(new NatureDomain("Щебень", 23.44, "nature_2"));
        natureDomains.add(new NatureDomain("Гравий", 0.44, "nature_3"));
        natureDomains.add(new NatureDomain("Песок", 6.44, "nature_4"));
        natureDomains.add(new NatureDomain("Брусчатка", 11.44, "nature_5"));

        adapter = new NatureAdapter(natureDomains);
        recyclerViewItem.setAdapter(adapter);

    }
}