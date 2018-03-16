package com.example.vijaygarg.workshop;

/**
 * Created by vijaygarg on 13/03/18.
 */

public class WorkShopModel {
    String companyname,profile,description,date,details;
    String answer1,answer2;

    public WorkShopModel(String companyname, String profile, String description, String date, String details, String answer1, String answer2) {
        this.companyname = companyname;
        this.profile = profile;
        this.description = description;
        this.date = date;
        this.details = details;
        this.answer1 = answer1;
        this.answer2 = answer2;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

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
