package com.gardener.controller;

import com.gardener.bean.Knowledge;
import com.gardener.dto.knowledge.KnowledgeDto;
import com.gardener.service.KnowledgeService;
import org.springframework.stereotype.Controller;
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
    public ModelAndView save(KnowledgeDto knowledgeDto) {
        this.knowledgeService.save(knowledgeDto);
        ModelAndView mv = new ModelAndView("detailView");
        mv.addObject("detail", knowledgeDto);
        return mv;
    }

    @GetMapping("/view")
    public ModelAndView view(KnowledgeDto knowledgeDto) {
        Knowledge knowledge = this.knowledgeService.get(knowledgeDto);
        ModelAndView mv = new ModelAndView("detailView");
        mv.addObject("detail", knowledge);
        return mv;
    }

    @GetMapping("/edit")
    public ModelAndView detail(KnowledgeDto knowledgeDto) {
        Knowledge knowledge = this.knowledgeService.get(knowledgeDto);
        ModelAndView mv = new ModelAndView("detailEdit");
        mv.addObject("detail", knowledge);
        return mv;
    }
}
