package com.honc.cqrs.cqrsall.mapper;

import com.honc.cqrs.cqrsall.dataobject.KeywordDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeywordDoMapper {
    int deleteByPrimaryKey(String keyword);

    int insert(KeywordDo record);

    int insertSelective(KeywordDo record);

    KeywordDo selectByPrimaryKey(String keyword);

    int updateByPrimaryKeySelective(KeywordDo record);

    int updateByPrimaryKey(KeywordDo record);

    int insertUserSearchKeyword(@Param("keywordDo") KeywordDo keywordDo);

}