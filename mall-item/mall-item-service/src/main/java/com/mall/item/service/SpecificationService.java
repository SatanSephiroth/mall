package com.mall.item.service;

import com.mall.item.pojo.SpecGroup;
import com.mall.item.pojo.SpecParam;

import java.util.List;

/**
 * @author YZO
 * @date 2020/2/4 17:06
 */
public interface SpecificationService {
    /**
     * 根据分类id查询参数组
     * @param cid
     * @return
     */
    List<SpecGroup> findGroupByCid(Long cid);

    /**
     * 根据分类id查询规格参数
     * @param gid
     * @return
     */
    List<SpecParam> findParams(Long gid);
}
