package project.mahmud.com.swe.sweprojectarchive;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn2Activity extends AppCompatActivity implements View.OnClickListener {

    Database3 databaseHelper;
    private Button signInButton,signUpButton;
    private EditText emailEditText ;
    private EditText passwordEditText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_sign_in2);
        signInButton =  findViewById(R.id.signInButtonId);
        signUpButton =  findViewById(R.id.signUpButtonId);
        emailEditText =  findViewById(R.id.signInusernameEditTextId);
        passwordEditText =  findViewById(R.id.signInpasswordEditTextId);

        databaseHelper =new Database3(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        signInButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String uname = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if(v.getId()==R.id.signInButtonId){

            Boolean result = databaseHelper.findPassword(uname,password);

            if(result){

                //Toast.makeText(SignInActivity.this,"next activity",Toast.LENGTH_LONG).show();
                startActivity(new Intent(SignIn2Activity.this,Main2Activity.class));
            }else{
                Toast.makeText(getApplicationContext(), "Wrong Email and Password!",Toast.LENGTH_LONG).show();
            }
        }else if(v.getId()==R.id.signUpButtonId){
            Intent intent=new Intent(SignIn2Activity.this,SignUp2Activity.class);
            startActivity(intent);
        }

    }
}
