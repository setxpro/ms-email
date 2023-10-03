package com.ms.email.models;

import com.ms.email.dtos.EmailDTO;
import com.ms.email.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TB_EMAIL")
public class EmailModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailId;
    private String ownerRef; // id do usuário para quem será enviado o email
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT") // envia mais caracteres no caso... mais do que 255
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;

    public EmailModel(EmailDTO emailDTO) {
        this.ownerRef = emailDTO.ownerRef();
        this.emailFrom = emailDTO.emailFrom();
        this.emailTo = emailDTO.emailTo();
        this.subject = emailDTO.subject();
        this.text = emailDTO.text();
    }
}
