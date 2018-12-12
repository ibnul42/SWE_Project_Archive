package project.mahmud.com.swe.sweprojectarchive;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Reg.db";
    private static final String TABLE_NAME = "RegisterDetails";
    private static final String F_NAME = "f_name";
    private static final String L_NAME = "l_name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "pass";
    private static final String INSTITUTE = "institute";
    private static final int VERSION_NUMBER = 11;
    private static final String  CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"(  "+F_NAME+" VARCHAR(255) NOT NULL ,"+L_NAME+" VARCHAR(255) NOT NULL, "+EMAIL+" TEXT NOT NULL,"+PASSWORD+" TEXT NOT NUll,"+INSTITUTE+" TEXT NOT NULL)";
    private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+ TABLE_NAME;
    private Context context;
    public Database(Context context) {
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
    public long insertData(Userdetails userDetails){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(F_NAME,userDetails.getFName());
        contentValues.put(L_NAME,userDetails.getLname());
        contentValues.put(EMAIL,userDetails.getEmail());
        contentValues.put(PASSWORD,userDetails.getPassword());
        contentValues.put(INSTITUTE,userDetails.getInstitute());

        long rowId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowId;
    }

    public Boolean findPassword(String mail,String pass)
    {
        SQLiteDatabase sqLiteDatabase =this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        Boolean result = false;
        if(cursor.getCount()==0){
            Toast.makeText(context,"No Data is found.",Toast.LENGTH_LONG).show();
        }else{
            while (cursor.moveToNext()){
                String email = cursor.getString(2);
                String password = cursor.getString(3);

                if(email.equals(mail) && password.equals(pass)){
                    result = true ;
                    break;
                }
            }
        }
        return result;
    }
}
