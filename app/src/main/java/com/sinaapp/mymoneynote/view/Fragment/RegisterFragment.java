package com.sinaapp.mymoneynote.view.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sinaapp.mymoneynote.R;

import java.util.HashMap;
import java.util.Map;

/**用于用户的注册
 * Created by Chen on 2015/10/29.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {
    private Button submitButton = null;
    private EditText et_username = null;
    private EditText et_password = null;
    private TextView tv_alertText = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)  {
        View view = inflater.inflate(R.layout.register_fragment,container,false);

        et_username = (EditText)view.findViewById(R.id.register_fragment_username);
        et_password = (EditText)view.findViewById(R.id.register_fragment_password);
        submitButton = (Button)view.findViewById(R.id.register_fragment_submitButton);
        //注册警告信息
        tv_alertText = (TextView)view.findViewById(R.id.register_fragment_alertText);

        submitButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Log.e("THIS MY BUTTON ID:",String.valueOf(v.getId()));
        Log.e("THIS MY R BUUTON ID:",String.valueOf(R.id.register_fragment_submitButton));
        switch (v.getId()){
            case R.id.register_fragment_submitButton:
                //注册按钮时

                //1.初始化队列
                RequestQueue queue = Volley.newRequestQueue(this.getActivity().getApplicationContext());
                String url = "http://192.168.1.100:8080/lj/index.php/Home/Form/register";
                tv_alertText.setText(url.toString());
                //2.从url请求相应
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //成功服务响应
                        tv_alertText.setText(response.toString());
                        Log.e("---THIS IS MY TAG","22222");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("---THIS IS MY","Failed"+error.toString());
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> map = new HashMap<String, String>();
                                map.put("username", et_username.getText().toString());
                                map.put("password", et_password.getText().toString());
                                return map;
                        };
                };
                queue.add(stringRequest);
                break;
        }
    }
}
