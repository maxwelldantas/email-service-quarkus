package com.github.maxwelldantas.email.service;

import com.github.maxwelldantas.email.dto.EmailDto;
import com.github.maxwelldantas.email.dto.EnviarNotificacaoEmailDto;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.qute.Template;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
@RequiredArgsConstructor
public class EmailService {

	private final Mailer mailer;

	private final Template emailNotificacao;

	public Object enviarEmail(EmailDto dto) {
		Mail mail = new Mail();
		mail.setTo(Collections.singletonList(dto.destinatario()));
		mail.setSubject(dto.assunto());
		mail.setText(dto.corpo());
		mailer.send(mail);
		return mail;
	}

	public Object enviarNotificacao(EnviarNotificacaoEmailDto dto) {
		Map<String, Object> dataModel = new HashMap<>();
		dataModel.put("nome", dto.nome());
		dataModel.put("acao", dto.acao());
		dataModel.put("data", dto.data());
		dataModel.put("processo", dto.processo());

		String html = emailNotificacao.data(dataModel).render();

		Mail message = new Mail();
		message.setFrom("seu_email@example.com");
		message.setTo(Collections.singletonList(dto.para()));
		message.setSubject("Notificação Legal");
		message.setHtml(html);

		mailer.send(message);
		return message;
	}
}
