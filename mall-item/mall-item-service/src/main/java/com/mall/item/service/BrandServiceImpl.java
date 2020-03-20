package com.mall.item.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.item.mapper.BrandMapper;
import com.mall.item.pojo.Brand;
import com.mall.vo.PageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YZO
 * @date 2020/1/23 20:26
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 根据查询条件分页并排序查询品牌信息
     */
    @Override
    public PageResult<Brand> findBrandByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        Long total = Long.valueOf(brandMapper.selectCount(null));
        //根据name模糊查询,或根据首字母查询
        if (StringUtils.isNotBlank(key)) {
            queryWrapper.like("name", key).or().like("letter", key);
        }
        //添加排序条件
        if (StringUtils.isNotBlank(sortBy)) {
            queryWrapper.orderBy(true, !desc, sortBy);
        }
        //添加分页条件
        Page<Brand> brandPage = new Page<>(page, rows);
        Page<Brand> bPage = brandMapper.selectPage(brandPage, queryWrapper);
        //转为List集合
        List<Brand> brandList = bPage.getRecords();
        return new PageResult<Brand>(total, brandList);
    }

    /**
     * 新增品牌
     * @param brand
     * @param cids
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int saveBrand(Brand brand, List<Long> cids) {
        //新增brand
        int bRow = brandMapper.insert(brand);
        //校验品牌是否添加成功
        if (bRow != 0) {
            //新增中间表
            int cabRow = 0;
            for (Long cid : cids) {
                brandMapper.insertCategoryAndBrand(cid, brand.getId());
                cabRow++;
            }
            //校验中间表是否添加成功
            if (cabRow != 0) {
                return cabRow + bRow;
            }
            return 0;
            //返回结果
        } else {
            return 0;
        }
    }

    /**
     * 根据id删除品牌
     * @param id
     * @return
     */
    @Override
    public int deleteBrandById(Long id) {
        return brandMapper.deleteById(id);
    }

    /**
     * 修改品牌参数
     * @param brand
     * @param cids
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void updateBrand(Brand brand, List<Long> cids) {
        //修改brand
        brandMapper.updateById(brand);
        //根据品牌id删除旧的中间表数据
        brandMapper.deleteBrandCategoryByBid(brand.getId());
        //根据参数新增中间表
        cids.forEach(cid -> {
            brandMapper.insertCategoryAndBrand(cid,brand.getId());
        });
    }

    /**
     * 根据分类id查询品牌
     * @param cid
     * @return
     */
    @Override
    public List<Brand> findBrandByCid(Long cid) {
        return brandMapper.findBrandByCid(cid);
    }
}
