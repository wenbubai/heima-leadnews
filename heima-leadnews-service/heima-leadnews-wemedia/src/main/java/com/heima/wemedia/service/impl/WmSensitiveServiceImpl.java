package com.heima.wemedia.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.admin.pojos.AdSensitive;
import com.heima.model.common.dtos.PageResponseResult;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.wemedia.dtos.SensitiveDto;
import com.heima.model.wemedia.pojos.WmMaterial;
import com.heima.model.wemedia.pojos.WmSensitive;
import com.heima.wemedia.mapper.WmSensitiveMapper;
import com.heima.wemedia.service.WmSensitiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
@Transactional
public class WmSensitiveServiceImpl extends ServiceImpl<WmSensitiveMapper, WmSensitive> implements WmSensitiveService {

    @Autowired
    private WmSensitiveMapper wmSensitiveMapper;

    @Override
    public ResponseResult savesensitive(WmSensitive wmSensitive) {
        if (wmSensitive== null || wmSensitive.getSensitives() == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }

        wmSensitive.setCreatedTime(new Date());
        save(wmSensitive);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult updatesensitive(WmSensitive wmSensitive) {
        if (wmSensitive== null || wmSensitive.getSensitives() == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }

        // 检查主键是否存在
        if (wmSensitive.getId() == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
            // 自定义一个表示更新主键缺失的错误码枚举
        }

        wmSensitive.setCreatedTime(new Date());
        updateById(wmSensitive);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult listsensitive(SensitiveDto sensitiveDto) {

        //1.检查参数
        sensitiveDto.checkParam();

        //2.分页查询
        IPage page = new Page(sensitiveDto.getPage(),sensitiveDto.getSize());
        LambdaQueryWrapper<WmSensitive> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        if(sensitiveDto.getName() != null){
            lambdaQueryWrapper.like(WmSensitive::getSensitives,sensitiveDto.getName());
        }

        page = page(page,lambdaQueryWrapper);

        //3.结果返回
        ResponseResult responseResult = new PageResponseResult(sensitiveDto.getPage(),sensitiveDto.getSize(),(int)page.getTotal());
        responseResult.setData(page.getRecords());

        return responseResult;
    }

    @Override
    public ResponseResult delsensitive(Integer id) {
        if(id == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        removeById(id);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}
