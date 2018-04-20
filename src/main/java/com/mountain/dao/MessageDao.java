package com.mountain.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.mountain.common.BaseMapper;
import com.mountain.po.Message;

@Mapper
public interface MessageDao extends BaseMapper<Message, Long> {

}
