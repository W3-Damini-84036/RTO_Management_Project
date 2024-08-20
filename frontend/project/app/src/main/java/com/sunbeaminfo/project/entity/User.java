package com.sunbeaminfo.project.entity;

import java.io.Serializable;

public class User implements Serializable {
    private int user_id;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private String aadhar_number;
    private String date_of_birth;
    private int age;
    private String blood_group;
    private String gender;
    private String mobile_number;
    private String address;
    private String pincode;
    private String city;
    private String district;
    private String state;
    private String country;

    public User() {
    }

    public User(int user_id, String email, String password, String first_name, String last_name, String aadhar_number, String date_of_birth, int age, String blood_group, String gender, String mobile_number, String address, String pincode, String city, String district, String state, String country) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.aadhar_number = aadhar_number;
        this.date_of_birth = date_of_birth;
        this.age = age;
        this.blood_group = blood_group;
        this.gender = gender;
        this.mobile_number = mobile_number;
        this.address = address;
        this.pincode = pincode;
        this.city = city;
        this.district = district;
        this.state = state;
        this.country = country;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAadhar_number() {
        return aadhar_number;
    }

    public void setAadhar_number(String aadhar_number) {
        this.aadhar_number = aadhar_number;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
