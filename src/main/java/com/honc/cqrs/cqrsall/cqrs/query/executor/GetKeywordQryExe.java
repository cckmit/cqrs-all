package com.honc.cqrs.cqrsall.cqrs.query.executor;

import com.alibaba.sofa.command.Command;
import com.alibaba.sofa.command.CommandExecutorI;
import com.alibaba.sofa.dto.Response;
import com.alibaba.sofa.util.YsResponseUtil;
import com.honc.cqrs.cqrsall.cqrs.query.GetKeywordQry;
import com.honc.cqrs.cqrsall.dataobject.KeywordDo;
import com.honc.cqrs.cqrsall.mapper.KeywordDoMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author honc.z
 * @date 2019/4/3
 */
@Command
public class GetKeywordQryExe implements CommandExecutorI<Response, GetKeywordQry> {
    @Autowired
    private KeywordDoMapper keywordDoMapper;

    @Override
    public Response execute(GetKeywordQry cmd) {
        KeywordDo keywordDo = keywordDoMapper.selectByPrimaryKey("aa");
        return YsResponseUtil.getSuccessResponse(keywordDo,"1.0.0");
    }
}
