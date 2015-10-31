package com.sinaapp.mymoneynote;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.sinaapp.mymoneynote.view.Fragment.LoginFragment;
import com.sinaapp.mymoneynote.view.Fragment.RegisterFragment;

public class MainActivity extends Activity implements View.OnClickListener {
    /**
     * 用于显示登陆界面的loginFragment
     */
    private LoginFragment loginFragment;

    /**
     * 用于显示注册界面的registerFragment
     */
    private RegisterFragment registerFragment;

    /**
     * 分别对应activity_main.xml的两个TAB标签页
     */
    private View loginLayout;
    private View regiterLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化布局
        initView();

    }

    private void initView(){
        /**
         * 两个TAB标签
         */
        loginLayout = findViewById(R.id.login_layout);
        regiterLayout = findViewById(R.id.register_layout);

        loginLayout.setOnClickListener(this);
        regiterLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_layout:
                setTabSelection(0);
                break;
            case R.id.register_layout:
                setTabSelection(1);
                break;
            default:
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     * @param index
     *  每个tab页对应的下标。0表示登陆，1表示注册，
     */
    private void setTabSelection(int index){
        //获得事务
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        //清除之前选中效果(10/29 : 还没实现选中效果)
        clearSelection();
        //隐蔽所有Fragment(10/29 : loginFragment和registerFragment)
        hideFragment(transaction);
        switch (index){
            case 0:
                /**
                 * 选中登陆TAB页，可以做相应的按钮图片文字实现(10/29 : 未完成)和对LoginFragment的添加
                 */
                if(loginFragment==null){
                    //loginFragment为空就新建一个该对象
                    loginFragment = new LoginFragment();
                    transaction.add(R.id.content,loginFragment);
                }else{
                    //如果不为空则直接显示,以下的registerFragment类似
                    transaction.show(loginFragment);
                }
                break;
            case 1:
                if(registerFragment==null){
                    registerFragment = new RegisterFragment();
                    transaction.add(R.id.content,registerFragment);
                }else {
                    transaction.show(registerFragment);
                }
                break;
            default:
                break;
        }
        //提交事务
        transaction.commit();
    }

    /**
     * 清除所有选中状态
     */
    private void clearSelection(){

    }

    /**
     * 隐藏所有TAB标签页
     */
    private void hideFragment(FragmentTransaction transaction){
        if(loginFragment!=null){
            transaction.hide(loginFragment);
        }
        if(registerFragment!=null){
            transaction.hide(registerFragment);
        }

    }
}
