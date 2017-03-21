package studymeteam.studymea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class SignUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
    }
    public void createStudentAccount(View view){
        Intent intent = new Intent(this, SignUpStudentAccount.class);
        startActivity(intent);
    }

    public void createParentAccount(View view){
        Intent intent = new Intent(this, SignUpParentAccount.class);
        startActivity(intent);
    }
}
