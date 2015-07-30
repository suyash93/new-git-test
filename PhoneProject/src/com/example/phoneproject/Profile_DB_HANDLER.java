package com.example.phoneproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class Profile_DB_HANDLER {

	private myHelper DB_helper;

	public Profile_DB_HANDLER(Context C) {
		// TODO Auto-generated constructor stub
		DB_helper = new myHelper(C);
	}

	public boolean addProfile(String pn, String hd) {

		ContentValues vals = new ContentValues();
		SQLiteDatabase db = DB_helper.getWritableDatabase();

		vals.put(DB_helper.COL_HEADER, hd);
		vals.put(DB_helper.COL_NAME, pn);
		long id = db.insert(DB_helper.TABLE_NAME, null, vals);

		if (id > 0)
			return true;
		else
			return false;
	}

	public Cursor getAllData() {

		String[] colArray = { DB_helper.COL_HEADER, DB_helper.COL_NAME };

		SQLiteDatabase db = DB_helper.getWritableDatabase();
		Cursor cs = db.query(DB_helper.TABLE_NAME, colArray, null, null, null,
				null, null);

		return cs;
	}

	public int Delete_Details(String s) {

		SQLiteDatabase db = DB_helper.getWritableDatabase();
		String sA[] = { s };
		int ret = db
				.delete(DB_helper.TABLE_NAME, DB_helper.COL_NAME + "=?", sA);

		return ret;
	}

	public int update(String oName, String Nname) {

		SQLiteDatabase db = DB_helper.getWritableDatabase();
		ContentValues val = new ContentValues();
		String[] sA = { oName };

		val.put(DB_helper.COL_NAME, Nname);
		int ret = db.update(DB_helper.TABLE_NAME, val, DB_helper.COL_NAME
				+ "=?", sA);

		return ret;

	}

	/*
	 * public boolean editUserName(long id) {
	 * 
	 * ContentValues vals = new ContentValues(); SQLiteDatabase db =
	 * DB_helper.getWritableDatabase();
	 * 
	 * long id = db.update(DB_helper.TABLE_NAME, vals, , whereArgs);
	 * 
	 * return false; }
	 */
	static class myHelper extends SQLiteOpenHelper {

		private static final String dbname = "myDB";
		private static final int dbVer = 2;
		private static final String TABLE_NAME = "Profiles";
		private static final String COL_HEADER = "_id";
		private static final String COL_NAME = "Name";

		static final String TABLE_CREATE = "Create table " + TABLE_NAME + " ("
				+ COL_HEADER + " varchar(20), " + COL_NAME + " varchar(20) )";

		static final String DROP_TABLE = "Drop table if Exists " + TABLE_NAME;
		Context con;

		public myHelper(Context context) {

			super(context, dbname, null, dbVer);
			con = context;

		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			Toast.makeText(con, "Going to create table", Toast.LENGTH_SHORT)
					.show();
			try {
				db.execSQL(TABLE_CREATE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
			// TODO Auto-generated method stub
			try {

				// any data
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
