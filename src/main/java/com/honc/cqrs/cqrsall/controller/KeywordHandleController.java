package com.honc.cqrs.cqrsall.controller;

import com.alibaba.sofa.dto.Response;
import com.honc.cqrs.cqrsall.service.KeywordHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author honc.z
 * @date 2019/2/22
 */
@RequestMapping("/keyword")
@RestController
public class KeywordHandleController {
    @Autowired
    private KeywordHandleService keywordHandleService;

    /**
     *cqrs query查询操作
     */
    @RequestMapping("/cqrs/query")
    public Response queryKeyword(@RequestParam("id")String id){
        return keywordHandleService.queryKeyword();
    }

    /**
     *cqrs command插入操作
     */
    @RequestMapping("/cqrs/insert")
    public Response insertKeyword(@RequestParam("id")String id){
        return keywordHandleService.insertKeyword(id);
    }
}
