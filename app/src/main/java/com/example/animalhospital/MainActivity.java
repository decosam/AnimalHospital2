package com.example.animalhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edt_userid,edt_passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_login = findViewById(R.id.btn_login);
        edt_userid = findViewById(R.id.edt_userid);
        edt_passwd = findViewById(R.id.edt_passwd);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Toast.makeText(MainActivity.this, "로그인 버튼 클릭", Toast.LENGTH_SHORT).show(); //이건 자동완성 T 써서 오버로딩
                // 아이디 10자리 : PieSystem2
                // 비밀번호 : 6자리 ~ 15자리 : 123456789
                String str_userid = edt_userid.getText().toString(); // 케이스가 많다
                String str_passwd = edt_passwd.getText().toString();
                Log.d("PieFlower","str_userid"+str_userid);
                Log.d("PieFlower",str_passwd);

                if(str_userid.length()!=10){
                    Toast.makeText(MainActivity.this, "아이디는 10자리입니다.", Toast.LENGTH_SHORT).show();
                }
                else if(str_passwd.length()>15 || str_passwd.length()<6){
                    Toast.makeText(MainActivity.this, "비밀번호는 6~ 15자리입니다.", Toast.LENGTH_SHORT).show();
                }
                else if(str_userid.equals("PieSystem2") && str_passwd.equals("123456789")){
                    Toast.makeText(MainActivity.this, str_userid + "님 환영합니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "입력한 로그인 정보를 확입하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.btn_info).setOnClickListener(this);
        findViewById(R.id.btn_guide).setOnClickListener(this);
        findViewById(R.id.btn_call).setOnClickListener(this);
        findViewById(R.id.btn_shop).setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btn_info:
                intent = new Intent(MainActivity.this,InfoActivity.class);
                intent.putExtra("MSG","안녕하세요");
                break;
            case R.id.btn_guide:
                intent = new Intent(MainActivity.this,GuideActivity.class);
                break;
            case R.id.btn_call:
                intent = new Intent(getApplicationContext(),CallActivity.class);
                break;
            case R.id.btn_shop:
                intent = new Intent(getApplicationContext(),ShopActivity.class);
                break;
        }
        startActivity(intent);
    }
}