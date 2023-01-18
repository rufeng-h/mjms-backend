package com.mjmspred.mapper.mjms;

import com.github.pagehelper.Page;
import com.mjmspred.model.mjms.Dining;
import com.mjmspred.model.mjms.query.DiningQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;


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

    Page<Dining> page(@Param("query") DiningQuery query);

    Dining selectBydate(LocalDate date);

    List<Dining> selectBydates(List<LocalDate> dates);
}