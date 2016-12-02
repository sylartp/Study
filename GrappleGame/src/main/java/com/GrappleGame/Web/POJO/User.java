package com.GrappleGame.Web.POJO;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }


}
