package ru.opencode.bankinfo.manuals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.opencode.bankinfo.manuals.dto.InfoCreationDTO;
import ru.opencode.bankinfo.manuals.entity.Info;
import ru.opencode.bankinfo.manuals.exception.InfoNotFoundException;
import ru.opencode.bankinfo.manuals.mapper.InfoMapper;
import ru.opencode.bankinfo.manuals.repository.InfoRepository;

import java.util.List;

@Service
public class InfoService {
    private InfoRepository infoRepository;
    private InfoMapper infoMapper;

    @Autowired
    public InfoService(InfoRepository infoRepository, InfoMapper infoMapper) {
        this.infoRepository = infoRepository;
        this.infoMapper = infoMapper;
    }

    public Info getInfo(Long id) {
        return infoRepository.findById(id).orElseThrow(() -> new InfoNotFoundException("Info with id: " + id + " not found."));
    }

    public List<Info> getAllInfo() {
        return infoRepository.findAll();
    }

    public void createInfo(Info info) {
        infoRepository.save(info);
    }

    public void updateInfo(Long id, InfoCreationDTO infoCreationDTO) {
        Info info = getInfo(id);
        infoMapper.updateInfoFromInfoCreationDTO(infoCreationDTO, info);
        infoRepository.save(info);
    }
    public void deleteInfo(Long id) {
        Info info = getInfo(id);
        info.setIsDeleted(true);
        infoRepository.save(info);
    }
}
