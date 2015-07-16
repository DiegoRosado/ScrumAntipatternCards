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
        String[] cardFoldersArray = new String[0];
        try {
            cardFoldersArray = getAssets().list("cards");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cardFoldersArray;
    }




}
