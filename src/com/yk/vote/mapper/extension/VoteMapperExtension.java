package com.yk.vote.mapper.extension;

import com.yk.vote.po.extension.VoteInfoExtension;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoteMapperExtension {

    /**
     * 查询所有投票信息
     * @return
     */
    public List<VoteInfoExtension> queryAllVotes();

    /**
     * 根据vid查询投票信息
     * @return
     * @param vid
     */
    public VoteInfoExtension queryVoteByVid(String vid);

    /**
     * 根据用户名查找参与过的投票
     * @param userName
     * @return
     */
    public List<String> queryVoteByUserName(String userName);

    /**
     * 根据用户名和vid查找投票项
     * @param userName
     * @param vid
     * @return
     */
    public List<String> queryVoteByUserNameAndVid(@Param("userName") String userName, @Param("vid") String vid);

}