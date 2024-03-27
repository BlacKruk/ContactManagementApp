package cma.api.controller;

import cma.api.dto.CreateContactDTO;
import cma.api.dto.ReturnContactDTO;
import cma.api.mapper.CMAMapper;
import cma.api.repository.ContactManagementAppRepository;
import cma.api.service.CMAService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.validation.annotation.Validated;

@Validated
@RestController
public class CMAController {
    private final CMAService contactService;
    private final CMAMapper cmaMapper;
    private final ContactManagementAppRepository repository;

    @Autowired
    public CMAController(CMAService contactService, CMAMapper cmaMapper, ContactManagementAppRepository repository) {
        this.contactService = contactService;
        this.cmaMapper = cmaMapper;
        this.repository = repository;
    }

    @PostMapping("/contacts")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ReturnContactDTO saveContact(@Valid @RequestBody CreateContactDTO contactDto) {

        return contactService.saveContact(contactDto);
    }

    @GetMapping("/contacts/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ReturnContactDTO getContact(@PathVariable("id") Integer id) {

        return contactService.getContact(id);
    }

    @GetMapping("/contacts")
    @ResponseStatus(value = HttpStatus.OK)
    public List<ReturnContactDTO> getContacts(@RequestParam(value = "firstName", required = false) String firstName, @RequestParam(value = "lastName", required = false) String lastName) {

        return contactService.filterContactsUsingJPAQueryMethods(firstName, lastName);
    }

    @PutMapping("/contacts/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ReturnContactDTO update(@PathVariable("id") int id, @Valid @RequestBody CreateContactDTO contactDto) {

        return contactService.updateContact(id, contactDto);
    }

    @DeleteMapping("/contacts/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable("id") int id) {

        contactService.deleteContact(id);
    }
}