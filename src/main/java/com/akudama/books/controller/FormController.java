package com.akudama.books.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.akudama.books.controller.exceptions.ItemNotFoundException;
import com.akudama.books.domain.dto.FormDto;
import com.akudama.books.domain.entity.Form;
import com.akudama.books.mapper.ModelConverter;
import com.akudama.books.service.FormDbService;
import java.util.List;
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
@RequestMapping("v1/forms")
public class FormController {

    private final FormDbService service;
    private final ModelConverter modelConverter;

    @Autowired
    public FormController(FormDbService service, ModelConverter modelConverter) {
        this.service = service;
        this.modelConverter = modelConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<FormDto> getForms() {
        return modelConverter.convertToDtoList(service.getAllForms(), FormDto.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{formId}")
    public FormDto getForm(@PathVariable long formId) {
        return modelConverter.convertToDto(
                service.getForm(formId).orElseThrow(ItemNotFoundException::new),
                FormDto.class
        );
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.DELETE, value = "{formId}")
    public void deleteForm(@PathVariable long formId) {
        service.deleteForm(formId);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.PUT)
    public FormDto updateForm(@RequestBody FormDto form) {
        return modelConverter.convertToDto(
                service.saveForm(modelConverter.convertToEntity(form, Form.class)),
                FormDto.class
        );
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createForm(@RequestBody FormDto form) {
        service.saveForm(modelConverter.convertToEntity(form, Form.class));
    }
}
