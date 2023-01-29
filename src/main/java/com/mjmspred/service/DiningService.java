package com.mjmspred.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mjmspred.common.api.ApiPage;
import com.mjmspred.mapper.DiningMapper;
import com.mjmspred.model.Dining;
import com.mjmspred.model.query.DiningQuery;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author HuangChunFeng
 * @time 2023-01-09 11:14
 * @package com.windcf.springmybatismultipledatasource.service.mjms
 * @description TODO
 */
@Service
public class DiningService {
    private final DiningMapper diningMapper;

    public DiningService(DiningMapper diningMapper) {
        this.diningMapper = diningMapper;
    }

    public Dining getDining(LocalDate date) {
        return diningMapper.selectBydate(date);
    }

    public ApiPage<Dining> pageDining(Integer page, Integer pageSize, DiningQuery query) {
        PageHelper.startPage(page, pageSize);
        Page<Dining> dinings = diningMapper.page(query);
        return ApiPage.convert(dinings);
    }


    public List<Dining> listByDates(List<LocalDate> dates) {
        return diningMapper.selectBydates(dates);
    }
}
