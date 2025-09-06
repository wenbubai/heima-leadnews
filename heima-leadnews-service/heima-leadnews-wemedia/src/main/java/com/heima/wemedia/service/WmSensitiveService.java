package com.heima.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.admin.pojos.AdSensitive;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.SensitiveDto;
import com.heima.model.wemedia.pojos.WmSensitive;
import org.springframework.web.bind.annotation.PathVariable;

public interface WmSensitiveService extends IService<WmSensitive> {

    public ResponseResult savesensitive(WmSensitive wmSensitive);
    public ResponseResult updatesensitive(WmSensitive wmSensitive);

    public ResponseResult listsensitive(SensitiveDto sensitiveDto);

    public ResponseResult delsensitive(Integer id);
}
