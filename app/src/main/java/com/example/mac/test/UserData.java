package com.example.mac.test;

/**
 * Created by mac on 22/02/2016.
 */
public class UserData {
    private static UserData instance;
    //User Data fields
    private int userID;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String houseNo;
    private String street;
    private String city;
    private String county;
    private String postcode;
    private String binLocation;

    public static UserData getInstance(){
        if(instance == null){
            instance = new UserData();
        }
        return instance;
    }
    private UserData(){
        emailAddress = "";
        firstName = "";
        lastName = "";
        phoneNo = "";
        houseNo = "";
        street = "";
        city = "";
        county = "";
        postcode = "";
        binLocation = "";
    }

    //Setters
    public void setID(int fid){
        userID = fid;
    }
    public void setEmail(String email){
        emailAddress = email;
    }
    public void setFirstName(String firstname){
        firstName =firstname;
    }
    public void setLastName(String lastname){
        lastName =lastname;
    }public void setPhoneNo(String phoneno){
        phoneNo =phoneno;
    }public void setHouseNo(String houseno){
        houseNo =houseno;
    }public void setStreet(String fstreet){
        street =fstreet;
    }public void setCity(String fcity){
        city =fcity;
    }
    public void setCounty(String fcounty){
        county =fcounty;
    }
    public void setPostcode(String fpostcode){
        postcode =fpostcode;
    }
    public void setBinLocation(String fbinlocation ){
        binLocation =fbinlocation;
    }

}
