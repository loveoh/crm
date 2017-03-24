package com.kaishengit.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 刘忠伟 on 2017/3/15.
 */
public class Customer implements Serializable {


    public static final String TYPE_CUSTOMER = "customer";     //客户
    public static final String TYPE_COMPANY = "company";       //公司

    private Integer id;
    private String name;//客户名称
    private String  tel;
    private String  weixin;
    private String  address;
    private String  email;
    private String  createtime;
    private Integer userid;         //null代表公开客户
    private Integer  companyid;
    private String companyname;//公司名称，是公司就没有客户名称
    private String level;
    private String type;

    //一对多， TODO sales销售机会
    //private List<Sales> salesList;

    //一对多，待办事项，一个客户对应的待办事项  外键customerid
    private List<Items> itemsList;









    //get set
    public List<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
