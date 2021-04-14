package com.example.productswithdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProductsDB {
    private DBHelper dbHelper;

    public ProductsDB(Context ctx) {
        dbHelper = new DBHelper(ctx);
    }

    public void insertProduct(Product product) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(DBHelper.FIELD_PRODUCT_NAME, product.name);
        cv.put(DBHelper.FIELD_PRODUCT_QUANTITY, product.quantity);

        db.insert(DBHelper.TABLE_PRODUCTS, null, cv);

        db.close();
    }

    public Product getProduct(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selection = "id=?";
        String[] selectionArgs = {"" + id};

        Cursor cursor = db.query(DBHelper.TABLE_PRODUCTS, null,
                selection, selectionArgs,
                null, null, null);

        Product product = null;

        if(cursor.moveToFirst()) {
            product = new Product();

            product.id = cursor.getInt(cursor.getColumnIndex(DBHelper.FIELD_PRODUCT_ID));
            product.name = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_PRODUCT_NAME));
            product.quantity = cursor.getInt(cursor.getColumnIndex(DBHelper.FIELD_PRODUCT_QUANTITY));
        }

        //if you have more than one row
//        while (cursor.moveToNext()) {
//            // read data
//        }

        cursor.close();
        db.close();

        return product;
    }
}
