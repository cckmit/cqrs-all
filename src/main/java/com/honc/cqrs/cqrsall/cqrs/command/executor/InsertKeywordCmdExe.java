package com.honc.cqrs.cqrsall.cqrs.command.executor;

import com.alibaba.sofa.command.Command;
import com.alibaba.sofa.command.CommandExecutorI;
import com.alibaba.sofa.dto.Response;
import com.alibaba.sofa.util.YsResponseUtil;
import com.honc.cqrs.cqrsall.cqrs.command.InsertKeywordCmd;
import com.honc.cqrs.cqrsall.dataobject.KeywordDo;
import com.honc.cqrs.cqrsall.mapper.KeywordDoMapper;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author honc.z
 * @date 2019/4/3
 */
@Command
public class InsertKeywordCmdExe implements CommandExecutorI<Response, InsertKeywordCmd> {
    @Autowired
    private KeywordDoMapper keywordDoMapper;

    @Override
    public Response execute(InsertKeywordCmd cmd) {
        String keyword = cmd.getKeyword();
        KeywordDo keywordDo = new KeywordDo();
        keywordDo.setKeyword(keyword);
        keywordDoMapper.insert(keywordDo);
        return YsResponseUtil.getSuccessResponse(null,"1.0.0");
    }
}
