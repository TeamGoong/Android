package com.example.jinyoungkim.teamgung.ui.main;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.jinyoungkim.teamgung.R;
import com.example.jinyoungkim.teamgung.ui.gung_ticket.TicketMainActivity;
import com.example.jinyoungkim.teamgung.ui.gung_tour.TourMainActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {


    RelativeLayout btn_ticket, btn_tour; //예매정보, 궁궐정보 페이지로 넘어가는 이미지 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getHashKey();

//        뷰 초기화
        btn_ticket = (RelativeLayout)findViewById(R.id.btn_ticket);
        btn_tour = (RelativeLayout)findViewById(R.id.btn_tour);

//       1. 티켓 예매/화인 메뉴로 가기
        btn_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(), TicketMainActivity.class);
                startActivity(i1);
            }
        });

//       2. 궁 투어 메뉴로 가기
        btn_tour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(getApplicationContext(),TourMainActivity.class);
                startActivity(i2);
            }
        });

    }

//   카카오 로그인 해시키 가져오는 함수
    private void getHashKey(){

        try{

            PackageInfo info = getPackageManager().getPackageInfo("com.example.jinyoungkim.teamgung", PackageManager.GET_SIGNATURES);

            for(Signature signature : info.signatures){
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("TAG: ","key_hash: "+ Base64.encodeToString(md.digest(),Base64.DEFAULT));
            }

        } catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

    }

}
