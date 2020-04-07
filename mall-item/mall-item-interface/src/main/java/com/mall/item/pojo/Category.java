package com.mall.item.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author XiaoJack
 * @date 2020/1/23
 */
@TableName("tb_category")
public class Category {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Long parentId;
    @TableField("is_parent")
    private Boolean bolIsParent;
    private Integer sort;

    public Category(Long id, String name, Long parentId, Boolean bolIsParent, Integer sort) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.bolIsParent = bolIsParent;
        this.sort = sort;
    }

    public Category() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public Boolean getBolIsParent() {
        return this.bolIsParent;
    }

    public Integer getSort() {
        return this.sort;
    }

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public Category setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public Category setBolIsParent(Boolean bolIsParent) {
        this.bolIsParent = bolIsParent;
        return this;
    }

    public Category setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    @Override
    public String toString() {
        return "Category(id=" + this.getId() + ", name=" + this.getName() + ", parentId=" + this.getParentId() + ", isParent=" + this.getBolIsParent() + ", sort=" + this.getSort() + ")";
    }
}
