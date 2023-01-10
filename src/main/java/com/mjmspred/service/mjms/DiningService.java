package com.mjmspred.service.mjms;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mjmspred.common.api.ApiPage;
import com.mjmspred.config.MjmsDataSourceConfig;
import com.mjmspred.mapper.mjms.DiningMapper;
import com.mjmspred.model.mjms.Dining;
import com.mjmspred.model.mjms.query.DiningQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(rollbackFor = Exception.class, transactionManager = MjmsDataSourceConfig.TRANSACTION_MANAGER)
    public Dining getDining(long id) {
        return diningMapper.selectByPrimaryKey(id);
    }

    public ApiPage<Dining> pageDining(Integer page, Integer pageSize, DiningQuery query) {
        PageHelper.startPage(page, pageSize);
        Page<Dining> dinings = diningMapper.page(query);
        return ApiPage.convert(dinings);
    }
}
