package com.mall.item.service;

import com.mall.item.mapper.BrandMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @auther YZO
 * @date 2020/2/6 22:05
 */
@SpringBootTest
public class BrandServiceTests {
    @Autowired
    private BrandMapper brandMapper;

    @Test
    void insertCategoryAndBrand(){
        brandMapper.insertCategoryAndBrand(4L,325408L);
        System.out.println("添加成功");
    }

    @Test
    void deleteBrandById(){
        int row = brandMapper.deleteById(325401);
        System.out.println("删除的行数:"+row);
    }
}
