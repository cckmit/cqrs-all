package com.honc.cqrs.cqrsall.service.impl;

import com.alibaba.sofa.command.CommandBus;
import com.alibaba.sofa.dto.Response;
import com.honc.cqrs.cqrsall.cqrs.command.InsertKeywordCmd;
import com.honc.cqrs.cqrsall.cqrs.query.GetKeywordQry;
import com.honc.cqrs.cqrsall.service.KeywordHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author honc.z
 * @date 2019/3/5
 */
@Service
public class KeywordHandleServiceImpl implements KeywordHandleService {
    @Autowired
    private CommandBus commandBus;


    @Override
    public Response queryKeyword() {
        GetKeywordQry getKeywordQry = new GetKeywordQry();
        return commandBus.send(getKeywordQry);
    }

    @Override
    public Response insertKeyword(String keyword) {
        InsertKeywordCmd insertKeywordCmd = new InsertKeywordCmd();
        insertKeywordCmd.setKeyword(keyword);
        return commandBus.send(insertKeywordCmd);
    }
}
