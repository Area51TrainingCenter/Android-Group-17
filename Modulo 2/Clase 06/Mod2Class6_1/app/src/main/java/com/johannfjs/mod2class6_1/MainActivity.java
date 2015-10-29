package com.johannfjs.mod2class6_1;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnObtener, btnLlamar;
    private TextView lblTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnObtener = (Button) findViewById(R.id.btnObtener);
        btnLlamar = (Button) findViewById(R.id.btnLlamar);
        lblTexto = (TextView) findViewById(R.id.lblTexto);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:987654321"));
                startActivity(intent);
            }
        });
        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contenido = "";

                contenido += "SDK->" + Build.VERSION.SDK + "\n";
                contenido += "Modelo->" + Build.MODEL + "\n";
                contenido += "Device->" + Build.DEVICE + "\n";
                contenido += "Host->" + Build.HOST + "\n";
                contenido += "Id->" + Build.ID + "\n";
                contenido += "Display->" + Build.DISPLAY + "\n";
                contenido += "Manufacturer->" + Build.MANUFACTURER + "\n";
                contenido += "User->" + Build.USER + "\n";

                TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

                contenido += "IMEI->" + telephonyManager.getDeviceId() + "\n";
                contenido += "IMEI->" + telephonyManager.getLine1Number() + "\n";
                contenido += "IMEI->" + telephonyManager.getNetworkOperator() + "\n";
                contenido += "IMEI->" + telephonyManager.getSimSerialNumber() + "\n";


                contenido += "Width->" + getWindow().getWindowManager().getDefaultDisplay().getWidth() + "\n";
                contenido += "Height->" + getWindow().getWindowManager().getDefaultDisplay().getHeight() + "\n";

                lblTexto.setText(contenido);
/*
                AccountManager am = AccountManager.get(MainActivity.this);
                Account[] accounts = am.getAccounts();
                String acname=null;
                String actype=null;
                ArrayList<String> googleAccounts = new ArrayList<String>();
                for (Account ac : accounts) {
                    acname = ac.name;

                    actype = ac.type;
                    // Take your time to look at all available accounts
                    System.out.println("Accounts : " + acname + ", " + actype);
                }
                //Check actype for whatsapp account

                if(actype.equals("com.whatsapp")){
                    String phoneNumber = acname;

                    lblTexto.setText(phoneNumber);
                }

                */
            }
        });
    }
}
