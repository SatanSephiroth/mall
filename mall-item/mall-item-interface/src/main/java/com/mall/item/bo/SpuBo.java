package com.mall.item.bo;

import com.mall.item.pojo.Spu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
}
