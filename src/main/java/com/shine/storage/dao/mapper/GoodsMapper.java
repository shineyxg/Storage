package com.shine.storage.dao.mapper;

import com.shine.storage.dao.dto.GoodsSaveInfoDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年11月30日 15:27
 */
@Mapper
@Repository
public interface GoodsMapper {


    @Insert("insert into goods (goods_name,goods_type_id,goods_identifier,goods_quantity,damage_quantity,create_person_id," +
            "create_time,storage_id,eg_name) value(#{goodsName},#{goodsTypeId},#{goodsIdentifier},#{goodsQuantity},#{damageQuantity}," +
            "#{createPersonId},#{createTime},#{storageId},#{egName})")
    int saveGoods(GoodsSaveInfoDTO goods);

}
