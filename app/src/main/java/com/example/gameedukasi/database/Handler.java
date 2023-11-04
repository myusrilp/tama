package com.example.gameedukasi.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gameedukasi.model.ModelSkor;

import java.util.ArrayList;
import java.util.List;

// BERIKUT CONTOH PENGGUNAAN ID DAN SKOR TIPE
// ID DAN SKOR TIPE YANG DIGUNAKAN UNTUK SETIAP SOAL WAJIB BERBEDA,
// CONTOH UNTUK ID = 1 DAN SKOR TIPE = HEWAN, MAKA DIPERUNTUKKAN UNTUK TEBAK GAMBAR HEWAN,
// MAKA DARI ITU, ID = 1, DAN SKOR TIPE = HEWAN TIDAK BOLEH DIGUNAKAN UNTUK SOAL TEBAK GAMBAR LAIN,
// SILAHKAN TENTUKAN SENDISI BERAPA ID DAN APA SKOR TIPE UNTUK QUIZ LAINNYA
// ID DAN TIPE SKOR AKAN DIGUNAKAN SETIAP KALI MENYIMPAN NILAI TERTINGGI YANG BARU

public class Handler {
    private Helper dbHelper;
    private SQLiteDatabase database;

    public Handler(Context context) {
        dbHelper = new Helper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long insertModelSkor(int id, int skor, String skorType, String name) {
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("skor", skor);
        values.put("skorType", skorType);
        values.put("name", name);

        return database.insert("ModelSkor", null, values);
    }

    public ModelSkor getModelSkorById(int id) {
        ModelSkor modelSkor = null;

        Cursor cursor = database.rawQuery("SELECT * FROM ModelSkor WHERE id = ?", new String[]{String.valueOf(id)});

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                @SuppressLint("Range") int skor = cursor.getInt(cursor.getColumnIndex("skor"));
                @SuppressLint("Range") String skorType = cursor.getString(cursor.getColumnIndex("skorType"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));

                modelSkor = new ModelSkor(id, skor, skorType, name);
            }

            cursor.close();
        }

        return modelSkor;
    }

    public List<ModelSkor> getAllModelSkor() {
        List<ModelSkor> modelSkorList = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM ModelSkor", null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
                    @SuppressLint("Range") int skor = cursor.getInt(cursor.getColumnIndex("skor"));
                    @SuppressLint("Range") String skorType = cursor.getString(cursor.getColumnIndex("skorType"));
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));

                    ModelSkor modelSkor = new ModelSkor(id, skor, skorType, name);
                    modelSkorList.add(modelSkor);
                } while (cursor.moveToNext());
            }

            cursor.close();
        }

        return modelSkorList;
    }
    public int updateModelSkor(int id, int newSkor, String newSkorType, String newName) {
        ContentValues values = new ContentValues();
        values.put("skor", newSkor);
        values.put("skorType", newSkorType);
        values.put("name", newName);

        String whereClause = "id = ?";
        String[] whereArgs = {String.valueOf(id)};

        return database.update("ModelSkor", values, whereClause, whereArgs);
    }

    public long insertOrUpdateModelSkor(int id, int skor, String skorType, String name) {
        // Check if a row with the given skorType already exists
        Cursor cursor = database.rawQuery("SELECT id FROM ModelSkor WHERE skorType = ?", new String[]{skorType});

        if (cursor != null && cursor.getCount() > 0) {
            // The row with the skorType exists, perform an update
            ContentValues values = new ContentValues();
            values.put("skor", skor);
            values.put("name", name);

            String whereClause = "skorType = ?";
            String[] whereArgs = {skorType};

            int rowsUpdated = database.update("ModelSkor", values, whereClause, whereArgs);

            cursor.close();

            return rowsUpdated;
        } else {
            // The row with the skorType does not exist, perform an insert
            ContentValues values = new ContentValues();
            values.put("id", id);
            values.put("skor", skor);
            values.put("skorType", skorType);
            values.put("name", name);

            long result = database.insert("ModelSkor", null, values);

            if (cursor != null) {
                cursor.close();
            }

            return result;
        }
    }
}
