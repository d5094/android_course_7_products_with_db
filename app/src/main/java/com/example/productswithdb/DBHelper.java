package com.example.productswithdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "ProductsDB";
    private static final int DB_VERSION = 1;

    public static final String TABLE_PRODUCTS = "Products";
    public static final String FIELD_PRODUCT_ID = "id";
    public static final String FIELD_PRODUCT_NAME = "name";
    public static final String FIELD_PRODUCT_QUANTITY = "quantity";

    private static final String CREATE_PRODUCTS = "CREATE TABLE IF NOT EXISTS " + TABLE_PRODUCTS + " (" +
            FIELD_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FIELD_PRODUCT_NAME + " TEXT," +
            FIELD_PRODUCT_QUANTITY + " INTEGER)";

    private static final String DROP_PRODUCTS = "DROP TABLE IF EXISTS " + TABLE_PRODUCTS;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PRODUCTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_PRODUCTS);
        onCreate(db);
    }
}
