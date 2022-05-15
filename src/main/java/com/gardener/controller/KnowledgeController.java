package com.gardener.controller;

import com.gardener.bean.Knowledge;
import com.gardener.dto.knowledge.KnowledgeDto;
import com.gardener.service.KnowledgeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 知识维护
 */
@Controller
@RequestMapping("/knowledge")
public class KnowledgeController {

    @Resource
    private KnowledgeService knowledgeService;

    @PostMapping("/save")
    public String save(KnowledgeDto knowledgeDto, Model model) {
        this.knowledgeService.save(knowledgeDto);
        model.addAttribute("detail", knowledgeDto.toKnowledge());
        return "knowledge/detailView";
    }

    @GetMapping("/view")
    public String view(KnowledgeDto knowledgeDto, Model model) {
        Knowledge knowledge = this.knowledgeService.get(knowledgeDto);
        model.addAttribute("detail", knowledge);
        return "knowledge/detailView";
    }

    @GetMapping("/edit")
    public String detail(KnowledgeDto knowledgeDto, Model model) {
        Knowledge knowledge = this.knowledgeService.get(knowledgeDto);
        model.addAttribute("detail", knowledge);
        return "knowledge/detailEdit";
    }
}
