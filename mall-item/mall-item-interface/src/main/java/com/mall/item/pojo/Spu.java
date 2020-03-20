package com.mall.item.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @author YZO
 * @date 2020/2/6 19:53
 */
@TableName("tb_spu")
public class Spu {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String title;
    private String subTitle;
    private Long cid1;
    private Long cid2;
    private Long cid3;
    private Long brandId;
    private Boolean saleable;
    private Boolean valid;
    private Date createTime;
    private Date lastUpdateTime;

    public Spu(Long id, String title, String subTitle, Long cid1, Long cid2, Long cid3, Long brandId, Boolean saleable, Boolean valid, Date createTime, Date lastUpdateTime) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.cid1 = cid1;
        this.cid2 = cid2;
        this.cid3 = cid3;
        this.brandId = brandId;
        this.saleable = saleable;
        this.valid = valid;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
    }

    public Spu() {
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public Long getCid1() {
        return this.cid1;
    }

    public Long getCid2() {
        return this.cid2;
    }

    public Long getCid3() {
        return this.cid3;
    }

    public Long getBrandId() {
        return this.brandId;
    }

    public Boolean getSaleable() {
        return this.saleable;
    }

    public Boolean getValid() {
        return this.valid;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public Spu setId(Long id) {
        this.id = id;
        return this;
    }

    public Spu setTitle(String title) {
        this.title = title;
        return this;
    }

    public Spu setSubTitle(String subTitle) {
        this.subTitle = subTitle;
        return this;
    }

    public Spu setCid1(Long cid1) {
        this.cid1 = cid1;
        return this;
    }

    public Spu setCid2(Long cid2) {
        this.cid2 = cid2;
        return this;
    }

    public Spu setCid3(Long cid3) {
        this.cid3 = cid3;
        return this;
    }

    public Spu setBrandId(Long brandId) {
        this.brandId = brandId;
        return this;
    }

    public Spu setSaleable(Boolean saleable) {
        this.saleable = saleable;
        return this;
    }

    public Spu setValid(Boolean valid) {
        this.valid = valid;
        return this;
    }

    public Spu setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Spu setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    @Override
    public String toString() {
        return "Spu(id=" + this.getId() + ", title=" + this.getTitle() + ", subTitle=" + this.getSubTitle() + ", cid1=" + this.getCid1() + ", cid2=" + this.getCid2() + ", cid3=" + this.getCid3() + ", brandId=" + this.getBrandId() + ", saleable=" + this.getSaleable() + ", valid=" + this.getValid() + ", createTime=" + this.getCreateTime() + ", lastUpdateTime=" + this.getLastUpdateTime() + ")";
    }
}
