package com.example.hrapplication.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.hrapplication.R;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class HomeFragment extends Fragment {

    //private HomeViewModel homeViewModel;
    //private FragmentHomeBinding binding;


    private RecyclerView recyclerView_features;
    private RecyclerView recyclerView_date;
    private RecyclerView recyclerView_notice;
    private TextView textView_year;
    private Context context;

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        this.context = context;
    }



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        /*
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        */
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //功能
        recyclerView_features = root.findViewById(R.id.features_rcv);
        recyclerView_features.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));//行數、左右滑動
        Vector<String> vDate_f_img = getFeaturesImg();
        Vector<String> vDate_f_tv = getFeaturesTv();
        recyclerView_features.setAdapter(new MemberAdapter_Features(context,vDate_f_img,vDate_f_tv));


        //日期
        recyclerView_date = root.findViewById(R.id.date_rcv);
        recyclerView_date.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));//行數、左右滑動
        Vector<String> vDate_day = getDayDate();
        Vector<String> vDate_week = getWeektDate();
        recyclerView_date.setAdapter(new MemberAdapter_Date(context,vDate_day,vDate_week));


        //通知
        recyclerView_notice = root.findViewById(R.id.notice_rcv);
        recyclerView_notice.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));//行數、上下滑動
        Vector<String> vDate_n_img = getNoticeImg();
        Vector<String> vDate_n_tv1 = getNoticeTv1();
        Vector<String> vDate_n_tv2 = getNoticeTv2();
        Vector<String> vDate_n_tv3 = getNoticeTv3();
        Vector<String> vDate_n_tv4 = getNoticeTv4();
        Vector<String> vDate_n_tv5 = getNoticeTv5();
        recyclerView_notice.setAdapter(new MemberAdapter_Notice(context,vDate_n_img,vDate_n_tv1,vDate_n_tv2,vDate_n_tv3,vDate_n_tv4,vDate_n_tv5));


        //年月
        String year = getYear();
        String month = getMonth();
        month = getEMonth(Integer.parseInt(month));
        textView_year = root.findViewById(R.id.year_tv);
        textView_year.setText(month + "　" + year);





        return root;
    }

    private class MemberAdapter_Features extends RecyclerView.Adapter<MemberAdapter_Features.MyViewHolder>{
        private Context context;
        private Vector<String> vDateList_f_img;
        private Vector<String> vDateList_f_tv;
        MemberAdapter_Features(Context context, Vector<String> vDateList1, Vector<String> vDateList2){
            this.context = context;
            this.vDateList_f_img = vDateList1;
            this.vDateList_f_tv = vDateList2;
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView img_features;
            TextView tv_features;
            public MyViewHolder(@NonNull @NotNull View date_item_view) {
                super(date_item_view);
                img_features = date_item_view.findViewById(R.id.features_img);
                tv_features = date_item_view.findViewById(R.id.features_tv);
            }
        }

        @NonNull
        @NotNull
        @Override
        public MemberAdapter_Features.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View fragment_home_item_view1 = layoutInflater.inflate(R.layout.fragment_home_item_view1,parent,false);

            return new MyViewHolder(fragment_home_item_view1);
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull MemberAdapter_Features.MyViewHolder holder, int position) {
            String sDate_f_img = vDateList_f_img.get(position);
            String uri = "@drawable/" + sDate_f_img; //圖片路徑和名稱
            int imageResource = getResources().getIdentifier(uri, null, "com.example.hrapplication"); //取得圖片Resource位子
            holder.img_features.setImageResource(imageResource);

            String sDate_f_tv = vDateList_f_tv.get(position);
            holder.tv_features.setText(sDate_f_tv);
        }

        @Override
        public int getItemCount() {
            return vDateList_f_img.size();
        }


    }

    private class MemberAdapter_Date extends RecyclerView.Adapter<MemberAdapter_Date.MyViewHolder>{
        private Context context;
        private Vector<String> vDateList_day;
        private Vector<String> vDateList_week;
        String now = getDay();
        MemberAdapter_Date(Context context, Vector<String> vDateList1, Vector<String> vDateList2){
            this.context = context;
            this.vDateList_day = vDateList1;
            this.vDateList_week = vDateList2;
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView tv_day;
            TextView tv_week;
            LinearLayout layoutDate;
            public MyViewHolder(@NonNull @NotNull View date_item_view) {
                super(date_item_view);
                tv_day = date_item_view.findViewById(R.id.day_tv);
                tv_week = date_item_view.findViewById(R.id.week_tv);
                layoutDate = date_item_view.findViewById(R.id.layout_date);
            }
        }

        @NonNull
        @NotNull
        @Override
        public MemberAdapter_Date.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View fragment_home_item_view2 = layoutInflater.inflate(R.layout.fragment_home_item_view2,parent,false);

            return new MyViewHolder(fragment_home_item_view2);
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull MemberAdapter_Date.MyViewHolder holder, int position) {
            String sDate_day = vDateList_day.get(position);
            holder.tv_day.setText(sDate_day);

            String sDate_week = vDateList_week.get(position);
            holder.tv_week.setText(sDate_week);

            if(now.equals(sDate_day)){
                holder.tv_day.setTextColor(Color.parseColor("#FFFFFF"));
                holder.tv_week.setTextColor(Color.parseColor("#FFFFFF"));

                String uri = "@drawable/background_corners4"; //圖片路徑和名稱
                int imageResource = getResources().getIdentifier(uri, null, "com.example.hrapplication"); //取得圖片Resource位子
                holder.layoutDate.setBackgroundResource(imageResource);
            }else{
                holder.layoutDate.setBackgroundResource(0);
                holder.tv_day.setTextColor(Color.parseColor("#FF757575"));
                holder.tv_week.setTextColor(Color.parseColor("#FF757575"));
            }
        }

        @Override
        public int getItemCount() {
            return vDateList_day.size();
        }


    }

    private class MemberAdapter_Notice extends RecyclerView.Adapter<MemberAdapter_Notice.MyViewHolder>{
        private Context context;
        private Vector<String> vDateList_N_img;
        private Vector<String> vDateList_N_tv1;
        private Vector<String> vDateList_N_tv2;
        private Vector<String> vDateList_N_tv3;
        private Vector<String> vDateList_N_tv4;
        private Vector<String> vDateList_N_tv5;
        MemberAdapter_Notice(Context context, Vector<String> vDateList1, Vector<String> vDateList2, Vector<String> vDateList3, Vector<String> vDateList4, Vector<String> vDateList5, Vector<String> vDateList6){
            this.context = context;
            this.vDateList_N_img = vDateList1;
            this.vDateList_N_tv1 = vDateList2;
            this.vDateList_N_tv2 = vDateList3;
            this.vDateList_N_tv3 = vDateList4;
            this.vDateList_N_tv4 = vDateList5;
            this.vDateList_N_tv5 = vDateList6;
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView img_notice;
            TextView tv_notice1;
            TextView tv_notice2;
            TextView tv_notice3;
            TextView tv_notice4;
            TextView tv_notice5;
            public MyViewHolder(@NonNull @NotNull View date_item_view) {
                super(date_item_view);
                img_notice = date_item_view.findViewById(R.id.notice_img);
                tv_notice1 = date_item_view.findViewById(R.id.notice_tv1);
                tv_notice2 = date_item_view.findViewById(R.id.notice_tv2);
                tv_notice3 = date_item_view.findViewById(R.id.notice_tv3);
                tv_notice4 = date_item_view.findViewById(R.id.notice_tv4);
                tv_notice5 = date_item_view.findViewById(R.id.notice_tv5);
            }
        }

        @NonNull
        @NotNull
        @Override
        public MemberAdapter_Notice.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View fragment_home_item_view3 = layoutInflater.inflate(R.layout.fragment_home_item_view3,parent,false);

            return new MyViewHolder(fragment_home_item_view3);
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull MemberAdapter_Notice.MyViewHolder holder, int position) {

            String sDate_n_img = vDateList_N_img.get(position);
            String uri = "@drawable/" + sDate_n_img; //圖片路徑和名稱
            int imageResource = getResources().getIdentifier(uri, null, "com.example.hrapplication"); //取得圖片Resource位子
            holder.img_notice.setImageResource(imageResource);

            String sDate_n_tv1 = vDateList_N_tv1.get(position);
            holder.tv_notice1.setText(sDate_n_tv1);

            String sDate_n_tv2 = vDateList_N_tv2.get(position);
            holder.tv_notice2.setText(sDate_n_tv2);

            String sDate_n_tv3 = vDateList_N_tv3.get(position);
            holder.tv_notice3.setText(sDate_n_tv3);

            String sDate_n_tv4= vDateList_N_tv4.get(position);
            holder.tv_notice4.setText(sDate_n_tv4);

            String sDate_n_tv5 = vDateList_N_tv5.get(position);
            holder.tv_notice5.setText(sDate_n_tv5);

        }

        @Override
        public int getItemCount() {
            return vDateList_N_img.size();
        }


    }

    public static String getYear(){
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat ("yyyy");
        String ctime = formatter.format(new Date());
        return ctime;
    }

    public static String getMonth(){
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat ("M");
        String ctime = formatter.format(new Date());
        return ctime;
    }

    public static String getWeek(){
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat ("E");
        String ctime = formatter.format(new Date());
        return ctime;
    }

    public static String getDay(){
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat ("d");
        String ctime = formatter.format(new Date());
        return ctime;
    }

    public Vector<String> getDayDate(){
        Vector<String> vDate = new Vector<>();
        String m = getMonth();
        int endDD = 31;
        if("2".equals(m)){
            endDD = 28;
        }else if("4".equals(m) || "6".equals(m) || "9".equals(m) || "11".equals(m)){
            endDD = 30;
        }
        for(int i = 0; i < endDD; i++){
            String iDD = String.valueOf(i+1);
            /*if(i<9){
                iDD = "0"+iDD;
            }*/
            vDate.add(iDD);
        }

        return vDate;
    }

    public Vector<String> getWeektDate(){
        Vector<String> vDate = new Vector<>();
        String m = getMonth();
        String d = getDay();
        String w = getWeek();
        int wek = 1;
        int day =Integer.parseInt(d);
        int endDD = 31;
        if("週一".equals(w) || "Mon".equals(w)){
            wek = 1;
        }else if("週二".equals(w) || "Tue".equals(w)){
            wek = 2;
        }else if("週三".equals(w) || "Wed".equals(w)){
            wek = 3;
        }else if("週四".equals(w) || "Thu".equals(w)){
            wek = 4;
        }else if("週五".equals(w) || "Fri".equals(w)){
            wek = 5;
        }else if("週六".equals(w) || "Sat".equals(w)){
            wek = 6;
        }else if("週日".equals(w) || "Sun".equals(w)){
            wek = 7;
        }
        wek = 7 - (Math.abs((day - wek)) % 7) + 1;

        if("2".equals(m)){
            endDD = 28;
        }else if("4".equals(m) || "6".equals(m) || "9".equals(m) || "11".equals(m)){
            endDD = 30;
        }
        for(int i = 0; i < endDD; i++) {
            if(wek == 1) {
                vDate.add("Mon");//一
                wek++;
            }
            if(wek == 2) {
                vDate.add("Tue");//二
                wek++;
            }
            if(wek == 3) {
                vDate.add("Wed");//三
                wek++;
            }
            if(wek == 4) {
                vDate.add("Thu");//四
                wek++;
            }
            if(wek == 5) {
                vDate.add("Fri");//五
                wek++;
            }
            if(wek == 6) {
                vDate.add("Sat");//六
                wek++;
            }
            if(wek == 7) {
                vDate.add("Sun");//日
                wek = 1;
            }
        }
        return vDate;
    }

    public String getEMonth(int m){
        String mm = "";
        if(m == 1) {
            mm = "January";
        }else if(m == 2) {
            mm = "February";
        }else if(m == 3) {
            mm = "March";
        }else if(m == 4) {
            mm = "April";
        }else if(m == 5) {
            mm = "May";
        }else if(m == 6) {
            mm = "June";
        }else if(m == 7) {
            mm = "July";
        }else if(m == 8) {
            mm = "August";
        }else if(m == 9) {
            mm = "September";
        }else if(m == 10) {
            mm = "October";
        }else if(m == 11) {
            mm = "November";
        }else if(m == 12) {
            mm = "December";
        }
        return mm;
    }

    public Vector<String> getFeaturesImg(){
        Vector<String> vDate = new Vector<>();

        vDate.add("ic_g001");
        vDate.add("ic_g002");
        vDate.add("ic_g003");
        vDate.add("ic_g004");
        vDate.add("ic_g005");
        vDate.add("ic_g006");

        return vDate;
    }

    public Vector<String> getFeaturesTv(){
        Vector<String> vDate = new Vector<>();

        vDate.add("排班");
        vDate.add("加班");
        vDate.add("打卡");
        vDate.add("請假");
        vDate.add("文件");
        vDate.add("訂餐");

        return vDate;
    }

    public Vector<String> getNoticeImg(){
        Vector<String> vDate = new Vector<>();

        vDate.add("ic_g001");
        vDate.add("ic_g002");
        vDate.add("ic_g003");

        return vDate;
    }

    public Vector<String> getNoticeTv1(){
        Vector<String> vDate = new Vector<>();

        vDate.add("(L110630)");
        vDate.add("(L110631)");
        vDate.add("(L110632)");

        return vDate;
    }

    public Vector<String> getNoticeTv2(){
        Vector<String> vDate = new Vector<>();

        vDate.add("外訓申請提醒-人資動畫影音製作時站班(第一期)");
        vDate.add("外訓申請提醒-人資動畫影音製作時站班(第二期)");
        vDate.add("外訓申請提醒-人資動畫影音製作時站班(第三期)");

        return vDate;
    }

    public Vector<String> getNoticeTv3(){
        Vector<String> vDate = new Vector<>();

        vDate.add("09:35");
        vDate.add("09:40");
        vDate.add("09:45");

        return vDate;
    }

    public Vector<String> getNoticeTv4(){
        Vector<String> vDate = new Vector<>();

        vDate.add("Dec");
        vDate.add("Dec");
        vDate.add("Dec");

        return vDate;
    }

    public Vector<String> getNoticeTv5(){
        Vector<String> vDate = new Vector<>();

        vDate.add("27");
        vDate.add("28");
        vDate.add("29");

        return vDate;
    }

    /*
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    */
}