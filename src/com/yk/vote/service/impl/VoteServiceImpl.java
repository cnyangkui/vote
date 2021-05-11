package com.yk.vote.service.impl;

import com.yk.vote.mapper.UserVoteMapper;
import com.yk.vote.mapper.VoteInfoMapper;
import com.yk.vote.mapper.VoteOptionMapper;
import com.yk.vote.mapper.custom.VoteMapperCustom;
import com.yk.vote.po.UserVote;
import com.yk.vote.po.VoteInfo;
import com.yk.vote.po.VoteOption;
import com.yk.vote.po.custom.VoteInfoCustom;
import com.yk.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteInfoMapper voteInfoMapper;

    @Autowired
    private VoteOptionMapper voteOptionMapper;

    @Autowired
    private VoteMapperCustom voteMapperExtension;

    @Autowired
    private UserVoteMapper userVoteMapper;

    @Override
    public void saveVote(VoteInfo voteInfo, List<VoteOption> options) throws Exception {
        voteInfoMapper.insert(voteInfo);
        for(VoteOption option: options) {
            voteOptionMapper.insertSelective(option);
        }
    }

    @Override
    public List<VoteInfoCustom> queryAllVotes() throws Exception {
        return voteMapperExtension.queryAllVotes();
    }

    @Override
    public VoteInfoCustom queryVoteByVid(String vid) throws Exception {
        return voteMapperExtension.queryVoteByVid(vid);
    }

    @Override
    public void saveUserVoteList(List<UserVote> userVoteList) {
        for(UserVote userVote: userVoteList) {
            userVoteMapper.insert(userVote);
        }
    }

    @Override
    public List<String> queryVoteByUserName(String userName) throws Exception {
        return voteMapperExtension.queryVoteByUserName(userName);
    }

    @Override
    public List<String> queryVoteByUserNameAndVid(String userName, String vid) throws Exception {
        return voteMapperExtension.queryVoteByUserNameAndVid(userName, vid);
    }
}
