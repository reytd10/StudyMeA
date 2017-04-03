package studymeteam.studymea;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import static android.content.ContentValues.TAG;

public class Lecture extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);

        WebView webView =(WebView) findViewById(R.id.web1);
        String myPdfUrl = "http://che.org.il/wp-content/uploads/2016/12/pdf-sample.pdf";
        String url = "https://docs.google.com/gview?embedded=true&url=" + myPdfUrl;
        Log.i(TAG, "Opening PDF: " + url);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, StudentMainPage.class);
        startActivity(intent);
    }



}
