package com.example.bottomnavview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parade.bottomNavView.BottomNavView;

public class MainActivity extends AppCompatActivity implements BottomNavView.OnItemSelectedListener, BottomNavView.OnItemReSelectedListener {

    private Button btnRead0,btnRead1,btnRead2,btnRead3;
    private BottomNavView bottomNavView;

    private String[] mListText = new String[]{"首页","消息","通讯录","我的"};
    private int[] mListNormalIcon = new int[]{R.mipmap.bottom_index_2,R.mipmap.boottom_notice_2,R.mipmap.bottom_list_2,R.mipmap.bottom_my_2};
    private int[] mListSelectedIcon = new int[]{R.mipmap.bottom_index, R.mipmap.boottom_notice, R.mipmap.bottom_list, R.mipmap.bottom_my};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRead0 = (Button) findViewById(R.id.btnRead0);
        btnRead1 = (Button) findViewById(R.id.btnRead1);
        btnRead2 = (Button) findViewById(R.id.btnRead2);
        btnRead3 = (Button) findViewById(R.id.btnRead3);
        bottomNavView = (BottomNavView) findViewById(R.id.bottomNavView);

        bottomNavView.setmListText(mListText)
                .setmListNormalIcons(mListNormalIcon)
                .setmListSelectedIcons(mListSelectedIcon)
                .setOnItemSelectedListener(this)//选中事件监听，代表的是当一个 item 由 未选中状态 变成 选中状态 时的回调
                .setOnItemReSelectedListener(this)//已选中状态下的事件监听，代表的是当一个 item 已经是选中状态 并且 又点击该 item 时的回调
                .build();

        btnRead0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomNavView.setUnreadNumber(0,1);
            }
        });
        btnRead1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomNavView.setUnreadNumber(1,34);
            }
        });
        btnRead2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomNavView.setUnreadNumber(2,102);
            }
        });

        btnRead3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomNavView.setUnreadNumber(3,99);
            }
        });
    }

    private int dp2px(float dpValue) {
        return (int) (0.5f + dpValue * Resources.getSystem().getDisplayMetrics().density);
    }

    private float px2dp(int pxValue) {
        return (pxValue / Resources.getSystem().getDisplayMetrics().density);
    }

    private  int px2sp(final float pxValue) {
        final float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    public  int sp2px(final float spValue) {
        final float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    @Override
    public void onItemSelected(View view, int position) {
        Toast.makeText(this,"选中了"+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemReSelected(View view, int position) {
        Toast.makeText(this,"重复选中了"+position,Toast.LENGTH_SHORT).show();
    }
}
