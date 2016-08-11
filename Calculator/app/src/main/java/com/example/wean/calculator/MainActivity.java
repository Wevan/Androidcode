package com.example.wean.calculator;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn_point,btn_clear,btn_del,btn_multiply,btn_plus,btn_minus,btn_divide,btn_equal;
    EditText et_input;
    boolean clear_flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0= (Button) findViewById(R.id.btn_0);
        btn1= (Button) findViewById(R.id.btn_1);
        btn2= (Button) findViewById(R.id.btn_2);
        btn3= (Button) findViewById(R.id.btn_3);
        btn4= (Button) findViewById(R.id.btn_4);
        btn5= (Button) findViewById(R.id.btn_5);
        btn6= (Button) findViewById(R.id.btn_6);
        btn7= (Button) findViewById(R.id.btn_7);
        btn8= (Button) findViewById(R.id.btn_8);
        btn9= (Button) findViewById(R.id.btn_9);
        btn_clear= (Button) findViewById(R.id.btn_clear);
        btn_point= (Button) findViewById(R.id.btn_point);
        btn_plus= (Button) findViewById(R.id.btn_plus);
        btn_minus= (Button) findViewById(R.id.btn_minus);
        btn_multiply= (Button) findViewById(R.id.btn_multiply);
        btn_del= (Button) findViewById(R.id.btn_del);
        btn_divide= (Button) findViewById(R.id.btn_divide);
        btn_equal= (Button) findViewById(R.id.btn_equal);
        et_input= (EditText) findViewById(R.id.et_input);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_point.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String str=et_input.getText().toString();
        switch (view.getId()){
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_point:
                if (clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }
                et_input.setText(str+((Button)view).getText());
                break;
            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                if (clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }
                et_input.setText(str+" "+((Button)view).getText()+" ");
                break;
            case R.id.btn_clear:
                clear_flag=false;
                et_input.setText("");
                break;
            case R.id.btn_del:
                if (clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }else if(str!=null&&!str.equals("")){
                    et_input.setText(str.substring(0,str.length()-1));
                }
                break;
            case R.id.btn_equal:
                getResult();
                break;
        }
    }
    private void getResult(){
        String exp=et_input.getText().toString();
        if (exp==null||exp.equals("")){
            return;
        }
        if(!exp.contains(" ")){
            return;
        }
        if(clear_flag){
            clear_flag=false;
            return;
        }
        clear_flag=true;
        double result=0;
        String s1=exp.substring(0,exp.indexOf(" "));
        String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        String s2=exp.substring(exp.indexOf(" ")+3);
        if (!s1.equals("")&&!s2.equals("")&&!op.equals("÷")){
            double d1=Double.parseDouble(s1);
            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                result=d1+d2;
            }
            else if(op.equals("-")){
                result=d1-d2;
            }
            else if(op.equals("×")){
                result=d1*d2;
            }
            else if(op.equals("÷")){
                if(d2==0){
                    result=0;
                }
                else {
                    result=d1/d2;
                }
            }
            if (!s1.contains(".")&&!s2.contains(".")){
                int r=(int)result;
                et_input.setText(r+"");
            }else{
                et_input.setText(result+"");
            }
        }else if (!s1.equals("")&&s2.equals("")){
            et_input.setText(exp);
        }else if (s1.equals("")&&!s2.equals("")){

            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                result=0+d2;
            }
            else if(op.equals("-")){
                result=0-d2;
            }
            else if(op.equals("×")){
                result=0*d2;
            }
            else if(op.equals("÷")){
                    result=0;
            }
            if (!s1.contains(".")&&!s2.contains(".")){
                int r=(int)result;
                et_input.setText(r+"");
            }else{
                et_input.setText(result+"");
            }
        }else {
            et_input.setText("");
        }
    }
}
