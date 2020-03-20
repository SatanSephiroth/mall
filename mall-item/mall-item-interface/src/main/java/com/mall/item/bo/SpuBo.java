package com.mall.item.bo;

import com.mall.item.pojo.Sku;
import com.mall.item.pojo.Spu;
import com.mall.item.pojo.SpuDetail;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author YZO
 * @date 2020/2/6 20:14
 */
@Accessors(chain = true)
public class SpuBo extends Spu {
    private String bname;
    private String cname;
    private SpuDetail spuDetail;
    private List<Sku> skus;

    public SpuBo(String bname, String cname, SpuDetail spuDetail, List<Sku> skus) {
        this.bname = bname;
        this.cname = cname;
        this.spuDetail = spuDetail;
        this.skus = skus;
    }

    public SpuBo() {
    }

    public String getBname() {
        return this.bname;
    }

    public String getCname() {
        return this.cname;
    }

    public SpuDetail getSpuDetail() {
        return this.spuDetail;
    }

    public List<Sku> getSkus() {
        return this.skus;
    }

    public SpuBo setBname(String bname) {
        this.bname = bname;
        return this;
    }

    public SpuBo setCname(String cname) {
        this.cname = cname;
        return this;
    }

    public SpuBo setSpuDetail(SpuDetail spuDetail) {
        this.spuDetail = spuDetail;
        return this;
    }

    public SpuBo setSkus(List<Sku> skus) {
        this.skus = skus;
        return this;
    }

    @Override
    public String toString() {
        return "SpuBo(bname=" + this.getBname() + ", cname=" + this.getCname() + ", spuDetail=" + this.getSpuDetail() + ", skus=" + this.getSkus() + ")";
    }
}
