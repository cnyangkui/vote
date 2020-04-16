package com.yk.vote.po;

public class VoteOption {
    private Integer oid;

    private String vid;

    private String optionName;

    public VoteOption(Integer oid, String vid, String optionName) {
        this.oid = oid;
        this.vid = vid;
        this.optionName = optionName;
    }

    public VoteOption() {
        super();
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid == null ? null : vid.trim();
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName == null ? null : optionName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oid=").append(oid);
        sb.append(", vid=").append(vid);
        sb.append(", optionName=").append(optionName);
        sb.append("]");
        return sb.toString();
    }
}