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
import cn.edu.gdpt.queryphone.bean.idbean;

public class IDCard extends AppCompatActivity implements View.OnClickListener {

    private EditText input_id;
    private Button btn_id_search;
    private TextView tv_id_area;
    private TextView tv_id_sex;
    private TextView tv_id_birthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idcard);
        initView();
    }

    private void initView() {
        input_id = (EditText) findViewById(R.id.input_id);
        btn_id_search = (Button) findViewById(R.id.btn_id_search);
        tv_id_area = (TextView) findViewById(R.id.tv_id_area);
        tv_id_sex = (TextView) findViewById(R.id.tv_id_sex);
        tv_id_birthday = (TextView) findViewById(R.id.tv_id_birthday);

        btn_id_search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_id_search:
                if (input_id.getText().toString().trim().length()==18) {
                    String idNumber = "http://apis.juhe.cn/idcard/index?key=7f1d4e7293aa8f4efd71fc2400d11926&cardno=" + input_id.getText().toString().trim() ;
                    GetIDInfo(idNumber);
                }else {
                    Toast.makeText(IDCard.this, "输入的身份证号有误", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
    public void GetIDInfo(final String url) {
        OkhttpUntil.enqueueGetrequest(url, idbean.class, new NetworkListining<idbean>() {
            @Override
            public void BackResultSuccess(idbean bean, int code) {
                try {
                    if (code == 200) {
                        tv_id_area.setText(bean.getResult().getArea());
                        tv_id_sex.setText(bean.getResult().getSex());
                        tv_id_birthday.setText(bean.getResult().getBirthday());
                    }
                } catch (Exception e) {
                    Toast.makeText(IDCard.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void BackResultFail(Exception errow) {
                Toast.makeText(IDCard.this, "请输入正确的身份证号", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void tostring(String responseString) {

            }
        });



    }

}
