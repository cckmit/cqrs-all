package com.honc.cqrs.cqrsall.cqrs.command;

import com.alibaba.sofa.dto.Command;
import lombok.Data;

/**
 * @author honc.z
 * @date 2019/4/3
 */
@Data
public class InsertKeywordCmd extends Command {
    private String keyword;
}
