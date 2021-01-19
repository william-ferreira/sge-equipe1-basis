package com.basis.sge.sge.utils;

import com.basis.sge.sge.servico.EmailServico;
import com.basis.sge.sge.servico.dto.EmailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailUtils {
    private final EmailServico emailServico;

    public void enviarEmail(String destinatario, String corpo, String assunto){
        EmailDTO email = new EmailDTO();

        email.setDestinatario(destinatario);
        email.setCorpo(corpo);
        email.setAssunto(assunto);

        emailServico.sendMail(email);
    }
}
