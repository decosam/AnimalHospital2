package com.example.animalhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        //img_map
        findViewById(R.id.img_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:37.4824,127.0838") );
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=서울랜드&z=23") ); //특정 검색 &z=23 > 최대크기로 키움
                startActivity(intent);
            }
        });

    }


}
