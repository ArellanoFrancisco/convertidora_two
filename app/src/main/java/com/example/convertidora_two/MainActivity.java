package com.example.convertidora_two;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.convertidora_two.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Intent recopila = getIntent();

        mBinding.name.setText("");
        mBinding.lastname.setText("");
        mBinding.email.setText("");
        mBinding.password.setText("");

        mBinding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = mBinding.name.getText().toString();
                String Lastname = mBinding.lastname.getText().toString();
                String Email = mBinding.email.getText().toString();
                String Password = mBinding.password.getText().toString();
                Toast.makeText(MainActivity.this, "bienvenido "+ Name+ ""+Lastname,Toast.LENGTH_LONG).show();
                recopila(Name,Lastname,Email,Password);
                Log.d("busca elementos"," "+Name +" " + Lastname + "" + Email);
            }

        });

    }
    private void recopila(String Name, String Lastname, String Email, String Password) {
        Intent recopila = new Intent(MainActivity.this,SecondActivity.class);
        recopila.putExtra("name2",Name);
        recopila.putExtra("lastname2",Lastname);
        recopila.putExtra("email2",Email);
        recopila.putExtra("password2",Password);

        startActivity (recopila);
    }

}