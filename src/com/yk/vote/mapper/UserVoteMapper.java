package com.yk.vote.mapper;

import com.yk.vote.po.UserVote;
import com.yk.vote.po.UserVoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserVoteMapper {
    long countByExample(UserVoteExample example);

    int deleteByExample(UserVoteExample example);

    int deleteByPrimaryKey(Integer uvid);

    int insert(UserVote record);

    int insertSelective(UserVote record);

    List<UserVote> selectByExample(UserVoteExample example);

    UserVote selectByPrimaryKey(Integer uvid);

    int updateByExampleSelective(@Param("record") UserVote record, @Param("example") UserVoteExample example);

    int updateByExample(@Param("record") UserVote record, @Param("example") UserVoteExample example);

    int updateByPrimaryKeySelective(UserVote record);

    int updateByPrimaryKey(UserVote record);
}