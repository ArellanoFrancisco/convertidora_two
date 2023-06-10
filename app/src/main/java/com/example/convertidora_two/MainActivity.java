package com.example.convertidora_two;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;

import com.example.convertidora_two.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


        mBinding.button1.setOnClickListener(v -> {
            String Name = Objects.requireNonNull(mBinding.name.getText()).toString();
            String Lastname = Objects.requireNonNull(mBinding.lastname.getText()).toString();
            String Email = Objects.requireNonNull(mBinding.email.getText()).toString();
            String Password = mBinding.password.getText().toString();

            if (TextUtils.isEmpty(Name) || TextUtils.isEmpty(Lastname) || TextUtils.isEmpty(Email) || TextUtils.isEmpty(Password)) {
                String toast1 = getString(R.string.toast1);
                Toast.makeText(MainActivity.this, toast1, Toast.LENGTH_LONG).show();
            } else if (!isValidName(Name)) {
                String toast2 = getString(R.string.toast2);
                Toast.makeText(MainActivity.this, toast2, Toast.LENGTH_LONG).show();
            } else if (!isValidLastname(Lastname)) {
                String toast3 = getString(R.string.toast3);
                Toast.makeText(MainActivity.this, toast3, Toast.LENGTH_LONG).show();
            } else if (!isValidEmail(Email)) {
                String toast4 = getString(R.string.toast4);
                Toast.makeText(MainActivity.this, toast4, Toast.LENGTH_LONG).show();
            } else if (!isValidPassword(Password)) {
                String toast5 = getString(R.string.toast5);
                Toast.makeText(MainActivity.this, toast5, Toast.LENGTH_LONG).show();
            } else {
                String Welcome = getString(R.string.welcome);
                Toast.makeText(MainActivity.this,Welcome +" "+ Name + " "+ Lastname,Toast.LENGTH_LONG).show();
                recopila(Name, Lastname, Email, Password);
                Log.d("busca elementos", " " + Name + " " + Lastname + " " + Email);
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
        private boolean isValidName(String Name) {
            return Name.length() >= 2 && Name.matches("[a-zA-Z]+ ");
        }
        private boolean isValidLastname(String Lastname) {
            return Lastname.length() >= 2 && Lastname.matches("[a-zA-Z]+ ");
        }
        private boolean isValidEmail(String email) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
        private boolean isValidPassword(String password) {
            return password.length() >= 8;
        }
    }