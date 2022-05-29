package com.example.course_project.Helper;

import android.content.Context;
import android.widget.Toast;


import com.example.course_project.Domains.MaterialDomain;
import com.example.course_project.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(MaterialDomain item) {
        ArrayList<MaterialDomain> listMaterial = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listMaterial.size(); i++) {
            if (listMaterial.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready) {
            listMaterial.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            listMaterial.add(item);
        }
        tinyDB.putListObject("CartList", listMaterial);
        Toast.makeText(context, "Добавлен в корзину", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<MaterialDomain> getListCart() {
        return tinyDB.getListObject("CartList");
    }

    public void plusNumberFood(ArrayList<MaterialDomain> listMaterial, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listMaterial.get(position).setNumberInCart(listMaterial.get(position).getNumberInCart() + 1);
        tinyDB.putListObject("CartList", listMaterial);
        changeNumberItemsListener.changed();
    }

    public void minusNumberFood(ArrayList<MaterialDomain> listMaterial, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listMaterial.get(position).getNumberInCart() == 1) {
            listMaterial.remove(position);
        } else {
            listMaterial.get(position).setNumberInCart(listMaterial.get(position).getNumberInCart() - 1);
        }
        tinyDB.putListObject("CartList", listMaterial);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<MaterialDomain> listMaterial = getListCart();
        double fee = 0;
        for (int i = 0; i < listMaterial.size(); i++) {
            fee = fee + (listMaterial.get(i).getFee() * listMaterial.get(i).getNumberInCart());
        }
        return fee;
    }
}
