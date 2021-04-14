package com.example.productswithdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtID;
    EditText txtName;
    EditText txtQuantity;

    ProductsDB productsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtID = findViewById(R.id.txtID);
        txtName = findViewById(R.id.txtName);
        txtQuantity = findViewById(R.id.txtQuantity);

        productsDB = new ProductsDB(this);
    }

    public void saveProduct(View view) {
        Product product = new Product();
        product.name = txtName.getText().toString();
        product.quantity = Integer.parseInt(txtQuantity.getText().toString());

        productsDB.insertProduct(product);
    }

    public void loadProduct(View view) {
        int id = Integer.parseInt(txtID.getText().toString());

        Product product = productsDB.getProduct(id);

        txtName.setText(product.name);
        txtQuantity.setText("" + product.quantity);
    }



}