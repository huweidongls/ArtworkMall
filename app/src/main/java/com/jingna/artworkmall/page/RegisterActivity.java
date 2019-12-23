package com.jingna.artworkmall.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jingna.artworkmall.R;
import com.jingna.artworkmall.app.MyApplication;
import com.jingna.artworkmall.base.BaseActivity;
import com.jingna.artworkmall.bean.LoginBean;
import com.jingna.artworkmall.net.NetUrl;
import com.jingna.artworkmall.util.SpUtils;
import com.jingna.artworkmall.util.StatusBarUtil;
import com.jingna.artworkmall.util.ToastUtil;
import com.jingna.artworkmall.util.ViseUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

    private Context context = RegisterActivity.this;

    private String code ="";
    @BindView(R.id.tv_get_code)
    TextView tvGetCode;

    @BindView(R.id.et_phone)
    EditText et_phone;

    @BindView(R.id.et_code)
    EditText et_code;

    @BindView(R.id.et_yqm)
    EditText et_yqm;

    @BindView(R.id.et_pwd)
    EditText et_pwd;
    public TextView getCode_btn() {
        return tvGetCode;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        StatusBarUtil.setStatusBarColor(RegisterActivity.this, getResources().getColor(R.color.white_ffffff));
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        if (!StatusBarUtil.setStatusBarDarkTheme(RegisterActivity.this, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtil.setStatusBarColor(RegisterActivity.this,0x55000000);
        }
        ButterKnife.bind(RegisterActivity.this);
        MyApplication.registerTimeCount.setActivity(RegisterActivity.this);

    }

    @OnClick({R.id.rl_back, R.id.tv_get_code, R.id.login_btn})
    public void onClick(View view){
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_get_code:
                MyApplication.registerTimeCount.start();
                String phones = et_phone.getText().toString();
                if(phones.isEmpty()){
                    ToastUtil.showShort(context, "请输入电话号码!");
                }else{
                    Map<String, String> map = new LinkedHashMap<>();
                    map.put("phone",phones);
                    ViseUtil.Get(context, NetUrl.MemUsersendMessage, map, new ViseUtil.ViseListener() {
                        @Override
                        public void onReturn(String s) {
                            //Log.e("7787887",s);
                            try {
                                JSONObject jsonObject = new JSONObject(s);
                                if(jsonObject.optString("status").equals("200")){
                                    code = jsonObject.optString("data");
                                    ToastUtil.showShort(context,"验证码发送成功，请注意查收!");
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }

                break;
            case R.id.login_btn:
                String tel = et_phone.getText().toString();
                String code_msg = et_code.getText().toString();
                String yq = et_yqm.getText().toString();
                String pwd = et_pwd.getText().toString();
                if(tel.isEmpty() || code.isEmpty() || yq.isEmpty() || pwd.isEmpty()){
                    ToastUtil.showShort(context,"请填写完整信息!");
                }else{
                    Log.e("7878787878",code);
                    if(!code.equals(code_msg)){
                        ToastUtil.showShort(context,"短信验证码不正确!");
                    }else{
                        Map<String,String> map = new LinkedHashMap<>();
                        map.put("phone",tel);
                        map.put("invitationCode",yq);
                        map.put("password",pwd);
                        map.put("code",code_msg);
                        ViseUtil.Get(context, NetUrl.MemUseraddMember, map, new ViseUtil.ViseListener() {
                            @Override
                            public void onReturn(String s) {
                                Gson gson = new Gson();
                                LoginBean bean = gson.fromJson(s,LoginBean.class);
                                SpUtils.setToken(context, bean.getData().getToken());
                                SpUtils.setUserId(context, bean.getData().getUserId()+"");
                                Intent intent = new Intent();
                                intent.setClass(context, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                    }

                }
                break;
        }
    }

}
