package com.asier.aranda.diseointerfaces;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
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
        setContentView(R.layout.activity_splash_screen); //referenciar este Java con el XML en la carpeta Layout
        openApp(true);

        //implementar animacion  ------------------LOGO PRINCIPAL------------------
        ImageView mSea = (ImageView) findViewById(R.id.beach); //definimos una variable de tipo ImageView referenciada al id beach que es el LOGO PRINCIPAL
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fadein); //aqui defino una variable Animaton y que cargue mi animacion llamada FADEIN
        mSea.startAnimation(myanim);//inicio Animacion

        //implementar animacion al ------------------FONDOOOOO---------------------
        //.load carga un drawable para el fondo
        //.placeholder si no consigue cargar la foto te pone un fondo fuscsia en este caso como en instagram si no tenemos internet
        //.centerCrop me rellena todoo
        //.into indica en donde se van a aplicar estos atributos
        ImageView mback =findViewById(R.id.backView);
        Glide.with(this)
                .load(R.drawable.sea)
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.fucsia)))
                .centerCrop()
                .into(mback);

        //animation del ------------------TITULO DELIGHFUL ------------------
        //Ver animacion en anim/titleanimation ES UN SHAKE
        TextView shake = findViewById(R.id.Titulo);
        Animation shake1 = AnimationUtils.loadAnimation(this, R.anim.titleanimation);
        shake.startAnimation(shake1);


//        //animacion  llegar desde abajo------------------DESARROLLADOR de la app------------------
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
                //aqui indicamos que vaya del Splash al login
                Intent intent = new Intent(SplashScreen.this, com.asier.aranda.diseointerfaces.LoginActivity.class);//SPLASH-->LOGIN
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//creamos bandera
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);//limpiamos para no poder volver
                startActivity(intent);//con esto vamos al siguiente activity indicando con la variable intent
            }
        }, 3000);//tarda 3s en pasar al siguiente activity
    }

    /*public void pulsarLogo(View view){
        Intent intent=new Intent(SplashScreen.this, LoginActivity.class);
        startActivity(intent);

    }*/

}

