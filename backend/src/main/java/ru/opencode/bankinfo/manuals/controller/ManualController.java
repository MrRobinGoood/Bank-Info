package ru.opencode.bankinfo.manuals.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.opencode.bankinfo.manuals.dto.ManualDTO;
import ru.opencode.bankinfo.manuals.mapper.ManualMapper;
import ru.opencode.bankinfo.manuals.service.ManualService;

import java.util.List;
import java.util.Optional;

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
    public List<ManualDTO> getManualsByInfoId(@PathVariable(value = "id") Long infoId,
                                              @RequestParam(defaultValue = "0", name = "page") Integer pageNo,
                                              @RequestParam(defaultValue = "10", name = "size") Integer pageSize,
                                              @RequestParam(defaultValue = "id") String sortBy)

                                               {
        return manualMapper.manualsToDTO(manualService.getManualsByInfoId(infoId, pageNo,pageSize, sortBy));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{id}/manuals")
    public void addManual(@PathVariable(value = "id") Long infoId, @Valid @RequestBody ManualDTO manualDTO) {
        manualService.addManual(manualMapper.dtoToManual(manualDTO), infoId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/manuals/{id}")
    public void updateManual(@PathVariable(value = "id") Long id, @Valid @RequestBody ManualDTO manualDTO) {
        manualDTO.setId(id);
        manualService.updateManual(manualDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/manuals/{id}")
    public void deleteManual(@PathVariable(value = "id") Long id) {
        manualService.deleteManual(id);
    }


}
