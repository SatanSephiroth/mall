package com.mall.item.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @author YZO
 * @date 2020/2/20 8:58
 */
@TableName("tb_sku")
public class Sku {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long spuId;
    private String title;
    private String images;
    private Long price;
    private String indexes;
    private String ownSpec;
    private Boolean enable;
    private Date createTime;
    private Date lastUpdateTime;
    @TableField(exist = false)
    private Integer stock;

    public Sku(Long id, Long spuId, String title, String images, Long price, String indexes, String ownSpec, Boolean enable, Date createTime, Date lastUpdateTime, Integer stock) {
        this.id = id;
        this.spuId = spuId;
        this.title = title;
        this.images = images;
        this.price = price;
        this.indexes = indexes;
        this.ownSpec = ownSpec;
        this.enable = enable;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
        this.stock = stock;
    }

    public Sku() {
    }

    public Long getId() {
        return this.id;
    }

    public Long getSpuId() {
        return this.spuId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getImages() {
        return this.images;
    }

    public Long getPrice() {
        return this.price;
    }

    public String getIndexes() {
        return this.indexes;
    }

    public String getOwnSpec() {
        return this.ownSpec;
    }

    public Boolean getEnable() {
        return this.enable;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public Integer getStock() {
        return this.stock;
    }

    public Sku setId(Long id) {
        this.id = id;
        return this;
    }

    public Sku setSpuId(Long spuId) {
        this.spuId = spuId;
        return this;
    }

    public Sku setTitle(String title) {
        this.title = title;
        return this;
    }

    public Sku setImages(String images) {
        this.images = images;
        return this;
    }

    public Sku setPrice(Long price) {
        this.price = price;
        return this;
    }

    public Sku setIndexes(String indexes) {
        this.indexes = indexes;
        return this;
    }

    public Sku setOwnSpec(String ownSpec) {
        this.ownSpec = ownSpec;
        return this;
    }

    public Sku setEnable(Boolean enable) {
        this.enable = enable;
        return this;
    }

    public Sku setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Sku setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    public Sku setStock(Integer stock) {
        this.stock = stock;
        return this;
    }

    @Override
    public String toString() {
        return "Sku(id=" + this.getId() + ", spuId=" + this.getSpuId() + ", title=" + this.getTitle() + ", images=" + this.getImages() + ", price=" + this.getPrice() + ", indexes=" + this.getIndexes() + ", ownSpec=" + this.getOwnSpec() + ", enable=" + this.getEnable() + ", createTime=" + this.getCreateTime() + ", lastUpdateTime=" + this.getLastUpdateTime() + ", stock=" + this.getStock() + ")";
    }
}

