package com.mall.item.controller;

import com.mall.item.pojo.SpecGroup;
import com.mall.item.pojo.SpecParam;
import com.mall.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author YZO
 * @date 2020/2/4 17:08
 */
@Controller
@RequestMapping("spec")
public class SpecificationController {
    @Autowired
    private SpecificationService specificationService;

    /**
     * 根据分类id查询参数组
     * @param cid
     * @return
     */
    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> findGroupByCid(@PathVariable("cid") Long cid){
        List<SpecGroup> groups = specificationService.findGroupByCid(cid);
        if (CollectionUtils.isEmpty(groups)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(groups);
    }

    /**
     * 根据分类id查询参数组
     * @param gid
     * @return
     */
    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> findParam(@RequestParam("gid") Long gid){
       List<SpecParam> params = specificationService.findParams(gid);
       if (CollectionUtils.isEmpty(params)){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(params);
    }
}
