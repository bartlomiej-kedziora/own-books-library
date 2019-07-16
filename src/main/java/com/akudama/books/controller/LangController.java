package com.akudama.books.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.akudama.books.controller.exceptions.ItemNotFoundException;
import com.akudama.books.domain.dto.LangDto;
import com.akudama.books.domain.entity.Lang;
import com.akudama.books.mapper.ModelConverter;
import com.akudama.books.service.LangDbService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/langs")
public class LangController {

    private final LangDbService service;
    private final ModelConverter modelConverter;

    @Autowired
    public LangController(LangDbService service, ModelConverter modelConverter) {
        this.service = service;
        this.modelConverter = modelConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Set<LangDto> getLangs() {
        return modelConverter.convertToDtoSet(service.getAllLangs(), LangDto.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{langId}")
    public LangDto getLang(@PathVariable long langId) {
        return modelConverter
                .convertToDto(service.getLang(langId).orElseThrow(ItemNotFoundException::new), LangDto.class);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.DELETE, value = "{langId}")
    public void deleteLang(@PathVariable long langId) {
        service.deleteLang(langId);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.PUT)
    public LangDto updateLang(@RequestBody LangDto lang) {
        return modelConverter.convertToDto(
                service.saveLang(modelConverter.convertToEntity(lang, Lang.class)), LangDto.class
        );
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createLang(@RequestBody LangDto lang) {
        service.saveLang(modelConverter.convertToEntity(lang, Lang.class));
    }
}
