package com.example.jinyoungkim.teamgung.ui.gung_ticket.make_reservation.booking_normal;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.example.jinyoungkim.teamgung.R;
import com.example.jinyoungkim.teamgung.ui.gung_tour.TourMainActivity;

// 창덕궁 일반권 예매 페이지

public class ChangdeokNormalActivity extends AppCompatActivity {
    LinearLayout yesselect_palace_changdeok, yesselect_garden_changdeok;
    ImageView noselect_palace_changdeok, noselect_garden_changdeok;
    CalendarView calendar_changdeok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.changdeok);

        setContentView(R.layout.activity_changdeok_normal);

        //        상태바 색상변경
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(0xffF9C210);
        }

        // 초기화


        // 1. 하단 메뉴 설정
        yesselect_garden_changdeok = (LinearLayout)findViewById(R.id.yesselect_garden_changdeok);
        yesselect_palace_changdeok = (LinearLayout)findViewById(R.id.yesselect_palace_changdeok);

        noselect_garden_changdeok = (ImageView)findViewById(R.id.noselect_garden_changdeok);
        noselect_palace_changdeok = (ImageView)findViewById(R.id.noselect_palace_changdeok);

        // 2. 캘린더
        calendar_changdeok = (CalendarView)findViewById(R.id.calendar_changdeok);






        // 1. 하단 메뉴 설정
        yesselect_palace_changdeok.bringToFront();

        noselect_garden_changdeok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesselect_garden_changdeok.bringToFront();

                yesselect_garden_changdeok.setVisibility(View.VISIBLE);
                yesselect_palace_changdeok.setVisibility(View.GONE);
                noselect_palace_changdeok.setVisibility(View.VISIBLE);
            }
        });

        noselect_palace_changdeok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesselect_palace_changdeok.bringToFront();

                yesselect_palace_changdeok.setVisibility(View.VISIBLE);
                yesselect_garden_changdeok.setVisibility(View.GONE);
                noselect_garden_changdeok.setVisibility(View.VISIBLE);
            }
        });

        // 2. 캘린더
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            calendar_changdeok.setFocusedMonthDateColor(getResources().getColor(R.color.changduk));
        }
    }
}
