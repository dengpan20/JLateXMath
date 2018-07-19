package com.dengpan.pan.jlatexmath;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

import org.scilab.forge.jlatexmath.core.AjLatexMath;

import java.util.concurrent.Callable;

import bolts.Task;

/**
 * Created by xuzhenzhou on 15/10/28.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
        Task.callInBackground(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                AjLatexMath.init(getApplicationContext());
                return null;
            }
        });
    }
}
