package com.mall.item.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.item.mapper.*;
import com.mall.item.pojo.*;
import com.mall.vo.PageResult;
import com.mall.item.bo.SpuBo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
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
    @Autowired
    private SkuMapper skuMapper;
    @Autowired
    private StockMapper stockMapper;

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
        queryWrapper.eq(saleable != null, "saleable", saleable);
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

    /**
     * 新增商品
     * @param spuBo
     * @return
     */
    @Override
    @Transactional
    public int saveGood(SpuBo spuBo) {
        //新增spu
        spuBo.setCreateTime(new Date())
                .setLastUpdateTime(spuBo.getCreateTime())
                .setSaleable(true).setValid(true).setId(null);
        spuMapper.insert(spuBo);
        //新增spuDetail
        SpuDetail spuDetail = spuBo.getSpuDetail();
        //获取spu_id
        QueryWrapper<Spu> wrapper = new QueryWrapper<>();
        wrapper.eq("title",spuBo.getTitle());
        Spu spu = spuMapper.selectOne(wrapper);
        spuDetail.setSpuId(spu.getId());
        spuDetailMapper.insert(spuDetail);
        //新增sku
        List<Sku> skuList = spuBo.getSkus();
        skuList.forEach(sku -> {
            sku.setId(null).setSpuId(spu.getId())
                    .setCreateTime(new Date())
                    .setLastUpdateTime(sku.getCreateTime());
            skuMapper.insert(sku);
            //新增stock
            Stock stock = new Stock();
            stock.setSkuId(sku.getId()).setStock(sku.getStock());
            stockMapper.insert(stock);
        });
        return 0;
    }

}
