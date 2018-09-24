package com.example.jinyoungkim.teamgung.ui.gung_tour.going_palace.viewpager_going_items;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.jinyoungkim.teamgung.R;
import com.example.jinyoungkim.teamgung.ui.gung_tour.going_palace.going_dialog.GoingChangdeokDialog;
import com.example.jinyoungkim.teamgung.ui.gung_tour.going_palace.going_dialog.GoingChanggyonDialog;

public class GoingChanggyong extends Fragment {
    public View view;
    GoingChanggyonDialog cd;
    ImageView changgyong;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.vpitem_going_changgyong,container,false);
        DisplayMetrics dm = view.getContext().getApplicationContext().getResources().getDisplayMetrics(); //디바이스 화면크기를 구하기위해
        int width = dm.widthPixels; //디바이스 화면 너비
        int height = dm.heightPixels; //디바이스 화면 높이

        changgyong = (ImageView)view.findViewById(R.id.img_changgyong_goingpalace);
        cd = new  GoingChanggyonDialog(this.getContext());

        WindowManager.LayoutParams wm = cd.getWindow().getAttributes();  //다이얼로그의 높이 너비 설정하기위해
        wm.copyFrom(cd.getWindow().getAttributes());  //여기서 설정한값을 그대로 다이얼로그에 넣겠다는의미
        wm.width = width / 2;  //화면 너비의 절반
        wm.height = height / 2;  //화면 높이의 절반
        changgyong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cd.show();  //다이얼로그
            }
        });
        return view;
    }
}
