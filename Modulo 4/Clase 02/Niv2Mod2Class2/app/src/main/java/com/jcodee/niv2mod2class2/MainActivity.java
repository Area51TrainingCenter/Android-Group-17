package com.jcodee.niv2mod2class2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {
    private EditText txtCorreo, txtUsuario, txtContrasenia, txtRepContrasenia;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtContrasenia = (EditText) findViewById(R.id.txtContrasenia);
        txtRepContrasenia = (EditText) findViewById(R.id.txtRepContrasenia);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtUsuario.getText().toString().length() > 0 &&
                        txtCorreo.getText().toString().length() > 0 &&
                        txtContrasenia.getText().toString().length() > 0 &&
                        txtRepContrasenia.getText().toString().length() > 0) {

                    if (txtContrasenia.getText().toString().equals(txtRepContrasenia.getText().toString())) {
                        ParseUser parseUser = new ParseUser();
                        parseUser.setEmail(txtCorreo.getText().toString());
                        parseUser.setPassword(txtContrasenia.getText().toString());
                        parseUser.setUsername(txtUsuario.getText().toString());
                        parseUser.put("nombre","Johann");
                        parseUser.signUpInBackground(new SignUpCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {
                                    Toast.makeText(getApplicationContext(), "Todo OK", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                /*
                SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(getApplicationContext(), "Todo OK", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                 */

                }
            }
        });
    }
}
