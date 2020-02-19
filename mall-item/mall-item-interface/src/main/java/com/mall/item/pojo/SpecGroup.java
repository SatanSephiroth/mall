package com.mall.item.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author YZO
 * @date 2020/2/4 16:12
 */
@TableName("tb_spec_group")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SpecGroup {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long cid;
    private String name;
    @TableField(exist = false)
    private List<SpecParam> params;
}
