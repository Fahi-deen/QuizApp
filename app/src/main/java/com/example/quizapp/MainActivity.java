package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView optionA,optionB,optionC,optionD;
    private TextView answer,question,questionNumber,chechkout1,checkout2,score;
    private int qn=1,currentIndex,CorrectQuestion,currentOptionA,currentOptionB,currentOptionC,currentOptionD,correctAnswer;
    ProgressBar progressBar;
    public  int mScore;


    private answerClass[] questionBank=new answerClass[]
            {
              new answerClass(R.string.question1,R.string.question_1a,R.string.question_1b,R.string.question_1c,R.string.question_1d,R.string.answer_1),
              new answerClass(R.string.question2,R.string.question_2a,R.string.question_2b,R.string.question_2c,R.string.question_2d,R.string.answer_2),
              new answerClass(R.string.question3,R.string.question_3a,R.string.question_3b,R.string.question_3c,R.string.question_3d,R.string.answer_3),
              new answerClass(R.string.question4,R.string.question_4a,R.string.question_4b,R.string.question_4c,R.string.question_4d,R.string.answer_4),
              new answerClass(R.string.question5,R.string.question_5a,R.string.question_5b,R.string.question_5c,R.string.question_5d,R.string.answer_5),
              new answerClass(R.string.question6,R.string.question_6a,R.string.question_6b,R.string.question_6c,R.string.question_6d,R.string.answer_6),
              new answerClass(R.string.question7,R.string.question_7a,R.string.question_7b,R.string.question_7c,R.string.question_7d,R.string.answer_7),
              new answerClass(R.string.question8,R.string.question_8a,R.string.question_8b,R.string.question_8c,R.string.question_8d,R.string.answer_8),

            };
    final int PROGRESS_BAR = (int) Math.ceil(100/questionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        optionA=findViewById(R.id.option1);
        optionB=findViewById(R.id.option2);
        optionC=findViewById(R.id.option3);
        optionD=findViewById(R.id.option4);

        question=findViewById(R.id.question);
        score=findViewById(R.id.Score);
        questionNumber=findViewById(R.id.questionNumber);
        chechkout1=findViewById(R.id.selectedOption);
        checkout2=findViewById(R.id.correctAnswer);
        progressBar=findViewById(R.id.progressBar);
        CorrectQuestion=questionBank[currentIndex].getQuestionId();
        question.setText(CorrectQuestion);
        currentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(currentOptionA);
        currentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(currentOptionB);
        currentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(currentOptionC);
        currentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(currentOptionD);


        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              checkAnswer(currentOptionA);
              updateOption();
            }});
        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentOptionB);
                updateOption();
            }});
        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentOptionC);
                updateOption();
            }});
        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentOptionD);
                updateOption();
            }});
    }
    private void checkAnswer(int userOption)
    {
        correctAnswer=questionBank[currentIndex].getAnswerId();
        chechkout1.setText(userOption);
        checkout2.setText(correctAnswer);
        String m=chechkout1.getText().toString().trim();
        String n=checkout2.getText().toString().trim();

        if(n.equals(m))
        {
            Toast.makeText(this,"Right",Toast.LENGTH_SHORT).show();
            mScore=mScore+1;

        }
        else
        {
            Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show();
        }

    }
    private void updateOption()
    {
        currentIndex=(currentIndex+1)%questionBank.length;
        if(currentIndex==0)
        {
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Game over");
            alert.setCancelable(false);
            alert.setMessage("your points" + mScore);
            alert.setNegativeButton("Wanna play again", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    qn=1;
                    mScore=0;
                    progressBar.setProgress(0);
                    score.setText("Score " + mScore + "/" + questionBank.length);
                    questionNumber.setText(qn + "/" + questionBank.length + "question");

                }
            });
            alert.setPositiveButton("Quit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
        }

        CorrectQuestion=questionBank[currentIndex].getQuestionId();
        question.setText(CorrectQuestion);
        currentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(currentOptionA);
        currentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(currentOptionB);
        currentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(currentOptionC);
        currentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(currentOptionD);
        qn=qn+1;
        if (qn<=questionBank.length)
        {questionNumber.setText(qn+"/"+ questionBank.length +" question");}
        score.setText("Score"+ mScore+"/"+questionBank.length);
        progressBar.incrementProgressBy(PROGRESS_BAR);

    }
}