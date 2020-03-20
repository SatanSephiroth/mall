package com.mall.item.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author YZO
 * @date 2020/2/6 19:57
 */
@TableName("tb_spu_detail")
public class SpuDetail {
    @TableId
    private Long spuId;
    private String description;
    private String genericSpec;
    private String  specialSpec;
    private String packingList;
    private String afterService;

    public SpuDetail(Long spuId, String description, String genericSpec, String specialSpec, String packingList, String afterService) {
        this.spuId = spuId;
        this.description = description;
        this.genericSpec = genericSpec;
        this.specialSpec = specialSpec;
        this.packingList = packingList;
        this.afterService = afterService;
    }

    public SpuDetail() {
    }

    public Long getSpuId() {
        return this.spuId;
    }

    public String getDescription() {
        return this.description;
    }

    public String getGenericSpec() {
        return this.genericSpec;
    }

    public String getSpecialSpec() {
        return this.specialSpec;
    }

    public String getPackingList() {
        return this.packingList;
    }

    public String getAfterService() {
        return this.afterService;
    }

    public SpuDetail setSpuId(Long spuId) {
        this.spuId = spuId;
        return this;
    }

    public SpuDetail setDescription(String description) {
        this.description = description;
        return this;
    }

    public SpuDetail setGenericSpec(String genericSpec) {
        this.genericSpec = genericSpec;
        return this;
    }

    public SpuDetail setSpecialSpec(String specialSpec) {
        this.specialSpec = specialSpec;
        return this;
    }

    public SpuDetail setPackingList(String packingList) {
        this.packingList = packingList;
        return this;
    }

    public SpuDetail setAfterService(String afterService) {
        this.afterService = afterService;
        return this;
    }

    @Override
    public String toString() {
        return "SpuDetail(spuId=" + this.getSpuId() + ", description=" + this.getDescription() + ", genericSpec=" + this.getGenericSpec() + ", specialSpec=" + this.getSpecialSpec() + ", packingList=" + this.getPackingList() + ", afterService=" + this.getAfterService() + ")";
    }
}
