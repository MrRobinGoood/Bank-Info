package ru.opencode.bankinfo.messages.dto.subDTO;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import ru.opencode.bankinfo.core.utils.Audit;

import javax.xml.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "BICDirectoryEntry", namespace = "urn:cbr-ru:ed:v2.0")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntryDTO {
    
    @NonNull
    @NotBlank
    @XmlAttribute(name = "BIC")
    @Size(min = 9, max = 9)
    private String BIC;

    @XmlAttribute(name = "ChangeType")
    @Size(min = 4, max = 4)
    private String changeType;

    @NonNull
    @NotBlank
    @XmlElement(name = "ParticipantInfo", namespace = "urn:cbr-ru:ed:v2.0")
    private ParticipantInfoDTO participantInfoDTO;


    private Boolean isDeletedP = false;

//    @NonNull
    private Long createdByP;

//    @NonNull
    private LocalDateTime createDateTimeP;

    private Long changeByP;

    private LocalDateTime changeDateTimeP;

    @XmlElement(name = "SWBICS", namespace = "urn:cbr-ru:ed:v2.0")
    private List<SWBICDTO> swbics;
    @XmlElement(name = "Accounts", namespace = "urn:cbr-ru:ed:v2.0")
    private List<AccountDTO> accounts;

    @Embedded
    private Audit auditFields;
}
