package com.example.phoneinfo.service;

import com.example.phoneinfo.entity.Informations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Informations)表服务接口
 *
 * @author makejava
 * @since 2023-06-23 13:48:23
 */
public interface InformationsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Informations queryById(Integer id);


    /**
     * 新增数据
     *
     * @param informations 实例对象
     * @return 实例对象
     */
    Informations insert(Informations informations);

    /**
     * 修改数据
     *
     * @param informations 实例对象
     * @return 实例对象
     */
    Informations update(Informations informations);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Informations> getAll();
}
