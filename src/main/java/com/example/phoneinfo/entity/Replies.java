package com.example.phoneinfo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Replies)实体类
 *
 * @author makejava
 * @since 2023-06-23 13:48:50
 */
public class Replies implements Serializable {
    private static final long serialVersionUID = -74838003215536799L;

    private Integer id;

    private String content;

    private Date replytime;

    private Integer infoid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }

    public Integer getInfoid() {
        return infoid;
    }

    public void setInfoid(Integer infoid) {
        this.infoid = infoid;
    }

}

