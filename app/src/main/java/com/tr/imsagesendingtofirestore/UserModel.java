package com.tr.imsagesendingtofirestore;

public class UserModel {
private String imageUriDBvalue;
private String nameDBvalue;
private String emailDBvalue;
private String passDBvalue;
private String contactDBvalue;

private String userID;
private String Nickname;

    public UserModel(String userID, String nickname) {
        this.userID = userID;
        Nickname = nickname;
    }

    public UserModel() {

    }




    public UserModel(String imageUriDBvalue, String nameDBvalue, String emailDBvalue, String passDBvalue, String contactDBvalue) {

        this.imageUriDBvalue = imageUriDBvalue;
        this.nameDBvalue = nameDBvalue;
        this.emailDBvalue = emailDBvalue;
        this.passDBvalue = passDBvalue;
        this.contactDBvalue = contactDBvalue;
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public String getImageUriDBvalue() {
        return imageUriDBvalue;
    }

    public void setImageUriDBvalue(String imageUriDBvalue) {
        this.imageUriDBvalue = imageUriDBvalue;
    }

    public String getNameDBvalue() {
        return nameDBvalue;
    }

    public void setNameDBvalue(String nameDBvalue) {
        this.nameDBvalue = nameDBvalue;
    }

    public String getEmailDBvalue() {
        return emailDBvalue;
    }

    public void setEmailDBvalue(String emailDBvalue) {
        this.emailDBvalue = emailDBvalue;
    }

    public String getPassDBvalue() {
        return passDBvalue;
    }

    public void setPassDBvalue(String passDBvalue) {
        this.passDBvalue = passDBvalue;
    }

    public String getContactDBvalue() {
        return contactDBvalue;
    }

    public void setContactDBvalue(String contactDBvalue) {
        this.contactDBvalue = contactDBvalue;
    }
}
