package com.asier.aranda.diseointerfaces;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ImageView mAcantilado=findViewById(R.id.backAcantilado1);
        Glide.with(this)
                .load(R.drawable.acantilado)
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .into(mAcantilado);
    }
}