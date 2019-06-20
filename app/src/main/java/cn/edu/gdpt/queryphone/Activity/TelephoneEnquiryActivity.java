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
import cn.edu.gdpt.queryphone.bean.phonebean;

public class TelephoneEnquiryActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText input_phone;
    private Button btn_phone_search;
    private TextView tv_phone_province;
    private TextView tv_phone_city;
    private TextView tv_phone_areacode;
    private TextView tv_phone_zip;
    private TextView tv_phone_company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephone_enquiry);
        initView();

    }

    private void initView() {
        input_phone = (EditText) findViewById(R.id.input_phone);
        btn_phone_search = (Button) findViewById(R.id.btn_phone_search);
        tv_phone_province = (TextView) findViewById(R.id.tv_phone_province);
        btn_phone_search.setOnClickListener(this);
        tv_phone_city = (TextView) findViewById(R.id.tv_phone_city);
        tv_phone_areacode = (TextView) findViewById(R.id.tv_phone_areacode);
        tv_phone_zip = (TextView) findViewById(R.id.tv_phone_zip);
        tv_phone_company = (TextView) findViewById(R.id.tv_phone_company);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_phone_search:
                if (input_phone.getText().toString().trim().length()==11){
                    String phoneNumber = "http://apis.juhe.cn/mobile/get?phone=" + input_phone.getText().toString().trim() + "&key=7411f5f5cccd99b6c4b08e444b9b11a6";
                    GetPhoneInfo(phoneNumber);
                }else {
                    Toast.makeText(TelephoneEnquiryActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    public void GetPhoneInfo(final String url) {
        OkhttpUntil.enqueueGetrequest(url, phonebean.class, new NetworkListining<phonebean>() {
            @Override
            public void BackResultSuccess(phonebean bean, int code) {
                try {
                    if (code == 200) {
                        tv_phone_province.setText(bean.getResult().getProvince());
                        tv_phone_city.setText(bean.getResult().getCity());
                        tv_phone_areacode.setText(bean.getResult().getAreacode());
                        tv_phone_zip.setText(bean.getResult().getZip());
                        tv_phone_company.setText(bean.getResult().getCompany());
                    }
                } catch (Exception e) {
                    Toast.makeText(TelephoneEnquiryActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void BackResultFail(Exception errow) {
                Toast.makeText(TelephoneEnquiryActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void tostring(String responseString) {

            }
        });
    }
}
