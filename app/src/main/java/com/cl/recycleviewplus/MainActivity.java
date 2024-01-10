package com.cl.recycleviewplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cl.recycleviewplus.bean.HomeData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recommendRy;
    private RecommendAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        recommendRy = findViewById(R.id.recommendRecycleView);
    }

    private void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mAdapter = new RecommendAdapter(this);
        recommendRy.setLayoutManager(manager);
        recommendRy.setAdapter(mAdapter);
        mAdapter.setDataList(getDataList());
    }

    private List getDataList() {
        List<HomeData> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            HomeData homeData = new HomeData();
            homeData.setUserName("user" + i);
            homeData.setContext("context" + i);
            if (i % 2 == 0) {
                homeData.setPicList(
                        Arrays.asList("https://ts3.cn.mm.bing.net/th?id=OIP-C.g9UbVfyVZX-SfD09JcYr5QHaEK&w=333&h=187&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2",
                                "https://tse1-mm.cn.bing.net/th/id/OIP-C.cGc4c8dVlqnfV3uwcS1IogHaE8?w=279&h=187&c=7&r=0&o=5&dpr=1.3&pid=1.7"));
            } else {
                homeData.setPicList(
                        Collections.singletonList("https://tse3-mm.cn.bing.net/th/id/OIP-C.fQ5PcZmxhv6XJw6jzK6KVgHaE8?w=198&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"));
            }
            dataList.add(homeData);
        }
        return dataList;
    }
}
