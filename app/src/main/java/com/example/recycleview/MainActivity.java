package com.example.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private RecyclerView rvtest;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        initView();
    }

    public void initView(){
        rvtest=findViewById(R.id.rv_test);

        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvtest.setLayoutManager(layoutManager);
        TestAdapter testAdapter=new TestAdapter(R.layout.testitem, Arrays.asList("1","2","3"));//传入布局和数据源
        testAdapter.setOnItemClickListener(this);
        rvtest.setAdapter(testAdapter);

    }

    private static final String TAG = "MainActivity";
    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        Log.e(TAG, "onItemClick: "+position );
        TextView textView= view.findViewById(R.id.tv_text1);
        textView.setVisibility(View.VISIBLE);
        textView.setText("12");
    }
}