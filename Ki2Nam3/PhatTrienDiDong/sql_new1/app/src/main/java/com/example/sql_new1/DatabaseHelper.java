package com.example.sql_new1;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.Vector;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "SinhVien", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE SinhVien (MSSV TEXT PRIMARY KEY, TEN TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public Boolean addData(String item1, String item2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MSSV", item1);
        contentValues.put("TEN", item2);

        long rs = db.insert("SinhVien", null, contentValues);
        if (rs == -1)
            return false;
        else
            return true;
    }

    public Vector<String> findData(String s) {
        Vector<String> v = new Vector<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM SinhVien WHERE MSSV = " + s;
//        Cursor cursor = db.query("SinhVien", new String[] {"MSSV", "TEN"}, "MSSV=?", new String[] {s }, null, null, null, null);
        Cursor cursor = db.rawQuery(sql, null);
        System.out.println("duy456");
//        StringBuffer stringBuffer = new StringBuffer();

//        v.add(cursor.getString(0));
//        v.add("hj");
//        v.add(cursor.getString(1));
        cursor.getInt(0);
        return v;
    }
}
