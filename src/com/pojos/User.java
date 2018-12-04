package com.pojos;

import java.io.Serializable;

public class User  implements Serializable {

    public User()
    {}
    private String userName;
    private  String passWord;
    private  String eMail;
    private  String phone;
    private  String postCard;

    public User(String userName, String passWord,String phone , String eMail, String postCard) {
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
        this.eMail = eMail;
        this.postCard = postCard;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostCard() {
        return postCard;
    }

    public void setPostCard(String postCard) {
        this.postCard = postCard;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", eMail='" + eMail + '\'' +
                ", phone='" + phone + '\'' +
                ", postCard='" + postCard + '\'' +
                '}';
    }
}
