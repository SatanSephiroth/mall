package com.mall.item.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.item.mapper.SpecGroupMapper;
import com.mall.item.mapper.SpecParamMapper;
import com.mall.item.pojo.SpecGroup;
import com.mall.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YZO
 * @date 2020/2/4 17:06
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    private SpecGroupMapper groupMapper;
    @Autowired
    private SpecParamMapper paramMapper;

    /**
     * 根据分类id查询参数组
     * @param cid
     * @return
     */
    @Override
    public List<SpecGroup> findGroupByCid(Long cid) {
        QueryWrapper<SpecGroup> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cid",cid);
        return groupMapper.selectList(queryWrapper);
    }

    /**
     * 根据分类id查询规格参数
     * @param gid
     * @return
     */
    @Override
    public List<SpecParam> findParams(Long gid) {
        QueryWrapper<SpecParam> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("group_id",gid);
        return paramMapper.selectList(queryWrapper);
    }
}
