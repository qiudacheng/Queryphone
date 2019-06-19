package cn.edu.gdpt.queryphone.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import cn.edu.gdpt.queryphone.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_register;
    private EditText edt_register_user;
    private EditText edt_register_psw;
    private EditText edt_register_psw_again;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        img_register = (ImageView) findViewById(R.id.img_register);
        edt_register_user = (EditText) findViewById(R.id.edt_register_user);
        edt_register_psw = (EditText) findViewById(R.id.edt_register_psw);
        edt_register_psw_again = (EditText) findViewById(R.id.edt_register_psw_again);
        btn_register = (Button) findViewById(R.id.btn_register);

        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:

                break;
        }
    }

    private void submit() {
        // validate
        String user = edt_register_user.getText().toString().trim();
        if (TextUtils.isEmpty(user)) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }

        String psw = edt_register_psw.getText().toString().trim();
        if (TextUtils.isEmpty(psw)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String again = edt_register_psw_again.getText().toString().trim();
        if (TextUtils.isEmpty(again)) {
            Toast.makeText(this, "请再次输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
