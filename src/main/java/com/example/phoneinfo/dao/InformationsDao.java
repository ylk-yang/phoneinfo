package com.example.phoneinfo.dao;

import com.example.phoneinfo.entity.Informations;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Informations)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-23 13:48:23
 */
public interface InformationsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Informations queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param informations 查询条件
     * @param pageable     分页对象
     * @return 对象列表
     */
    List<Informations> queryAllByLimit(Informations informations, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param informations 查询条件
     * @return 总行数
     */
    long count(Informations informations);

    /**
     * 新增数据
     *
     * @param informations 实例对象
     * @return 影响行数
     */
    int insert(Informations informations);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Informations> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Informations> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Informations> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Informations> entities);

    /**
     * 修改数据
     *
     * @param informations 实例对象
     * @return 影响行数
     */
    int update(Informations informations);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Informations> getAll();
}

