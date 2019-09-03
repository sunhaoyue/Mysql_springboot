package com.wantwant.pojo;

import java.util.Date;

public class ShyUser {
    private Long userId;

    private Long userToId;

    private String userLoginName;

    private String userPassword;

    private String userName;

    private String useObject;

    private Integer useStatus;

    private Date userCreateTime;

    private String userMobile;

    private Integer userHandleStatus;

    private Date userLoginTime;

    private Date userLastLoginTime;

    private Long userCount;

    private String userE;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserToId() {
        return userToId;
    }

    public void setUserToId(Long userToId) {
        this.userToId = userToId;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName == null ? null : userLoginName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUseObject() {
        return useObject;
    }

    public void setUseObject(String useObject) {
        this.useObject = useObject == null ? null : useObject.trim();
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public Integer getUserHandleStatus() {
        return userHandleStatus;
    }

    public void setUserHandleStatus(Integer userHandleStatus) {
        this.userHandleStatus = userHandleStatus;
    }

    public Date getUserLoginTime() {
        return userLoginTime;
    }

    public void setUserLoginTime(Date userLoginTime) {
        this.userLoginTime = userLoginTime;
    }

    public Date getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserLastLoginTime(Date userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    public Long getUserCount() {
        return userCount;
    }

    public void setUserCount(Long userCount) {
        this.userCount = userCount;
    }

    public String getUserE() {
        return userE;
    }

    public void setUserE(String userE) {
        this.userE = userE == null ? null : userE.trim();
    }
}