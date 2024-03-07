package com.example.phoneinfo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Informations)实体类
 *
 * @author makejava
 * @since 2023-06-23 13:48:23
 */
public class Informations implements Serializable {
    private static final long serialVersionUID = -12536155142382428L;

    private Integer id;

    private String title;

    private String content;

    private Integer replycount;

    private Integer viewcount;

    private Date reporttime;

    private Date lastposttime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReplycount() {
        return replycount;
    }

    public void setReplycount(Integer replycount) {
        this.replycount = replycount;
    }

    public Integer getViewcount() {
        return viewcount;
    }

    public void setViewcount(Integer viewcount) {
        this.viewcount = viewcount;
    }

    public Date getReporttime() {
        return reporttime;
    }

    public void setReporttime(Date reporttime) {
        this.reporttime = reporttime;
    }

    public Date getLastposttime() {
        return lastposttime;
    }

    public void setLastposttime(Date lastposttime) {
        this.lastposttime = lastposttime;
    }

}

