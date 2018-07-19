package com.dengpan.pan.jlatexmath.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;

/**
 * CREATE TABLE question (
 id          INTEGER PRIMARY KEY,
 subject     INTEGER,
 parent      INTEGER,
 seq         INTEGER,
 content     TEXT,
 create_time INTEGER,
 topic       TEXT    NOT NULL
 DEFAULT '0',
 sourceids   TEXT    NOT NULL
 DEFAULT '0',
 options     TEXT    NOT NULL
 DEFAULT '0'
 );

 */
@Table(database = AppDatabase.class)
public class Question extends BaseModel implements Serializable {
    @Column
    @PrimaryKey
    private int id;
    @Column
    private int subject;
    @Column
    private int parent;
    @Column
    private int seq;
    @Column
    private String content;
    @Column
    private int create_time;
    @Column
    private String topic;
    @Column
    private String sourceids;
    @Column
    private String options;

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSourceids() {
        return sourceids;
    }

    public void setSourceids(String sourceids) {
        this.sourceids = sourceids;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
