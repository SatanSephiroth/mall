package com.mall.item.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

/**
 * @author YZO
 * @date 2020/2/4 16:12
 */
@TableName("tb_spec_group")
public class SpecGroup {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long cid;
    private String name;
    @TableField(exist = false)
    private List<SpecParam> params;

    public SpecGroup(Long id, Long cid, String name, List<SpecParam> params) {
        this.id = id;
        this.cid = cid;
        this.name = name;
        this.params = params;
    }

    public SpecGroup() {
    }

    public Long getId() {
        return this.id;
    }

    public Long getCid() {
        return this.cid;
    }

    public String getName() {
        return this.name;
    }

    public List<SpecParam> getParams() {
        return this.params;
    }

    public SpecGroup setId(Long id) {
        this.id = id;
        return this;
    }

    public SpecGroup setCid(Long cid) {
        this.cid = cid;
        return this;
    }

    public SpecGroup setName(String name) {
        this.name = name;
        return this;
    }

    public SpecGroup setParams(List<SpecParam> params) {
        this.params = params;
        return this;
    }

    @Override
    public String toString() {
        return "SpecGroup(id=" + this.getId() + ", cid=" + this.getCid() + ", name=" + this.getName() + ", params=" + this.getParams() + ")";
    }
}
