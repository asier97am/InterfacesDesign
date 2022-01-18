package com.asier.aranda.diseointerfaces;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ImageView mBeach=findViewById(R.id.backBeach1);
        Glide.with(this)
                .load(R.drawable.oleajevistaaerea)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .into(mBeach);
    }
    public void openBottomBar(View v){
        Intent intent=new Intent(SignUp.this, MainBAP.class);
        startActivity(intent);
    }

}