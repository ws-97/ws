package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvtest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){
        rvtest=findViewById(R.id.rv_test);

        //设置布局管理
        rvtest.setLayoutManager(new LinearLayoutManager(this));
        //设置item增加和删除时的动画
        rvtest.setItemAnimator(new DefaultItemAnimator());
//        TestAdapter testAdapter=new TestAdapter(R.layout.testitem, Arrays.asList("1","2","3"));//传入布局和数据源
        DefaultAdapter defaultAdapter=new DefaultAdapter(this, Arrays.asList("1","2","3"));
        rvtest.setAdapter(defaultAdapter);
    }


}