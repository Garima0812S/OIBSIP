package com.example.quizzango;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DashBoard_Activity extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionTextView;
    TextView questionTextView;
    Button ansA ,ansB , ansC ,ansD;
    Button submitBtn;

    int score=0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        totalQuestionTextView=findViewById(R.id.TQ);
        questionTextView=findViewById(R.id.Ques);
        ansA=findViewById(R.id.button);
        ansB=findViewById(R.id.button2);
        ansC=findViewById(R.id.button3);
        ansD=findViewById(R.id.button4);
        submitBtn=findViewById(R.id.button5);


        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionTextView.setText("Total Question"+totalQuestion);

        loadNewQuestion();

    }
    @Override
    public void onClick(View view){
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);


        Button clickedButton = (Button) view ;
        if(clickedButton.getId()==R.id.button5){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswer[currentQuestionIndex])){
                score++;
            }
                  currentQuestionIndex++;
                  loadNewQuestion();

        }
        else{
            selectedAnswer =clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }


    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }



        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
    }
    void finishQuiz(){

        String passStatus = ""
;
        if(score > totalQuestion*0.60){
            passStatus ="Passed";
        }else{
            passStatus ="Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is " + score +"out of "+ totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();

    }

    void restartQuiz(){
        score=0;
        currentQuestionIndex=0;
        loadNewQuestion();
    }

}