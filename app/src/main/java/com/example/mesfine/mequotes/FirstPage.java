package com.example.mesfine.mequotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by mesfine on 6/26/17.
 */

public class FirstPage extends Activity {

    Button cont,home;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);
        cont= (Button) findViewById(R.id.cont);
        home= (Button) findViewById(R.id.home);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstPage.this,MainActivity.class));
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(FirstPage.this,Home.class));
            }
        });
    }
}
