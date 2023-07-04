package ru.opencode.bankinfo.messages.dto.subDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import ru.opencode.bankinfo.adapter.LocalDateAdapter;
import ru.opencode.bankinfo.messages.entity.subClass.Audit;
import ru.opencode.bankinfo.messages.entity.subClass.Rstr;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
    private Integer idP;

    @NonNull
    @NotBlank
    @XmlAttribute(name = "NameP")
    @Size(max = 160)
    private String nameP;
    @XmlAttribute(name = "RegN")
    @Size(max = 9)
    private String regN;
    @XmlAttribute(name = "CntrCd")
    @Size(min = 2, max = 2)
    private String cntrCd;

    @NonNull
    @XmlAttribute(name = "Rgn")
    @Size(max = 2)
    private Integer rgn;
    @XmlAttribute(name = "Ind")
    @Size(max = 6)
    private Integer ind;
    @XmlAttribute(name = "Tnp")
    @Size(max = 5)
    private String tnp;
    @XmlAttribute(name = "Nnp")
    @Size(max = 25)
    private String nnp;
    @XmlAttribute(name = "Adr")
    @Size(max = 160)
    private String adr;
    @XmlAttribute(name = "PrntBIC")
    @Size(min = 9, max = 9)
    private String prntBic;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlAttribute(name = "DateIn")
    @NonNull
    private LocalDate dateIn;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlAttribute(name = "DateOut")
    private LocalDate dateOut;

    @NonNull
    @XmlAttribute(name = "PtType")
    @Size(max = 2)
    private Byte ptType;

    @NonNull
    @XmlAttribute(name = "Srvcs")
    @Size(max = 1)
    private Byte srvcs;

    @NonNull
    @XmlAttribute(name = "XchType")
    @Size(max = 1)
    private Byte xchType;

    @NonNull
    @NotBlank
    @XmlAttribute(name = "UID")
    @Size(min = 10, max = 10)
    private String UID;
    @XmlAttribute(name = "ParticipantStatus")
    @Size(min = 4, max = 4)
    private String participantStatus;
    @XmlElement(name = "RstrList", namespace = "urn:cbr-ru:ed:v2.0")
    List<Rstr> rstrList;

    private Boolean isDeletedP = false;

    @NonNull
    private Long createdByP;

    @NonNull
    private LocalDateTime createDateTimeP;

    private Long changeByP;

    private LocalDateTime changeDateTimeP;
    @XmlElement(name = "SWBICS", namespace = "urn:cbr-ru:ed:v2.0")
    private Set<SWBICDTO> swbics;
    @XmlElement(name = "Accounts", namespace = "urn:cbr-ru:ed:v2.0")
    private Set<AccountDTO> accounts;

    @Embedded
    private Audit auditFields;
}
