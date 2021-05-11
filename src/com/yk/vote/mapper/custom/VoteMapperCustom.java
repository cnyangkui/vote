package com.yk.vote.mapper.custom;

import com.yk.vote.po.custom.VoteInfoCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoteMapperCustom {

    /**
     * 查询所有投票信息
     * @return
     */
    List<VoteInfoCustom> queryAllVotes();

    /**
     * 根据vid查询投票信息
     * @return
     * @param vid
     */
    VoteInfoCustom queryVoteByVid(String vid);

    /**
     * 根据用户名查找参与过的投票
     * @param userName
     * @return
     */
    List<String> queryVoteByUserName(String userName);

    /**
     * 根据用户名和vid查找投票项
     * @param userName
     * @param vid
     * @return
     */
    List<String> queryVoteByUserNameAndVid(@Param("userName") String userName, @Param("vid") String vid);

}