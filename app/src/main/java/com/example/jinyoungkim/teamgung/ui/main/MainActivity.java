package com.example.jinyoungkim.teamgung.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.jinyoungkim.teamgung.R;
import com.example.jinyoungkim.teamgung.ui.gung_ticket.TicketMainActivity;
import com.example.jinyoungkim.teamgung.ui.gung_tour.TourMainActivity;

public class MainActivity extends AppCompatActivity {

    ImageView btn_ticket, btn_tour; //예매정보, 궁궐정보 페이지로 넘어가는 이미지 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        뷰 초기화
        btn_ticket = (ImageView)findViewById(R.id.btn_ticket);
        btn_tour = (ImageView)findViewById(R.id.btn_tour);

//       1. 티켓 예매/화인 메뉴로 가기
        btn_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TicketMainActivity.class));
            }
        });

//       2. 궁 투어 메뉴로 가기
        btn_tour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TourMainActivity.class));
            }
        });

    }
}
