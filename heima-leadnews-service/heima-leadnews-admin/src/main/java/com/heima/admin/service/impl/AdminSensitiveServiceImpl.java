package com.heima.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.admin.mapper.AdminSensitiveMapper;
import com.heima.admin.service.AdminSensitiveService;
import com.heima.model.admin.pojos.AdSensitive;
import com.heima.model.common.dtos.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class AdminSensitiveServiceImpl extends ServiceImpl<AdminSensitiveMapper, AdSensitive> implements AdminSensitiveService {

    @Autowired
    private AdminSensitiveMapper adminSensitiveMapper;

    @Override
    public ResponseResult savesensitive(AdSensitive adSensitive) {
        adminSensitiveMapper.insert(adSensitive);
        return ResponseResult.okResult(adSensitive);
    }
}
