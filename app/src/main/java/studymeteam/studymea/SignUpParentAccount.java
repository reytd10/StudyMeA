package studymeteam.studymea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class SignUpParentAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_parent_account);
    }

    public void toSignUpPage(View view){
        Intent intent = new Intent(this, SignUpPage.class);
        startActivity(intent);
    }

}
