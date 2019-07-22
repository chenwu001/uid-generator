package com.kj.uid.feign.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kj.common.fo.FeignResult;
import com.kj.uid.feign.UidGeneratorClient;
import com.kj.uid.service.UidGenService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * UID生成服务
 * 
 * @author chenht
 */
@Api(tags = { "UID生成器" })
@RestController
@RequestMapping(value = "feign/generator")
public class UidGeneratorClientImpl implements UidGeneratorClient {

    @Autowired
    private UidGenService uidGenService;

    /**
     * 预先缓存UID的生成器服务：http://localhost:9999/testcacheduid
     * 
     * @return
     */
    @Override
    @ApiOperation("预先缓存UID的生成器")
    public FeignResult<Long> cached() {
        return FeignResult.success(uidGenService.getCachedUid());
    }

    /**
     * UID的生成器服务：http://localhost:9999/testdefaultuid
     * 
     * @return
     */
    @Override
    @ApiOperation("UID的生成器服务")
    public FeignResult<Long> defaultUid() {
        return FeignResult.success(uidGenService.getDefaultUid());
    }
}
