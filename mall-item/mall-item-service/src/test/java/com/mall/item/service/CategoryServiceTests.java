package com.mall.item.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.item.mapper.CategoryMapper;
import com.mall.item.pojo.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @auther XiaoJack
 * @date 2020/1/23 19:53
 */
@SpringBootTest
public class CategoryServiceTests {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void findCategoryByPid() {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", 0);
        List<Category> list = categoryMapper.selectList(queryWrapper);
        list.forEach((category -> System.out.println(category)));
    }

    @Test
    void findCategoryByBid() {
        List<Category> categories = categoryMapper.findCategoryByBid(325406L);
        categories.forEach(category -> {
            System.out.println(category);
        });
    }
}
