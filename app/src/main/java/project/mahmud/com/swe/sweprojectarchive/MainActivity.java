package project.mahmud.com.swe.sweprojectarchive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button homeButton =  findViewById(R.id.homeButton);
        Button signIn =  findViewById(R.id.bSignIn);
        Button signUp =  findViewById(R.id.bSignUp);
        Button projectButton =  findViewById(R.id.projectButtonId);
        Button aboutButton =  findViewById(R.id.aboutButtonId);

        homeButton.setOnClickListener(this);
        signIn.setOnClickListener(this);
        signUp.setOnClickListener(this);
        projectButton.setOnClickListener(this);
        aboutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.homeButton:
                Intent homeIntent =new Intent(MainActivity.this,DiuHome.class);
                startActivity(homeIntent);
                break;
            case R.id.bSignIn: {
                Intent signInIntent = new Intent(MainActivity.this, Type2.class);
                startActivity(signInIntent);
                break;
            }
            case R.id.bSignUp: {
                Intent signUpIntent = new Intent(MainActivity.this, Type.class);
                startActivity(signUpIntent);
                break;
            }
            case R.id.projectButtonId: {
                Intent projectIntent = new Intent(MainActivity.this, Project_Start.class);
                startActivity(projectIntent);
                break;
            }
            case R.id.aboutButtonId: {
                Intent searchIntent = new Intent(MainActivity.this, AboutUs.class);
                startActivity(searchIntent);
                break;
            }
        }


    }
}
