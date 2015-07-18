package com.android.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by JohnVenn on 2015/7/17.
 */
public class MyDBHeaper extends SQLiteOpenHelper {

    public static final String CREATE_GUEST = "Create table guest ("
            + "id integer primary key autoincrement, "
            + "name text, "
            + "account integer, "
            + "money real)";

    private Context context;

    public MyDBHeaper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_GUEST);
        Toast.makeText(context, "Create Successed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
