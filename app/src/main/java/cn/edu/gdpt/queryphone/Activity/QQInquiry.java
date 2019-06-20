package cn.edu.gdpt.queryphone.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.gdpt.queryphone.R;
import cn.edu.gdpt.queryphone.Untils.NetworkListining;
import cn.edu.gdpt.queryphone.Untils.OkhttpUntil;
import cn.edu.gdpt.queryphone.bean.phonebean;
import cn.edu.gdpt.queryphone.bean.qqbean;

public class QQInquiry extends AppCompatActivity implements View.OnClickListener {

    private EditText input_qq;
    private Button btn_qq_search;
    private TextView tv_qq_conclusion;
    private TextView tv_qq_analysis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqinquiry);
        initView();
    }

    private void initView() {
        input_qq = (EditText) findViewById(R.id.input_qq);
        btn_qq_search = (Button) findViewById(R.id.btn_qq_search);

        tv_qq_conclusion = (TextView) findViewById(R.id.tv_qq_conclusion);
        tv_qq_analysis = (TextView) findViewById(R.id.tv_qq_analysis);

        btn_qq_search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_qq_search:
                if (input_qq.getText().toString().trim()!=null) {
                    String qqNumber = "http://japi.juhe.cn/qqevaluate/qq?key=8cbdfee61f6619d724973f4a46dd94e2&qq=" + input_qq.getText().toString().trim() ;
                    Log.e("sss",qqNumber);
                    GetQQInfo(qqNumber);
                }else {
                    Toast.makeText(QQInquiry.this, "输入的QQ号不能为空", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    public void GetQQInfo(final String url) {
        OkhttpUntil.enqueueGetrequest(url, qqbean.class, new NetworkListining<qqbean>() {
            @Override
            public void BackResultSuccess(qqbean bean, int code) {
                try {
                    if (code == 200) {
                        tv_qq_conclusion.setText(bean.getResult().getData().getConclusion());
                        tv_qq_analysis.setText(bean.getResult().getData().getAnalysis());
                    }
                } catch (Exception e) {
                    Toast.makeText(QQInquiry.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void BackResultFail(Exception errow) {
                Toast.makeText(QQInquiry.this, "请输入正确的QQ号", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void tostring(String responseString) {

            }
        });



    }
}
