package com.mjmspred.mapper.mjms;

import com.mjmspred.model.mjms.MjmsUser;
import org.apache.ibatis.annotations.Mapper;


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
}