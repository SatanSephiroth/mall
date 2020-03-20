package com.mall.item.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.item.pojo.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XiaoJack
 * @date 2020/1/23 19:27
 */
public interface CategoryMapper extends BaseMapper<Category> {
    /**
     * 根据brand_id查找商品类目
     * @param bid
     * @return
     */
    List<Category> findCategoryByBid(@Param("bid") Long bid);
}
