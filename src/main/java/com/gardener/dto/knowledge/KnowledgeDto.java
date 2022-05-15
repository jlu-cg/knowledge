package com.gardener.dto.knowledge;

import com.gardener.bean.Knowledge;

public class KnowledgeDto {

    private Integer id;

    private String title;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Knowledge toKnowledge() {
        Knowledge knowledge = new Knowledge();
        knowledge.setId(id);
        knowledge.setTitle(title);
        knowledge.setContent(content);
        return knowledge;
    }
}
