package cn.edu.gdpt.queryphone.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.gdpt.queryphone.R;

public class HomeActivity extends AppCompatActivity {

    private NavigationView nav;
    private DrawerLayout drawerlayout;
    ImageView menu;
    private TextView tv_userName;
    private ImageView img_query;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
    }

    private void initView() {
        nav = (NavigationView) findViewById(R.id.nav);
        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        menu=findViewById(R.id.home_menu);
        View headView=nav.getHeaderView(0);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerlayout.isDrawerOpen(nav)){
                    drawerlayout.closeDrawer(nav);
                }else {
                    drawerlayout.openDrawer(nav);
                }
            }
        });
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(HomeActivity.this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        tv_userName = headView.findViewById(R.id.tv_user);
        tv_userName.setText(user);
        img_query=(ImageView)findViewById(R.id.img_query);
        img_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,TelephoneEnquiryActivity.class);
                startActivity(intent);
            }
        });
        final LinearLayout chat,frinend,see,pay,help;
        ImageButton btn_popu=(ImageButton)findViewById(R.id.btn_popu);
        btn_popu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View myview= LayoutInflater.from(HomeActivity.this).inflate(R.layout.popowindow,null);
                final PopupWindow mypopwindow=new PopupWindow(myview, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
                mypopwindow.setTouchable(true);
                mypopwindow.setOutsideTouchable(true);
                mypopwindow.showAsDropDown(view);
                LinearLayout see=(LinearLayout)myview.findViewById(R.id.ll_see);
                LinearLayout pay=(LinearLayout)myview.findViewById(R.id.ll_pay);
                LinearLayout help=(LinearLayout)myview.findViewById(R.id.ll_help);
                LinearLayout chat=(LinearLayout)myview.findViewById(R.id.ll_chat);
                LinearLayout frinend=(LinearLayout)myview.findViewById(R.id.ll_friend);
                chat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(HomeActivity.this,"添加朋友",Toast.LENGTH_LONG).show();
                        mypopwindow.dismiss();

                    }
                });
                frinend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(HomeActivity.this,"听歌识曲",Toast.LENGTH_LONG).show();
                        mypopwindow.dismiss();

                    }
                });
                see.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(HomeActivity.this,"分享给朋友",Toast.LENGTH_LONG).show();
                        mypopwindow.dismiss();

                    }
                });
                pay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(HomeActivity.this,"设置",Toast.LENGTH_LONG).show();
                        mypopwindow.dismiss();

                    }
                });
                help.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(HomeActivity.this,"帮助与反馈",Toast.LENGTH_LONG).show();
                        mypopwindow.dismiss();

                    }
                });
            }
        });


    }
}
