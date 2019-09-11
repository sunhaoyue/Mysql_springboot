package com.wantwant.service.impl;



import com.wantwant.mapper.ShyUserMapper;
import com.wantwant.pojo.ShyUser;
import com.wantwant.service.ShyUserService;
import com.wantwant.utils.DynamicDataSourceSwitcher;
import com.wantwant.utils.aop.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @program: Mysql_springboot
 * @description: 用户管理
 * @author: Sunhaoyue
 * @create: 2019/09/06 10:11
 */


@Service("ShyUserserviceImpl")
public class ShyUserserviceImpl implements ShyUserService {

    @Autowired
    private ShyUserMapper shyUserMapper;

    @Override
    public List<ShyUser> selectByPrimaryKey(Long id) {
        List<ShyUser> listUser = shyUserMapper.selectByPrimaryKey(id);
        return listUser;
    }

    @MyDataSource(value = DynamicDataSourceSwitcher.Mater)
    public List<ShyUser> getUserByIdWithSlave(Long id) {
        return shyUserMapper.selectByPrimaryKey(id);
    }
}
