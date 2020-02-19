package com.mall.item.controller;

import com.mall.vo.PageResult;
import com.mall.item.pojo.Brand;
import com.mall.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YZO
 * @date 2020/1/23 20:27
 */
@Controller
@RequestMapping("brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 根据查询条件分页并排序查询品牌信息
     *
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    @GetMapping("page")//key=&page=1&rows=5&sortBy=id&desc=false
    public ResponseEntity<PageResult<Brand>> findBrandByPage(@RequestParam(value = "key", required = false) String key,
                                                             @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                             @RequestParam(value = "rows", defaultValue = "5") Integer rows,
                                                             @RequestParam(value = "sortBy", required = false) String sortBy,
                                                             @RequestParam(value = "desc", required = false) Boolean desc) {
        PageResult<Brand> result = brandService.findBrandByPage(key, page, rows, sortBy, desc);
        if (result == null || CollectionUtils.isEmpty(result.getItems()))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    /**
     * 新增品牌
     *
     * @param brand
     * @param cids
     * @return
     */
    @PostMapping
    public ResponseEntity saveBrand(Brand brand, @RequestParam("cids") List<Long> cids) {
        brandService.saveBrand(brand, cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 根据id删除品牌
     *
     * @param id
     * @return
     */
    @GetMapping("delete/{id}")
    public ResponseEntity deleteBrandById(@PathVariable Long id) {
        //校验数据
        if (id == null || id.longValue() < 0) {
            return ResponseEntity.badRequest().build();
        }
        //根据bid删除品牌
        int row = brandService.deleteBrandById(id);
        //校验结果
        if (row == 0) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 修改品牌参数
     *
     * @param brand
     * @param cids
     * @return
     */
    @PutMapping
    public ResponseEntity updateBrand(Brand brand, @RequestParam("cids") List<Long> cids) {
        //校验参数
        if (brand == null || CollectionUtils.isEmpty(cids))
            return ResponseEntity.badRequest().build();
        brandService.updateBrand(brand, cids);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据分类id查询品牌
     * @param cid
     * @return
     */
    @GetMapping("cid/{cid}")
    public ResponseEntity<List<Brand>> findBrandByCid(@PathVariable("cid") Long cid) {
        List<Brand> brandList = brandService.findBrandByCid(cid);
        if (CollectionUtils.isEmpty(brandList))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(brandList);
    }
}
