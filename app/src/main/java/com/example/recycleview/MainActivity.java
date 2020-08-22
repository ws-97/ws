package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
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

        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvtest.setLayoutManager(layoutManager);
        TestAdapter testAdapter=new TestAdapter(R.layout.testitem, Arrays.asList("1","2","3"));//传入布局和数据源
        rvtest.setAdapter(testAdapter);
    }


}