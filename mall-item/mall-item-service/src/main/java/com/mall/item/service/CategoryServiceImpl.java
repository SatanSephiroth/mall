package com.mall.item.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.item.mapper.CategoryMapper;
import com.mall.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author XiaoJack
 * @date 2020/1/23 19:26
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 根据父类目id查询子类目集
     * @param pid
     * @return
     */
    @Override
    public List<Category> findCategoryByPid(Long pid) {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",pid);
        return categoryMapper.selectList(queryWrapper);
    }

    /**
     * 根据brand_id查询品牌
     * @param bid
     * @return
     */
    @Override
    public List<Category> findCategoryByBid(Long bid) {
        return categoryMapper.findCategoryByBid(bid);
    }

    @Override
    public List<String> findNamesByIds(List<Long> ids) {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",ids);
        List<Category> categories = categoryMapper.selectList(queryWrapper);
        return categories.stream().map(category -> category.getName()).collect(Collectors.toList());
    }
}
