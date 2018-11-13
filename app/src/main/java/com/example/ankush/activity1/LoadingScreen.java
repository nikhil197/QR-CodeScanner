package com.example.ankush.activity1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.ankush.activity1.models.User;

public class LoadingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Thread myThread =new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);
                    Intent intent;
                    User user = getIntent().getParcelableExtra(getString(R.string.user_object));

                    if(user.getIsAdmin() == 1)
                        intent = new Intent(getApplicationContext(), AdminActivity.class);
                    else
                        intent = new Intent(getApplicationContext(), Scanner.class);

                    intent.putExtra(getString(R.string.user_object), user);

                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }

}
