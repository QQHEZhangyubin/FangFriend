package com.example.fangfriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.fangfriend.activity.comment.CommentActivity;
import com.example.fangfriend.activity.comment.pulldshuoshuo.PulldshuoshuoActivity;
import com.example.fangfriend.api.APIWrapper;
import com.example.fangfriend.bean.ShuoShuo;
import com.example.fangfriend.utils.TLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar2)
    Toolbar toolbar2;
    private RecyclerView listView;
    /**
     * Item数据实体集合
     */
    //  private ArrayList<ItemEntity> itemEntities;
    private ArrayList<ShuoShuo> shuoShuoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        shuoShuoList = new ArrayList<>();
        shuoShuoList.clear();
        listView = (RecyclerView) findViewById(R.id.listview);
        initData2();
        setSupportActionBar(toolbar2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_menu1 :
                Intent intent = new Intent(MainActivity.this,PulldshuoshuoActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initData2() {
        APIWrapper.getInstance().RequestData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArrayList<ShuoShuo>>() {
                    @Override
                    public void onCompleted() {
                        RecyclerItemAdapter.OnPlayClickListener onPlayClickListener = new RecyclerItemAdapter.OnPlayClickListener() {
                            @Override
                            public void onItemClick(ShuoShuo shuo) {
                                Intent intent = new Intent(MainActivity.this, CommentActivity.class);
                                intent.putExtra("brower", shuo.getBrowser());//说说id
                                intent.putExtra("content", shuo.getContent());//说说内容
                                intent.putExtra("picture", shuo.getPicture());//用户头像
                                intent.putExtra("time", shuo.getTime());//说说发布时间
                                intent.putExtra("username", shuo.getUserName());//学号
                                intent.putStringArrayListExtra("Epicture", shuo.getEpicture());//九宫格图片
                                startActivity(intent);
                            }
                        };
                        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        listView.setLayoutManager(layoutManager);
                        //TLog.log(shuoShuoList.size()+"");
                        RecyclerItemAdapter adapter = new RecyclerItemAdapter(MainActivity.this, shuoShuoList);
                        adapter.setOnplayClickListener(onPlayClickListener);
                        listView.setAdapter(adapter);
                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.error(e.toString());
                    }

                    @Override
                    public void onNext(ArrayList<ShuoShuo> shuoShuos) {
                        for (ShuoShuo s : shuoShuos) {
                            TLog.log("1111111" + s.getBrowser() + "," + s.getUserName() + "," + s.getPicture() + "," + s.getEpicture().get(0) + "," + s.getContent());
                            shuoShuoList.add(s);
                        }
                    }
                });

    }


}
