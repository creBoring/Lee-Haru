package com.example.lee_haru;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int standardSize_X, standardSize_Y;
        float density;

        RelativeLayout area1 = (RelativeLayout) findViewById(R.id.area_1);
        RelativeLayout area2 = (RelativeLayout) findViewById(R.id.area_2);
        RelativeLayout area3 = (RelativeLayout) findViewById(R.id.area_3);
        RelativeLayout area4 = (RelativeLayout) findViewById(R.id.area_4);

        TextView area1Text = (TextView) findViewById(R.id.area_1_text);
        TextView area2Text = (TextView) findViewById(R.id.area_2_text);
        TextView area3Text = (TextView) findViewById(R.id.area_3_text);
        TextView area4Text = (TextView) findViewById(R.id.area_4_text);

        // 텍스트 사이즈를 동적으로 지정하기 위해 화면 비율에 맞게 사이즈 가져오기
        Point ScreenSize = getScreenSize(this);
        density  = getResources().getDisplayMetrics().density;
        standardSize_X = (int) (ScreenSize.x / density);


        // 서비스 동
        area1.setOnClickListener(this::areaClick);
        area2.setOnClickListener(this::areaClick);
        area3.setOnClickListener(this::areaClick);
        area4.setOnClickListener(this::areaClick);

        area1Text.setTextSize((float) (standardSize_X / 7));
        area2Text.setTextSize((float) (standardSize_X / 7));
        area3Text.setTextSize((float) (standardSize_X / 7));
        area4Text.setTextSize((float) (standardSize_X / 7));

    }

    private Point getScreenSize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return  size;
    }

    private void areaClick(View view) {
        if(view.getAlpha()<1)
            view.setAlpha(1);
        else
            view.setAlpha(0.5F);
    }
}