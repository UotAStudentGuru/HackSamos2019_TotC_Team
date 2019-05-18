package com.example.kostas.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class AdScreen extends AppCompatActivity {
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    /** Called when the activity is first created. */
    Thread splashTread;
    ImageView image;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_screen);
        image = (ImageView)findViewById(R.id.splash1);
        final int random = new Random().nextInt(7) + 1;
        if (random ==1)
                image.setBackgroundResource(R.drawable.a1);
        else if (random == 2)
            image.setBackgroundResource(R.drawable.a2);
        else if (random == 3)
            image.setBackgroundResource(R.drawable.a3);
        else if (random == 4)
            image.setBackgroundResource(R.drawable.a4);
        else if (random == 5)
            image.setBackgroundResource(R.drawable.a5);
        else
            image.setBackgroundResource(R.drawable.a6);


        StartAnimations();
    }
    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.splash1);
        TextView iv2 = (TextView) findViewById(R.id.textLogo1);
        iv.clearAnimation();
        iv.startAnimation(anim);
        iv2.clearAnimation();
        iv2.startAnimation(anim);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 2000) {
                        sleep(150);
                        waited += 100;
                    }
                    Intent intent = new Intent(AdScreen.this,
                            DistanceCalc.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    AdScreen.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    AdScreen.this.finish();
                }

            }
        };
        splashTread.start();

    }

}