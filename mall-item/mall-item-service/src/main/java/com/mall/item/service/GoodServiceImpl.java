package com.mall.item.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.item.mapper.BrandMapper;
import com.mall.item.pojo.Brand;
import com.mall.vo.PageResult;
import com.mall.item.bo.SpuBo;
import com.mall.item.mapper.SpuDetailMapper;
import com.mall.item.mapper.SpuMapper;
import com.mall.item.pojo.Spu;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author YZO
 * @date 2020/2/6 20:07
 */
@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private SpuMapper spuMapper;
    @Autowired
    private SpuDetailMapper spuDetailMapper;
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private CategoryService categoryService;

    /**
     * 根据条件分页查询spu
     *
     * @param key      搜索字段
     * @param saleable 是否上架
     * @param page     页数
     * @param rows     每页行数
     * @return
     */
    @Override
    public PageResult<SpuBo> findSpuByPage(String key, Boolean saleable, Integer page, Integer rows) {
        QueryWrapper<Spu> queryWrapper = new QueryWrapper<>();
        //添加查询条件
        //模糊查询
        queryWrapper.like("title", key);
        //添加上下架过滤条件
        if (saleable != null)
            queryWrapper.eq("saleable", saleable);
        //添加分页条件
        Page<Spu> iPage = new Page<>(page, rows);
        //查询获得spu集合
        IPage<Spu> spuPage = spuMapper.selectPage(iPage, queryWrapper);
        //spu转为spubo集合
        List<Spu> spuList = spuPage.getRecords();
        List<SpuBo> spuBoList = spuList.stream().map(spu -> {
            SpuBo spuBo = new SpuBo();
            BeanUtils.copyProperties(spu, spuBo);
            //查询品牌名称
            Brand brand = brandMapper.selectById(spu.getBrandId());
            //查询分类名称
            List<String> names = categoryService.findNamesByIds(Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3()));
            spuBo.setBname(brand.getName()).setCname(StringUtils.join(names, "-"));
            return spuBo;
        }).collect(Collectors.toList());
        //返回数据
        return new PageResult<>(spuPage.getTotal(), spuBoList);
    }
}
