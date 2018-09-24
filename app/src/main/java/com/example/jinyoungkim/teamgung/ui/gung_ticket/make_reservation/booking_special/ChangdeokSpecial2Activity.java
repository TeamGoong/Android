package com.example.jinyoungkim.teamgung.ui.gung_ticket.make_reservation.booking_special;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jinyoungkim.teamgung.R;

public class ChangdeokSpecial2Activity extends AppCompatActivity {

    ImageView changdeok_special_btn1,changdeok_special_btn2,changdeok_special_btn3; // 하단 정보 보기 버튼
    ImageView adult_minus_changdeok_special,adult_plus_changdeok_special; // 인원 수
    TextView adult_number_changdeok_special;
    int adult_number_changdeok_special_i;
    LinearLayout changdeok_special_layout1,changdeok_special_layout2,changdeok_special_layout3; // 하단 정보
    RelativeLayout payment_changdeok_special; // 결제하기 버튼
    int r_year, r_month, r_day;
    Intent i;

//  통신에 넘길 데이터
    int palace_id; // 궁 아이디(0 : 경복궁, 1 : 창덕궁, 2 : 창경궁, 3 : 덕수궁, 4 : 종묘 )
    String ticket_title; // 티켓 이름
    String ticket_start; // 티켓 시작 날짜
    String ticket_end; // 티켓 끝나는 날짜
    String ticket_people; // 사람 정보
    int ticket_special; // 특별권 여부
    int ticket_jongro; // 종로인 구분

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.changdeok);
        setContentView(R.layout.activity_changdeok_special2);

        //        상태바 색상변경
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(0xffF9C210);
        }

        // Special1Activity에서 받은 예매 날짜
        i = getIntent();
        r_year = i.getIntExtra("r_year",0);
        r_month = i.getIntExtra("r_month",0);
        r_day = i.getIntExtra("r_day",0);

        ticket_start = r_year+"."+r_month+"."+r_day;


        // 초기화
        changdeok_special_btn1 = (ImageView)findViewById(R.id.changdeok_special_btn1);
        changdeok_special_btn2 = (ImageView)findViewById(R.id.changdeok_special_btn2);
        changdeok_special_btn3 = (ImageView)findViewById(R.id.changdeok_special_btn3);

        adult_minus_changdeok_special = (ImageView)findViewById(R.id.adult_minus_changdeok_special);
        adult_number_changdeok_special = (TextView)findViewById(R.id.adult_number_changdeok_special);
        adult_number_changdeok_special.setText("0");
        adult_plus_changdeok_special = (ImageView)findViewById(R.id.adult_plus_changdeok_special);

        changdeok_special_layout1 = (LinearLayout)findViewById(R.id.changdeok_special_layout1);
        changdeok_special_layout2 = (LinearLayout)findViewById(R.id.changdeok_special_layout2);
        changdeok_special_layout3 = (LinearLayout)findViewById(R.id.changdeok_special_layout3);

        payment_changdeok_special = (RelativeLayout)findViewById(R.id.payment_changdeok_special);


        // 1. 궁궐 통합 관람권
        changdeok_special_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changdeok_special_btn1.setImageResource(R.drawable.changdeokgung_booking_every_yes);
                changdeok_special_btn2.setImageResource(R.drawable.changdeokgung_booking_always_no);
                changdeok_special_btn3.setImageResource(R.drawable.changdeokgung_booking_lunch_no);

                changdeok_special_layout1.setVisibility(View.VISIBLE);
                changdeok_special_layout2.setVisibility(View.GONE);
                changdeok_special_layout3.setVisibility(View.GONE);

                ticket_title = "궁궐 통합 관람권";
                r_year = i.getIntExtra("r_year",0);
                r_month = i.getIntExtra("r_month",0);
                r_day = i.getIntExtra("r_day",0);
                r_month = r_month+3;
                ticket_end = r_year+"."+r_month+"."+r_day;
            }
        });

        // 2. 상시 관람권
        changdeok_special_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changdeok_special_btn1.setImageResource(R.drawable.changdeokgung_booking_every_no);
                changdeok_special_btn2.setImageResource(R.drawable.changdeokgung_booking_always_yes);
                changdeok_special_btn3.setImageResource(R.drawable.changdeokgung_booking_lunch_no);

                changdeok_special_layout1.setVisibility(View.GONE);
                changdeok_special_layout2.setVisibility(View.VISIBLE);
                changdeok_special_layout3.setVisibility(View.GONE);

                ticket_title="상시 관람권";
                r_year = i.getIntExtra("r_year",0);
                r_month = i.getIntExtra("r_month",0);
                r_day = i.getIntExtra("r_day",0);
                r_month = r_month+1;
                ticket_end = r_year+"."+r_month+"."+r_day;
                ticket_special = 1;
            }
        });

        // 3. 점심시간 관람권
        changdeok_special_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changdeok_special_btn1.setImageResource(R.drawable.changdeokgung_booking_every_no);
                changdeok_special_btn2.setImageResource(R.drawable.changdeokgung_booking_always_no);
                changdeok_special_btn3.setImageResource(R.drawable.changdeokgung_booking_lunch_yes);

                changdeok_special_layout1.setVisibility(View.GONE);
                changdeok_special_layout2.setVisibility(View.GONE);
                changdeok_special_layout3.setVisibility(View.VISIBLE);

                ticket_title = "점심시간 관람권";
                r_year = i.getIntExtra("r_year",0);
                r_month = i.getIntExtra("r_month",0);
                r_day = i.getIntExtra("r_day",0);
                r_month = r_month+3;
                ticket_end = r_year+"."+r_month+"."+r_day;
            }
        });

        // 4. 인원 수 가감 버튼
        adult_minus_changdeok_special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adult_number_changdeok_special_i>0){
                    adult_number_changdeok_special_i --;
                    adult_number_changdeok_special.setText(String.valueOf(adult_number_changdeok_special_i));
                }
            }
        });

        adult_plus_changdeok_special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adult_number_changdeok_special_i ++;
                adult_number_changdeok_special.setText(String.valueOf(adult_number_changdeok_special_i));
            }
        });

        ticket_people = "대인 " + adult_number_changdeok_special_i;
        palace_id = 2; // 창덕궁 아이디
        ticket_jongro = 0;

        // 5. 결제하기 버튼
        payment_changdeok_special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("궁 아이디", String.valueOf(palace_id));
                Log.e("특별권 종류) ",ticket_title);
                Log.e("티켓 시작날짜) ",ticket_start);
                Log.e("티켓 끝나날짜) ", ticket_end);
                Log.e("사람정보) ", ticket_people);
                Log.e("특별권 구분) ", String.valueOf(ticket_special));
                Log.e("종로 구분) ",String.valueOf(ticket_jongro));

            }
        });
    }
}
