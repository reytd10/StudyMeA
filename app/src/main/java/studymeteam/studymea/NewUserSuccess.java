package studymeteam.studymea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class NewUserSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_success);
    }

    public void toLoginPage(View view){
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {

    }
}
