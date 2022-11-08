package upi.edu.hagaibrayens.homescreen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME="Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table users(Nama TEXT, Mail TEXT primary key, Pass TEXT, Telp TEXT, Alamat TEXT, Tgl TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
    }

    public Boolean insertData(String Nama, String Pass, String Mail, String Alamat, String Telp, String Tgl){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("Nama", Nama);
        values.put("Mail", Mail);
        values.put("Pass", Pass);
        values.put("Alamat", Alamat);
        values.put("Telp", Telp);
        values.put("Tgl", Tgl);

        long result= sqLiteDatabase.insert("users", null, values);
        if (result==-1) return false;
        else
            return true;
    }

    public Boolean checkmail(String Mail){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from users where Mail=?", new String[] {Mail});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkmailpass(String Mail, String Pass){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from users where Mail=? and Pass=?", new String[] {Mail,Pass});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
