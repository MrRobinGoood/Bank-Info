package ru.opencode.bankinfo.manuals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.opencode.bankinfo.manuals.dto.ManualDTO;
import ru.opencode.bankinfo.manuals.entity.Info;
import ru.opencode.bankinfo.manuals.entity.Manual;
import ru.opencode.bankinfo.manuals.exception.ManualNotFoundException;
import ru.opencode.bankinfo.manuals.mapper.ManualMapper;
import ru.opencode.bankinfo.manuals.repository.ManualRepository;

import java.util.List;

@Service
public class ManualService {
    private ManualRepository manualRepository;
    private ManualMapper manualMapper;
    private InfoService infoService;

    @Autowired
    public ManualService(ManualRepository manualRepository, ManualMapper manualMapper, InfoService infoService) {
        this.manualRepository = manualRepository;
        this.manualMapper = manualMapper;
        this.infoService = infoService;
    }

    public Manual getManual(Long id) {
        return manualRepository.findById(id).orElseThrow(() -> new ManualNotFoundException("Manual with id: " + id + " not found."));
    }

    public List<Manual> getAllManuals() {
        return manualRepository.findAll();
    }

    public List<Manual> getManualsByInfoId(Long infoId) {
        Info info = infoService.getInfo(infoId);
        return info.getManuals();
    }

    public void addManual(Manual manual, Long infoId) {
        Info info = infoService.getInfo(infoId);
        manual.setInfo(info);
        manualRepository.save(manual);
    }

    public void updateManual(ManualDTO manualDTO) {
        Manual manual = getManual(manualDTO.getId());
        manualMapper.updateManualFromDTO(manualDTO, manual);
        manualRepository.save(manual);
    }

    public void deleteManual(Long id) {
        Manual manual = getManual(id);
        manual.setIsDeleted(true);
        manualRepository.save(manual);
    }


}
