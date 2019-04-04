package com.honc.cqrs.cqrsall.dataobject;

import java.util.Date;

public class KeywordDo {
    private String keyword;

    private Integer commendStatus;

    private Double weight;

    private Integer searchNumber;

    private Integer approveStatus;

    private Integer sourceFrom;

    private Date gmtCreated;

    private Date gmtModified;

    private String creator;

    private String modifier;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getCommendStatus() {
        return commendStatus;
    }

    public void setCommendStatus(Integer commendStatus) {
        this.commendStatus = commendStatus;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getSearchNumber() {
        return searchNumber;
    }

    public void setSearchNumber(Integer searchNumber) {
        this.searchNumber = searchNumber;
    }

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(Integer sourceFrom) {
        this.sourceFrom = sourceFrom;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
}