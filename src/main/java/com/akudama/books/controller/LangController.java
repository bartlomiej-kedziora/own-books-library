package com.akudama.books.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.akudama.books.domain.dto.LangDto;
import com.akudama.books.mapper.LangMapper;
import com.akudama.books.service.LangDbService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/langs")
public class LangController {

    private final LangDbService service;
    private final LangMapper langMapper;

    @Autowired
    public LangController(LangDbService service, LangMapper langMapper) {
        this.service = service;
        this.langMapper = langMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<LangDto> getLangs() {
        return langMapper.mapToLangDtoList(service.getAllLangs());
    }

    @RequestMapping(method = RequestMethod.GET, value = "{langId}")
    public LangDto getLang(@PathVariable long langId) {
        return langMapper
                .mapToLangDto(service.getLang(langId).orElseThrow(ItemNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{langId}")
    public void deleteLang(@PathVariable long langId) {
        service.deleteLang(langId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public LangDto updateLang(@RequestBody LangDto langDto) {
        return langMapper.mapToLangDto(
                service.saveLang(langMapper.mapToLang(langDto))
        );
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createLang(@RequestBody LangDto langDto) {
        service.saveLang(langMapper.mapToLang(langDto));
    }
}
