package com.heima.wemedia.controller.v1;


import com.heima.model.admin.pojos.AdSensitive;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.SensitiveDto;
import com.heima.model.wemedia.pojos.WmSensitive;
import com.heima.wemedia.service.WmSensitiveService;
import com.mysql.fabric.xmlrpc.base.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sensitive")
public class WmSensitiveController {

    @Autowired
    private WmSensitiveService wmSensitiveService;

    @PostMapping("/save")
    public ResponseResult savesensitive(@RequestBody WmSensitive wmSensitive){

        return wmSensitiveService.savesensitive(wmSensitive);
    }

    @PostMapping("/update")
    public ResponseResult updatesensitive(@RequestBody WmSensitive wmSensitive){

        return wmSensitiveService.updatesensitive(wmSensitive);
    }

    @PostMapping("/list")
    public ResponseResult listsensitive(@RequestBody SensitiveDto sensitiveDto){

        return wmSensitiveService.listsensitive(sensitiveDto);
    }

    @DeleteMapping("/del/{id}")
    public ResponseResult delsensitive(@PathVariable("id") Integer id){

        return wmSensitiveService.delsensitive(id);
    }


}
