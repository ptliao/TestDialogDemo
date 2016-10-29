package com.example.testupdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
    
    
    private AlertDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mDialog = new AlertDialog(this.getParent() == null ? this : this.getParent(), AlertDialog.THEME_HOLO_LIGHT) {

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                // 设置dialog为全屏显示
                WindowManager.LayoutParams lay = this.getWindow().getAttributes();
                DisplayMetrics dm = new DisplayMetrics();
                WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                wm.getDefaultDisplay().getMetrics(dm);
                lay.height = LayoutParams.WRAP_CONTENT;
                lay.width = LayoutParams.MATCH_PARENT;
            }
        };
        
        
        
        findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                showAgePickerDialog();
            }
        });
    }
    
    
    // 显示单位的上滑菜单
    private void showAgePickerDialog() {

        Window window = mDialog.getWindow();
        window.setGravity(Gravity.BOTTOM); // 显示的位置
        window.setWindowAnimations(R.style.unit_picker_style); // 添加动画

        mDialog.setCanceledOnTouchOutside(true);
        mDialog.setCancelable(true);
        mDialog.show();

        window.setContentView(R.layout.unit_picker);
        
    }

}
