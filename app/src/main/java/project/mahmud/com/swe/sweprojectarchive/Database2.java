package project.mahmud.com.swe.sweprojectarchive;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Database2 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "proposal.db";
    private static final String TABLE_NAME = "ProposalDetails";
    private static final String COURSE = "c_name";
    private static final String L_DATE = "date";
    private static final String TYPE = "type";
    private static final int VERSION_NUMBER = 11;
    private static final String  CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"(  "+TYPE+" TEXT NOT NULL, "+COURSE+" VARCHAR(100) NOT NULL, "+L_DATE+" VARCHAR(20) NOT NULL)";
    private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+ TABLE_NAME;
    private Context context;
    public Database2(Context context) {
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
    public long insertData(ProposalDetails userDetails){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COURSE,userDetails.getCName());
        contentValues.put(L_DATE,userDetails.getLdate());
        contentValues.put(TYPE,userDetails.getPType());

        long rowId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowId;
    }
    public Cursor showAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(" SELECT * FROM " + TABLE_NAME,null);
        return cursor;
    }
}
