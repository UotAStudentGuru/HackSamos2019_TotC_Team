package com.example.kostas.myapplication;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class QRWallet extends AppCompatActivity {

    ImageView image;
    String text2Qr;
    static ImageView vol;
    String x;
    TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrwallet);
        x = LogIn.e_mail.toUpperCase();
        ImageView img = (ImageView) findViewById(R.id.imageView2) ;
        if(MkoChoose_Ewallet.current.equals("wwf"))
            img.setImageResource(R.drawable.wwf);
        else if(MkoChoose_Ewallet.current.equals("line"))
            img.setImageResource(R.drawable.health);
        else if(MkoChoose_Ewallet.current.equals("unicef"))
            img.setImageResource(R.drawable.unicef);
        else if(MkoChoose_Ewallet.current.equals("med"))
            img.setImageResource(R.drawable.ed);
        else if(MkoChoose_Ewallet.current.equals("smile"))
            img.setImageResource(R.drawable.smile);
        else
            img.setImageResource(R.drawable.actionade);

        mTextViewResult = findViewById(R.id.textViewEv3);

        OkHttpClient client = new OkHttpClient();

        String url = "http://192.168.0.104:3000/api/queries/selectCommoditiesByOwner?owner="+x+"";


        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    Log.d("Coins : ",myResponse);/
                    QRWallet.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewResult.setText(myResponse);
                        }
                    });
                }
            }
        });



        image = (ImageView)findViewById(R.id.QRImage);
        text2Qr = x;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try{
            BitMatrix bitMatrix = multiFormatWriter.encode(text2Qr , BarcodeFormat.QR_CODE, 200 , 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            image.setImageBitmap(bitmap);
        }
        catch (WriterException e){
            e.printStackTrace();
        }
    }

}
