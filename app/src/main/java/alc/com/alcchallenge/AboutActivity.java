package alc.com.alcchallenge;

import android.annotation.SuppressLint;
import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    WebView myWebView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setTitle("About ALC");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

         myWebView = (WebView) findViewById(R.id.webview);
        //myWebView.loadUrl("https://andela.com/alc");

      /*  WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        myWebView.setWebViewClient(new MyWebViewClient());
        //myWebView.loadUrl("https://andela.com/alc/");
        myWebView.loadUrl("https://www.google.com");*/



        myWebView.getSettings().setJavaScriptEnabled(true); // enable javascript



        myWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(AboutActivity.this, description, Toast.LENGTH_SHORT).show();
            }

            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
                handler.proceed();
            }
        });



        myWebView.loadUrl("https://andela.com/alc/");



    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }



}
