package com.example.mesfine.mequotes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import java.io.ByteArrayOutputStream;

/**
 * Created by mesfine on 6/26/17.
 */

public class ArtGallery extends Activity {
    Button prev,next,share;
    ImageSwitcher imageSwitch;
    Integer [] image= {R.mipmap.a00,R.mipmap.a01,R.mipmap.a1,R.mipmap.a2,R.mipmap.a3,R.mipmap.a4,R.mipmap.a5,R.mipmap.a6,R.mipmap.a00,
                       R.mipmap.a7,R.mipmap.a8,R.mipmap.a9,R.mipmap.a10,R.mipmap.a11,R.mipmap.a12,R.mipmap.a13,R.mipmap.a14,R.mipmap.a15,
                       R.mipmap.a16,R.mipmap.a17,R.mipmap.a18,R.mipmap.a19,R.mipmap.a20,R.mipmap.a21,R.mipmap.a22,R.mipmap.a23,R.mipmap.a24,
                       R.mipmap.a24,R.mipmap.a25,R.mipmap.a26,R.mipmap.a27,R.mipmap.a28,R.mipmap.a29,R.mipmap.a30,R.mipmap.a31,R.mipmap.a32,
                       R.mipmap.a33,R.mipmap.a34,R.mipmap.a35,R.mipmap.a36,R.mipmap.a37,R.mipmap.a38,R.mipmap.a39,R.mipmap.a40,R.mipmap.a41,
                       R.mipmap.a42,R.mipmap.a43,R.mipmap.a44,R.mipmap.a45,R.mipmap.a46,R.mipmap.a47,R.mipmap.a48,R.mipmap.a49,R.mipmap.a50
                       };
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artgallery);

        imageSwitch= (ImageSwitcher) findViewById(R.id.artImageSwitcher);
        imageSwitch.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                ImageView imageView=new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setLayoutParams(
                        new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT));

                return imageView;
                }
          });
        Animation in= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.in);
        Animation out=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.out);
        imageSwitch.setAnimation(in);
        imageSwitch.setAnimation(out);

        prev=(Button)findViewById(R.id.artback);
        next=(Button)findViewById(R.id.artnext);
        share=(Button)findViewById(R.id.artshare);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i>0){
                    i--;
                    imageSwitch.setImageResource(image[i]);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i<image.length-1){
                    i++;
                    imageSwitch.setImageResource(image[i]);
                }
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareImage();
            }
        });
    }

    private void shareImage() {
        Bitmap b = BitmapFactory.decodeResource(getResources(),image[i]);
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/*");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(getContentResolver(),
                b, "Title", null);
        Uri imageUri =  Uri.parse(path);
        share.putExtra(Intent.EXTRA_STREAM, imageUri);
        startActivity(Intent.createChooser(share, "Share Via"));
    }
}
