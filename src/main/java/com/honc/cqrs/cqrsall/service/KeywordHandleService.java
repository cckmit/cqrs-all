package com.honc.cqrs.cqrsall.service;

import com.alibaba.sofa.dto.Response;

import java.util.List;

/**
 * @author honc.z
 * @date 2019/3/5
 */
public interface KeywordHandleService {

    Response queryKeyword();

    Response insertKeyword(String keyword);
}
