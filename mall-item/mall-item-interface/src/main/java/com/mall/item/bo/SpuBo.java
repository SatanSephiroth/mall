package com.mall.item.bo;

import com.mall.item.pojo.Sku;
import com.mall.item.pojo.Spu;
import com.mall.item.pojo.SpuDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author YZO
 * @date 2020/2/6 20:14
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SpuBo extends Spu {
    private String bname;
    private String cname;
    private SpuDetail spuDetail;
    private List<Sku> skus;
}
