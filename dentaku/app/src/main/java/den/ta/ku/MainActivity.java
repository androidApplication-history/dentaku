package den.ta.ku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private double wkNum = 0;
    private String wkop = "";
    private double workNum = 0;
    //=が押されたか判別する
    private boolean equalFlug = false;
    //"."が押されたか判別する
    private boolean dotFlug = false;
    //少数加算するためのもの
    private double  dotNum = 0.1;
    //最終的な値
    private String value = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button[] numBtn = new Button[10];
        numBtn[0] = findViewById(R.id.zero);
        numBtn[1] = findViewById(R.id.one);
        numBtn[2] = findViewById(R.id.two);
        numBtn[3] = findViewById(R.id.three);
        numBtn[4] = findViewById(R.id.four);
        numBtn[5] = findViewById(R.id.five);
        numBtn[6] = findViewById(R.id.six);
        numBtn[7] = findViewById(R.id.seven);
        numBtn[8] = findViewById(R.id.eight);
        numBtn[9] = findViewById(R.id.nine);
        Button plusBtn = findViewById(R.id.plus);
        Button backspaceBtn = findViewById(R.id.backspace);
        Button clearBtn = findViewById(R.id.clear);
        Button multiBtn = findViewById(R.id.multi);
        Button subBtn = findViewById(R.id.sub);
        Button divBtn = findViewById(R.id.div);
        Button plus_minusBtn = findViewById(R.id.plus_minus);
        Button equalBtn =  findViewById(R.id.equal);
        Button dotBtn = findViewById(R.id.dot);


        equalBtn.setOnClickListener(view -> {
            opClicked(view);
        });
        plusBtn.setOnClickListener(view -> {
            opClicked(view);
        });
        backspaceBtn.setOnClickListener(view -> {
            opClicked(view);
        });
        clearBtn.setOnClickListener(view -> {
            opClicked(view);
        });
        multiBtn.setOnClickListener(view -> {
            opClicked(view);
        });
        subBtn.setOnClickListener(view -> {
            opClicked(view);
        });
        divBtn.setOnClickListener(view -> {
            opClicked(view);
        });
        plus_minusBtn.setOnClickListener(view -> {
            opClicked(view);
        });
        dotBtn.setOnClickListener(view -> {
            opClicked(view);
        });

        for (int i =0; i < numBtn.length; i++){
            numBtn[i].setOnClickListener(view -> {
                numBtnClicked(view);
            });
        }

    }

    //演算記号が押された時に行うメソッド
    private  void opClicked(View view){

        //表示されたボタンの種類を判別する
        Button opCode = (Button) view;
        //ボタンに書かれている文字の取得
        String operationCode = opCode.getText().toString();

        //取得した文字によって処理を変える
        if(operationCode.equals("+")){
            //小数点モードを解除
            dotFlug = false;
            dotNum = 0.1;

            //"="じゃないのでfalse
            equalFlug = false;
            //表示エリアの一時保存
            TextView tvDisplay = findViewById(R.id.display_area);
            String wkNumStr = tvDisplay.getText().toString();
            //int型に変換しておく
            wkNum = Double.parseDouble(wkNumStr);
            //演算子の保存
            wkop = "+";

            //表示エリアのクリア
            tvDisplay.setText("0");
        }else if (operationCode.equals("=")){
            //小数点モードを解除
            dotFlug = false;
            dotNum = 0.1;

            //"="なのでtrue
            equalFlug = true;
            //wkNumに入っている数値と表示エリアの数字を加算し、表示する
            TextView tvDisplay = findViewById(R.id.display_area);
            String wkNumStr = tvDisplay.getText().toString();

            //演算子の保存
            if(wkop.equals("+")) {
                wkNum += Double.parseDouble(wkNumStr);
            }else if(wkop.equals("÷")){
                wkNum /= Double.parseDouble(wkNumStr);
            }else if(wkop.equals("×")){
                wkNum *= Double.parseDouble(wkNumStr);
            }else if(wkop.equals("-")){
                wkNum -= Double.parseDouble(wkNumStr);
            }

            //小数点削除
            DecimalFormat format = new DecimalFormat("0.####");
            //加算結果を表示する
            tvDisplay.setText(String.valueOf(format.format(wkNum)));
        }else if (operationCode.equals("C")){
            //小数点モードを解除
            dotFlug = false;
            dotNum = 0.1;

            //"="じゃないのでfalse
            equalFlug = false;
            //表示エリアの一時保存
            TextView tvDisplay = findViewById(R.id.display_area);
            String wkNumStr = "0";
            wkNum = Double.parseDouble(wkNumStr);

            tvDisplay.setText("0");
        }else if (operationCode.equals("÷")){
            //小数点モードを解除
            dotFlug = false;
            dotNum = 0.1;

            //"="じゃないのでfalse
            equalFlug = false;
            //表示エリアの一時保存
            TextView tvDisplay = findViewById(R.id.display_area);
            String wkNumStr = tvDisplay.getText().toString();
            //int型に変換しておく
            wkNum = Double.parseDouble(wkNumStr);
            //演算子の保存
            wkop = "÷";

            //表示エリアのクリア
            tvDisplay.setText("0");
        }else if (operationCode.equals("×")){
            //小数点モードを解除
            dotFlug = false;
            dotNum = 0.1;

            //"="じゃないのでfalse
            equalFlug = false;
            //表示エリアの一時保存
            TextView tvDisplay = findViewById(R.id.display_area);
            String wkNumStr = tvDisplay.getText().toString();
            //int型に変換しておく
            wkNum = Double.parseDouble(wkNumStr);
            //演算子の保存
            wkop = "×";

            //表示エリアのクリア
            tvDisplay.setText("0");
        }else if (operationCode.equals("-")){
            //小数点モードを解除
            dotFlug = false;
            dotNum = 0.1;
            //"="じゃないのでfalse
            equalFlug = false;
            //表示エリアの一時保存
            TextView tvDisplay = findViewById(R.id.display_area);
            String wkNumStr = tvDisplay.getText().toString();
            //int型に変換しておく
            wkNum = Double.parseDouble(wkNumStr);
            //演算子の保存
            wkop = "-";

            //表示エリアのクリア
            tvDisplay.setText("0");
        }else if (operationCode.equals("±")){
            TextView tvDisplay = findViewById(R.id.display_area);
            String wkNumStr = tvDisplay.getText().toString();

            //equalFlugによって反転するintを判別
            if(equalFlug == false){//わーにんぐメモequalFlug == false' can be simplified to '!equalFlug'
                //"="が押される前
                workNum *= -1;
                //小数点削除
                DecimalFormat format = new DecimalFormat("0.####");
                //表示エリアのクリア
                tvDisplay.setText(String.valueOf(format.format(workNum)));
            }else{
                //"="が押された後
                wkNum *= -1;
                //小数点削除
                DecimalFormat format = new DecimalFormat("0.####");
                //表示エリアのクリア
                tvDisplay.setText(String.valueOf(format.format(wkNum)));
            }
        }else if (operationCode.equals("←")){
            //小数点削除
            DecimalFormat format = new DecimalFormat("0.#####");
            //表示エリアの一時保存
            TextView tvDisplay = findViewById(R.id.display_area);
            String workNumSTR = String.valueOf(format.format(workNum));
            try {//1桁以上
                if(dotFlug){
                    //少数桁を*10
                    dotNum *= 10;
                }
                workNumSTR = workNumSTR.substring(0, workNumSTR.length() - 1);
                workNum = Double.parseDouble(workNumSTR);
                tvDisplay.setText(String.valueOf(format.format(workNum)));
            }catch(NumberFormatException e){
                //1桁だった場合
                tvDisplay.setText(String.valueOf(0));
            }
        }else if(operationCode.equals(".")){
            dotFlug = true;
        }

    }

    private void numBtnClicked(View view) {

        // 押されたボタンのID(View)を取得、表示エリアに数字を表示する
        //ViewからButtonへのcastを行い、ボタンのテキストを表示する
        Button btn = (Button) view;
        //ボタンに書かれているテキスト(数字)を取得する
        String strBtn = btn.getText().toString();
        //表示エリアの一時保存
        TextView tvDisplay = findViewById(R.id.display_area);

        if(dotFlug){
            workNum = Double.parseDouble(tvDisplay.getText().toString());
            workNum = workNum + dotNum * Double.parseDouble(strBtn);
            dotNum *= 0.1;
        }else {
            workNum = Double.parseDouble(tvDisplay.getText().toString());
            workNum = workNum * 10 + Double.parseDouble(strBtn);
        }

        //小数点削除
        DecimalFormat format = new DecimalFormat("0.#####");

        tvDisplay.setText(String.valueOf(format.format(workNum)));
    }

}