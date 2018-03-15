package com.example.vijaygarg.workshop.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.vijaygarg.workshop.WorkShopModel;

import java.util.ArrayList;

/**
 * Created by vijaygarg on 13/03/18.
 */

public class CredentialDatabase extends SQLiteOpenHelper {
    public static final String DATABASENAME="workshop.db";
    public static final String TABLENAME="credential";
    public static final String COLUMN0="ID";
    public static final String COLUMN1="firstname";
    public static final String COLUMN2="lastname";
    public static final String COLUMN3="email";
    public static final String COLUMN4="password";
    public final Context context;

    public CredentialDatabase(Context context) {
        super(context, DATABASENAME, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();

        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="CREATE TABLE "+TABLENAME+" ("+COLUMN0+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN1+" TEXT,"+COLUMN2+" TEXT,"+COLUMN3+" TEXT,"+COLUMN4+" TEXT)";
            sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLENAME);
    onCreate(sqLiteDatabase);
    }
    public boolean insertdata(String firstname,String lastname,String email,String password){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN1,firstname);
        contentValues.put(COLUMN2,lastname);
        contentValues.put(COLUMN3,email);
        contentValues.put(COLUMN4,password);

        long result=db.insert(TABLENAME,null,contentValues);
        if(result==-1){
        return false;}
        else{
            return true;
        }
    }
    public boolean searchuser(String uname,String pass){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ TABLENAME,null);
        boolean result=false;
        while(cursor.moveToNext()){
            String username=cursor.getString(3);
            String password=cursor.getString(4);
            if(username.equals(uname)&&pass.equals(password)){
            return true;
            }
        }
return false;
    }
}
