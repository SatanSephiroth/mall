package com.mall.item.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author YZO
 * @date 2020/1/23 20:23
 */
@TableName("tb_Brand")
public class Brand {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String image;
    private Character letter;

    public Brand(Long id, String name, String image, Character letter) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.letter = letter;
    }

    public Brand() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getImage() {
        return this.image;
    }

    public Character getLetter() {
        return this.letter;
    }

    public Brand setId(Long id) {
        this.id = id;
        return this;
    }

    public Brand setName(String name) {
        this.name = name;
        return this;
    }

    public Brand setImage(String image) {
        this.image = image;
        return this;
    }

    public Brand setLetter(Character letter) {
        this.letter = letter;
        return this;
    }

    @Override
    public String toString() {
        return "Brand(id=" + this.getId() + ", name=" + this.getName() + ", image=" + this.getImage() + ", letter=" + this.getLetter() + ")";
    }
}
