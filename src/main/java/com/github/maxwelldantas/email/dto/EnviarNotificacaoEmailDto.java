package com.github.maxwelldantas.email.dto;

public record EnviarNotificacaoEmailDto(
		String para,
		String nome,
		String acao,
		String data,
		String processo
) {
}
