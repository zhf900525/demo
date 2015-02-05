package com.example.androidtesttwo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.androidtesttwo.R;
import com.example.androidtesttwo.activity.gridview.DragGridViewActivity;
import com.example.androidtesttwo.activity.roundprogressbar.ProgressBarMainActivity;

public class MainActivity extends Activity implements OnClickListener {
    private Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void init() {
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
    }

    private void initListener() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent it = null;
        switch (v.getId()) {
        case R.id.button1:
            it = new Intent(MainActivity.this, DragGridViewActivity.class);
            break;
        case R.id.button2:
            it = new Intent(MainActivity.this, ProgressBarMainActivity.class);
            break;





        default:
            break;
        }
        startActivity(it);

    }

}
