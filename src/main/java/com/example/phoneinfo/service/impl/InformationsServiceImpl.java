package com.example.phoneinfo.service.impl;

import com.example.phoneinfo.entity.Informations;
import com.example.phoneinfo.dao.InformationsDao;
import com.example.phoneinfo.service.InformationsService;
import com.example.phoneinfo.utils.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Informations)表服务实现类
 *
 * @author makejava
 * @since 2023-06-23 13:48:23
 */
@Service("informationsService")
public class InformationsServiceImpl implements InformationsService {
    final static Logger Log = LoggerFactory.getLogger(InformationsServiceImpl.class);

    @Resource
    private InformationsDao informationsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Informations queryById(Integer id) {
        //咨询查看次数加1
        Informations informations = new Informations();
        informations = informationsDao.queryById(id);

        if(informations != null){
            informations.setViewcount(informations.getViewcount()+1);
            informationsDao.update(informations);
        }
        return informations;
    }



    /**
     * 新增数据
     *
     * @param informations 实例对象
     * @return 实例对象
     */
    @Transactional
    public Informations insert(Informations informations) {
        try {
            this.informationsDao.insert(informations);
        } catch (DataAccessException ex) {
            // 处理数据库异常
            //进行事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            // 日志记录
            Log.error("更新用户信息时发生数据库异常：" + ex.getMessage(), ex);
            //异常处理
            throw new CustomException("更新用户信息时发生数据库异常", ex);
        }
        return informations;
    }

    /**
     * 修改数据
     *
     * @param informations 实例对象
     * @return 实例对象
     */
    @Override
    public Informations update(Informations informations) {
        this.informationsDao.update(informations);
        return this.queryById(informations.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.informationsDao.deleteById(id) > 0;
    }

    @Override
    public List<Informations> getAll() {
        return informationsDao.getAll();
    }
}
