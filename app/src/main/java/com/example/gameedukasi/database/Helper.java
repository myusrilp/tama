package com.example.gameedukasi.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Helper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DBGameResource";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "ModelSkor";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SKOR = "skor";
    private static final String COLUMN_SKOR_TYPE = "skorType";
    private static final String COLUMN_NAME = "name";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_SKOR + " INTEGER," +
                    COLUMN_SKOR_TYPE + " TEXT," +
                    COLUMN_NAME + " TEXT)";

    public Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
