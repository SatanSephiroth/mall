package com.mall.item.controller;

import com.mall.vo.PageResult;
import com.mall.item.bo.SpuBo;
import com.mall.item.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
     * @param key 搜索字段
     * @param saleable 是否上架
     * @param page 页数
     * @param rows 每页行数
     * @return
     */
    @GetMapping("spu/page")//key=&saleable=true&page=1&rows=5
    public ResponseEntity<PageResult<SpuBo>> findSpuByPage(
            @RequestParam(value = "key",required = false) String key,
            @RequestParam(value = "saleable",required = false) Boolean saleable,
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "5") Integer rows
    ){
        PageResult<SpuBo> result = goodService.findSpuByPage(key,saleable,page,rows);
        if (result == null || CollectionUtils.isEmpty(result.getItems()))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }


}
