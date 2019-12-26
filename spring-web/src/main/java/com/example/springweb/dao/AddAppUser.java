package com.example.springweb.dao;

import java.io.Serializable;

public class AddAppUser implements Serializable {
    private int event_id;
    private String user_id;
    private String app_name;
    private String range_classify;
    private String range_Info;
    private String operation_classify;
    private String operation_Info;
    private String type_classify;
    private String type_Info;
    private String safe_level;
    private String index1_level;
    private String index1_Info;
    private String index2_level;
    private String index2_Info;
    private String index3_level;
    private String index3_Info;

    public AddAppUser() {
        event_id = 0;
        user_id = null;
        app_name = null;
        range_classify = null;
        range_Info=null;
        operation_classify = null;
        operation_Info=null;
        type_classify = null;
        type_Info=null;
        safe_level = null;
        index1_level = null;
        index1_Info = null;
        index2_level = null;
        index2_Info = null;
        index3_level = null;
        index3_Info = null;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String id) {
        this.user_id = id;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getRange_classify() {
        return range_classify;
    }

    public void setRange_classify(String range_classify) {
        this.range_classify = range_classify;
    }

    public String getOperation_classify() {
        return operation_classify;
    }

    public void setOperation_classify(String operation_classify) {
        this.operation_classify = operation_classify;
    }

    public String getOperation_Info() {
        return operation_Info;
    }

    public void setOperation_Info(String operation_Info) {
        this.operation_Info = operation_Info;
    }

    public String getRange_Info() {
        return range_Info;
    }

    public void setRange_Info(String range_Info) {
        this.range_Info = range_Info;
    }

    public String getType_classify() {
        return type_classify;
    }

    public void setType_classify(String type_classify) {
        this.type_classify = type_classify;
    }

    public String getType_Info() {
        return type_Info;
    }

    public void setType_Info(String type_Info) {
        this.type_Info = type_Info;
    }

    public String getSafe_level() {
        return safe_level;
    }

    public void setSafe_level(String safe_level) {
        this.safe_level = safe_level;
    }

    public String getIndex1_level() {
        return index1_level;
    }

    public void setIndex1_level(String index1_level) {
        this.index1_level = index1_level;
    }

    public String getIndex1_Info() {
        return index1_Info;
    }

    public void setIndex1_Info(String index1_Info) {
        this.index1_Info = index1_Info;
    }

    public String getIndex2_level() {
        return index2_level;
    }

    public void setIndex2_level(String index2_level) {
        this.index2_level = index2_level;
    }

    public String getIndex2_Info() {
        return index2_Info;
    }

    public void setIndex2_Info(String index2_Info) {
        this.index2_Info = index2_Info;
    }

    public String getIndex3_level() {
        return index3_level;
    }

    public void setIndex3_level(String index3_level) {
        this.index3_level = index3_level;
    }

    public String getIndex3_Info() {
        return index3_Info;
    }

    public void setIndex3_Info(String index3_Info) {
        this.index3_Info = index3_Info;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
