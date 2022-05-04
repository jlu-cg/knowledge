package com.gardener.service;

import com.gardener.bean.GardenPage;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<T> {

    protected abstract JpaRepository<T, ?> getJpaRepository();

    public T save(T t) {
        return this.getJpaRepository().save(t);
    }

    public GardenPage<T> getPage(GardenPage<T> page) {
        Pageable pageable = toPageRequest(page);
        Page<T> pageData = this.getJpaRepository().findAll(pageable);
        return toGardenPage(pageData, page);
    }

    public GardenPage<T> getPage(Example<T> example, GardenPage<T> page) {
        Pageable pageable = toPageRequest(page);
        Page<T> pageData = this.getJpaRepository().findAll(example, pageable);
        return toGardenPage(pageData, page);
    }

    private Pageable toPageRequest(GardenPage page) {
        Pageable pageable = PageRequest.of(page.getStart() / page.getPageSize(), page.getPageSize());
        return pageable;
    }

    private GardenPage<T> toGardenPage(Page<T> pageData, GardenPage<T> page) {
        page.setPageData(pageData.getContent());
        page.setTotalCount(pageData.getTotalElements());
        return page;
    }
}
