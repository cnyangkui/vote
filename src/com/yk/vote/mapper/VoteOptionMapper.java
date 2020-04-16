package com.yk.vote.mapper;

import com.yk.vote.po.VoteOption;
import com.yk.vote.po.VoteOptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoteOptionMapper {
    long countByExample(VoteOptionExample example);

    int deleteByExample(VoteOptionExample example);

    int deleteByPrimaryKey(Integer oid);

    int insert(VoteOption record);

    int insertSelective(VoteOption record);

    List<VoteOption> selectByExample(VoteOptionExample example);

    VoteOption selectByPrimaryKey(Integer oid);

    int updateByExampleSelective(@Param("record") VoteOption record, @Param("example") VoteOptionExample example);

    int updateByExample(@Param("record") VoteOption record, @Param("example") VoteOptionExample example);

    int updateByPrimaryKeySelective(VoteOption record);

    int updateByPrimaryKey(VoteOption record);
}