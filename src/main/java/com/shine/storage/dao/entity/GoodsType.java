package com.shine.storage.dao.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年11月30日 15:21
 */
@Data
public class GoodsType {


    private Integer id;

    @ApiModelProperty(value = "货物种类名称")
    private String typeName;

    @ApiModelProperty(value = "英文名")
    private String egName;


}
