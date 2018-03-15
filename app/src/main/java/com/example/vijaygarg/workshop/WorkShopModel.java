package com.example.vijaygarg.workshop;

/**
 * Created by vijaygarg on 13/03/18.
 */

public class WorkShopModel {
    String companyname,profile,description,date,details;

    public WorkShopModel(String companyname, String profile, String description, String date, String details) {
        this.companyname = companyname;
        this.profile = profile;
        this.description = description;
        this.date = date;
        this.details = details;
    }

    public WorkShopModel() {
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
