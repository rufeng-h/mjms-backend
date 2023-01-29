package com.mjmspred.mapper;

import com.mjmspred.model.MjmsUser;
import com.mjmspred.model.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author HuangChunFeng
 * @time 2023-01-09 19:05
 * @package com.mjmspred.mapper.mjms
 * @description TODO
 */

@Mapper
public interface MjmsUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(MjmsUser record);

    int insertSelective(MjmsUser record);

    MjmsUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(MjmsUser record);

    int updateByPrimaryKey(MjmsUser record);

    MjmsUser getUser(@Param("query") UserQuery query);
}