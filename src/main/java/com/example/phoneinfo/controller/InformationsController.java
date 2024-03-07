package com.example.phoneinfo.controller;

import com.example.phoneinfo.entity.Informations;
import com.example.phoneinfo.entity.Replies;
import com.example.phoneinfo.service.InformationsService;
import com.example.phoneinfo.service.RepliesService;
import com.example.phoneinfo.utils.R;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Informations)表控制层
 *
 * @author makejava
 * @since 2023-06-23 13:48:23
 */
@Controller
@RequestMapping("/informations")
public class InformationsController {
    /**
     * 服务对象
     */
    @Resource
    private InformationsService informationsService;

    @Resource
    private RepliesService repliesService;

    //回复
    @PostMapping("/add")
    @ResponseBody
    public R add(@RequestBody Map<String, String> data) {
        String content = data.get("content");
        int id = Integer.parseInt(data.get("id"));

        if (repliesService.add(id,content) > 0) {
            return R.ok();
        }
        return R.error();
    }

    //页面跳转
    @GetMapping("/details/{id}")
    public String template(@PathVariable("id") int id, Model model) {

        // 根据id查询相关手机咨询信息
       Informations informations = informationsService.queryById(id);

        // 根据id查询相关回复
        List<Replies> replies = repliesService.queryAllById(id);


        model.addAttribute("informations", informations);

        model.addAttribute("replies", replies);
        String ss;

        return "details";
    }

    @RequestMapping("/showAll")
    public String show() {
        return "phoneinfo";
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Informations> getAll() {
        List<Informations> data = informationsService.getAll();
        return data;
    }


    @PostMapping
    public ResponseEntity<Informations> add(Informations informations) {
        return ResponseEntity.ok(this.informationsService.insert(informations));
    }


    @PutMapping
    public ResponseEntity<Informations> edit(Informations informations) {
        return ResponseEntity.ok(this.informationsService.update(informations));
    }


    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.informationsService.deleteById(id));
    }

}

