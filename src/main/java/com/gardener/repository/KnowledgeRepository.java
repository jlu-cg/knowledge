package com.gardener.repository;

import com.gardener.bean.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnowledgeRepository extends JpaRepository<Knowledge, Integer> {
}
