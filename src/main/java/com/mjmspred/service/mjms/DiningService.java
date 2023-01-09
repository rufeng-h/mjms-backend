package com.windcf.springmybatismultipledatasource.service.mjms;

import com.windcf.springmybatismultipledatasource.config.MjmsDataSourceConfig;
import com.windcf.springmybatismultipledatasource.mapper.mjms.DiningMapper;
import com.windcf.springmybatismultipledatasource.model.mjms.Dining;
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
}
