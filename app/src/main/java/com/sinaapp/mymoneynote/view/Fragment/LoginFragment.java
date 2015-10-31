package com.sinaapp.mymoneynote.view.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sinaapp.mymoneynote.R;

import org.w3c.dom.Text;

/**主页面的登陆片段
 * Created by Chen on 2015/10/29.
 */
public class LoginFragment extends Fragment {
    private Button loginButton = null;
    private EditText et_username = null;
    private EditText et_password = null;
    private TextView tv_alertText = null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment,container,false);
        et_username =(EditText) view.findViewById(R.id.login_fragment_username);
        et_password = (EditText) view.findViewById(R.id.login_fragment_password);
        loginButton = (Button) view.findViewById(R.id.login_fragment_loginButton);
        //登陆警告信息
        tv_alertText = (TextView) view.findViewById(R.id.login_fragment_alertText);

        return view;
    }



}
