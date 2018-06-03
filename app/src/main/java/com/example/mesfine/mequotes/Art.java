package com.example.mesfine.mequotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by mesfine on 6/26/17.
 */

public class Art extends Activity{
    Button cont,home;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.art);
        cont= (Button) findViewById(R.id.artcont);
        home=(Button)findViewById(R.id.arthome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Art.this,Home.class));
            }
        });
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Art.this,ArtGallery.class));
            }
        });
    }
}
