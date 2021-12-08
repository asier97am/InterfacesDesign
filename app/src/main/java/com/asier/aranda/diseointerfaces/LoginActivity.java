package com.asier.aranda.diseointerfaces;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * @author Asier97am
 *
 */


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //implementar animacion al ------------------FONDOOOOO---------------------
        //.load carga un drawable para el fondo
        //.placeholder si no consigue cargar la foto te pone un fondo fuscsia en este caso como en instagram si no tenemos internet
        //.centerCrop me rellena todoo
        //.into indica en donde se van a aplicar estos atributos
        ImageView mBeach=findViewById(R.id.backBeach);
        Glide.with(this)
                .load(R.drawable.oleajevistaaerea)
                .centerCrop()
                //.circleCrop()
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .into(mBeach);

    }
    //ONCLICK DEL BUTTON "LOGIN" que me va a llevar al MAINACTIVITY
    //además le meto unas FLAGS para no poder volver al activity LOGINACTIVITY
    public void openMainActivity(View v){
        Intent intent=new Intent(LoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    //ONCLICK PARA IR AL REGISTRO "SIGNUP"
    public void openRegistro(View v){
        Intent intent=new Intent(LoginActivity.this, SignUp.class);
        startActivity(intent);
    }
}

