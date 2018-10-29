package hrcbetaversion.com.hrcbt.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import hrcbetaversion.com.hrcbt.R;


public class Login extends AppCompatActivity implements OnClickListener {
    Button b1, b2, b3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.button2) {
            Intent intent = new Intent(this, Signup.class);
            startActivity(intent);
        } else if (v.getId() == R.id.button3) {
            Intent intent = new Intent(this, ForgotPassward.class);
            startActivity(intent);
        }


    }
}
