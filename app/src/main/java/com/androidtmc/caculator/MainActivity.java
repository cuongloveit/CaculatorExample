package com.androidtmc.caculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private EditText edtNum1,edtNum2,edtResult;
    private Button btnCal;
    private RadioButton rdAdd,rdSub,rdPro,rdDiv;
    private static final int ADD = 1;
    private static final int SUB = 2;
    private static final int PRO = 3;
    private static final int DIV = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lấy 2 số từ edittext
                int num1 = Integer.parseInt(edtNum1.getText().toString());
                int num2 = Integer.parseInt(edtNum2.getText().toString());
                //Lấy kiểu phép tính.
                int type = 0;
                if(rdAdd.isChecked()) type = ADD;
                if(rdSub.isChecked()) type = SUB;
                if(rdPro.isChecked()) type = PRO;
                if(rdDiv.isChecked()) type = DIV;
                //Đưa kết qua ra edittext
                edtResult.setText(caculate(type,num1,num2)+"");
            }
        });
    }

    /**
     * Hàm khởi tạo các widget có trong layout.
     */
    private void initWidgets() {
        edtNum1 = (EditText) findViewById(R.id.edtNum1);
        edtNum2 = (EditText) findViewById(R.id.edtNum2);
        edtResult = (EditText) findViewById(R.id.edtResult);

        btnCal = (Button) findViewById(R.id.btnCal);

        rdAdd = (RadioButton) findViewById(R.id.rdAdd);
        rdSub = (RadioButton) findViewById(R.id.rdSub);
        rdPro = (RadioButton) findViewById(R.id.rdPro);
        rdDiv = (RadioButton) findViewById(R.id.rdDiv);
    }

    /**
     * Hàm thực hiện các phép tính
     * @param type
     * @param num1
     * @param num2
     * @return
     */
    public float caculate(int type,float num1, float num2){
        float result = 0;
        switch (type){
            case ADD: result = num1 + num2; break;
            case SUB: result = num1 - num2; break;
            case PRO: result = num1 * num2; break;
            case DIV: result = num1 / num2; break;
        }
        return result;
    }
}
