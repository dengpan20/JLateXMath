package com.dengpan.pan.jlatexmath;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.daquexian.flexiblerichtextview.FlexibleRichTextView;
import com.dengpan.pan.jlatexmath.db.DBHelper;
import com.dengpan.pan.jlatexmath.db.Question;
import com.dengpan.pan.jlatexmath.utils.HtmlUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mian_lit);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setAdapter(new MyAdapter(DBHelper.getData()));
    }

    public class MyAdapter extends BaseQuickAdapter<Question,BaseViewHolder>{

        public MyAdapter(@Nullable List<Question> data) {
            super(R.layout.item_math, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, Question item) {
//            LaTexTextView view = helper.getView(R.id.latex);
//            view.setLinketext(item.getTopic());
//            helper.setText(R.id.tv_html, HtmlUtil.fromHtml(item.getTopic()));
            helper.setText(R.id.tv_origin,"原文本："+item.getTopic());
            FlexibleRichTextView view = helper.getView(R.id.fr_tv);
            view.setText("转化后："+item.getTopic().replace("[br/]","\n"));
        }
    }
}
