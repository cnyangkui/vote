package com.yk.vote.mapper;

import com.yk.vote.po.VoteInfo;
import com.yk.vote.po.VoteInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoteInfoMapper {
    long countByExample(VoteInfoExample example);

    int deleteByExample(VoteInfoExample example);

    int deleteByPrimaryKey(String vid);

    int insert(VoteInfo record);

    int insertSelective(VoteInfo record);

    List<VoteInfo> selectByExample(VoteInfoExample example);

    VoteInfo selectByPrimaryKey(String vid);

    int updateByExampleSelective(@Param("record") VoteInfo record, @Param("example") VoteInfoExample example);

    int updateByExample(@Param("record") VoteInfo record, @Param("example") VoteInfoExample example);

    int updateByPrimaryKeySelective(VoteInfo record);

    int updateByPrimaryKey(VoteInfo record);
}