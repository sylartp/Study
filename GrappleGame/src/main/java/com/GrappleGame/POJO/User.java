package com.GrappleGame.POJO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by tppppp on 2016/12/1.
 */
public class User {
    @NotNull
    @Size(max = 15, min = 5)
    private String userName;
    @NotNull
    @Size(min = 5, max = 25)
    private String passWord;

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
}
