package com.example.phoneinfo.controller;

import com.example.phoneinfo.entity.Replies;
import com.example.phoneinfo.service.RepliesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Replies)表控制层
 *
 * @author makejava
 * @since 2023-06-23 13:48:50
 */
@RestController
@RequestMapping("replies")
public class RepliesController {
    /**
     * 服务对象
     */
    @Resource
    private RepliesService repliesService;

    /**
     * 分页查询
     *
     * @param replies     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Replies>> queryByPage(Replies replies, PageRequest pageRequest) {
        return ResponseEntity.ok(this.repliesService.queryByPage(replies, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Replies> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.repliesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param replies 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Replies> add(Replies replies) {
        return ResponseEntity.ok(this.repliesService.insert(replies));
    }

    /**
     * 编辑数据
     *
     * @param replies 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Replies> edit(Replies replies) {
        return ResponseEntity.ok(this.repliesService.update(replies));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.repliesService.deleteById(id));
    }

}

