package com.shine.storage.dao.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年12月10日 23:24
 */
@Data
public class GoodsSaveInfoDTO {

    @ApiModelProperty(value = "货物名",required = true)
    private String goodsName;

    @ApiModelProperty(value = "货物类型")
    private Integer goodsTypeId;

    @ApiModelProperty(value = "货物编码",required = true)
    private String goodsIdentifier;

    @ApiModelProperty(value = "货物数量",required = true)
    private Integer goodsQuantity;

    @ApiModelProperty(value = "异常货物数量",required = true)
    private Integer damageQuantity;

    @ApiModelProperty(value = "创建人id",required = true)
    private Integer createPersonId;

    @ApiModelProperty(value = "创建时间（不需要作为入参）", hidden = true,required = false)
    private String createTime;

    @ApiModelProperty(value = "仓库id",required = true)
    private Integer storageId;

    @ApiModelProperty(value = "英文名", required = false)
    private String egName;

    /*Id
goods_name
goods_type
goods_identifier
goods_quantity
damage_quantity
create_person_id
create_time
storage_id
eg_name*/
}
