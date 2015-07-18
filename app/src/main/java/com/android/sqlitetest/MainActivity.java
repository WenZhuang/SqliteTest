package com.android.sqlitetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private MyDBHeaper dbHeaper;
    private SQLiteDatabase db;
    private EditText nameText, accountText, moneyText;
    private Button commitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHeaper = new MyDBHeaper(this,"Guests.db", null, 1);
        db = dbHeaper.getWritableDatabase();

        nameText = (EditText) findViewById(R.id.nameText);
        accountText = (EditText) findViewById(R.id.accountText);
        moneyText = (EditText) findViewById(R.id.moneyText);
        commitBtn = (Button) findViewById(R.id.commitBtn);

         commitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                int account = Integer.parseInt(accountText.getText().toString());
                double money = Double.parseDouble(moneyText.getText().toString());

                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("account", account);
                values.put("money", money);
                db.insert("guest", null, values);
                Toast.makeText(MainActivity.this, "提交成功", Toast.LENGTH_SHORT).show();

                nameText.setText("");
                accountText.setText("");
                moneyText.setText("");
            }
        });
    }
}
