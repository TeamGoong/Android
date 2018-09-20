package com.example.jinyoungkim.teamgung.ui.gung_ticket.make_reservation.booking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.jinyoungkim.teamgung.R;
import com.example.jinyoungkim.teamgung.ui.gung_ticket.make_reservation.booking_normal.ChangdeokNormalActivity;

public class BookingChangdeokActivity extends AppCompatActivity {

    private ImageView btn_normal_changdeok, btn_special_changdeok; // 일반권, 특별권 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_changdeok);

        // 초기화
        btn_normal_changdeok = (ImageView)findViewById(R.id.btn_normal_changdeok);
        btn_special_changdeok = (ImageView)findViewById(R.id.btn_special_changdeok);


        // 버튼 리스너

//       창덕궁 일반권
        btn_normal_changdeok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ChangdeokNormalActivity.class));
            }
        });

//       창덕궁 특별권
        btn_special_changdeok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
