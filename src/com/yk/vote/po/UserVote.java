package com.yk.vote.po;

public class UserVote {
    private Integer uvid;

    private String userName;

    private Integer oid;

    public UserVote(Integer uvid, String userName, Integer oid) {
        this.uvid = uvid;
        this.userName = userName;
        this.oid = oid;
    }

    public UserVote() {
        super();
    }

    public Integer getUvid() {
        return uvid;
    }

    public void setUvid(Integer uvid) {
        this.uvid = uvid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uvid=").append(uvid);
        sb.append(", userName=").append(userName);
        sb.append(", oid=").append(oid);
        sb.append("]");
        return sb.toString();
    }
}