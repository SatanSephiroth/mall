package com.mall.item.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author YZO
 * @date 2020/2/20 9:06
 */
@TableName("tb_stock")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @TableId
    private Long skuId;
    private Integer seckillStock;
    private Integer seckillTotal;
    private Integer stock;
}
