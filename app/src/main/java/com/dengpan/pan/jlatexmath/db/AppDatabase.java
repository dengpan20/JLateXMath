package com.dengpan.pan.jlatexmath.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * 数据库基本信息
 */
@Database(name = AppDatabase.NAME,version = AppDatabase.VERSION)
public class AppDatabase {
    public static final String NAME = "gmatquestion";
    public static final int VERSION = 1;
}
