package com.jcodee.clasefacebook;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    private LoginButton btnLogin;
    private TextView lblTexto;
    private SimpleDraweeView ivImagen;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivImagen = (SimpleDraweeView) findViewById(R.id.ivImagen);
        lblTexto = (TextView) findViewById(R.id.lblTexto);
        btnLogin = (LoginButton) findViewById(R.id.btnLogin);
        btnLogin.setReadPermissions("public_profile", "email", "user_friends", "user_photos");
        callbackManager = CallbackManager.Factory.create();
        btnLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(final LoginResult loginResult) {
                Toast.makeText(getApplicationContext(),
                        "AccessToken" + loginResult.getAccessToken(),
                        Toast.LENGTH_SHORT).show();

                GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                Toast.makeText(getApplicationContext(),
                                        object.toString() + "-----" + response.toString(),
                                        Toast.LENGTH_LONG).show();


                                try {
                                    GraphRequest gr = new GraphRequest(
                                            loginResult.getAccessToken(),
                                            "/" + object.getString("id"),
                                            null,
                                            HttpMethod.GET,
                                            new GraphRequest.Callback() {
                                                public void onCompleted(GraphResponse response) {
                                                    lblTexto.setText(response.toString());
                                                }
                                            }
                                    );
                                    Bundle bn = new Bundle();
                                    bn.putString("fields","about");
                                    gr.setParameters(bn);
                                    gr.executeAsync();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                                try {
                                    ivImagen.setImageURI(Uri.parse("https://graph.facebook.com/" + object.getString("id") + "/picture?type=large"));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                //lblTexto.setText(object.toString() + "-----" + response.toString());
                            }
                        });
                Bundle bundle = new Bundle();
                bundle.putString("fields", "id,name,first_name,email,link,gender");
                graphRequest.setParameters(bundle);
                graphRequest.executeAsync();

                new GraphRequest(loginResult.getAccessToken(),
                        "/me/friends",
                        null,
                        HttpMethod.GET,
                        new GraphRequest.Callback() {
                            @Override
                            public void onCompleted(GraphResponse response) {
                                //lblTexto.setText(/*lblTexto.getText().toString() + "\n" + */response.toString());
                            }
                        }).executeAsync();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
/*
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.jcodee.clasefacebook",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
        */
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
