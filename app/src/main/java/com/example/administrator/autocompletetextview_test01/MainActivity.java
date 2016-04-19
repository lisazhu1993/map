package com.example.administrator.autocompletetextview_test01;

import android.content.Intent;
import android.location.GpsStatus;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView acTextView;
    private String[] res = {"beijing1","beijing2","beijing3",
                           "shanghai1","shanghai2","shanghai3"};


    private ToggleButton tb;
    private ImageView img;
    private MultiAutoCompleteTextView macTextView;
    private CheckBox checkBox;
    private RadioGroup rg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //引入布局文件
        setContentView(R.layout.activity_main);

        Button btn =(Button)findViewById(R.id.button19);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Second_.class);
                MainActivity.this.startActivity(intent);
            }
        });



        //radioGroup
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        /*
        *实现RadiGroup的监听事件
         */

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton:
                        Log.i("tag","you are a boy");
                        break;
                    case R.id.radioButton2:
                        Log.i("tag","you are a girl");
                        break;

                    default:
                }
            }
        });






        //------checkbox
        //初始化checkbox
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        //通过设置checkbox的监听事件来对checkbox是不是被选中
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //通过onCheckedChanged来监听当前的checkBox是否被选中
                 Log.i("tag",isChecked+"");
                if(isChecked){
                    //获得checkBox的文本内容
                    String text = checkBox.getText().toString();
                    Log.i("tag",text);
                }
            }

        });





        /*
        * toggleebutton操作  控件操作初始化
        *
        * */

        tb = (ToggleButton)findViewById(R.id.toggleButton);
        img = (ImageView)findViewById(R.id.imageView);

        /*
        * 给当前的tb设置监听器
        * */

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
                /*
                * 当tb被点击的时候，当前的方法会执行
                *
                * buttonView---代表被点击控件的本事
                * isChecked---代表被点击的控件的状态
                *
                * 当点击这个tb的时候更换img的背景
                * */

                img.setBackgroundResource(isChecked?R.drawable.on:R.drawable.off);

            }

        });




        /**
         * 第一步：初始化控件
         *第二步：需要一个适配器
         *第三步：初始化数据源----这数据源去匹配文本框输入的内容
         *第四步：将adapter与当前autoconpleteTextView绑定
         */
        acTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,res);
        acTextView.setAdapter(adapter);


        /**
         * 第一步：初始化控件
         *第二步：需要一个适配器
         *第三步：初始化数据源----这数据源去匹配文本框输入的内容
         *第四步：将adapter与当前autoconpleteTextView绑定
         * 第五步：设置分隔符
         */

        macTextView = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);
        macTextView.setAdapter(adapter);
        //设置以逗号为分隔符为结束的符号
        macTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }


}
