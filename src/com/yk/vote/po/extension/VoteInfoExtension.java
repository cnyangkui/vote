package com.yk.vote.po.extension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yk.vote.po.UserVote;
import com.yk.vote.po.VoteInfo;

public class VoteInfoExtension extends VoteInfo {

    // 投票选项
    private List<VoteOptionExtension> optionList;

    // 投票选项数量
    private Integer optionNumber = 0;

    // 参与这项投票的用户的数量
    private Integer votedUserNumber = 0;

    // 投票总数量
    private Integer total = 0;

    // 参与这项投票的用户
    private Set<String> votedUser = new HashSet<>();

    public List<VoteOptionExtension> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<VoteOptionExtension> optionList) {
        this.optionList = optionList;
    }

    public Integer getOptionNumber() {
        if(optionList != null) {
            optionNumber = optionList.size();
        }
        return optionNumber;
    }

    public Set<String> getVotedUser() {
        votedUser.clear();
        if(optionList != null) {
            for(VoteOptionExtension optionExtension: optionList) {
                List<UserVote> userVoteList = optionExtension.getUserVoteList();
                if(userVoteList != null) {
                    for(UserVote uservote: userVoteList) {
                        if(uservote.getUvid() != null) {
                            votedUser.add(uservote.getUserName());
                        }
                    }
                }
            }
        }
        return votedUser;
    }

    public Integer getVotedUserNumber() {
        votedUserNumber = getVotedUser().size();
        return votedUserNumber;
    }

    public Integer getTotal() {
        total = 0;
        if(optionList != null) {
            for(VoteOptionExtension optionExtension: optionList) {
                total += optionExtension.getCount();
            }
        }
        return total;
    }
}
