package com.codeheroes.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;


public class DisplayCardActivity extends AppCompatActivity {

    // Attributes
    private String cardName;


    // Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_card);

        // Get message from the intent
        Intent intent = getIntent();
        this.cardName = intent.getStringExtra(MainActivity.CARD_NAME);
        ImageView imageView = (ImageView) findViewById(R.id.cardImageView);


        Drawable drawableCardImage = loadCardImage(cardName);

        imageView.setImageDrawable(drawableCardImage);

        // Add onTouchListener
        DisplayCardTouchListener onTouchListener = new DisplayCardTouchListener();
        imageView.setOnTouchListener(onTouchListener);


/*        // Create text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);;
        textView.setText(message);

        // Set the TextView as the activity layout
        setContentView(textView);*/
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

    /**
     * A placeholder fragment containing a simple view.
     */
/*    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() { }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_display_message,
                    container, false);
            return rootView;
        }
    }*/


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
