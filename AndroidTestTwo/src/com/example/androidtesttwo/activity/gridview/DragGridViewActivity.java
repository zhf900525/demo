package com.example.androidtesttwo.activity.gridview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;

import com.example.androidtesttwo.R;
import com.example.androidtesttwo.adpater.DragAdapter;
import com.example.androidtesttwo.view.DragGridView;
import com.example.androidtesttwo.view.DragGridView.OnChanageListener;

/**
 * @blog http://blog.csdn.net/xiaanming
 * 
 * @author xiaanming
 * 
 */
public class DragGridViewActivity extends Activity {
    private List<HashMap<String, Object>> dataSourceList = new ArrayList<HashMap<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draggridviewmain);

        DragGridView mDragGridView = (DragGridView) findViewById(R.id.dragGridView);
        for (int i = 0; i < 30; i++) {
            HashMap<String, Object> itemHashMap = new HashMap<String, Object>();
            itemHashMap.put("item_image", R.drawable.com_tencent_open_notice_msg_icon_big);
            itemHashMap.put("item_text", "��ק " + Integer.toString(i));
            dataSourceList.add(itemHashMap);
        }

        final DragAdapter mDragAdapter = new DragAdapter(this, dataSourceList);

        mDragGridView.setAdapter(mDragAdapter);

        mDragGridView.setOnChangeListener(new OnChanageListener() {

            @Override
            public void onChange(int from, int to) {
                HashMap<String, Object> temp = dataSourceList.get(from);

                // ����Ĵ�����Ҫע����
                if (from < to) {
                    for (int i = from; i < to; i++) {
                        Collections.swap(dataSourceList, i, i + 1);
                    }
                } else if (from > to) {
                    for (int i = from; i > to; i--) {
                        Collections.swap(dataSourceList, i, i - 1);
                    }
                }

                dataSourceList.set(to, temp);

                // �����µ���item���أ����õ���notifyDataSetChanged��ˢ�½��棬��ΪsetItemHide�������������
                mDragAdapter.setItemHide(to);

            }
        });

    }

}
