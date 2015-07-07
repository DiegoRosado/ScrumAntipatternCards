package com.codeheroes.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import us.feras.mdv.MarkdownView;


public class DisplayMarkdownActivity extends AppCompatActivity {

    // Attributes
    private String cardName;

    // Methods
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        this.cardName = intent.getStringExtra(MainActivity.CARD_NAME);
        MarkdownView markdownView = new MarkdownView(this);
        setContentView(markdownView);
        markdownView.loadMarkdownFile("file:///android_asset/" + cardName.replace(' ', '_') + "_description.md");
    }

}
