package com.yk.vote.po.extension;

import java.util.List;

import com.yk.vote.po.UserVote;
import com.yk.vote.po.VoteOption;

public class VoteOptionExtension extends VoteOption {

    private List<UserVote> userVoteList;

    private Integer count = 0;

    public List<UserVote> getUserVoteList() {
        return userVoteList;
    }

    public void setUserVoteList(List<UserVote> userVoteList) {
        this.userVoteList = userVoteList;
    }

    public Integer getCount() {
        count = 0;
        if(userVoteList != null) {
            for(UserVote userVote: userVoteList) {
                if(userVote.getUvid() != null) {
                    count++;
                }
            }
        }
        return count;
    }

}
