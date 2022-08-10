package com.example.info;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Login extends AppCompatActivity {

    private boolean passwordShowing = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        final EditText usernameET = findViewById(R.id.usernameET);
        final EditText passwordET = findViewById(R.id.passwordET);
        final ImageView passwordIcon = findViewById(R.id.passwordIcon);
        final TextView signUpBtn = findViewById(R.id.signUpBtn);
        final AppCompatButton signInBtn = findViewById(R.id.signInBtn);

        passwordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //checking if a password is showing or not
                if (passwordShowing) {
                    passwordShowing = false;

                    passwordET.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordIcon.setImageResource(R.drawable.eyeslash);
                }
                else {
                    passwordShowing = true;

                    passwordET.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordIcon.setImageResource(R.drawable.eye);
                }

                //move the cursor at last of the text
                passwordET.setSelection(passwordET.length());
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, RegisterActivity.class));
            }
        });

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,
                        Home.class));
            }
        });
    }
}