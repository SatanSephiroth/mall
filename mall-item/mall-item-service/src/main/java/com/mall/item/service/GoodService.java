package com.mall.item.service;

import com.mall.vo.PageResult;
import com.mall.item.bo.SpuBo;

/**
 * @author YZO
 * @date 2020/2/6 20:07
 */
public interface GoodService {
    /**
     * 根据条件分页查询spu
     * @param key 搜索字段
     * @param saleable 是否上架
     * @param page 页数
     * @param rows 每页行数
     * @return
     */
    PageResult<SpuBo> findSpuByPage(String key, Boolean saleable, Integer page, Integer rows);

    /**
     * 新增商品
     * @param spuBo
     * @return
     */
    int saveGood(SpuBo spuBo);
}
