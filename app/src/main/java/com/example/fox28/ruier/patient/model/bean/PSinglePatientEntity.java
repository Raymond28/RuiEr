package com.example.fox28.ruier.patient.model.bean;

/**
 * @Description:
 * @Author: Scorpion
 * @Date: 2018/10/1 01:22
 * @Tags:
 */
public class PSinglePatientEntity {

    private String name;
    private String url;
    private String startTime;
    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "PSinglePatientEntity{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", startTime='" + startTime + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
