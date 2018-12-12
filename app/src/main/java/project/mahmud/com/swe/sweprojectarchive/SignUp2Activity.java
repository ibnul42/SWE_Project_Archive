package project.mahmud.com.swe.sweprojectarchive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SignUp2Activity extends AppCompatActivity implements View.OnClickListener {


    private EditText nameEditText,usernameEditText,emailEditText,passwordEditText,insitutionEditText;
    private Button signUpButton;

    User2details user2Details;
    Database3 database3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        nameEditText =  findViewById(R.id.nameEditText);
        usernameEditText =  findViewById(R.id.usernameEditText);
        emailEditText =  findViewById(R.id.emailEditText);
        passwordEditText =  findViewById(R.id.passwordEditText);
        insitutionEditText =  findViewById(R.id.instituteEditText);

        signUpButton = findViewById(R.id.signUpButton);

        user2Details =new User2details();
        database3 =new Database3(this);
        signUpButton.setOnClickListener(this);
    }

    private boolean checkUserInformation()
    {
        String fname,lname,email,password,institution;
        fname = nameEditText.getText().toString();
        lname = usernameEditText.getText().toString();
        email = emailEditText.getText().toString();
        password = passwordEditText.getText().toString();
        institution = insitutionEditText.getText().toString();

        return !fname.isEmpty() && !lname.isEmpty() && !email.isEmpty() && !password.isEmpty() && !institution.isEmpty();

    }



    @Override
    public void onClick(View v) {

        String fname=nameEditText.getText().toString();
        String lname=usernameEditText.getText().toString();
        String email=emailEditText.getText().toString();
        String password=passwordEditText.getText().toString();
        String institute=insitutionEditText.getText().toString();

        user2Details.setFName(fname);
        user2Details.setLname(lname);
        user2Details.setEmail(email);
        user2Details.setPassword(password);
        user2Details.setInstitute(institute);


        if(checkUserInformation())
        {
            long rowId =database3.insertData(user2Details);

            if(rowId>0){
                Toast.makeText(getApplicationContext(), "Successfully Registered",Toast.LENGTH_LONG).show();
                Intent intent =new Intent(SignUp2Activity.this,SignIn2Activity.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(), "Row insertion failed",Toast.LENGTH_LONG).show();
            }
        }else Toast.makeText(getApplicationContext(), "Invalid data,Please insert valid data.",Toast.LENGTH_LONG).show();

    }



}
