package com.mall.item.service;

import com.mall.item.pojo.Category;

import java.util.List;

/**
 * @author XiaoJack
 * @date 2020/1/23 19:25
 */
public interface CategoryService {
    /**
     * 根据父类id查询子类目集
     * @param pid
     * @return
     */
    List<Category> findCategoryByPid(Long pid);

    /**
     * 根据brand_id查询品牌
     * @param bid
     * @return
     */
    List<Category> findCategoryByBid(Long bid);


    List<String> findNamesByIds(List<Long> ids);

}
