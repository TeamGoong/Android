package com.example.jinyoungkim.teamgung.ui.gung_ticket.make_reservation.booking_normal;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.jinyoungkim.teamgung.R;
import com.example.jinyoungkim.teamgung.ui.gung_tour.TourMainActivity;

// 창덕궁 일반권 예매 페이지

public class ChangdeokNormalActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changdeok_normal);

        //        상태바 색상변경
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(0xffF9C210);
        }

        // 초기화


    }
}
