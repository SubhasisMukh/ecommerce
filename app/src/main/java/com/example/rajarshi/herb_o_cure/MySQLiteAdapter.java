package com.example.rajarshi.herb_o_cure;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Rajarshi on 7/17/2017.
 */

public class MySQLiteAdapter {
    Context context;
    MySQLiteOpenHelper mySQLiteOpenHelper;

    public MySQLiteAdapter(Context context) {
        this.context = context;
        mySQLiteOpenHelper = new MySQLiteOpenHelper(context);
    }

    public long InsertRecord(String usr_name, String email_id, String passwd, String ph_no) {
        SQLiteDatabase db = mySQLiteOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(mySQLiteOpenHelper.USERNAME, usr_name);
        contentValues.put(mySQLiteOpenHelper.EMAIL, email_id);
        contentValues.put(mySQLiteOpenHelper.PASSWORD, passwd);
        contentValues.put(mySQLiteOpenHelper.PHONE_NUMBER, ph_no);


        long id = db.insert(MySQLiteOpenHelper.TABLE_NAME, null, contentValues);
        Log.e("My db TAG"," "+id );
        return id;
    }


    public String DisplayAllRecords(String showdetails_usrmail) {
        SQLiteDatabase db = mySQLiteOpenHelper.getWritableDatabase();
        String[] columns = {MySQLiteOpenHelper.USERNAME, MySQLiteOpenHelper.EMAIL, MySQLiteOpenHelper.PASSWORD, MySQLiteOpenHelper.PHONE_NUMBER};
        Cursor cursor = db.rawQuery("select * from " + mySQLiteOpenHelper.TABLE_NAME + " where e_mail = '" + showdetails_usrmail + "'", null);
        cursor.moveToFirst();
        StringBuffer buffer = new StringBuffer();

        String name = cursor.getString(cursor.getColumnIndex(MySQLiteOpenHelper.USERNAME));
        String emaill = cursor.getString(cursor.getColumnIndex(MySQLiteOpenHelper.EMAIL));
        String passwordd = cursor.getString(cursor.getColumnIndex(MySQLiteOpenHelper.PASSWORD));
        String phnoo = cursor.getString(cursor.getColumnIndex(MySQLiteOpenHelper.PHONE_NUMBER));

        buffer.append("Name :" + name + "\n" + "Email :" + emaill + "\n" + "Password :" + passwordd + "\n" + "Phone no. :" + phnoo);
        return buffer.toString();

    }



    public String getUserNamefromEmail(String emailpassed){
        SQLiteDatabase db = mySQLiteOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(MySQLiteOpenHelper.TABLE_NAME, null, MySQLiteOpenHelper.EMAIL + " = ?", new String[]{emailpassed}, null, null, null);
        cursor.moveToFirst();
        String returned_username = cursor.getString(cursor.getColumnIndex(MySQLiteOpenHelper.USERNAME));
        cursor.close();
        return returned_username;
    }


    //Doubt portion

    public String getSingleEntry(String usrname) {

        SQLiteDatabase db = mySQLiteOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(MySQLiteOpenHelper.TABLE_NAME, null, MySQLiteOpenHelper.EMAIL + " = ?", new String[]{usrname}, null, null, null);
        if (cursor.getCount() < 1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String returned_pass = cursor.getString(cursor.getColumnIndex(MySQLiteOpenHelper.PASSWORD));
        cursor.close();
        return returned_pass;
    }


    public class MySQLiteOpenHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "customer.db";
        private static final String TABLE_NAME = "customer_table";
        private static final int DATABASE_VERSION = 3;
        private static final String USERNAME = "user_name";
        private static final String PHONE_NUMBER = "phone_number";
        private static final String EMAIL = "e_mail";
        private static final String PASSWORD = "password";


        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + USERNAME + " VARCHAR(255), " + EMAIL + " VARCHAR(255) PRIMARY KEY, " + PASSWORD + " VARCHAR(255), " + PHONE_NUMBER + " VARCHAR(255));";


        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
        private Context context;

        public MySQLiteOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Toast.makeText(context, "On upgrade called............", Toast.LENGTH_SHORT).show();
            try {
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (Exception e) {
                Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
            }
        }
    }

}
