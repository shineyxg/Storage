package com.shine.storage.rest.web;

import com.shine.storage.common.utils.ApiResult;
import com.shine.storage.dao.dto.GoodsSaveInfoDTO;
import com.shine.storage.dao.mapper.GoodsMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年12月11日 11:21
 */
@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    private GoodsMapper goodsMapper;


    @ApiOperation(value = "保存货物信息")
    @PostMapping("/saveGoodsInfo")
    public ApiResult insertGoodsInfo(@ApiParam @RequestBody GoodsSaveInfoDTO goodsInfo){
        goodsInfo.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));
        int count = goodsMapper.saveGoods(goodsInfo);
        if (count==0)
            return ApiResult.failed("货物信息保存失败");
        return ApiResult.success(count);
    }
}
