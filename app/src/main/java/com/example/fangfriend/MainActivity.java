package com.example.fangfriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fangfriend.activity.comment.CommentActivity;
import com.example.fangfriend.api.APIWrapper;
import com.example.fangfriend.bean.ShuoShuo;
import com.example.fangfriend.utils.TLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements RecyclerItemAdapter.K{
    private RecyclerView listView;
    /** Item数据实体集合 */
  //  private ArrayList<ItemEntity> itemEntities;
    private ArrayList<ShuoShuo> shuoShuoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shuoShuoList = new ArrayList<>();
        shuoShuoList.clear();
        listView = (RecyclerView) findViewById(R.id.listview);
        initData2();
        //listView.setAdapter(new ListItemAdapter(this, itemEntities));
    }
/*
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
*/
    private void initData2(){
        APIWrapper.getInstance().RequestData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArrayList<ShuoShuo>>() {
                    @Override
                    public void onCompleted() {
                        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        listView.setLayoutManager(layoutManager);
                        //TLog.log(shuoShuoList.size()+"");
                        listView.setAdapter(new RecyclerItemAdapter(MainActivity.this,shuoShuoList));
                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.error(e.toString());
                    }

                    @Override
                    public void onNext(ArrayList<ShuoShuo> shuoShuos) {
                        for (ShuoShuo s : shuoShuos){
                            TLog.log("1111111"+s.getBrowser()+","+s.getUserName()+","+s.getPicture()+","+s.getEpicture().get(0)+","+s.getContent());
                            shuoShuoList.add(s);
                        }
                    }
                });

    }

    @Override
    public void m(ShuoShuo shuo) {
        Intent intent = new Intent(MainActivity.this,CommentActivity.class);
        intent.putExtra("brower",shuo.getBrowser());//说说id
        intent.putExtra("content",shuo.getContent());//说说内容
        intent.putExtra("picture",shuo.getPicture());//用户头像
        intent.putExtra("time",shuo.getTime());//说说发布时间
        intent.putExtra("username",shuo.getUserName());//学号
        intent.putStringArrayListExtra("Epicture",shuo.getEpicture());//九宫格图片
        startActivity(intent);
    }
}
