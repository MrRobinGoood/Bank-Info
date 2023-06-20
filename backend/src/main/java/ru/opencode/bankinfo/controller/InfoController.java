package ru.opencode.bankinfo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.opencode.bankinfo.dto.InfoDTO;
import ru.opencode.bankinfo.entity.Info;
import ru.opencode.bankinfo.mapper.InfoMapper;
import ru.opencode.bankinfo.service.InfoService;

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
    public List<InfoDTO> getAllInfo() {
        return infoMapper.infosToDTO(infoService.getAllInfo()) ;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createInfo(@Valid @RequestBody InfoDTO infoDTO) {
        Info info = infoMapper.dtoToInfo(infoDTO);
        infoService.createInfo(info);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInfo(@PathVariable(value = "id") Long id,@Valid @RequestBody InfoDTO infoDTO){
        infoDTO.setId(id);
        infoService.updateInfo(infoDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInfo(@PathVariable(value = "id") Long id){
        infoService.deleteInfo(id);
    }
}
