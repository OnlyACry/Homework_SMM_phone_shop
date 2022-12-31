package org.xja.phonedemo.domain;


import java.io.Serializable;
import java.util.List;

/**
 * 功能实体类
 */
public class Funs implements Serializable {
    //    fun_id	int
    private Integer funId;
    //    fun_name	varchar
    private String funName;
    //    fun_url	varchar
    private String funUrl;
    //    fun_pid	int
    private Integer funPid;
    //    fun_target	varchar
    private String funTarget;
    //    fun_sort	int
    private Integer funSort;
    //一级菜单的二级菜单列表
    private List<Funs> twoFunList;

    public Integer getFunId() {
        return funId;
    }

    public void setFunId(Integer funId) {
        this.funId = funId;
    }

    public String getFunName() {
        return funName;
    }

    public void setFunName(String funName) {
        this.funName = funName;
    }

    public String getFunUrl() {
        return funUrl;
    }

    public void setFunUrl(String funUrl) {
        this.funUrl = funUrl;
    }

    public String getFunTarget() {
        return funTarget;
    }

    public void setFunTarget(String funTarget) {
        this.funTarget = funTarget;
    }

    public Integer getFunSort() {
        return funSort;
    }

    public void setFunSort(Integer funSort) {
        this.funSort = funSort;
    }

    public List<Funs> getTwoFunList() {
        return twoFunList;
    }

    public void setTwoFunList(List<Funs> twoFunList) {
        this.twoFunList = twoFunList;
    }

    public Integer getFunPid() {
        return funPid;
    }

    public void setFunPid(Integer funPid) {
        this.funPid = funPid;
    }
}
