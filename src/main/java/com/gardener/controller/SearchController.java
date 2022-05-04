package com.gardener.controller;

import com.alibaba.fastjson.JSONObject;
import com.gardener.bean.GardenPage;
import com.gardener.bean.Knowledge;
import com.gardener.dto.GardenerResponse;
import com.gardener.dto.search.KnowledgeDto;
import com.gardener.service.KnowledgeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class SearchController {

    private static Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Resource
    private KnowledgeService knowledgeService;

    @PostMapping(path = "/search")
    @ResponseBody
    public GardenerResponse<GardenPage<Knowledge>> search(GardenPage<Knowledge> page, KnowledgeDto knowledgeDto) {
        logger.info("request data:{}", JSONObject.toJSONString(knowledgeDto));
        Knowledge knowledge = new Knowledge();
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("title", ExampleMatcher.GenericPropertyMatcher::contains);
        knowledge.setTitle(knowledgeDto.getSearchText());
        Example<Knowledge> example = Example.of(knowledge, exampleMatcher);
        GardenPage<Knowledge> result = knowledgeService.getPage(example, page);
        GardenerResponse<GardenPage<Knowledge>> response = new GardenerResponse<>();
        response.setData(result);
        return response;
    }
}
