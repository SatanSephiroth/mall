package com.mall.item.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author YZO
 * @date 2020/2/20 9:06
 */
@TableName("tb_stock")
public class Stock {
    @TableId
    private Long skuId;
    private Integer seckillStock;
    private Integer seckillTotal;
    private Integer stock;

    public Stock(Long skuId, Integer seckillStock, Integer seckillTotal, Integer stock) {
        this.skuId = skuId;
        this.seckillStock = seckillStock;
        this.seckillTotal = seckillTotal;
        this.stock = stock;
    }

    public Stock() {
    }

    public Long getSkuId() {
        return this.skuId;
    }

    public Integer getSeckillStock() {
        return this.seckillStock;
    }

    public Integer getSeckillTotal() {
        return this.seckillTotal;
    }

    public Integer getStock() {
        return this.stock;
    }

    public Stock setSkuId(Long skuId) {
        this.skuId = skuId;
        return this;
    }

    public Stock setSeckillStock(Integer seckillStock) {
        this.seckillStock = seckillStock;
        return this;
    }

    public Stock setSeckillTotal(Integer seckillTotal) {
        this.seckillTotal = seckillTotal;
        return this;
    }

    public Stock setStock(Integer stock) {
        this.stock = stock;
        return this;
    }

    @Override
    public String toString() {
        return "Stock(skuId=" + this.getSkuId() + ", seckillStock=" + this.getSeckillStock() + ", seckillTotal=" + this.getSeckillTotal() + ", stock=" + this.getStock() + ")";
    }
}
