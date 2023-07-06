package com.phonecompany.billing;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class PhoneData {
    private String phoneNumber;
    private Date date1;
    private Date date2;
    private Long minutes;
    private Integer hourFrom;
    private Integer minutesFrom;
    private Boolean free;

    public PhoneData(String phoneNumber, Date date1, Date date2) {
        this.phoneNumber = phoneNumber;
        this.date1 = date1;
        this.date2 = date2;
        this.free=false;
    }

    public Integer getMinutesFrom() {
        return minutesFrom;
    }

    public void setMinutesFrom(Integer minutesFrom) {
        this.minutesFrom = minutesFrom;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public Integer getHourFrom() {
        return hourFrom;
    }
    public void setHourFrom(Integer hourFrom) {
        this.hourFrom = hourFrom;
    }

    public Long getMinutes() {
        return minutes;
    }

    public void setMinutes(Long minutes) {
        this.minutes = minutes;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getDate1() {
        return date1;
    }

    public Date getDate2() {
        return date2;
    }
}
