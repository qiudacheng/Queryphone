package cn.edu.gdpt.queryphone.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.gdpt.queryphone.R;
import cn.edu.gdpt.queryphone.Untils.NetworkListining;
import cn.edu.gdpt.queryphone.Untils.OkhttpUntil;
import cn.edu.gdpt.queryphone.bean.ipbean;

public class IPSearch extends AppCompatActivity implements View.OnClickListener {

    private EditText input_ip;
    private Button btn_id_search;
    private TextView tv_ip_Country;
    private TextView tv_ip_Province;
    private TextView tv_ip_City;
    private TextView tv_ip_Isp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipsearch);
        initView();
    }

    private void initView() {
        input_ip = (EditText) findViewById(R.id.input_ip);
        btn_id_search = (Button) findViewById(R.id.btn_id_search);
        tv_ip_Country = (TextView) findViewById(R.id.tv_ip_Country);
        tv_ip_Province = (TextView) findViewById(R.id.tv_ip_Province);
        tv_ip_City = (TextView) findViewById(R.id.tv_ip_City);
        tv_ip_Isp = (TextView) findViewById(R.id.tv_ip_Isp);

        btn_id_search.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_id_search:
                if (input_ip.getText().toString().trim()!=null) {
                    String ipNumber = "http://apis.juhe.cn/ip/ipNew?ip=" + input_ip.getText().toString().trim()+"&key=7523c52a864d7bf7387ad44b29441823" ;
                    GetIPInfo(ipNumber);
                }else {
                    Toast.makeText(IPSearch.this, "输入正确的的IP地址", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
    public void GetIPInfo(final String url) {
        OkhttpUntil.enqueueGetrequest(url, ipbean.class, new NetworkListining<ipbean>() {
            @Override
            public void BackResultSuccess(ipbean bean, int code) {
                try {
                    if (code == 200) {
                        tv_ip_Country.setText(bean.getResult().getCountry());
                        tv_ip_Province.setText(bean.getResult().getProvince());
                        tv_ip_City.setText(bean.getResult().getCity());
                        tv_ip_Isp.setText(bean.getResult().getIsp());

                    }
                } catch (Exception e) {
                    Toast.makeText(IPSearch.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void BackResultFail(Exception errow) {
                Toast.makeText(IPSearch.this, "请输入正确的IP地址", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void tostring(String responseString) {

            }
        });



    }


}
