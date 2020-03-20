package com.mall.item.controller;

import com.mall.item.bo.SpuBo;
import com.mall.item.pojo.Sku;
import com.mall.item.pojo.SpuDetail;
import com.mall.item.service.GoodService;
import com.mall.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YZO
 * @date 2020/2/6 20:09
 */
@Controller
public class GoodsController {
    @Autowired
    private GoodService goodService;

    /**
     * 根据条件分页查询spu
     *
     * @param key      搜索字段
     * @param saleable 是否上架
     * @param page     页数
     * @param rows     每页行数
     * @return
     */
    @GetMapping("spu/page")
    public ResponseEntity<PageResult<SpuBo>> findSpuByPage(
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "saleable", required = false) Boolean saleable,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows
    ) {
        PageResult<SpuBo> result = goodService.findSpuByPage(key, saleable, page, rows);
        if (result == null || CollectionUtils.isEmpty(result.getItems())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 新增商品
     *
     * @param spuBo
     * @return
     */
    @PostMapping("goods")
    public ResponseEntity saveGood(@RequestBody SpuBo spuBo) {
        goodService.saveGood(spuBo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 根据spuId查询商品信息
     *
     * @param spuId
     * @return
     */
    @GetMapping("spu/detail/{spuId}")
    public ResponseEntity<SpuDetail> findSpuDetailBySouId(@PathVariable("spuId") Long spuId) {
        SpuDetail spuDetail = goodService.findSpuDetailBySouId(spuId);
        if (spuDetail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(spuDetail);
    }

    /**
     * 根据spuId查询sku集合
     *
     * @param spuId
     * @return
     */
    @GetMapping("sku/list")
    public ResponseEntity<List<Sku>> findSkuBySpuId(
            @RequestParam("id") Long spuId) {
        List<Sku> skuList = goodService.findSkuBySpuId(spuId);
        if (CollectionUtils.isEmpty(skuList)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(skuList);
    }

    /**
     * 修改商品
     * @param spuBo
     * @return
     */
    @PutMapping("goods")
    public ResponseEntity updateGood(@RequestBody SpuBo spuBo){
        goodService.updateGood(spuBo);
        return ResponseEntity.noContent().build();
    }
}
