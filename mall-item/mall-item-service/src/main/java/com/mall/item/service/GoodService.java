package com.mall.item.service;

import com.mall.item.pojo.Sku;
import com.mall.item.pojo.SpuDetail;
import com.mall.vo.PageResult;
import com.mall.item.bo.SpuBo;

import java.util.List;

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

    /**
     * 根据spuId查询商品信息
     * @param spuId
     * @return
     */
    SpuDetail findSpuDetailBySouId(Long spuId);

    /**
     * 根据spuId查询sku集合
     * @param spuId
     * @return
     */
    List<Sku> findSkuBySpuId(Long spuId);

    /**
     * 修改商品
     * @param spuBo
     * @return
     */
    int updateGood(SpuBo spuBo);
}
