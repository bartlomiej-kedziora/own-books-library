package com.akudama.books.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.akudama.books.controller.exceptions.ItemNotFoundException;
import com.akudama.books.domain.dto.FormDto;
import com.akudama.books.mapper.FormMapper;
import com.akudama.books.service.FormDbService;
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
@RequestMapping("v1/forms")
public class FormController {

    private final FormDbService service;
    private final FormMapper formMapper;

    @Autowired
    public FormController(FormDbService service, FormMapper formMapper) {
        this.service = service;
        this.formMapper = formMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<FormDto> getForms() {
        return formMapper.mapToFormDtoList(service.getAllForms());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{formId}")
    public FormDto getForm(@PathVariable long formId) {
        return formMapper
                .mapToFormDto(service.getForm(formId).orElseThrow(ItemNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{formId}")
    public void deleteForm(@PathVariable long formId) {
        service.deleteForm(formId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public FormDto updateForm(@RequestBody FormDto formDto) {
        return formMapper.mapToFormDto(
                service.saveForm(formMapper.mapToForm(formDto))
        );
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createForm(@RequestBody FormDto formDto) {
        service.saveForm(formMapper.mapToForm(formDto));
    }
}
