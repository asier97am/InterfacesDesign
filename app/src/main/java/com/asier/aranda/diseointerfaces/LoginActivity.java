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

        ImageView mBeach=findViewById(R.id.backBeach);
        Glide.with(this)
                .load(R.drawable.beach)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .into(mBeach);





    }
    public void openMain(View v){
        Intent intent=new Intent(LoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public void openRegistro(View v){
        Intent intent=new Intent(LoginActivity.this, SignUp.class);
        startActivity(intent);
    }
}

