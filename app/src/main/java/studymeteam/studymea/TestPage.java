package studymeteam.studymea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TestPage extends AppCompatActivity {
    private String question= "";
    private ArrayList answers = new ArrayList();
    private String correctAns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getQuestionData();
        getAnswerData();
        getCorrectAnsData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_page);
        //Creating TextView
        TextView question = (TextView) findViewById(R.id.testQ);
        question.setText(this.getQuestion());
        // Creating buttons
        final Button answer = (Button) findViewById(R.id.answer);
        final Button answer1 = (Button) findViewById(R.id.answer1);
        final Button answer2 = (Button) findViewById(R.id.answer2);
        final Button answer3 = (Button) findViewById(R.id.answer3);
        //Setting Answer on each button
        answer.setText((String)getAnswer(0));
        answer1.setText((String)getAnswer(1));
        answer2.setText((String)getAnswer(2));
        answer3.setText((String)getAnswer(3));
        //Setting activity for buttons
        answer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(answer.getText().equals(getCorrectAns())) {
                    Toast.makeText(getApplicationContext(), "Correct! Moving on to next questions", Toast.LENGTH_SHORT).show();

                     /// Moving will be implemented later
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong! Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        answer1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(answer1.getText().equals(getCorrectAns())) {
                    Toast.makeText(getApplicationContext(), "Correct! Moving on to next questions", Toast.LENGTH_SHORT).show();
                    /// Moving will be implemented later
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong! Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(answer2.getText().equals(getCorrectAns())) {
                    Toast.makeText(getApplicationContext(), "Correct! Moving on to next questions", Toast.LENGTH_SHORT).show();
                    /// Moving will be implemented later
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong! Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(answer3.getText().equals(getCorrectAns())) {
                    Toast.makeText(getApplicationContext(), "Correct! Moving on to next questions", Toast.LENGTH_SHORT).show();
                    /// Moving will be implemented later
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong! Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Setting question
    public void setQuestion(String question){
        this.question = question;
    }
    // Get question
    public String getQuestion(){
        return this.question;
    }

    //Setting answer
    public void setAnswer(ArrayList answer){
        for(int i = 0; i< 4; i++){
            if(!answer.isEmpty()) {
                Object hold = "";
                 hold = answer.get(i);
                //Check if the current position in the array is empty
                if(this.answers.get(i) == null){
                    this.answers.add(i,(String)hold);
                }
                else{
                    this.answers.remove(i);
                    this.answers.add(i,(String)hold);
                }
            }
        }
    }
    //Getting Answers
    public String getAnswer(int position){
        return (String)this.answers.get(position);
    }
    //Getting Correct Answer
    public String getCorrectAns(){
        return this.correctAns;
    }
    //Setting Correct Answer
    public void setCorrectAns(String ans){
        this.correctAns = ans;
    }


    //Getting the data from the database to set Question and Answer
    //Supposedly this will be implemented in the future when a database is
    // implemented
    public void getQuestionData(){
        String question  = "This is a place holder for a question";
        setQuestion(question);
    }
    public void getAnswerData(){
        answers.add("Answer1");
        answers.add("Answer2");
        answers.add("Answer3");
        answers.add("Answer4");
        setAnswer(answers);
    }
    public void getCorrectAnsData(){
        String correctAns = "Answer2";
        setCorrectAns(correctAns);
    }

    //Go back to Home
    public void goBackHome(View view){
        Intent intent = new Intent(this, StudentMainPage.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

        }


}
