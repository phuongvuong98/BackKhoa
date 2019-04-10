package com.example.sql_new1;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class NhapActivity extends AppCompatActivity {
    DatabaseHelper  db;
    EditText edtTen;
    EditText edtMSSV;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap);
        edtTen = findViewById(R.id.ten);
        edtMSSV = findViewById(R.id.mssv);
        btnAdd = findViewById(R.id.add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData(edtMSSV.getText().toString(), edtTen.getText().toString());
            }
        });
    }
    public void addData(String s1, String s2) {
        db = new DatabaseHelper(this);
        boolean b = db.addData(s1,s2);
        if (b) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        }
    }
}
