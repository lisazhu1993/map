package com.example.administrator.autocompletetextview_test01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2015/12/7 0007.
 */
public class Second_ extends Activity{

    private Button bt;
    private String content = "你好";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        /*
        * 第二个页面什么时候给第一个页面回传数据
        * 回传到第一个页面的实际上是一个Intent对象
        * */
        bt = (Button)findViewById(R.id.button7);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("data",content);
                setResult(2,data);
                //结束当前页面
                finish();

            }
        });

    }
}
