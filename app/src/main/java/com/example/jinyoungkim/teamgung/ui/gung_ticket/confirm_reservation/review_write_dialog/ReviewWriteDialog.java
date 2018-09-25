package com.example.jinyoungkim.teamgung.ui.gung_ticket.confirm_reservation.review_write_dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jinyoungkim.teamgung.R;

public class ReviewWriteDialog extends Dialog {
        ImageView good_tr;
        ImageView good_con ;
        ImageView good_see ;

        ImageView soso_tr;
        ImageView soso_con ;
        ImageView soso_see  ;

        ImageView bad_tr ;
        ImageView bad_con;
        ImageView bad_see;

    public ReviewWriteDialog(@NonNull Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //다이얼로그의 타이틀바를 없애주는 옵션입니다.
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  //다이얼로그의 배경을 투명으로 만듭니다.
        setContentView(R.layout.dialog_review_write);     //다이얼로그에서 사용할 레이아웃입니다.

        TextView finish = (TextView)findViewById(R.id.btn_finish_review);


        good_tr = (ImageView)findViewById(R.id.face_good_traffic);
        good_con = (ImageView)findViewById(R.id.face_good_congestion);
        good_see = (ImageView)findViewById(R.id.face_good_see);

        soso_tr = (ImageView)findViewById( R.id.face_soso_traffic);
        soso_con = (ImageView)findViewById(R.id.face_soso_congestion);
        soso_see = (ImageView)findViewById(R.id.face_soso_see);

        bad_tr = (ImageView)findViewById(R.id.face_bad_traffic);
        bad_con = (ImageView)findViewById(R.id.face_bad_congestion);
        bad_see = (ImageView)findViewById(R.id.face_bad_see);


        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        good_tr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearSelected_traffic();
                if(good_tr.isSelected()==false){
                    good_tr.setSelected(true);
                }else{
                    good_tr.setSelected(false);
                }

            }
        });
        good_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearSelected_congestion();
                if(good_con.isSelected()==false){
                    good_con.setSelected(true);
                }else{
                    good_con.setSelected(false);
                }

            }
        });
        good_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearSelected_see();
                if(good_see.isSelected()==false){
                    good_see.setSelected(true);
                }else{
                    good_see.setSelected(false);
                }

            }
        });
       soso_tr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearSelected_traffic();
                if(soso_tr.isSelected()==false){
                    soso_tr.setSelected(true);
                }else{
                    soso_tr.setSelected(false);
                }

            }
        });
        soso_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearSelected_congestion();
                if(soso_con.isSelected()==false){
                    soso_con.setSelected(true);
                }else{
                   soso_con.setSelected(false);
                }

            }
        });
        soso_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearSelected_see();
                if(soso_see.isSelected()==false){
                    soso_see.setSelected(true);
                }else{
                   soso_see.setSelected(false);
                }

            }
        });
        bad_tr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearSelected_traffic();
                if(bad_tr.isSelected()==false){
                   bad_tr.setSelected(true);
                }else{
                   bad_tr.setSelected(false);
                }

            }
        });
        bad_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearSelected_congestion();
                if(bad_con.isSelected()==false){
                   bad_con.setSelected(true);
                }else{
                   bad_con.setSelected(false);
                }

            }
        });
        bad_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearSelected_see();
                if(bad_see.isSelected()==false){
                    bad_see.setSelected(true);
                }else{
                    bad_see.setSelected(false);
                }

            }
        });

    }

    public void clearSelected_traffic(){
        good_tr.setSelected(false);
       soso_tr.setSelected(false);
        bad_tr.setSelected(false);
    }
    public void clearSelected_congestion(){
        good_con.setSelected(false);
        soso_con.setSelected(false);
        bad_con.setSelected(false);
    }
    public void clearSelected_see(){
        good_see .setSelected(false);
        soso_see.setSelected(false);
        bad_see.setSelected(false);

    }
}