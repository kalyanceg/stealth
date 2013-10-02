package com.example.budget;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbUtil extends SQLiteOpenHelper{
static int DB_VER=8;
	public dbUtil(Context applicationcontext) {
	  super(applicationcontext, "budgetapp.db", null, DB_VER);

	}

@Override
public void onCreate(SQLiteDatabase db) {
	// TODO Auto-generated method stub
	String CREATE_EVENTS_TABLE="Create table Events( inserttime datetime primary key, IncorDec int, Amount real, Cat TEXT)";
	db.execSQL(CREATE_EVENTS_TABLE);
	String CREATE_BALANCE_TABLE="Create table Balance(Amount real)";
	db.execSQL(CREATE_BALANCE_TABLE);
	String CREATE_CAT_TABLE="Create table CAT( CatId INTEGER primary key AUTOINCREMENT,category TEXT)";
	db.execSQL(CREATE_CAT_TABLE);
	
}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	// TODO Auto-generated method stub
	db.execSQL("DROP TABLE IF EXISTS Events");
	db.execSQL("DROP TABLE IF EXISTS Balance");
	db.execSQL("DROP TABLE IF EXISTS CAT");
	onCreate(db);
}
public boolean insertCat(SQLiteDatabase db,String st){
	try{
		String insert_query="insert into CAT (category) values('"+st+"')";
	
	db.execSQL(insert_query);
	return true;
	}
	catch(Exception e){
		return false;
	}
}
public ArrayList<String> selectCat(SQLiteDatabase db){
	String selectquery="select category from CAT";
	Cursor cursor = db.rawQuery(selectquery, null);
	ArrayList<String>catList=new ArrayList<String>();
	if (cursor.moveToFirst()) {
        do {
        	catList.add(cursor.getString(0));
        }while (cursor.moveToNext());
	}
	return catList;
}
public boolean decrement(SQLiteDatabase db,String cat,float f){
	String insert_query="insert into Events values(  datetime(), 0,"+ f+",'"+cat+"')";
	db.execSQL(insert_query);
	String selectquery="select * from Balance";
	Cursor cursor = db.rawQuery(selectquery, null);
	
    // looping through all rows and adding to list
	if (cursor.getCount()>0 && f>0) {
	cursor.moveToFirst();
    
    double curbalance=cursor.getDouble(0);
    double newcurbalance=curbalance-f;
    
    String insert_balance="insert into Balance values("+newcurbalance+")";
    db.execSQL(insert_balance);
    String deleteOldBalance="Delete from Balance where Amount="+curbalance;
    db.execSQL(deleteOldBalance);
    return true;
	}
	else
	{
		if(f>0){
		float	negf=-f;
		String insert_balance="insert into Balance values("+negf+")";
	    db.execSQL(insert_balance);
	    return true;
	    
		}
		
		
	}
	
	
	return false;
}

public boolean increment(SQLiteDatabase db,String value){
	float f=Float.parseFloat(value);
	String insert_query="insert into Events values(  datetime(), 1,"+ f+", NULL )";
	db.execSQL(insert_query);
	String selectquery="select * from Balance";
	Cursor cursor = db.rawQuery(selectquery, null);
	
    // looping through all rows and adding to list
	if (cursor.getCount()>0 && f>0) {
	cursor.moveToFirst();
    
    double curbalance=cursor.getDouble(0);
    double newcurbalance=curbalance+f;
    
    String insert_balance="insert into Balance values("+newcurbalance+")";
    db.execSQL(insert_balance);
    String deleteOldBalance="Delete from Balance where Amount="+curbalance;
    db.execSQL(deleteOldBalance);
    return true;
	}
	else
	{
		if(f>0){
		String insert_balance="insert into Balance values("+f+")";
	    db.execSQL(insert_balance);
	    return true;
		}
	}
	
	
	return false;
}
}