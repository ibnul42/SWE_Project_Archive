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

public class Submit extends AppCompatActivity implements View.OnClickListener {


    private EditText titleEditText,languageEditText,descEditText;
    private Button submitButton;

    SubmitDetails submitDetails;
    Database4 database4Helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        titleEditText =  findViewById(R.id.titleEditText);
        languageEditText =  findViewById(R.id.langEditText);
        descEditText =  findViewById(R.id.descEditText);

        submitButton = findViewById(R.id.submitButton);

        submitDetails =new SubmitDetails();
        database4Helper =new Database4(this);
        submitButton.setOnClickListener(this);
    }

    private boolean checkUserInformation()
    {
        String title,language,description;
        title = titleEditText.getText().toString();
        language = languageEditText.getText().toString();
        description = descEditText.getText().toString();

        return !title.isEmpty() && !language.isEmpty() && !description.isEmpty() ;

    }



    @Override
    public void onClick(View v) {

        String title=titleEditText.getText().toString();
        String language=languageEditText.getText().toString();
        String description=descEditText.getText().toString();

        submitDetails.setTitle(title);
        submitDetails.setLanguage(language);
        submitDetails.setDes(description);


        if(checkUserInformation())
        {
            long rowId =database4Helper.insertData(submitDetails);

            if(rowId>0){
                Toast.makeText(getApplicationContext(), "Successful!",Toast.LENGTH_LONG).show();
                Intent intent =new Intent(Submit.this,Main3Activity.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(), "Insertion failed",Toast.LENGTH_LONG).show();
            }
        }else Toast.makeText(getApplicationContext(), "Invalid data,Please insert valid data.",Toast.LENGTH_LONG).show();

    }




}


