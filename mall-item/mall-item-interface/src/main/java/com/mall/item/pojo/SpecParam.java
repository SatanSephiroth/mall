package com.mall.item.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author YZO
 * @date 2020/2/4 16:51
 */
@TableName("tb_spec_param")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SpecParam {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long cid;
    private Long groupId;
    private String name;
    @TableField(value = "`numeric`")
    private Boolean numeric;
    private String unit;
    private Boolean generic;
    private Boolean searching;
    private String segments;
}
