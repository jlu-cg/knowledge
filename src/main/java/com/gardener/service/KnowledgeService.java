package com.gardener.service;

import com.gardener.bean.Knowledge;
import com.gardener.repository.KnowledgeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class KnowledgeService extends BaseService<Knowledge> {

    @Resource
    private KnowledgeRepository knowledgeRepository;

    @Override
    protected KnowledgeRepository getJpaRepository() {
        return knowledgeRepository;
    }
}
