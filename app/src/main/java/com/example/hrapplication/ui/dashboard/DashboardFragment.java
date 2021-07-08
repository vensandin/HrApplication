package com.example.hrapplication.ui.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.hrapplication.R;
import com.example.hrapplication.databinding.FragmentDashboardBinding;

import org.jetbrains.annotations.NotNull;

import java.util.Vector;

public class DashboardFragment extends Fragment {

    //private DashboardViewModel dashboardViewModel;
    //private FragmentDashboardBinding binding;

    private RecyclerView recyclerView_love;
    private RecyclerView recyclerView_all;
    private Context context;


    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
       */
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        //常用功能
        recyclerView_love = root.findViewById(R.id.love_rcv);
        recyclerView_love.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));//行數、左右滑動
        Vector<String> vDate_img1 = getImgViewDate1();
        Vector<String> vDate_tv1 = getTextViewDate1();
        recyclerView_love.setAdapter(new DashboardFragment.MemberAdapter(context,vDate_img1,vDate_tv1));

        //其他功能
        recyclerView_all = root.findViewById(R.id.dashboard_rcv);
        recyclerView_all.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));//行數、左右滑動
        Vector<String> vDate_img2 = getImgViewDate2();
        Vector<String> vDate_tv2= getTextViewDate2();
        recyclerView_all.setAdapter(new DashboardFragment.MemberAdapter(context,vDate_img2,vDate_tv2));

        return root;
    }

    private class MemberAdapter extends RecyclerView.Adapter<DashboardFragment.MemberAdapter.MyViewHolder>{
        private Context context;
        private Vector<String> vDate_img;
        private Vector<String> vDate_tv;
        MemberAdapter(Context context, Vector<String> vDateList1, Vector<String> vDateList2){
            this.context = context;
            this.vDate_img = vDateList1;
            this.vDate_tv = vDateList2;
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView img_item;
            TextView tv_item;
            public MyViewHolder(@NonNull @NotNull View date_item_view_d) {
                super(date_item_view_d);
                img_item = date_item_view_d.findViewById(R.id.item_img);
                tv_item = date_item_view_d.findViewById(R.id.item_tv);
            }
        }

        @NonNull
        @NotNull
        @Override
        public DashboardFragment.MemberAdapter.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View fragment_dashboard_item_view1 = layoutInflater.inflate(R.layout.fragment_dashboard_item_view1,parent,false);

            return new DashboardFragment.MemberAdapter.MyViewHolder(fragment_dashboard_item_view1);
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull DashboardFragment.MemberAdapter.MyViewHolder holder, int position) {
            String sDate_img = vDate_img.get(position);
            String uri = "@drawable/" + sDate_img; //圖片路徑和名稱
            int imageResource = getResources().getIdentifier(uri, null, "com.example.hrapplication"); //取得圖片Resource位子
            holder.img_item.setImageResource(imageResource);
            String sDate_tv = vDate_tv.get(position);
            holder.tv_item.setText(sDate_tv);


            holder.img_item.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if("ic_g001".equals(sDate_img)) {
                        Navigation.findNavController(view).navigate(R.id.navigation_dashboard_attendance);
                    }
                }
            });

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
        vDate.add("ic_g006");

        return vDate;
    }

    public Vector<String> getTextViewDate1(){
        Vector<String> vDate = new Vector<>();
        vDate.add("考勤匯總表");
        vDate.add("請假");
        vDate.add("補刷卡");
        vDate.add("出差");
        vDate.add("打卡");
        vDate.add("公文");

        return vDate;
    }

    public Vector<String> getImgViewDate2(){
        Vector<String> vDate = new Vector<>();
        vDate.add("ic_g001");
        vDate.add("ic_g002");
        vDate.add("ic_g003");
        vDate.add("ic_g004");
        vDate.add("ic_g005");
        vDate.add("ic_g006");

        return vDate;
    }

    public Vector<String> getTextViewDate2(){
        Vector<String> vDate = new Vector<>();
        vDate.add("文件");
        vDate.add("訂餐");
        vDate.add("排班");
        vDate.add("公告");
        vDate.add("投票");
        vDate.add("表單");

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