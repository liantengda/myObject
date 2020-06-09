package com.lian.myObject.controller;


import com.lian.myObject.common.globalexception.pojo.response.R;
import com.lian.myObject.service.ObjectService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * @author Ted
 * @version 1.0
 * @date 2020/6/2 21:08
 */
@RestController
@RequestMapping(value = "/object")
@Slf4j
@Api(tags = "用户管理接口")
public class ObjectController {

    @Autowired
    ObjectService objectService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public R<List> getOriginSql(){
        List list = objectService.originSqlExecute();
        return new R<>(list);
    }

}
