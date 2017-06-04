package com.martinprograms.pieknyswiat;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import static com.martinprograms.pieknyswiat.R.layout.webview;

public class WebViewActivity extends Activity {

    int id_wiki = 0;
    //int time=1;
    WebView webView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(webview);
        webView = (WebView) findViewById(com.martinprograms.pieknyswiat.R.id.webView1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null); //paanie performance sie tu dzieje
        } else {
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        //webView.getSettings().setJavaScriptEnabled(true);
        //webView.getSettings().setLoadWithOverviewMode(true);
        // webView.getSettings().setUseWideViewPort(true);
        final Button pozno = (Button) findViewById(com.martinprograms.pieknyswiat.R.id.button3);
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                //hide loading image
                //Button pozno = (Button) findViewById(R.id.button3);
                findViewById(com.martinprograms.pieknyswiat.R.id.progressBar2).setVisibility(View.GONE);
                pozno.setVisibility(View.GONE);
                //show webview
                findViewById(com.martinprograms.pieknyswiat.R.id.webView1).setVisibility(View.VISIBLE);
            }


        });
        //walnijmy tu przycisk do przeglądarki, który się pojawi jeśli strona będzie się ładować za długo np 3 sekundy, ok?
        //nie dziala cos, albo sie pojawia od razu albo 3 sekundy po zaladowaniu, tak jakby onPageFinished nie mógł zmienić wartości zmiennej, trudno, nie ma czasu.
       /* pozno.setVisibility(View.GONE);
        if (time!=0){
        pozno.postDelayed(new Runnable() {
            public void run() {
                pozno.setVisibility(View.VISIBLE);
            }
        }, 3000);}*/
        Bundle extras = getIntent().getExtras();
        id_wiki = extras.getInt("ID");
        webView.loadUrl(getResources().getStringArray(com.martinprograms.pieknyswiat.R.array.urls)[id_wiki]);


        //String customHtml = getResources().getStringArray(R.array.urls)[id_wiki];
        //String customHtml="<iframe width=\"100%\" height=\"1005\" src=\"http://www.google.pl\"></iframe>";
        //webView.loadData(customHtml, "text/html", "UTF-8");
        pozno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse(getResources().getStringArray(com.martinprograms.pieknyswiat.R.array.urls)[id_wiki]));
                startActivity(myWebLink);
            }
        });
    }

}


