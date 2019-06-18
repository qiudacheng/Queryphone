package cn.edu.gdpt.queryphone.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import cn.edu.gdpt.queryphone.R;

public class HomeActivity extends AppCompatActivity {

    private NavigationView nav;
    private DrawerLayout drawerlayout;
    ImageView menu;

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
    }
}
