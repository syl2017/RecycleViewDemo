package com.example.syl.recycleviewdemo;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Partner[] partners = {new Partner("小林aaaaaaaaaaaaaaaaaaasadsadsadsadasdsaddsaddsadasdsasdsadasdadsdasda", R.mipmap.ic1, R.mipmap.ic1),
            new Partner("小林bbbbbbbbbbbbbbbbbbb", R.mipmap.ic2, R.mipmap.ic_launcher), new Partner("康娜ccccccccccccc", R.mipmap.ic3, R.mipmap.ic_launcher)
            , new Partner("机器人ssssss", R.mipmap.ic4, R.mipmap.ic_launcher), new Partner("机器人aaaaaaaaaaaaaaaaaccccccccaaxxxxxxx", R.mipmap.ic5, R.mipmap.ic_launcher),
            new Partner("小林vfffffffffffsda", R.mipmap.ic1, R.mipmap.ic1),
            new Partner("小林csacascaaaaaaaaaa", R.mipmap.ic2, R.mipmap.ic_launcher), new Partner("康娜cassssssssssssssssssssssssssss", R.mipmap.ic3, R.mipmap.ic_launcher)
            , new Partner("小林", R.mipmap.ic4, R.mipmap.ic_launcher), new Partner("机器人", R.mipmap.ic5, R.mipmap.ic_launcher)};
    private List<Partner> partnerList = new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recycleview;
    public FruitAdapter adpater = new FruitAdapter();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview);
        recycleview = (RecyclerView) findViewById(R.id.recycle_view);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                refreshPartner();
                            }
                        });
                    }
                }).start();
            }
        });

        initPartner();
//        RecyclerView.LayoutManager manager = new GridLayoutManager(this,2);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recycleview.setLayoutManager(layoutManager);
//        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);

        adpater.ChangeData(partnerList);
        recycleview.setAdapter(adpater);

    }

    private void refreshPartner() {
        initPartner2();
        adpater.ChangeData(partnerList);
//        recycleview.setAdapter(adapter);
        adpater.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    private void initPartner2() {
        partnerList.clear();
        for (int i = partners.length-1; i >=0 ; i--) {
            partnerList.add(partners[i]);
        }
    }

    private void initPartner() {
        partnerList.clear();
        for (int i = 0; i <partners.length ; i++) {
            partnerList.add(partners[i]);
        }

    }
}
