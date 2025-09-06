package com.heima.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.admin.pojos.AdSensitive;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.WmMaterialDto;
import com.heima.model.wemedia.pojos.WmMaterial;
import org.springframework.web.multipart.MultipartFile;

public interface AdminSensitiveService extends IService<AdSensitive> {


    /*完成增删查改*/
    //新增
    public ResponseResult savesensitive(AdSensitive adSensitive);


}