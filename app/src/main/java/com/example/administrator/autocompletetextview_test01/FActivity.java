package com.example.administrator.autocompletetextview_test01;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2015/12/8 0008.
 */
public class FActivity extends Activity{
   private Button bt1;
    private Button bt2;

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factivity);
        /*
        * 通过点击bt1实现页面之间的跳转
        * 1.startActivity的方式来实现
        * */

        mContext = this;
        bt1 = (Button)findViewById(R.id.button20);
        bt2 = (Button)findViewById(R.id.button21);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * 第一个参数：上下文对象this，或者直接用Factivity。this，或者声明对象mContext
                * 第二个参数：目标文件
                * */
                Intent intent = new Intent(mContext,Second_.class);
                startActivity(intent);
            }
        });

        /*
        * 通过startActivityForresult
        * */
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,Second_.class);

                /*
                * 第一个参数是Intent对象
                * 第二个参数是请求的一个表示*/
                startActivityForResult(intent,1);
            }
        });

    }
    /*
    *通过startActivityForresult跳转，接受返回数据的方法
    * requestCode：请求的标识
    * resultCode:第二个页面返回的标识
    * data：第二个页面回传的数据
     */

    protected void onActivityResult(){

    }

}
