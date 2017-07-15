package com.example.shwetashahane.finalproject;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private FirebaseAuth auth;
    private EditText loginText, passwordText;
    String password;
    File directory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        copyAssets();
        auth=FirebaseAuth.getInstance();
        loginText=(EditText)this.findViewById(R.id.loginNameText);
        passwordText=(EditText)this.findViewById(R.id.passwordText);
        loginButton=(Button)this.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginText.clearFocus();
                passwordText.clearFocus();
                validation();
            }
        });
        passwordText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    password = passwordText.getText().toString();
                    if (passwordText.getText().toString().length() < 6) {
                        passwordText.setError("Password must be atleast 6 characters long!");
                    }
                }
            }
        });

        loginText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String email = loginText.getText().toString().trim();
                    if (email.isEmpty() || !isEmailValid(email)) {
                        loginText.setError("enter valid email-id");
                    }
                }
            }
        });
        TextView regLink =(TextView)findViewById(R.id.signupLink);
        regLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, NewUserSignUp.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private static boolean isEmailValid(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public void validation(){
        if (loginText.getError() == null && passwordText.getError() == null) {
            submitForm();
        }
    }

    public void submitForm(){
        String email = loginText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();
        System.out.println(email);
        System.out.println(password);
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(Task<AuthResult> task) {
                if (!task.isSuccessful())
                    Toast.makeText(LoginActivity.this, "Wrong Username and Password", Toast.LENGTH_LONG).show();
                else
                {
                    Intent intent = new Intent(LoginActivity.this, ViewResumeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void copyAssets() {
        AssetManager assetManager = getAssets();
        String[] files = null;
        try {
            files = assetManager.list("");
        } catch (IOException e) {
           System.out.println( e.getMessage());
        }
        for(String filename : files) {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                out = new FileOutputStream("/sdcard/Android/data/com.example.shwetashahane.finalproject/" + filename);
                copyFile(in, out);
                in.close();
                in = null;
                out.flush();
                out.close();
                out = null;
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }
}
