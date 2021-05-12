package com.yk.vote.dao;

import com.yk.vote.mapper.custom.VoteMapperCustom;
import com.yk.vote.po.UserVote;
import com.yk.vote.po.custom.VoteInfoCustom;
import com.yk.vote.po.custom.VoteOptionCustom;
import com.yk.vote.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestVoteMapperCustom extends BaseTest {

    @Autowired
    private VoteMapperCustom voteMapperCustom;

    @Test
    public void testSelectAllVotes() {
        List<VoteInfoCustom> list = voteMapperCustom.queryAllVotes();
        for(VoteInfoCustom voteInfoCustom: list) {
            System.out.println(voteInfoCustom.getVoteName());
            List<VoteOptionCustom> optionList = voteInfoCustom.getOptionList();
            for(VoteOptionCustom voteOptionCustom: optionList) {
                System.out.println(voteOptionCustom.getOptionName());
                List<UserVote> userVoteList = voteOptionCustom.getUserVoteList();
                System.out.println(userVoteList.size());
                for(UserVote uservote: userVoteList) {
                    System.out.println(uservote);
                }
            }
            System.out.println("----------------------");
        }
    }

    @Test
    public void testQueryVoteByUserName() {
        List<String> list = voteMapperCustom.queryVoteByUserName("admin");
        for(String string: list) {
            System.out.println(string);
        }
    }

    @Test
    public void testQueryVoteByUserNameAndVid() {
        List<String> list = voteMapperCustom.queryVoteByUserNameAndVid("admin", "cc187806-00c9-4eca-98b8-93c7eee2e713");
        for(String string: list) {
            System.out.println(string);
        }
    }
}
