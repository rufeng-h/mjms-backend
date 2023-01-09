package com.windcf.springmybatismultipledatasource.mapper.mjms;

import com.windcf.springmybatismultipledatasource.model.mjms.Dining;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author HuangChunFeng
 * @time 2023-01-09 10:22
 * @package com.windcf.springmybatismultipledatasource.mapper.mjms
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