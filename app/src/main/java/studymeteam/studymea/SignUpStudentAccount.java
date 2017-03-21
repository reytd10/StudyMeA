package studymeteam.studymea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SignUpStudentAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_student_account);
    }

    public void verifyUserDetails(View view){
        Intent intent = new Intent(this, NewUserSuccess.class);
        startActivity(intent);
    }

    public void toSignUpPage(View view){
        Intent intent = new Intent(this, SignUpPage.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {

    }
}
