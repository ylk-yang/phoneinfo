package com.example.phoneinfo.dao;

import com.example.phoneinfo.entity.Replies;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Replies)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-23 13:48:50
 */
public interface RepliesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Replies queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param replies  查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Replies> queryAllByLimit(Replies replies, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param replies 查询条件
     * @return 总行数
     */
    long count(Replies replies);

    /**
     * 新增数据
     *
     * @param replies 实例对象
     * @return 影响行数
     */
    int insert(Replies replies);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Replies> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Replies> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Replies> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Replies> entities);

    /**
     * 修改数据
     *
     * @param replies 实例对象
     * @return 影响行数
     */
    int update(Replies replies);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Replies> queryAllById(int id);
}

