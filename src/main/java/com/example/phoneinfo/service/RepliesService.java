package com.example.phoneinfo.service;

import com.example.phoneinfo.entity.Replies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Replies)表服务接口
 *
 * @author makejava
 * @since 2023-06-23 13:48:50
 */
public interface RepliesService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Replies queryById(Integer id);

    /**
     * 分页查询
     *
     * @param replies     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Replies> queryByPage(Replies replies, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param replies 实例对象
     * @return 实例对象
     */
    Replies insert(Replies replies);

    /**
     * 修改数据
     *
     * @param replies 实例对象
     * @return 实例对象
     */
    Replies update(Replies replies);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Replies> queryAllById(int id);


    int  add(int id, String content);
}
