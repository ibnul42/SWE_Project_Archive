package project.mahmud.com.swe.sweprojectarchive;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    Database databaseHelper;
    private Button signInButton,signUpButton;
    private EditText emailEditText ;
    private EditText passwordEditText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signInButton =  findViewById(R.id.signInButtonId);
        signUpButton =  findViewById(R.id.signUpButtonId);
        emailEditText =  findViewById(R.id.signInusernameEditTextId);
        passwordEditText =  findViewById(R.id.signInpasswordEditTextId);

        databaseHelper =new Database(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        signInButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if(v.getId()==R.id.signInButtonId){

            Boolean result = databaseHelper.findPassword(email,password);

            if(result){

                //Toast.makeText(SignInActivity.this,"next activity",Toast.LENGTH_LONG).show();
                startActivity(new Intent(SignInActivity.this,Main3Activity.class));
            }else{
                Toast.makeText(getApplicationContext(), "Wrong Email and Password!",Toast.LENGTH_LONG).show();
            }
        }else if(v.getId()==R.id.signUpButtonId){
            Intent intent=new Intent(SignInActivity.this,SignUpActivity.class);
            startActivity(intent);
        }

    }
}
