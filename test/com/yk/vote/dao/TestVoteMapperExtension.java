package com.yk.vote.dao;

import com.yk.vote.mapper.custom.VoteMapperCustom;
import com.yk.vote.po.UserVote;
import com.yk.vote.po.custom.VoteInfoCustom;
import com.yk.vote.po.custom.VoteOptionCustom;
import com.yk.vote.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestVoteMapperExtension extends BaseTest {

    @Autowired
    private VoteMapperCustom voteMapperExtension;

    @Test
    public void testSelectAllVotes() {
        List<VoteInfoCustom> list = voteMapperExtension.queryAllVotes();
        for(VoteInfoCustom voteExtension: list) {
            System.out.println(voteExtension.getVoteName());
            List<VoteOptionCustom> optionList = voteExtension.getOptionList();
            for(VoteOptionCustom voteOption: optionList) {
                System.out.println(voteOption.getOptionName());
                List<UserVote> userVoteList = voteOption.getUserVoteList();
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
        List<String> list = voteMapperExtension.queryVoteByUserName("admin");
        for(String string: list) {
            System.out.println(string);
        }
    }

    @Test
    public void testQueryVoteByUserNameAndVid() {
        List<String> list = voteMapperExtension.queryVoteByUserNameAndVid("admin", "cc187806-00c9-4eca-98b8-93c7eee2e713");
        for(String string: list) {
            System.out.println(string);
        }
    }
}
