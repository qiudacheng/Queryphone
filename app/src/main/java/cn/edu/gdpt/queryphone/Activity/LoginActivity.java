package cn.edu.gdpt.queryphone.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.gdpt.queryphone.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_login;
    private EditText edt_login_user;
    private EditText edt_login_psw;
    private Button btn_login;
    private TextView tv_login_register;
    private TextView tv_find_psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        img_login = (ImageView) findViewById(R.id.img_login);
        edt_login_user = (EditText) findViewById(R.id.edt_login_user);
        edt_login_psw = (EditText) findViewById(R.id.edt_login_psw);
        btn_login = (Button) findViewById(R.id.btn_login);
        tv_login_register = (TextView) findViewById(R.id.tv_login_register);
        tv_find_psw = (TextView) findViewById(R.id.tv_find_psw);

        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:

                break;
        }
    }

    private void submit() {
        // validate
        String user = edt_login_user.getText().toString().trim();
        if (TextUtils.isEmpty(user)) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }

        String psw = edt_login_psw.getText().toString().trim();
        if (TextUtils.isEmpty(psw)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
