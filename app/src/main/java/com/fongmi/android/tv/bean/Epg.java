package com.fongmi.android.tv.bean;

import android.text.TextUtils;

import com.fongmi.android.tv.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

public class Epg {

    @SerializedName("date")
    private String date;
    @SerializedName("epg_data")
    private List<Epg> list;
    @SerializedName("title")
    private String title;
    @SerializedName("start")
    private String start;
    @SerializedName("end")
    private String end;

    private long startTime;
    private long endTime;

    public static Epg objectFrom(String str) {
        try {
            return new Gson().fromJson(str, Epg.class);
        } catch (Exception e) {
            return new Epg();
        }
    }

    public String getDate() {
        return TextUtils.isEmpty(date) ? "" : date;
    }

    public List<Epg> getList() {
        return list == null ? Collections.emptyList() : list;
    }

    public String getTitle() {
        return TextUtils.isEmpty(title) ? "" : title;
    }

    public String getStart() {
        return TextUtils.isEmpty(start) ? "" : start;
    }

    public String getEnd() {
        return TextUtils.isEmpty(end) ? "" : end;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public boolean equal(String date) {
        return getDate().equals(date);
    }

    public void initTime(SimpleDateFormat format) {
        for (Epg epg : getList()) {
            epg.setStartTime(Utils.format(format, getDate().concat(epg.getStart())));
            epg.setEndTime(Utils.format(format, getDate().concat(epg.getEnd())));
        }
    }
}
