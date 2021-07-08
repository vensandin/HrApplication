package com.example.hrapplication.ui.dashboard;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hrapplication.R;

import org.jetbrains.annotations.NotNull;

import java.util.Vector;


public class DashboardAttendanceFragment extends Fragment {
    private RecyclerView recyclerView;
    private Context context;

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_dashboard_attendance, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));//行數、左右滑動
        Vector<String> vDate_img1 = getImgViewDate1();
        Vector<String> vDate_tv1 = getTextViewDate1();
        Vector<String> vDate_tv2 = getTextViewDate2();
        Vector<String> vDate_tv3 = getTextViewDate3();
        recyclerView.setAdapter(new DashboardAttendanceFragment.MemberAdapter(context,vDate_img1,vDate_tv1,vDate_tv2,vDate_tv3));


        return root;
    }

    private class MemberAdapter extends RecyclerView.Adapter<DashboardAttendanceFragment.MemberAdapter.MyViewHolder>{
        private Context context;
        private Vector<String> vDate_img;
        private Vector<String> vDate_tv1;
        private Vector<String> vDate_tv2;
        private Vector<String> vDate_tv3;
        MemberAdapter(Context context, Vector<String> vDateList1, Vector<String> vDateList2, Vector<String> vDateList3, Vector<String> vDateList4){
            this.context = context;
            this.vDate_img = vDateList1;
            this.vDate_tv1 = vDateList2;
            this.vDate_tv2 = vDateList3;
            this.vDate_tv3 = vDateList4;
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView img_item;
            TextView tv1_item;
            TextView tv2_item;
            TextView tv3_item;
            public MyViewHolder(@NonNull @NotNull View date_item_view_d) {
                super(date_item_view_d);
                img_item = date_item_view_d.findViewById(R.id.item_img);
                tv1_item = date_item_view_d.findViewById(R.id.item_tv1);
                tv2_item = date_item_view_d.findViewById(R.id.item_tv2);
                tv3_item = date_item_view_d.findViewById(R.id.item_tv3);
            }
        }

        @NonNull
        @NotNull
        @Override
        public DashboardAttendanceFragment.MemberAdapter.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View fragment_dashboard_attendance_item_view = layoutInflater.inflate(R.layout.fragment_dashboard_attendance_item_view,parent,false);

            return new DashboardAttendanceFragment.MemberAdapter.MyViewHolder(fragment_dashboard_attendance_item_view);
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull DashboardAttendanceFragment.MemberAdapter.MyViewHolder holder, int position) {
            String sDate_img = vDate_img.get(position);
            String uri = "@drawable/" + sDate_img; //圖片路徑和名稱
            int imageResource = getResources().getIdentifier(uri, null, "com.example.hrapplication"); //取得圖片Resource位子
            holder.img_item.setImageResource(imageResource);

            String sDate_tv1 = vDate_tv1.get(position);
            holder.tv1_item.setText(sDate_tv1);

            String sDate_tv2 = vDate_tv2.get(position);
            holder.tv2_item.setText(sDate_tv2);

            String sDate_tv3 = vDate_tv3.get(position);
            holder.tv3_item.setText(sDate_tv3);




        }




        @Override
        public int getItemCount() {
            return vDate_img.size();
        }



        // view
        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;

            public ViewHolder(@NonNull @NotNull View date_item_view_d) {
                super(date_item_view_d);
                imageView = date_item_view_d.findViewById(R.id.item_img);
            }
        }

    }

    public Vector<String> getImgViewDate1(){
        Vector<String> vDate = new Vector<>();
        vDate.add("ic_g001");
        vDate.add("ic_g002");
        vDate.add("ic_g003");
        vDate.add("ic_g004");
        vDate.add("ic_g005");
        vDate.add("ic_g005");
        vDate.add("ic_g005");

        return vDate;
    }

    public Vector<String> getTextViewDate1(){
        Vector<String> vDate = new Vector<>();
        vDate.add("王大明");
        vDate.add("王忠明");
        vDate.add("王小明");
        vDate.add("王尚明");
        vDate.add("王夏明");
        vDate.add("王夏明");
        vDate.add("王夏明");

        return vDate;
    }

    public Vector<String> getTextViewDate2(){
        Vector<String> vDate = new Vector<>();
        vDate.add("技術處");
        vDate.add("技術處");
        vDate.add("技術處");
        vDate.add("技術處");
        vDate.add("技術處");
        vDate.add("技術處");
        vDate.add("技術處");


        return vDate;
    }

    public Vector<String> getTextViewDate3(){
        Vector<String> vDate = new Vector<>();
        vDate.add("1");
        vDate.add("2");
        vDate.add("3");
        vDate.add("4");
        vDate.add("5");
        vDate.add("5");
        vDate.add("5");

        return vDate;
    }
}