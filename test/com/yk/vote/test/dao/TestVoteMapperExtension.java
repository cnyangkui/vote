package com.yk.vote.test.dao;

import com.yk.vote.mapper.extension.VoteMapperExtension;
import com.yk.vote.po.UserVote;
import com.yk.vote.po.extension.VoteInfoExtension;
import com.yk.vote.po.extension.VoteOptionExtension;
import com.yk.vote.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestVoteMapperExtension extends BaseTest {

    @Autowired
    private VoteMapperExtension voteMapperExtension;

    @Test
    public void testSelectAllVotes() {
        List<VoteInfoExtension> list = voteMapperExtension.queryAllVotes();
        for(VoteInfoExtension voteExtension: list) {
            System.out.println(voteExtension.getVoteName());
            List<VoteOptionExtension> optionList = voteExtension.getOptionList();
            for(VoteOptionExtension voteOption: optionList) {
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
