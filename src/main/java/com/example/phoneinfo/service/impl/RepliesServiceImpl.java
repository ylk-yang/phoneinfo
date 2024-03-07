package com.example.phoneinfo.service.impl;

import com.example.phoneinfo.dao.InformationsDao;
import com.example.phoneinfo.entity.Informations;
import com.example.phoneinfo.entity.Replies;
import com.example.phoneinfo.dao.RepliesDao;
import com.example.phoneinfo.service.RepliesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Replies)表服务实现类
 *
 * @author makejava
 * @since 2023-06-23 13:48:50
 */
@Service("repliesService")
public class RepliesServiceImpl implements RepliesService {
    @Resource
    private RepliesDao repliesDao;

    @Resource
    private InformationsDao informationsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Replies queryById(Integer id) {
        return this.repliesDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param replies     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Replies> queryByPage(Replies replies, PageRequest pageRequest) {
        long total = this.repliesDao.count(replies);
        return new PageImpl<>(this.repliesDao.queryAllByLimit(replies, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param replies 实例对象
     * @return 实例对象
     */
    @Override
    public Replies insert(Replies replies) {
        this.repliesDao.insert(replies);
        return replies;
    }

    /**
     * 修改数据
     *
     * @param replies 实例对象
     * @return 实例对象
     */
    @Override
    public Replies update(Replies replies) {
        this.repliesDao.update(replies);
        return this.queryById(replies.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.repliesDao.deleteById(id) > 0;
    }

    @Override
    public List<Replies> queryAllById(int id) {
        return repliesDao.queryAllById(id);
    }

    @Override
    public int add(int id, String content) {

        //对数据进行封装
        Replies replies = new Replies();
        replies.setInfoid(id);
        replies.setContent(content);

        Date lastTime = new Date();
        replies.setReplytime(lastTime);
        int result = repliesDao.insert(replies);
//        同时将相关资讯的回复次数加 1 并更新最后回复时间
        //通过infoid查找到对象 并更新对象
        Informations informations = informationsDao.queryById(id);
        informations.setReplycount(informations.getId()+1);
        informations.setLastposttime(lastTime);

        if(result>0) {
            //更新手机咨询信息
            int update = informationsDao.update(informations);
        }
        return result;
    }


}
