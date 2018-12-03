package com.example.administrator.marimo;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.marimo.database.DataManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HabitEnroll extends AppCompatActivity {
    TextView bt;
    Button newBtn1;
    RadioGroup rgroup;
    RadioGroup rgroup2;
    DataManager dm = new DataManager(HabitEnroll.this);
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habitenroll);
        rgroup=(RadioGroup)findViewById(R.id.rgroup1);
        rgroup2=(RadioGroup)findViewById(R.id.rgroup2);
        newBtn1= (Button)findViewById(R.id.newBtn);
        showMarimoName();


        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1);
        tabHost1.setup();

        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1");
        ts1.setContent(R.id.content1);
        ts1.setIndicator("운동");
        tabHost1.addTab(ts1);

        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2");
        ts2.setContent(R.id.content2);
        ts2.setIndicator("공부");
        tabHost1.addTab(ts2);

        TabHost.TabSpec ts3 = tabHost1.newTabSpec("Tab Spec 3");
        ts3.setContent(R.id.content3);
        ts3.setIndicator("생활패턴");
        tabHost1.addTab(ts3);


        Button btn = (Button) findViewById(R.id.plus);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });
        bt=(TextView)findViewById(R.id.next2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                RadioButton selectedRdo = (RadioButton)findViewById(rgroup.getCheckedRadioButtonId());
                String selectedValue = selectedRdo.getText().toString();
                Toast.makeText(getApplicationContext(),selectedValue+"가 선택되었습니다", Toast.LENGTH_SHORT).show();

                RadioButton selectedRdo2 = (RadioButton)findViewById(rgroup2.getCheckedRadioButtonId());
                String selectedValue2 = selectedRdo2.getText().toString();
                Toast.makeText(getApplicationContext(),selectedValue2+"가 선택되었습니다", Toast.LENGTH_SHORT).show();

                //디비에 저장하려다 에러 나서 안함
//                int x = (int)(Math.random())+100;
//
//                String str_date = df.format(new Date());
//                dm.enrollAllHabit(x,selectedValue);
//                dm.enrollHabit(x,str_date,str_date+66);
                    Intent intent = new Intent(HabitEnroll.this, MainActivity.class);
                    startActivity(intent);

            }
        });

    }

    void show() {
        final EditText edittext = new EditText(this);
        edittext.setHint("15자 이내로 작성");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("습관을 입력해주세요.");

        builder.setView(edittext);
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), edittext.getText().toString(), Toast.LENGTH_LONG).show();
                        newBtn1.setText(edittext.getText().toString());
                        newBtn1.setVisibility(View.VISIBLE);

                    }
                });
        builder.setNegativeButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

    void showMarimoName() {
        DataManager dataManager = new DataManager(this);
        TextView tv = (TextView) findViewById(R.id.habitenroll_tv_marimoname);
        tv.setText(dataManager.getMarimoName());
    }
}
