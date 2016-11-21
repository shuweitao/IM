package com.swt.im.model;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by swt on 2016/11/21.
 */

public class Model {

    private Context mContext;
    private ExecutorService executors = Executors.newCachedThreadPool();

    //创建对象
    private static Model model = new Model();

    //私有构造
    private Model() {
    }

    //获取单利对象
    public static Model getInstance() {

        return model;
    }

    //初始化方法
    public void init(Context context) {
        mContext = context;
    }

    //获取全局线程池对象
    public ExecutorService getGlobalThreadPool() {
        return executors;
    }

}
