package com.github.maxwelldantas.email.resource;

import com.github.maxwelldantas.email.dto.EmailDto;
import com.github.maxwelldantas.email.dto.EnviarNotificacaoEmailDto;
import com.github.maxwelldantas.email.service.EmailService;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("/email")
@RequiredArgsConstructor
@ApplicationScoped
public class EmailResource {

	private final EmailService emailService;

	@POST
	@Blocking
	@Consumes(MediaType.APPLICATION_JSON)
	public Response enviarEmail(EmailDto dto) {
		return Response.ok(emailService.enviarEmail(dto)).build();
	}

	@POST
	@Path("/notificacao")
	@Blocking
	@Consumes(MediaType.APPLICATION_JSON)
	public Response enviarNotificacao(EnviarNotificacaoEmailDto dto) {
		return Response.ok(emailService.enviarNotificacao(dto)).build();
	}
}
