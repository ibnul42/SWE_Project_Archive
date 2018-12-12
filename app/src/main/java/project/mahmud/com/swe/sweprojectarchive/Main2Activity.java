package project.mahmud.com.swe.sweprojectarchive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button homeButton,proposalButton,projectButton,searchButton,aboutUsButton,logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        homeButton =  findViewById(R.id.homeButtonId);
        proposalButton =  findViewById(R.id.proposalButtonId);
        projectButton =  findViewById(R.id.projectButtonId);
        searchButton =  findViewById(R.id.searchButtonId);
        aboutUsButton =  findViewById(R.id.aboutButtonId);
        logoutButton =  findViewById(R.id.logoutButtonId);

        homeButton.setOnClickListener(this);
        proposalButton.setOnClickListener(this);
        projectButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);
        aboutUsButton.setOnClickListener(this);
        logoutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.homeButtonId: {
                Intent homeIntent = new Intent(Main2Activity.this, DiuHome.class);
                startActivity(homeIntent);
                break;
            }
            case R.id.proposalButtonId: {
                Intent proposalIntent = new Intent(Main2Activity.this, Proposal.class);
                startActivity(proposalIntent);
                break;
            }
            case R.id.projectButtonId: {
                Intent projectIntent = new Intent(Main2Activity.this, Project.class);
                startActivity(projectIntent);
                break;
            }
            case R.id.searchButtonId: {
                Intent searchIntent = new Intent(Main2Activity.this, SignUpActivity.class);
                startActivity(searchIntent);
                break;
            }case R.id.aboutButtonId: {
                Intent searchIntent = new Intent(Main2Activity.this, AboutUs.class);
                startActivity(searchIntent);
                break;
            }

            case R.id.logoutButtonId: {
                Intent searchIntent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(searchIntent);
                break;
            }
        }
    }
}
