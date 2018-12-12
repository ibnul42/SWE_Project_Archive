package project.mahmud.com.swe.sweprojectarchive;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Database4 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "submit.db";
    private static final String TABLE_NAME = "SubmitDetails";
    private static final String TITLE = "title";
    private static final String LANGUAGE = "lang";
    private static final String DESC = "des";
    private static final int VERSION_NUMBER = 11;
    private static final String  CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"(  "+TITLE+" VARCHAR(255) NOT NULL ,"+LANGUAGE+" VARCHAR(255) NOT NULL, "+DESC+" TEXT NOT NULL)";
    private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+ TABLE_NAME;
    private Context context;
    public Database4(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }
    public List<SubmitDetails> getSubmit(){

        SQLiteDatabase db =getReadableDatabase();
        SQLiteQueryBuilder qb= new SQLiteQueryBuilder();

        String[] sqlSelect={"title","lang","des"};
        String tablename= "SubmitDetails";

        qb.setTables(tablename);
        Cursor cursor = qb.query(db,sqlSelect, null,null,null,null,null);
        List<SubmitDetails> show =new ArrayList<>();

        if(cursor.moveToFirst()){
            do{
                SubmitDetails submitDetails=new SubmitDetails();
                submitDetails.setTitle(cursor.getString(cursor.getColumnIndex(TITLE)));
                submitDetails.setLanguage(cursor.getString(cursor.getColumnIndex(LANGUAGE)));
                submitDetails.setDes(cursor.getString(cursor.getColumnIndex(DESC)));

                show.add(submitDetails);
            }while(cursor.moveToNext());

        }


        return show;
    }
    public List<String> getTitles(){

        SQLiteDatabase db =getReadableDatabase();
        SQLiteQueryBuilder qb= new SQLiteQueryBuilder();

        String[] sqlSelect={"title"};
        String tablename= "SubmitDetails";

        qb.setTables(tablename);
        Cursor cursor = qb.query(db,sqlSelect, null,null,null,null,null);
        List<String> show =new ArrayList<>();

        if(cursor.moveToFirst()){
            do{


                show.add(cursor.getString(cursor.getColumnIndex(TITLE)));
            }while(cursor.moveToNext());

        }


        return show;
    }
    public List<SubmitDetails> getSubmitByname(String title){

            SQLiteDatabase db =getReadableDatabase();
            SQLiteQueryBuilder qb= new SQLiteQueryBuilder();

            String[] sqlSelect={"title","lang","des"};
            String tablename= "SubmitDetails";

            qb.setTables(tablename);
            Cursor cursor  = qb.query(db,sqlSelect, "Title LIKE ?",new String[]{"%"+title+"%"},null,null,null);
            List<SubmitDetails> show =new ArrayList<>();

            if(cursor.moveToFirst()){
                do{
                    SubmitDetails submitDetails=new SubmitDetails();
                    submitDetails.setTitle(cursor.getString(cursor.getColumnIndex(TITLE)));
                    submitDetails.setLanguage(cursor.getString(cursor.getColumnIndex(LANGUAGE)));
                    submitDetails.setDes(cursor.getString(cursor.getColumnIndex(DESC)));

                    show.add(submitDetails);
                }while(cursor.moveToNext());

            }


            return show;
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
    public long insertData(SubmitDetails submitDetails){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TITLE,submitDetails.getTitle());
        contentValues.put(LANGUAGE,submitDetails.getLanguage());
        contentValues.put(DESC,submitDetails.getDes());

        long rowId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowId;
    }
    public Cursor showAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(" SELECT * FROM " + TABLE_NAME,null);
        return cursor;
    }


}
