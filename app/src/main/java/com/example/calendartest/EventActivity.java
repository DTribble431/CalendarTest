package com.example.calendartest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.api.client.util.DateTime;

import java.util.Date;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView titleView;
        TextView descriptionView;
        TextView dateView;
        final TextView locationView;
        Intent intent = getIntent();
        setContentView(R.layout.activity_event);

        titleView = (TextView) findViewById(R.id.txt_title);
        descriptionView = (TextView) findViewById(R.id.txt_desc);
        dateView = (TextView) findViewById(R.id.txt_date);
        locationView = (TextView) findViewById(R.id.txt_location);

        titleView.setText(intent.getCharSequenceExtra("title"));
        descriptionView.setText(intent.getStringExtra("description"));
        dateView.setText(intent.getStringExtra("time"));
        locationView.setText(intent.getStringExtra("location"));

        locationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:0,0?q=" + Uri.encode(String.format("%s", locationView.getText())));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
