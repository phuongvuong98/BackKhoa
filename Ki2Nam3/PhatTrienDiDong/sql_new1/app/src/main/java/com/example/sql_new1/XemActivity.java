package com.example.sql_new1;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Vector;

public class XemActivity extends AppCompatActivity {

    EditText find;
    Button btnFind;
    TextView data;
    Button btnLocal;
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem);

        find = findViewById(R.id.find);
        btnFind = findViewById(R.id.btnFind);
        btnLocal = findViewById(R.id.btnLocal);
        wv = (WebView) findViewById(R.id.wv);


        btnFind.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                Vector<String> vec = getData(find.getText().toString());
//                String s = vec.get(0) + " " + vec.get(1);
//                data.setText(s);
                wv.loadUrl(find.getText().toString());

            }
        });


    }
    public Vector<String> getData(String s) {
        DatabaseHelper db = new DatabaseHelper(this);
        return db.findData(s);
    };
}
