package studymeteam.studymea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }

    public void toSignUpPage(View view){
        Intent intent = new Intent(this, SignUpPage.class);
        startActivity(intent);
    }

    public void toMainPage(View view){
        Intent intent = new Intent(this, StudentMainPage.class);
        startActivity(intent);
    }
}
