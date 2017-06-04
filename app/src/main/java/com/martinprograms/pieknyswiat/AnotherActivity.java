package com.martinprograms.pieknyswiat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "";
    int id_opis = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.martinprograms.pieknyswiat.R.layout.another_layout);
        Intent intent = getIntent();
        String tekstwiadomosci = intent.getStringExtra(EXTRA_MESSAGE);
        setTitle(tekstwiadomosci);

        TextView messageView = (TextView) findViewById(com.martinprograms.pieknyswiat.R.id.textView_another);
        messageView.setText(tekstwiadomosci);

        TextView TextView_opis = (TextView) findViewById(com.martinprograms.pieknyswiat.R.id.textView5);
        Bundle extras = getIntent().getExtras();
        id_opis = extras.getInt("OPIS");
        String opis = getResources().getStringArray(com.martinprograms.pieknyswiat.R.array.opisy)[id_opis];
        TextView_opis.setText(opis);

        ImageView obraz = (ImageView) findViewById(com.martinprograms.pieknyswiat.R.id.imageView);
        String image = tekstwiadomosci.replaceAll(" ", "_").toLowerCase();
        int resID = getResources().getIdentifier(image, "drawable", getPackageName());
        obraz.setImageResource(resID);
    }

    public void startgmaps(View view) {
        Bundle extras = getIntent().getExtras();
        double latitude = extras.getDouble("LATITUDE");
        double longitude = extras.getDouble("LONGITUDE");
        String url = "http://maps.google.com/maps?daddr=" + latitude + "," + longitude;
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }

    public void showmap(View view) {
        Bundle extras = getIntent().getExtras();
        double latitude = extras.getDouble("LATITUDE");
        double longitude = extras.getDouble("LONGITUDE");
        String geoURI = "geo:" + latitude + "," + longitude + "?z=8";
        Uri geo = Uri.parse(geoURI);
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, geo);
        startActivity(intent);
    }

    public void wikifunc(View view) {
        Intent intentwiki = new Intent(this, WebViewActivity.class);
        intentwiki.putExtra("ID", id_opis);
        startActivity(intentwiki);
    }


}

