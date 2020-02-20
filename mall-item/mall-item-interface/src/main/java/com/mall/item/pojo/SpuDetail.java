package com.mall.item.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author YZO
 * @date 2020/2/6 19:57
 */
@TableName("tb_spu_detail")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SpuDetail {
    @TableId
    private Long spuId;
    private String description;
    private String genericSpec;
    private String  specialSpec;
    private String packingList;
    private String afterService;
}
