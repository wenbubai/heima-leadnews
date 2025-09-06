package com.heima.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.ChannelDto;
import com.heima.model.wemedia.pojos.WmChannel;

public interface WmChannelService extends IService<WmChannel> {

    public ResponseResult listch(ChannelDto channelDto);

    /**
     * 查询所有频道
     * @return
     */
    public ResponseResult findAll();

    /**
     * 修改
     * @param wmChannel
     * @return
     */
    ResponseResult update(WmChannel wmChannel);

    /**
     * 删除
     * @param id
     * @return
     */
    ResponseResult delete(Integer id);

    /**
     * 保存
     * @param wmChannel
     * @return
     */
    ResponseResult insert(WmChannel wmChannel);


}