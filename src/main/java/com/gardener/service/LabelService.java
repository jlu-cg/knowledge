package com.gardener.service;

import com.gardener.bean.Label;
import com.gardener.repository.LabelRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LabelService extends BaseService<Label> {

    private LabelRepository labelRepository;

    @Override
    protected JpaRepository<Label, ?> getJpaRepository() {
        return labelRepository;
    }
}
