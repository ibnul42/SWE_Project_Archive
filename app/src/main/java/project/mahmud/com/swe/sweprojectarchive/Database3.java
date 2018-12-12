package project.mahmud.com.swe.sweprojectarchive;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Database3 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Register.db";
    private static final String TABLE_NAME = "Register2Details";
    private static final String F_NAME = "f_name";
    private static final String U_NAME = "u_name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "pass";
    private static final String INSTITUTE = "institute";
    private static final int VERSION_NUMBER = 11;
    private static final String  CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"(  "+F_NAME+" VARCHAR(255) NOT NULL ,"+U_NAME+" VARCHAR(255) NOT NULL, "+EMAIL+" TEXT NOT NULL,"+PASSWORD+" TEXT NOT NUll,"+INSTITUTE+" TEXT NOT NULL)";
    private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+ TABLE_NAME;
    private Context context;
    public Database3(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try {

            sqLiteDatabase.execSQL(CREATE_TABLE);
        }
        catch (Exception e){
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_LONG ).show();

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase , int oldVersion, int newVersion) {
        try{

            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
        }
        catch(Exception e){
            Toast.makeText(context, "Exception : "+e,Toast.LENGTH_LONG).show();
        }
    }
    public long insertData(User2details user2Details){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(F_NAME,user2Details.getFName());
        contentValues.put(U_NAME,user2Details.getLname());
        contentValues.put(EMAIL,user2Details.getEmail());
        contentValues.put(PASSWORD,user2Details.getPassword());
        contentValues.put(INSTITUTE,user2Details.getInstitute());

        long rowId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowId;
    }

    public Boolean findPassword(String uname,String pass)
    {
        SQLiteDatabase sqLiteDatabase =this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        Boolean result = false;
        if(cursor.getCount()==0){
            Toast.makeText(context,"No Data is found.",Toast.LENGTH_LONG).show();
        }else{
            while (cursor.moveToNext()){
                String u_name = cursor.getString(1);
                String password = cursor.getString(3);

                if(u_name.equals(uname) && password.equals(pass)){
                    result = true ;
                    break;
                }
            }
        }
        return result;
    }
}
