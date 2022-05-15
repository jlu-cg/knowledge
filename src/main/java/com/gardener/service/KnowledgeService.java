package com.gardener.service;

import com.gardener.bean.Knowledge;
import com.gardener.dto.knowledge.KnowledgeDto;
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

    public Knowledge save(KnowledgeDto knowledgeDto) {
        return this.knowledgeRepository.save(knowledgeDto.toKnowledge());
    }

    public Knowledge get(KnowledgeDto knowledgeDto) {
        if (knowledgeDto.getId() == null) {
            return new Knowledge();
        }
        return this.knowledgeRepository.findById(knowledgeDto.getId()).get();
    }
}
