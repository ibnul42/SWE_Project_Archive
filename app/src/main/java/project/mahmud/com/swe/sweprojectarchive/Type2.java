package project.mahmud.com.swe.sweprojectarchive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Type2 extends AppCompatActivity implements View.OnClickListener {

    private Button teacherButton, studentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type2);

        teacherButton = findViewById(R.id.teacherButtonId);
        studentButton = findViewById(R.id.studentButtonId);

        teacherButton.setOnClickListener(this);
        studentButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.teacherButtonId:
                Intent homeIntent = new Intent(Type2.this, SignIn2Activity.class);
                startActivity(homeIntent);
                break;
            case R.id.studentButtonId: {
                Intent proposalIntent = new Intent(Type2.this, SignInActivity.class);
                startActivity(proposalIntent);
                break;
            }
        }
    }
}
