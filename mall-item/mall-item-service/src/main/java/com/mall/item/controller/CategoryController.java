package com.mall.item.controller;

import com.mall.item.pojo.Category;
import com.mall.item.service.CategoryService;
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
 * @author XiaoJack
 * @date 2020/1/23 19:24
 */
@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 根据父类目id查询子类目集
     *
     * @param pid
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> findCategoryByPid(@RequestParam("pid") Long pid) {
        //校验数据
        if (pid == null || pid.longValue() < 0) return ResponseEntity.badRequest().build();
        //查询
        List<Category> categories = categoryService.findCategoryByPid(pid);
        //校验结果
        if (CollectionUtils.isEmpty(categories)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(categories);
    }

    /**
     * 根据brand_id查询品牌
     *
     * @param bid
     * @return
     */
    @GetMapping("bid/{bid}")
    public ResponseEntity<List<Category>> findCategoryByBid(@PathVariable Long bid) {
        //校验数据
        if (bid == null || bid.longValue() < 0) {
            return ResponseEntity.badRequest().build();
        }
        //根据bid查询
        List<Category> categories = categoryService.findCategoryByBid(bid);
        //校验结果
        if (CollectionUtils.isEmpty(categories)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categories);
    }

}
