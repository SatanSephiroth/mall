package com.mall.item.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author YZO
 * @date 2020/2/4 16:51
 */
@TableName("tb_spec_param")
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

    public SpecParam(Long id, Long cid, Long groupId, String name, Boolean numeric, String unit, Boolean generic, Boolean searching, String segments) {
        this.id = id;
        this.cid = cid;
        this.groupId = groupId;
        this.name = name;
        this.numeric = numeric;
        this.unit = unit;
        this.generic = generic;
        this.searching = searching;
        this.segments = segments;
    }

    public SpecParam() {
    }

    public Long getId() {
        return this.id;
    }

    public Long getCid() {
        return this.cid;
    }

    public Long getGroupId() {
        return this.groupId;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getNumeric() {
        return this.numeric;
    }

    public String getUnit() {
        return this.unit;
    }

    public Boolean getGeneric() {
        return this.generic;
    }

    public Boolean getSearching() {
        return this.searching;
    }

    public String getSegments() {
        return this.segments;
    }

    public SpecParam setId(Long id) {
        this.id = id;
        return this;
    }

    public SpecParam setCid(Long cid) {
        this.cid = cid;
        return this;
    }

    public SpecParam setGroupId(Long groupId) {
        this.groupId = groupId;
        return this;
    }

    public SpecParam setName(String name) {
        this.name = name;
        return this;
    }

    public SpecParam setNumeric(Boolean numeric) {
        this.numeric = numeric;
        return this;
    }

    public SpecParam setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public SpecParam setGeneric(Boolean generic) {
        this.generic = generic;
        return this;
    }

    public SpecParam setSearching(Boolean searching) {
        this.searching = searching;
        return this;
    }

    public SpecParam setSegments(String segments) {
        this.segments = segments;
        return this;
    }

    @Override
    public String toString() {
        return "SpecParam(id=" + this.getId() + ", cid=" + this.getCid() + ", groupId=" + this.getGroupId() + ", name=" + this.getName() + ", numeric=" + this.getNumeric() + ", unit=" + this.getUnit() + ", generic=" + this.getGeneric() + ", searching=" + this.getSearching() + ", segments=" + this.getSegments() + ")";
    }
}
