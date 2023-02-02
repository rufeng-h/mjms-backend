package com.mjmspred.service;

import com.mjmspred.common.util.CalendarUtils;
import com.mjmspred.mapper.FlowMapper;
import com.mjmspred.model.Flow;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @author : chunf
 */
@Service
public class FlowService {
    private static final String DEMO_PRED = "{\"07:00:00\": 38, \"07:10:00\": 45, \"07:20:00\": 135, \"07:30:00\": 199, \"07:40:00\": 226, \"07:50:00\": 255, \"08:00:00\": 50, \"08:10:00\": 6, \"08:20:00\": 6, \"08:30:00\": 6, \"08:40:00\": 6, \"08:50:00\": 6, \"11:00:00\": 10, \"11:10:00\": 11, \"11:20:00\": 40, \"11:30:00\": 354, \"11:40:00\": 264, \"11:50:00\": 232, \"12:00:00\": 261, \"12:10:00\": 142, \"12:20:00\": 39, \"12:30:00\": 10, \"12:40:00\": 7, \"12:50:00\": 6, \"17:00:00\": 6, \"17:10:00\": 11, \"17:20:00\": 10, \"17:30:00\": 138, \"17:40:00\": 130, \"17:50:00\": 114, \"18:00:00\": 71, \"18:10:00\": 39, \"18:20:00\": 39, \"18:30:00\": 9, \"18:40:00\": 8, \"18:50:00\": 7, \"19:00:00\": 6, \"19:10:00\": 7, \"19:20:00\": 7, \"19:30:00\": 7, \"19:40:00\": 6, \"19:50:00\": 6}";
    private final FlowMapper flowMapper;

    public FlowService(FlowMapper flowMapper) {
        this.flowMapper = flowMapper;
    }

    public Flow getByDate(LocalDate date) {
        Flow flow = flowMapper.selectByDate(date);
        /* TODO 样例数据 */
        if (flow == null) {
            String remark = CalendarUtils.isWorkday(date) ? "工作日" : "节假日";
            return Flow.builder().id(0L).fDate(date).pred(DEMO_PRED).remark(remark).build();
        }
        return flow;
    }
}
