package com.example.animalhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img_product_main;
    RadioButton radio1,radio2,radio3;
    Button btn_minus,btn_plus,btn_pay;
    EditText edit_count;
    TextView txt_price,txt_delivery,txt_pay;
    CheckBox chk_agree;

    int selected_count = 1;
    String selected_name = "";
    int selected_price; // 선택 아이템 가격
    int val_delivery = 0; // 배송려
    int val_pay = 0; // 최종결제 변수
    int val_price = 0; // 수량 * 단가
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        img_product_main = findViewById(R.id.img_product_main);
        //radio1 = findViewById(R.id.radio1);
        //radio2 = findViewById(R.id.radio2);
        //radio3 = findViewById(R.id.radio3);
        //btn_plus = findViewById(R.id.btn_plus);
        //btn_minus = findViewById(R.id.btn_minus);
        //btn_pay = findViewById(R.id.btn_pay);
        edit_count = findViewById(R.id.edit_count);
        txt_delivery = findViewById(R.id.txt_delivery);
        txt_price = findViewById(R.id.txt_price);
        txt_pay = findViewById(R.id.txt_pay);
        chk_agree = findViewById(R.id.chk_agree);

        findViewById(R.id.radio1).setOnClickListener(this);
        findViewById(R.id.radio2).setOnClickListener(this);
        findViewById(R.id.radio3).setOnClickListener(this);
        findViewById(R.id.btn_pay).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);

        findViewById(R.id.radio1).performClick();

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.radio1:
                img_product_main.setImageResource(R.drawable.product1);
                selected_price = 1500;
                selected_name = findViewById(R.id.radio1).getTag().toString();
                sumTotal();
                break;
            case R.id.radio2:
                img_product_main.setImageResource(R.drawable.product2);
                selected_name = findViewById(R.id.radio2).getTag().toString();
                selected_price = 2000;
                sumTotal();
                break;
            case R.id.radio3:
                img_product_main.setImageResource(R.drawable.product3);
                selected_name = findViewById(R.id.radio3).getTag().toString();
                selected_price = 3000;
                sumTotal();
                break;
            case R.id.btn_plus:
                selected_count = Integer.parseInt(edit_count.getText().toString());
                if(selected_count == 5){

                    Toast.makeText(this, "최대수량5임", Toast.LENGTH_SHORT).show();
                    edit_count.setText("5");
                }else{
                    ++selected_count;
                    edit_count.setText(String.valueOf(selected_count));
                    sumTotal();
                }

                break;
            case R.id.btn_pay:
                if(chk_agree.isChecked()){
                    Intent intent = new Intent(ShopActivity.this,PayActivity.class);
                    intent.putExtra("item_name",selected_name);
                    intent.putExtra("item_count",selected_count);
                    intent.putExtra("item_pay",val_pay);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "결제 동의해주세요", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_minus:
                selected_count = Integer.parseInt(edit_count.getText().toString());
                if(selected_count == 1){
                    Toast.makeText(this, "최소수량1임", Toast.LENGTH_SHORT).show();
                }else{
                    --selected_count;
                    edit_count.setText(String.valueOf(selected_count));
                    sumTotal();
                }
                break;

        }
    }

    private void sumTotal() {
        int selected_count = Integer.parseInt(edit_count.getText().toString());
        val_price = selected_price * selected_count;
        txt_price.setText(val_price+"원");
        // 수량 * 단가 계산 화면 출력

        if(val_price >= 10000){
            txt_delivery.setText("무료");
            val_delivery = 0;
        }
        else{
            val_delivery = 3000;
            txt_delivery.setText(val_delivery+"원");
        }
        // 배송비 : txt_price >= 10000 이상이면 무료
        // 아니면 3000원 추가
        val_pay = val_price + val_delivery;
        txt_pay.setText(val_pay+"원");
    }
}