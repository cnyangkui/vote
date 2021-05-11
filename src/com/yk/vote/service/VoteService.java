package com.yk.vote.service;

import com.yk.vote.po.UserVote;
import com.yk.vote.po.VoteInfo;
import com.yk.vote.po.VoteOption;
import com.yk.vote.po.custom.VoteInfoCustom;

import java.util.List;

public interface VoteService {

    /**
     * 添加投票
     * @param vote
     * @param options
     * @return
     */
    void saveVote(VoteInfo vote, List<VoteOption> options) throws Exception;

    /**
     * 查询所有投票信息，使用多表查询
     * @throws Exception
     */
    List<VoteInfoCustom> queryAllVotes() throws Exception;

    /**
     * 根据vid查询投票信息
     * @param vid
     * @return
     */
    VoteInfoCustom queryVoteByVid(String vid) throws Exception;

    /**
     * 保存用户投票记录
     * @param userVoteList
     */
    void saveUserVoteList(List<UserVote> userVoteList);

    /**
     * 根据用户名查找已投票的项
     * @param userName
     * @return
     * @throws Exception
     */
    List<String> queryVoteByUserName(String userName) throws Exception;

    /**
     * 根据用户名和vid查找已经投过票的项
     * @param userName
     * @param vid
     * @return
     * @throws Exception
     */
    List<String> queryVoteByUserNameAndVid(String userName, String vid) throws Exception;
}
