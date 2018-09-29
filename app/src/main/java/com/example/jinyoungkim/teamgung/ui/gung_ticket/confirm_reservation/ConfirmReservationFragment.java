package com.example.jinyoungkim.teamgung.ui.gung_ticket.confirm_reservation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jinyoungkim.teamgung.R;
import com.example.jinyoungkim.teamgung.model.ConfirmTicket;
import com.example.jinyoungkim.teamgung.model.ConfirmTicketData;
import com.example.jinyoungkim.teamgung.model.ReviewWrite;
import com.example.jinyoungkim.teamgung.network.NetworkService;
import com.example.jinyoungkim.teamgung.ui.gung_ticket.confirm_reservation.adapter.ReservationConfirmAdapter;
import com.example.jinyoungkim.teamgung.ui.gung_ticket.confirm_reservation.data.TicketData;
import com.example.jinyoungkim.teamgung.ui.gung_tour.looking_palace.adapter.ShowingReviewsAdapter;
import com.example.jinyoungkim.teamgung.ui.gung_tour.looking_palace.data.PalaceData;
import com.example.jinyoungkim.teamgung.util.GlobalApplication;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// 예매 확인 탭 프레그먼트

public class ConfirmReservationFragment extends Fragment {

    //리사이클러뷰
    RecyclerView coming_rcv;
    RecyclerView finish_rcv;
    RecyclerView.LayoutManager mLayoutManager_f;
    RecyclerView.LayoutManager mLayoutManager_c;

    //데이터
    ArrayList<ConfirmTicketData> confirmTicketData;
    ArrayList<ConfirmTicketData> finishTicket;
    ArrayList<ConfirmTicketData> comingTicket;


    //네트워킹
    private NetworkService networkService;



    public ConfirmReservationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirm_reservation, container, false);

        //네트워킹
        networkService = GlobalApplication.getGlobalApplicationContext().getNetworkService();

        //      < 예매확인 > 리사이클러뷰 부분

        mLayoutManager_f = new LinearLayoutManager(this.getContext());
        mLayoutManager_c = new LinearLayoutManager(this.getContext());


        coming_rcv = view.findViewById(R.id.rcv_coming_confirm_ticket);//다가오는 예약
        coming_rcv.setHasFixedSize(true);

        coming_rcv.setLayoutManager(mLayoutManager_c);

        finish_rcv = view.findViewById(R.id.rcv_finish_confirm_ticket);//끝난 예약
        finish_rcv.setHasFixedSize(true);
        finish_rcv.setLayoutManager(mLayoutManager_f);

        //데이터 받아오고 그 데이터 리사이클러뷰에 뿌려주기
        confirm_ticket(view);


        return view;
    }

    public void confirm_ticket(final View view){
        Call<ConfirmTicket> confirmTicketCall = networkService.confirmTicket("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6NzcsInVzZXJfaWQiOjkyNTExMTA0MywiaWF0IjoxNTM3OTcyMzAwLCJleHAiOjE1NDA1NjQzMDB9.G2YwvjIT74v8d9HmoxRghPRW3f3Sns3pdWbzm5ZHgZQ");
        confirmTicketCall.enqueue(new Callback<ConfirmTicket>() {
            @Override
            public void onResponse(Call<ConfirmTicket> call, Response<ConfirmTicket> response) {
                if(response.isSuccessful()){
                    confirmTicketData = new ArrayList<>();

                    confirmTicketData = response.body().result;

                    finishTicket = new ArrayList<>();
                    comingTicket = new ArrayList<>();


                    for(int i = 0; i<confirmTicketData.size();i++){
                        if(confirmTicketData.get(i).end_flag == 1){
                            finishTicket.add(new ConfirmTicketData(confirmTicketData.get(i).ticket_id,confirmTicketData.get(i).palace_name,confirmTicketData.get(i).ticket_people
                                    ,confirmTicketData.get(i).ticket_title,confirmTicketData.get(i).ticket_flag,confirmTicketData.get(i).ticket_start
                                    ,confirmTicketData.get(i).ticket_end,confirmTicketData.get(i).ticket_review,confirmTicketData.get(i).end_flag));
                        }else{
                           comingTicket.add(new ConfirmTicketData(confirmTicketData.get(i).ticket_id,confirmTicketData.get(i).palace_name,confirmTicketData.get(i).ticket_people
                                    ,confirmTicketData.get(i).ticket_title,confirmTicketData.get(i).ticket_flag,confirmTicketData.get(i).ticket_start
                                    ,confirmTicketData.get(i).ticket_end,confirmTicketData.get(i).ticket_review,confirmTicketData.get(i).end_flag));
                        }
                    }


                    ReservationConfirmAdapter reservationConfirmAdapter_finish = new ReservationConfirmAdapter(finishTicket,view);
                    ReservationConfirmAdapter reservationConfirmAdapter_coming = new ReservationConfirmAdapter(comingTicket,view);

                    finish_rcv.setAdapter(reservationConfirmAdapter_finish);
                    coming_rcv.setAdapter(reservationConfirmAdapter_coming);



                }
            }

            @Override
            public void onFailure(Call<ConfirmTicket> call, Throwable t) {

            }
        });
    }

}
