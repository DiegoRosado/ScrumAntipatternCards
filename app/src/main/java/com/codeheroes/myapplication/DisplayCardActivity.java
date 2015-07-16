package com.codeheroes.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;


public class DisplayCardActivity extends AppCompatActivity {

    // Attributes
    private String cardName;
    private Context context = null;


    // Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_card);
        context = this;

        // Get message from the intent
        Intent intent = getIntent();
        this.cardName = intent.getStringExtra(MainActivity.CARD_NAME);
        ImageView imageView = (ImageView) findViewById(R.id.cardImageView);


        Drawable drawableCardImage = loadCardImage(cardName);

        imageView.setImageDrawable(drawableCardImage);

        // Add onTouchListener
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                // Load Markdown activity and start it
                Intent markdownActivity;
                markdownActivity = new Intent(context, DisplayMarkdownActivity.class);
                markdownActivity.putExtra(MainActivity.CARD_NAME, cardName);
                startActivity(markdownActivity);
                return false;
            }

        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private Drawable loadCardImage(String cardName) {
        Drawable drawable = null;
        try {
            InputStream ims = getAssets().open("cards/" + cardName + "/image.png");
            // load image as Drawable
            drawable = Drawable.createFromStream(ims, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return drawable;
    }
}
