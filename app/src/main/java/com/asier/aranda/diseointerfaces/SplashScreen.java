package com.asier.aranda.diseointerfaces;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

/**
 * @author Mario
 */
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        openApp(true);

        //implementar animacion
        ImageView mBolt = (ImageView) findViewById(R.id.beach);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mBolt.startAnimation(myanim);

        ImageView mback =findViewById(R.id.backView);
        Glide.with(this)
                .load(R.drawable.sea)
                .centerCrop()
                .into(mback);

    }
    private void openApp(boolean locationPermission) {

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, com.asier.aranda.diseointerfaces.LoginActivity.class);
                startActivity(intent);
            }
        }, 2000);
    }
}

/*public void pulsarLogo(View view){
        Intent intent=new Intent(SplashScreen.this, LoginActivity.class);
        startActivity(intent);

    }*/