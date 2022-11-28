package upi.edu.hagaibrayens.homescreen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME="Login.db";
    public static final String table_name = "tabel_users";

    public static final String row_id = "id";
    public static final String row_nama = "Nama";
    public static final String row_mail = "Mail";
    public static final String row_pass = "Pass";
    public static final String row_tgl = "TGL";
    public static final String row_telp = "Telp";
    public static final String row_alamat = "Alamat";


    public DBHelper(Context context) {
        super(context, DBNAME, null, 1 );

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase.execSQL("create table users(Nama TEXT, Mail TEXT primary key, Pass TEXT, Telp TEXT, Alamat TEXT, Tgl TEXT)");
        String query = "CREATE TABLE " + table_name + "(" + row_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + row_nama + " TEXT, " + row_mail + " TEXT, " + row_pass + " TEXT, "
                + row_tgl + " TEXT, " + row_telp + " INTEGER, " + row_alamat + " TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + table_name);
        sqLiteDatabase= getWritableDatabase();
    }

    public Boolean insertData(String Nama, String Pass, String Mail, String Alamat, String Telp, String Tgl){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(row_nama, Nama);
        values.put(row_mail, Mail);
        values.put(row_pass, Pass);
        values.put(row_alamat, Alamat);
        values.put(row_telp, Telp);
        values.put(row_tgl, Tgl);

        long result= sqLiteDatabase.insert(table_name, null, values);
        if (result==-1) return false;
        else
            return true;
    }

    public Boolean checkmail(String Mail){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + table_name + " where Mail=?", new String[] {Mail});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkmailpass(String Mail, String Pass){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + table_name + " where Mail=? and Pass=? ", new String[] {Mail,Pass});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
