package ru.opencode.bankinfo.manuals.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.opencode.bankinfo.manuals.dto.ManualCreationDTO;
import ru.opencode.bankinfo.manuals.entity.Manual;
import ru.opencode.bankinfo.manuals.mapper.ManualMapper;
import ru.opencode.bankinfo.manuals.service.ManualService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/info")
public class ManualController {
    private ManualService manualService;
    private ManualMapper manualMapper;

    @Autowired
    public ManualController(ManualService manualService, ManualMapper manualMapper) {
        this.manualService = manualService;
        this.manualMapper = manualMapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}/manuals")
    public List<Manual> getManualsByInfoId(@PathVariable(value = "id") Long infoId,
                                           @RequestParam(defaultValue = "1", name = "page") Integer pageNo,
                                           @RequestParam(defaultValue = "10", name = "size") Integer pageSize,
                                           @RequestParam(defaultValue = "", name = "code") String code,
                                           @RequestParam(defaultValue = "", name = "description") String description,
                                           @RequestParam(defaultValue = "false", name = "deleted") Boolean isDeleted) {
        return manualService.getManualsByInfoId(infoId, isDeleted, code, description, pageNo, pageSize);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{id}/manuals")
    public void addManual(@PathVariable(value = "id") Long infoId, @Valid @RequestBody ManualCreationDTO manualCreationDTO) {
        manualService.addManual(manualMapper.manualCreationDTOToManual(manualCreationDTO), infoId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/manuals/{id}")
    public void updateManual(@PathVariable(value = "id") Long id, @Valid @RequestBody ManualCreationDTO manualCreationDTO) {
        manualService.updateManual(id, manualCreationDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/manuals/{id}")
    public void deleteManual(@PathVariable(value = "id") Long id) {
        manualService.deleteManual(id);
    }


}
