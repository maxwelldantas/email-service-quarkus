package com.github.maxwelldantas.email.dto;

public record EmailDto(
		String destinatario,
		String assunto,
		String corpo
) {
}
