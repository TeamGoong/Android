package com.example.jinyoungkim.teamgung.ui.gung_ticket.make_reservation.booking_special;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jinyoungkim.teamgung.R;

public class ChangdeokSpecial1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changdeok_special1);

        //        상태바 색상변경
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(0xffF9C210);
        }
    }
}
