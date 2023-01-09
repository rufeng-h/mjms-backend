package com.mjmspred.service.mjms;

import com.mjmspred.mapper.mjms.MjmsUserMapper;
import com.mjmspred.model.mjms.MjmsUser;
import org.springframework.stereotype.Service;

/**
 * @author HuangChunFeng
 * @time 2023-01-09 19:09
 * @package com.mjmspred.service.mjms
 * @description TODO
 */
@Service
public class MjmsUserService {
    private final MjmsUserMapper userMapper;

    public MjmsUserService(MjmsUserMapper userMapper) {
        this.userMapper = userMapper;
    }


    public MjmsUser getUser(long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
