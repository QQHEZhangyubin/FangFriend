package com.example.fangfriend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView listView;
    /** Item数据实体集合 */
    private ArrayList<ItemEntity> itemEntities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (RecyclerView) findViewById(R.id.listview);
        initData();
        //listView.setAdapter(new ListItemAdapter(this, itemEntities));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listView.setLayoutManager(layoutManager);
        listView.setAdapter(new RecyclerItemAdapter(MainActivity.this,itemEntities));
    }

    private void initData() {
        itemEntities = new ArrayList<ItemEntity>();
        int i = 0;
        while (i < 100){
            //1.无图片
            ItemEntity itemEntity = new ItemEntity("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548949172125&di=4da2744e18f80ce048baa490dfb30763&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ffcfaaf51f3deb48f31ff5c3ffd1f3a292cf578b9.jpg", "张三", "今天天气不错...", null);
            itemEntities.add(itemEntity);
            //2.1张图片
            ArrayList<String> urls_1 = new ArrayList<String>();
            urls_1.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548949172125&di=4da2744e18f80ce048baa490dfb30763&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ffcfaaf51f3deb48f31ff5c3ffd1f3a292cf578b9.jpg");
            ItemEntity entity2 = new ItemEntity(//
                    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548949172125&di=4da2744e18f80ce048baa490dfb30763&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ffcfaaf51f3deb48f31ff5c3ffd1f3a292cf578b9.jpg", "李四", "今天雾霾呢...", urls_1);
            itemEntities.add(entity2);
            // 3.3张图片
            ArrayList<String> urls_2 = new ArrayList<String>();
            urls_2.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548949172127&di=8cd099687837be975fffb2bfc0fc5434&imgtype=0&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fd833c895d143ad4b0f4772228f025aafa50f06e2.jpg");
            urls_2.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548949172125&di=395bfa264aecd628a752221e568f624d&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fcdbf6c81800a19d8b7ea25f83efa828ba71e4665.jpg");
            urls_2.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548949172125&di=2aa404e745081bcb2a5187108f98065e&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F9f510fb30f2442a79cac5e59dc43ad4bd01302af.jpg");
            ItemEntity entity3 = new ItemEntity(//
                    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548949172125&di=4da2744e18f80ce048baa490dfb30763&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ffcfaaf51f3deb48f31ff5c3ffd1f3a292cf578b9.jpg", "王五", "今天好大的太阳...", urls_2);
            itemEntities.add(entity3);

            // 4.6张图片
            ArrayList<String> urls_3 = new ArrayList<String>();
            urls_3.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548949172125&di=4da2744e18f80ce048baa490dfb30763&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ffcfaaf51f3deb48f31ff5c3ffd1f3a292cf578b9.jpg");
            urls_3.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548949172125&di=4da2744e18f80ce048baa490dfb30763&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ffcfaaf51f3deb48f31ff5c3ffd1f3a292cf578b9.jpg");
            urls_3.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548949172125&di=4da2744e18f80ce048baa490dfb30763&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ffcfaaf51f3deb48f31ff5c3ffd1f3a292cf578b9.jpg");
            urls_3.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548949172125&di=4da2744e18f80ce048baa490dfb30763&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ffcfaaf51f3deb48f31ff5c3ffd1f3a292cf578b9.jpg");
            urls_3.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548949172125&di=4da2744e18f80ce048baa490dfb30763&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ffcfaaf51f3deb48f31ff5c3ffd1f3a292cf578b9.jpg");
            urls_3.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548949172125&di=4da2744e18f80ce048baa490dfb30763&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ffcfaaf51f3deb48f31ff5c3ffd1f3a292cf578b9.jpg");
            ItemEntity entity4 = new ItemEntity(//
                    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548949172125&di=4da2744e18f80ce048baa490dfb30763&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ffcfaaf51f3deb48f31ff5c3ffd1f3a292cf578b9.jpg", "赵六", "今天下雨了...", urls_3);
            itemEntities.add(entity4);
            i++;
        }




    }
}
