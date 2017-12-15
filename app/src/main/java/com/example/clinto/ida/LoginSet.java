package com.example.clinto.ida;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginSet extends AppCompatActivity {
        Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_set);

                bt1=(Button)findViewById(R.id.button);
                bt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(LoginSet.this,Company.class);
                        startActivity(i);

                    }
                });
            }
        }

