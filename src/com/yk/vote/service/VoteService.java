package com.yk.vote.service;

import com.yk.vote.po.UserVote;
import com.yk.vote.po.VoteInfo;
import com.yk.vote.po.VoteOption;
import com.yk.vote.po.extension.VoteInfoExtension;

import java.util.List;

public interface VoteService {

    /**
     * 添加投票
     * @param vote
     * @param options
     * @return
     */
    public void saveVote(VoteInfo vote, List<VoteOption> options) throws Exception;

    /**
     * 查询所有投票信息，使用多表查询
     * @throws Exception
     */
    public List<VoteInfoExtension> queryAllVotes() throws Exception;

    /**
     * 根据vid查询投票信息
     * @param vid
     * @return
     */
    public VoteInfoExtension queryVoteByVid(String vid) throws Exception;

    /**
     * 保存用户投票记录
     * @param userVoteList
     */
    public void saveUserVoteList(List<UserVote> userVoteList);

    /**
     * 根据用户名查找已投票的项
     * @param userName
     * @return
     * @throws Exception
     */
    public List<String> queryVoteByUserName(String userName) throws Exception;

    /**
     * 根据用户名和vid查找已经投过票的项
     * @param userName
     * @param vid
     * @return
     * @throws Exception
     */
    public List<String> queryVoteByUserNameAndVid(String userName, String vid) throws Exception;
}
