package com.dengpan.pan.jlatexmath;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.dengpan.pan.jlatexmath.db.AppDatabase;

import org.scilab.forge.jlatexmath.core.AjLatexMath;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class ExampleActivity extends FragmentActivity implements
        OnPageChangeListener, OnClickListener {

    private ViewPager mPager;
    private PagesAdapter mAdapter;
    private String[] mExamples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		AjLatexMath.init(this);
        mExamples = ExampleFormula.getFormulaArray();
        mPager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new PagesAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);
        mPager.setOnPageChangeListener(this);
        setTitle(getString(R.string.app_name) + ": About");
        copyDatabase();


    }

    public boolean copyDatabase() {
        //数据库路径
            File dbFile = this.getDatabasePath(AppDatabase.NAME+".db");
        //true 未复制，false需要复制
        if (!dbFile.exists()) {
            Log.d("===","copying");
            InputStream is = null;
            FileOutputStream fos = null;
            try {
                dbFile.getParentFile().mkdirs();
                dbFile.createNewFile();

                is = getAssets().open("gmatquestion.sqlite");

                fos = new FileOutputStream(dbFile);

                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                    fos.flush();
                }
                Log.d("===","copying over");
            } catch (IOException e) {
                return false;
            } finally {
                try {
                    if (null != fos) {
                        fos.close();
                    }
                    if (null != is) {
                        is.close();
                    }

                } catch (IOException e) {
                    return false;
                }
            }
        }else {
            Log.d("==="," again copying");
//            deleteDatabase(AppDatabase.NAME);
//            copyDatabase();
        }
        return true;
    }

    private class PagesAdapter extends FragmentPagerAdapter {

        public PagesAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return ExampleFragment
                    .newInstance(mExamples[position], position);
        }

        @Override
        public int getCount() {
            return mExamples.length;
        }

    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0)
            setTitle(getString(R.string.app_name) + ": About");
        else
            setTitle(getString(R.string.app_name) + ": Example" + (position));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BitmapCacheUtil.getInstance().clearCache();
    }

    @Override
    public void onClick(View v) {
        mAdapter.notifyDataSetChanged();
    }

}
