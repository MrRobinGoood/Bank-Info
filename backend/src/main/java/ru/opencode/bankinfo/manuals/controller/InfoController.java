package ru.opencode.bankinfo.manuals.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.opencode.bankinfo.manuals.dto.InfoCreationDTO;
import ru.opencode.bankinfo.manuals.entity.Info;
import ru.opencode.bankinfo.manuals.mapper.InfoMapper;
import ru.opencode.bankinfo.manuals.service.InfoService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/info")
public class InfoController {

    private InfoService infoService;
    private InfoMapper infoMapper;

    @Autowired
    public InfoController(InfoService infoService, InfoMapper infoMapper) {
        this.infoService = infoService;
        this.infoMapper = infoMapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Info> getAllInfo() {
        return infoService.getAllInfo();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createInfo(@Valid @RequestBody InfoCreationDTO infoCreationDTO) {
        Info info = infoMapper.infoCreationDTOToInfo(infoCreationDTO);
        infoService.createInfo(info);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInfo(@PathVariable(value = "id") Long id, @Valid @RequestBody InfoCreationDTO infoCreationDTO) {
        infoService.updateInfo(id, infoCreationDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInfo(@PathVariable(value = "id") Long id) {
        infoService.deleteInfo(id);
    }
}
