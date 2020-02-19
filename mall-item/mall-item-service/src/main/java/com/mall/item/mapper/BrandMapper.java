package com.mall.item.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.item.pojo.Brand;
import org.apache.ibatis.annotations.Param;

/**
 * @author YZO
 * @date 2020/1/23 20:26
 */
public interface BrandMapper extends BaseMapper<Brand> {
    /**
     * 新增中间表数据
     * @param cid
     * @param bid
     * @return
     */
    int insertCategoryAndBrand(@Param("cid") Long cid, @Param("bid") Long bid);

    /**
     * 删除中间表数据
     * @param id
     */
    void deleteBrandCategoryByBid(@Param("id") Long id);
}
