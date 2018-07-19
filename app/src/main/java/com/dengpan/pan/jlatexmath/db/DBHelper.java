package com.dengpan.pan.jlatexmath.db;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class DBHelper {
    public static List<Question> getData(){
        return SQLite.select()
                .from(Question.class).where(Question_Table.subject.eq(5)).limit(50).queryList();
    }
}
