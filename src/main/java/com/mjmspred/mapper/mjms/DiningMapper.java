package com.mjmspred.mapper.mjms;

import com.mjmspred.model.mjms.Dining;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author HuangChunFeng
 * @time 2023-01-09 16:08
 * @package com.mjmspred.mapper.mjms
 * @description TODO
 */

@Mapper
public interface DiningMapper {
    int deleteByPrimaryKey(Long dnId);

    int insert(Dining record);

    int insertSelective(Dining record);

    Dining selectByPrimaryKey(Long dnId);

    int updateByPrimaryKeySelective(Dining record);

    int updateByPrimaryKey(Dining record);
}