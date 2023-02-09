package com.example.mycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView resultTv,solutionTv;
    MaterialButton buttonC,buttonBrackOpen,buttonBrackClose;
    MaterialButton buttonDivide,buttonMultiply,buttonPlus,buttonMinus,buttonEquals;
    MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    MaterialButton buttonAC,buttonDot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.soln_tv);

        assignId(buttonC,R.id.C);
        assignId(buttonBrackOpen,R.id.brac);
        assignId(buttonBrackClose,R.id.brac1);
        assignId(buttonDivide,R.id.div);
        assignId(buttonMultiply,R.id.multiply);
        assignId(buttonPlus,R.id.add);
        assignId(buttonMinus,R.id.sub);
        assignId(buttonEquals,R.id.equal);
        assignId(button0,R.id.n0);
        assignId(button1,R.id.n1);
        assignId(button2,R.id. n2);
        assignId(button3,R.id.n3);
        assignId(button4,R.id.n4);
        assignId(button5,R.id.n5);
        assignId(button6,R.id.n6);
        assignId(button7,R.id.n7);
        assignId(button8,R.id.n8);
        assignId(button9,R.id.n9);
        assignId(buttonAC,R.id.AC);
        assignId(buttonDot,R.id.dot);





    }

    void assignId(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        MaterialButton button =(MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solutionTv.getText().toString();

        if(buttonText.equals("AC")){
            solutionTv.setText("");
            resultTv.setText("0");
            return;
        }
        if(buttonText.equals("=")){
            solutionTv.setText(resultTv.getText());
            return;
        }
        if(buttonText.equals("C")){
            dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
        }else{
            dataToCalculate = dataToCalculate+buttonText;
        }
        solutionTv.setText(dataToCalculate);

        String finalResult = getResult(dataToCalculate);

        if(!finalResult.equals("Err")){
            resultTv.setText(finalResult);
        }

    }

    String getResult(String data){
        try{
            Context context  = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult =  context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if(finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0","");
            }
            return finalResult;
        }catch (Exception e){
            return "Err";
        }
    }

}
  /*  assignId(buttonC,R.id.C);
    assignId(buttonBrackOpen,R.id.brac);
    assignId(buttonBrackClose,R.id.brac1);
    assignId(buttonDivide,R.id.div);
    assignId(buttonMultiply,R.id.multiply);
    assignId(buttonPlus,R.id.add);
    assignId(buttonMinus,R.id.sub);
    assignId(buttonEquals,R.id.equal);
    assignId(button0,R.id.n0);
    assignId(button1,R.id.n1);
    assignId(button2,R.id. n2);
    assignId(button3,R.id.n3);
    assignId(button4,R.id.n4);
    assignId(button5,R.id.n5);
    assignId(button6,R.id.n6);
    assignId(button7,R.id.n7);
    assignId(button8,R.id.n8);
    assignId(button9,R.id.n9);
    assignId(buttonAC,R.id.AC);
    assignId(buttonDot,R.id.dot);

    button0 = findViewById(R.id.n0);
        button1 = findViewById(R.id.n1);
        button2 = findViewById(R.id.n2);
        button3 = findViewById(R.id.n3);
        button4 = findViewById(R.id.n4);
        button5 = findViewById(R.id.n5);
        button6 = findViewById(R.id.n6);
        button7 = findViewById(R.id.n7);
        button8 = findViewById(R.id.n8);
        button9 = findViewById(R.id.n9);

        buttonC =findViewById(R.id.C);
        buttonBrackOpen =findViewById(R.id.brac);
        buttonBrackClose =findViewById(R.id.brac1);
        buttonDivide =findViewById(R.id.div);
        buttonMultiply =findViewById(R.id.multiply);
        buttonPlus =findViewById(R.id.add);
        buttonMinus =findViewById(R.id.sub);
        buttonEquals =findViewById(R.id.equal);
        buttonDot =findViewById(R.id.dot);
        buttonAC =findViewById(R.id.AC);

    */




