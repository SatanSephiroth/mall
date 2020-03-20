package com.mall.item.service;

import com.mall.item.pojo.Brand;
import com.mall.vo.PageResult;

import java.util.List;

/**
 * @author YZO
 * @date 2020/1/23 20:26
 */
public interface BrandService {
    /**
     * 根据查询条件分页并排序查询品牌信息
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    PageResult<Brand> findBrandByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);

    /**
     * 新增品牌
     * @param brand
     * @param cids
     * @return
     */
    int saveBrand(Brand brand, List<Long> cids);

    /**
     * 根据id删除品牌
     * @param id
     * @return
     */
    int deleteBrandById(Long id);

    /**
     * 修改品牌参数
     * @param brand
     * @param cids
     * @return
     */
    void updateBrand(Brand brand, List<Long> cids);

    /**
     * 根据分类id查询品牌
     * @param cid
     * @return
     */
    List<Brand> findBrandByCid(Long cid);
}
