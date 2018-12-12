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

public class Proposal extends AppCompatActivity implements View.OnClickListener {


    private EditText courseEditText,dateEditText;
    private Button submitButton;

    ProposalDetails proposalDetails;
    Database2 database2Helper;
    private Spinner SemesterType;
    private String semesterType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposal);

        courseEditText =  findViewById(R.id.courseEditText);
        dateEditText =  findViewById(R.id.dateEditText);
        SemesterType = findViewById(R.id.semesterType);

        submitButton = findViewById(R.id.submitButton);

        proposalDetails =new ProposalDetails();
        database2Helper =new Database2(this);
        submitButton.setOnClickListener(this);
        seletUserType();
    }

    private boolean checkUserInformation()
    {
        String cname,ldate;
        cname = courseEditText.getText().toString();
        ldate = dateEditText.getText().toString();

        return !cname.isEmpty() && !ldate.isEmpty() ;

    }



    @Override
    public void onClick(View v) {

        String cname=courseEditText.getText().toString();
        String ldate=dateEditText.getText().toString();
        String type = semesterType;

        proposalDetails.setCName(cname);
        proposalDetails.setLdate(ldate);
        proposalDetails.setPType(type);


        if(checkUserInformation())
        {
            long rowId =database2Helper.insertData(proposalDetails);

            if(rowId>0){
                Toast.makeText(getApplicationContext(), "Successful!",Toast.LENGTH_LONG).show();
                Intent intent =new Intent(Proposal.this,Main2Activity.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(), "Insertion failed",Toast.LENGTH_LONG).show();
            }
        }else Toast.makeText(getApplicationContext(), "Invalid data,Please insert valid data.",Toast.LENGTH_LONG).show();

    }
    private void seletUserType()
    {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.semester,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        SemesterType.setAdapter(adapter);
        SemesterType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                semesterType = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }



}
