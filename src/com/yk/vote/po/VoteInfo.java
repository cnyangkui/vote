package com.yk.vote.po;

public class VoteInfo {
    private String vid;

    private String voteName;

    private Integer type;

    public VoteInfo(String vid, String voteName, Integer type) {
        this.vid = vid;
        this.voteName = voteName;
        this.type = type;
    }

    public VoteInfo() {
        super();
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid == null ? null : vid.trim();
    }

    public String getVoteName() {
        return voteName;
    }

    public void setVoteName(String voteName) {
        this.voteName = voteName == null ? null : voteName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", vid=").append(vid);
        sb.append(", voteName=").append(voteName);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}