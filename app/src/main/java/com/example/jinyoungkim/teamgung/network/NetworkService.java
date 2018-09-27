package com.example.jinyoungkim.teamgung.network;

import com.example.jinyoungkim.teamgung.model.UserData;
import com.example.jinyoungkim.teamgung.model.UserInfoPost;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface NetworkService {

    // 1. 예매 확인 (티켓)


    // 2. 유저 등록
    @POST("/user/user_info")
    Call<UserData>login(@Body UserInfoPost userInfoPost);


    // 3. 결제 하기


    // 4. 배워보기 사진


    // 5. 후기 등록


}
