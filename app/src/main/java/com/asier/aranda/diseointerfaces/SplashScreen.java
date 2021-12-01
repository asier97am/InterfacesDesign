package com.asier.aranda.diseointerfaces;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        openApp(true);

        //implementar animacion
        ImageView mSea = (ImageView) findViewById(R.id.beach);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mSea.startAnimation(myanim);

        ImageView mback =findViewById(R.id.backView);
        Glide.with(this)
                .load(R.drawable.sea)
                .centerCrop()
                .into(mback);

        TextView shake = findViewById(R.id.Titulo);
        Animation shake1 = AnimationUtils.loadAnimation(this, R.anim.titleanimation);
        shake.startAnimation(shake1);


//        //animacion titulo app llegar desde abajo
        TextView Titulo = findViewById(R.id.designer);
        TranslateAnimation an = new TranslateAnimation(00.0f, 0.0f, 1600.0f, 0.0f);
        an.setDuration(1000);
        Titulo.startAnimation(an);

    }
    private void openApp(boolean locationPermission) {
//cambia de activity pasados 2000 milis
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, com.asier.aranda.diseointerfaces.LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 3000);
    }


}

/*public void pulsarLogo(View view){
        Intent intent=new Intent(SplashScreen.this, LoginActivity.class);
        startActivity(intent);

    }*/