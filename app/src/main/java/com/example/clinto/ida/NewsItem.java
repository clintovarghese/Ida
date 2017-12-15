package com.example.clinto.ida;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Clinto on 26-Sep-17.
 */

public class NewsItem {
    @SerializedName("id_users")
    @Expose
    private String idUsers;
    @SerializedName("member_id")
    @Expose
    private String memberId;
    @SerializedName("designation_id")
    @Expose
    private Object designationId;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("fullname")
    @Expose
    private String fullname;
    @SerializedName("profiledp")
    @Expose
    private Object profiledp;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("phoneno")
    @Expose
    private String phoneno;
    @SerializedName("phonehome")
    @Expose
    private String phonehome;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("otherdetails")
    @Expose
    private String otherdetails;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("clinicaddress")
    @Expose
    private String clinicaddress;
    @SerializedName("clinicphoneno")
    @Expose
    private String clinicphoneno;
    @SerializedName("clinicwebsite")
    @Expose
    private String clinicwebsite;
    @SerializedName("deleted")
    @Expose
    private String deleted;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("id_designations")
    @Expose
    private Object idDesignations;
    @SerializedName("title")
    @Expose
    private Object title;
    @SerializedName("priority")
    @Expose
    private Object priority;

    public String getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(String idUsers) {
        this.idUsers = idUsers;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Object getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Object designationId) {
        this.designationId = designationId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Object getProfiledp() {
        return profiledp;
    }

    public void setProfiledp(Object profiledp) {
        this.profiledp = profiledp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPhonehome() {
        return phonehome;
    }

    public void setPhonehome(String phonehome) {
        this.phonehome = phonehome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtherdetails() {
        return otherdetails;
    }

    public void setOtherdetails(String otherdetails) {
        this.otherdetails = otherdetails;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getClinicaddress() {
        return clinicaddress;
    }

    public void setClinicaddress(String clinicaddress) {
        this.clinicaddress = clinicaddress;
    }

    public String getClinicphoneno() {
        return clinicphoneno;
    }

    public void setClinicphoneno(String clinicphoneno) {
        this.clinicphoneno = clinicphoneno;
    }

    public String getClinicwebsite() {
        return clinicwebsite;
    }

    public void setClinicwebsite(String clinicwebsite) {
        this.clinicwebsite = clinicwebsite;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getIdDesignations() {
        return idDesignations;
    }

    public void setIdDesignations(Object idDesignations) {
        this.idDesignations = idDesignations;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public Object getPriority() {
        return priority;
    }

    public void setPriority(Object priority) {
        this.priority = priority;
    }
}
