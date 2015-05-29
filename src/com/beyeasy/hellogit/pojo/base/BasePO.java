package com.beyeasy.hellogit.pojo.base;

public class BasePO {

    private String firstname;

    private String secondname;

    private String address;

    private String mobile;

    private String qq;

    private String wx;

    public BasePO() {

    }

    public BasePO(BasePO po) {
        System.out.println("Class:" + this.getClass().getName());
        setFirstname(po.getFirstname());
        setSecondname(po.getSecondname());
        setAddress(po.getAddress());
        setMobile(po.getMobile());
        setQq(po.getQq());
        setWx(po.getWx());
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "-" + getFirstname() + "-" + getSecondname() + "-" + getAddress() + "-"
                + getMobile() + "-" + getQq() + "-" + getWx();
    }
}
