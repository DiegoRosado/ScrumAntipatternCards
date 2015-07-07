package com.codeheroes.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    // Constants
    public final static String CARD_NAME = "com.codeheroes.scrumantipatterncards.CardName";

    // Attributes
    private Context context = null;

    // Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        String[] cardFolders = getCardsFolders();


        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cardFolders);

        // Get ListView object from xml
        ListView listView = (ListView) findViewById(R.id.mainactivity_listview);
        listView.setAdapter(listAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                final String cardName = (String) parent.getItemAtPosition(position);

                // Launch displayCardActivity
                Intent displayCardIntent;
                displayCardIntent = new Intent(context, DisplayCardActivity.class);
                displayCardIntent.putExtra(CARD_NAME, cardName);
                startActivity(displayCardIntent);
            }

        });

    }

    private String[] getCardsFolders() {
        List<String> cardsFolders = new ArrayList<>();
        String[] cardFoldersArray = new String[0];
        try {
            cardFoldersArray = getAssets().list("cards");
//            cardsFolders = Arrays.asList(cardFoldersArray);

        } catch (IOException e) {
            e.printStackTrace();
        }

//        return cardsFolders;
        return cardFoldersArray;
    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    /** Called when the user clicks the Send button */
/*
    public void sendMessage(View view) {
        // Do something in response to button
        Intent displayCardIntent = new Intent(this, DisplayCardActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        displayCardIntent.putExtra(EXTRA_MESSAGE, message);
        startActivity(displayCardIntent);
    }
*/



}
