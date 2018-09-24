package com.example.jinyoungkim.teamgung.ui.gung_ticket.make_reservation.booking_normal;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jinyoungkim.teamgung.R;

public class GyeongbokNormalActivity extends AppCompatActivity {

    CalendarView calendarView; // 캘린더
    ImageView adult_minus_gyeongbok_palace, adult_plus_gyeongbok_palace; // 성인 가감버튼
    TextView adult_number_gyeongbok_palace;

    ImageView jongro_minus_gyeongbok_palace, jongro_plus_gyeongbok_palace; // 종로구민 가감버튼
    TextView jongro_number_gyeongbok_palace;

    RelativeLayout payment_gyeongbok_normal; // 결제하기 버튼

    int adult_number_gyeongbok_palace_i, jongro_number_gyeongbok_palace_i;
    int r_year, r_month, r_day;

    //  통신에 넘길 데이터
    int palace_id; // 궁 아이디(0 : 경복궁, 1 : 창덕궁, 2 : 창경궁, 3 : 덕수궁, 4 : 종묘 )
    String ticket_title; // 티켓 이름
    String ticket_start; // 티켓 시작 날짜
    String ticket_end; // 티켓 끝나는 날짜
    String ticket_people_adult, ticket_people_jongro;
    String ticket_people; // 사람 정보
    int ticket_special; // 특별권 여부
    int ticket_jongro; // 종로인 구분

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.gyeongbok);
        setContentView(R.layout.activity_gyeongbok_normal);

        //        상태바 색상변경
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(0xffB54141);
        }

        // 초기화
        calendarView = (CalendarView)findViewById(R.id.calendar_gyeongbok);
        adult_minus_gyeongbok_palace = (ImageView)findViewById(R.id.adult_minus_gyeongbok_palace);
        adult_plus_gyeongbok_palace = (ImageView)findViewById(R.id.adult_plus_gyeongbok_palace);
        adult_number_gyeongbok_palace = (TextView)findViewById(R.id.adult_number_gyeongbok_palace);
       adult_number_gyeongbok_palace.setText("0");

        jongro_minus_gyeongbok_palace = (ImageView)findViewById(R.id.jongro_minus_gyeongbok_palace);
        jongro_plus_gyeongbok_palace = (ImageView)findViewById(R.id.jongro_plus_gyeongbok_palace);
        jongro_number_gyeongbok_palace = (TextView)findViewById(R.id.jongro_number_gyeongbok_palace);
        jongro_number_gyeongbok_palace.setText("0");

        payment_gyeongbok_normal = (RelativeLayout)findViewById(R.id.payment_gyeongbok_normal);


        // 1. 대인 가감버튼 동작
        adult_minus_gyeongbok_palace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adult_number_gyeongbok_palace_i>0){
                    adult_number_gyeongbok_palace_i --;
                    adult_number_gyeongbok_palace.setText(String.valueOf(adult_number_gyeongbok_palace_i));
                }

                ticket_people_adult = "대인 "+String.valueOf(adult_number_gyeongbok_palace_i);
                Log.e("대인",ticket_people_adult);
            }
        });

        adult_plus_gyeongbok_palace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adult_number_gyeongbok_palace_i ++;
                adult_number_gyeongbok_palace.setText(String.valueOf(adult_number_gyeongbok_palace_i));
                ticket_people_adult = "대인 "+String.valueOf(adult_number_gyeongbok_palace_i);
                Log.e("대인",ticket_people_adult);
            }
        });

        // 종로구민 가감버튼 동작
        jongro_minus_gyeongbok_palace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jongro_number_gyeongbok_palace_i>0){
                    jongro_number_gyeongbok_palace_i --;
                    jongro_number_gyeongbok_palace.setText(String.valueOf(jongro_number_gyeongbok_palace_i));
                }
                ticket_people_jongro = "종로구민 "+String.valueOf(jongro_number_gyeongbok_palace_i);
                Log.e("종로구민",ticket_people_jongro);
            }
        });

        jongro_plus_gyeongbok_palace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jongro_number_gyeongbok_palace_i ++;
                jongro_number_gyeongbok_palace.setText(String.valueOf(jongro_number_gyeongbok_palace_i));
                ticket_people_jongro = "종로구민 "+String.valueOf(jongro_number_gyeongbok_palace_i);
                Log.e("종로구민",ticket_people_jongro);
            }
        });

        // 달력 리스너
       calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
           @Override
           public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
               r_year = year;
               r_month = month;
               r_day = dayOfMonth;
               Log.e("date",String.valueOf(r_year));
               ticket_start=r_year+"."+r_month+"."+r_day;
               ticket_end=r_year+"."+r_month+"."+r_day;
           }
       });

        palace_id = 0; // 경복궁 아이디
        ticket_title = "경복궁 일반권";
        ticket_special = 0;


        // 결제하기 버튼 동작
       payment_gyeongbok_normal.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.e("궁아이디) ",String.valueOf(palace_id));
               Log.e("티켓종류) ", ticket_title);
               Log.e("티켓 시작일) ", ticket_start);
               Log.e("티켓 종료일) ", ticket_end);
               ticket_people = ticket_people_adult+" "+ticket_people_jongro;
               Log.e("사람 종류) ", ticket_people);
               Log.e("특별권 구분) ", String.valueOf(ticket_special));
           }
       });

    }
}
