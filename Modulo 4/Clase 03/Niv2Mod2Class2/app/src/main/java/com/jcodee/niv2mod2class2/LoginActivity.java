package com.jcodee.niv2mod2class2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText txtCorreo, txtContrasenia;
    private Button btnLogin;
    private TextView lblRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtContrasenia = (EditText) findViewById(R.id.txtContrasenia);
        btnLogin = (Button) findViewById(R.id.btnIngresar);
        lblRegistrar = (TextView) findViewById(R.id.lblRegistrar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lblRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtCorreo.getText().toString().length() > 0 &&
                        txtContrasenia.getText().toString().length() > 0) {
                    ParseUser.logInInBackground(txtCorreo.getText().toString(),
                            txtContrasenia.getText().toString(),
                            new LogInCallback() {
                                @Override
                                public void done(ParseUser parseUser, ParseException e) {
                                    if (e == null) {
                                        Toast.makeText(getApplicationContext(),"Todo OK "+parseUser.getUsername(),Toast.LENGTH_SHORT).show();

                                    } else {
                                    }
                                }
                            });
                }
            }
        });
    }
}
