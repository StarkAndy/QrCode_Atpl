package com.example.gyaneshbohara.qrcode_atpl;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.gyaneshbohara.qrcode_atpl.bean.QrInfo;

import net.glxn.qrgen.android.QRCode;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName,etDesignation,etCountry,etCity;

    Button btGenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btGenerate=(Button)findViewById(R.id.generate);


        etName=(EditText)findViewById(R.id.etName);
        etDesignation=(EditText)findViewById(R.id.etDesignation);
        etCountry=(EditText)findViewById(R.id.etCountry);
        etCity=(EditText)findViewById(R.id.etCity);


        btGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                QrInfo qrInfo=new QrInfo();

                qrInfo.setFirstField(etName.getText().toString());
                qrInfo.setSecondField(etCity.getText().toString());
                qrInfo.setThirdField(etCountry.getText().toString());
                qrInfo.setFourthField(etDesignation.getText().toString());


                generate(qrInfo);

            }
        });





    }

    public void generate(QrInfo qrInfo){


        // get QR file from text using defaults
        //Bitmap myBitmap = QRCode.from("www.studytutorial.in").bitmap();
    /*    VCard infoQuery = new VCard(name)
                .setEmail(designation)
                .setAddress(city)
                .setTitle(country);*/

        Bitmap myBitmap = QRCode.from(qrInfo.getFirstField()+"\n"+qrInfo.getSecondField()+"\n"+qrInfo.getThirdField()+"\n"+qrInfo.getFourthField()).withSize(250, 250).bitmap();
        ImageView myImage = (ImageView) findViewById(R.id.imageView);
        myImage.setImageBitmap(myBitmap);


    }
}
