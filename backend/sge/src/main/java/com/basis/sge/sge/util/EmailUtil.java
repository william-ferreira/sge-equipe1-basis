package com.basis.sge.sge.util;

import com.basis.sge.sge.servico.EmailServico;
import com.basis.sge.sge.servico.dto.EmailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailUtil {
    private final EmailServico emailServico;

    public void enviarEmail(String destinatario, String corpo, String assunto, List<String> copias){
        EmailDTO email = new EmailDTO();

        email.setDestinatario(destinatario);
        email.setCorpo(corpo);
        email.setAssunto(assunto);
        email.setCopias(copias);

        emailServico.sendMail(email);
    }
}
