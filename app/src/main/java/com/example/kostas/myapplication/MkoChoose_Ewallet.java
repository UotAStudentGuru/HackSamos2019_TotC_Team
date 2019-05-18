package com.example.kostas.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MkoChoose_Ewallet extends AppCompatActivity {
    public static String current;
    private TextView alertTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alertTextView = (TextView) findViewById(R.id.AlertTextView);
        setContentView(R.layout.activity_mko_choose__ewallet);

        AlertDialog.Builder builder = new AlertDialog.Builder(MkoChoose_Ewallet.this);

        builder.setCancelable(true);
        builder.setTitle("Choose Organization");
        builder.setMessage("Choose organizations that you want to help with your credits, after you complete your payment...");

        builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.show();


        ImageButton Img1=(ImageButton) findViewById(R.id.imageButton); //wwf
        ImageButton Img2=(ImageButton) findViewById(R.id.imageButton2); //line
        ImageButton Img3=(ImageButton) findViewById(R.id.imageButton4);//unicef
        ImageButton Img4=(ImageButton) findViewById(R.id.imageButton5); //med
        ImageButton Img5=(ImageButton) findViewById(R.id.imageButton6);//smile
        ImageButton Img6=(ImageButton) findViewById(R.id.imageButton7);//action

        Img1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MkoChoose_Ewallet.this, QRWallet.class));
                current="wwf";
            }
        });

        Img5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MkoChoose_Ewallet.this, QRWallet.class));
                current="line";
            }
        });
        Img4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MkoChoose_Ewallet.this,QRWallet.class));
                current="unicef";
            }
        });
        Img3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MkoChoose_Ewallet.this, QRWallet.class));
                current="med";
            }
        });
        Img6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MkoChoose_Ewallet.this, QRWallet.class));
                current="smile";
            }
        });
        Img2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MkoChoose_Ewallet.this, QRWallet.class));
                current="action";
            }
        });
    }
}
