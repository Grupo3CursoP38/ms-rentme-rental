package com.grupo3.msrentmerental.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Rental {
    @Id
    private String id;

    private Integer user_id;
    private Date date_start;
    private Date date_finish;
    private Boolean is_active;
    private Integer vehicle_id;

    public Rental(Integer user_id,
                  Date date_start,
                  Date date_finish,
                  Boolean is_active,
                  Integer vehicle_id
                  ){
        this.user_id = user_id;
        this.date_start = date_start;
        this.date_finish = date_finish;
        this.is_active = is_active;
        this.vehicle_id = vehicle_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_finish() {
        return date_finish;
    }

    public void setDate_finish(Date date_finish) {
        this.date_finish = date_finish;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Integer getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Integer vehicle_id) {
        this.vehicle_id = vehicle_id;
    }
}
