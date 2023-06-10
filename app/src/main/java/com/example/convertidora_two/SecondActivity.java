package com.example.convertidora_two;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.convertidora_two.databinding.ActivitySecondBinding;


public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding mBinding;

    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Intent recopila= getIntent();

        if(recopila!=null){
            mBinding.name2.setText(recopila.getStringExtra("name2"));
            mBinding.lastname2.setText(recopila.getStringExtra("lastname2"));
            mBinding.email2.setText(recopila.getStringExtra("email2"));
            mBinding.password2.setText(recopila.getStringExtra("password2"));
        }

        mBinding.button2.setOnTouchListener((v, event) -> {
            int action = event.getAction();
            if (action == MotionEvent.ACTION_DOWN) {
                mBinding.password2.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
                mBinding.password2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }

            return false;
        });

    }
}