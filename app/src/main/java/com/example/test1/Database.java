package com.example.test1;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.test1.R;

public class Database extends SQLiteOpenHelper {
        final static String DB_NAME = "db_kuis";

        public Database(Context context) {
            super(context, DB_NAME, null, 1);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE IF NOT EXISTS tbl_soal(id INTEGER PRIMARY KEY AUTOINCREMENT, soal TEXT, pil_a TEXT, pil_b TEXT, pil_c TEXT, jwban INTEGER, img BLOB)";
            db.execSQL(sql);

            ContentValues values = new ContentValues();
            values.put("soal", "Apa nama Karakter Di Gambar Ini ?");
            values.put("pil_a", "Reimu Hakurei");
            values.put("pil_b","Yukari Yakumo");
            values.put("pil_c", "Tensi Hinawari");
            values.put("jwban","0");
            values.put("img", R.drawable.rei);
            db.insert("tbl_soal", "soal", values);

            values.put("soal", "Di Game Touhou Berapakah Bercerita Tentang Karakter Di Gambar ?");
            values.put("pil_a", "Touhou 15 Legacy Of Lunatic Kingdom");
            values.put("pil_b","Touhou 15.5 Antinomy Of Common Flowwer");
            values.put("pil_c", "Touhou 17 Willy Beast Of Weaker Creatures");
            values.put("jwban","1");
            values.put("img", R.drawable.contoh);
            db.insert("tbl_soal", "soal", values);

            values.put("soal", "Apa judul lagu background dari karakter tersebut ?");
            values.put("pil_a", "Border of life");
            values.put("pil_b","U.N Owen Was Her ?");
            values.put("pil_c", "Necrofantasy");
            values.put("jwban","1");
            values.put("img", R.drawable.flandre);
            db.insert("tbl_soal", "soal", values);

            values.put("soal", "Siapa Nama Karakter Di Gambar Tersebut ?");
            values.put("pil_a", "Marisa Kirisame");
            values.put("pil_b","Remillia Scarlet");
            values.put("pil_c", "Flandre Scarlet");
            values.put("jwban","2");
            values.put("img", R.drawable.flandre);
            db.insert("tbl_soal", "soal", values);

            values.put("soal", "Siapa Nama Karakter Di Gambar Tersebut?");
            values.put("pil_a", "Aki Dan Shizuha");
            values.put("pil_b","Jo'on Dan Shion");
            values.put("pil_c", "Remillia Dan Flandre");
            values.put("jwban","1");
            values.put("img", R.drawable.contoh);
            db.insert("tbl_soal", "soal", values);

            values.put("soal", "Apa Nama Kuil Yang Dimiliki Karakter Di Gambar Ini ?");
            values.put("pil_a", "Hakurei Shrine");
            values.put("pil_b","Moriya Shrine");
            values.put("pil_c", "Mouren Shrine");
            values.put("jwban","0");
            values.put("img", R.drawable.rei);
            db.insert("tbl_soal", "soal", values);

            values.put("soal", "Apa Judul Lagu Di Gambar Ini ?");
            values.put("pil_a", "Bad Apple!");
            values.put("pil_b","Houra Nigyou");
            values.put("pil_c", "Banzai Banzai Banzai !");
            values.put("jwban","0");
            values.put("img", R.drawable.hitamputih);
            db.insert("tbl_soal", "soal", values);

            values.put("soal", "Di Game Touhou Manakah Karakter ini Muncul ?");
            values.put("pil_a", "Touhou 6");
            values.put("pil_b","Touhou 11");
            values.put("pil_c", "Touhou 12");
            values.put("jwban","0");
            values.put("img", R.drawable.patchy);
            db.insert("tbl_soal", "soal", values);

            values.put("soal", "Siapa Nama Karakter Di Gambar Ini ?");
            values.put("pil_a","Reimu Hakurei");
            values.put("pil_b", "Patchouli Knowledge");
            values.put("pil_c", "Flandre Scarlet");
            values.put("jwban","1");
            values.put("img", R.drawable.patchy);
            db.insert("tbl_soal", "soal", values);

            values.put("soal", "Di Game Touhou Manakah Karakter Di Muncul ?");
            values.put("pil_a", "Touhou 6,7,10");
            values.put("pil_b","Touhou 11,12,15,17");
            values.put("pil_c", "Semua Benar");
            values.put("jwban","2");
            values.put("img", R.drawable.hitamputih);
            db.insert("tbl_soal", "soal", values);

        }

        public List<Soal> getSoal(){
            List<Soal> listSoal = new ArrayList<Soal>();
            String query = "select * from tbl_soal";

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(query, null);

            if(cursor.moveToFirst()){
                do{
                    Soal s = new Soal();
                    s.setSoal(cursor.getString(1));
                    s.setPil_a(cursor.getString(2));
                    s.setPil_b(cursor.getString(3));
                    s.setPil_c(cursor.getString(4));
                    s.setJwban(cursor.getInt(5));
                    s.setGambar(cursor.getInt(6));
                    listSoal.add(s);
                }while(cursor.moveToNext());
            }

            return listSoal;
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS tbl_soal");
            onCreate(db);

        }

    }
