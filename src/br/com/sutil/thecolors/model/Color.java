package br.com.sutil.thecolors.model;

import br.com.sutil.thecolors.R;

public enum Color {
	
	VERMELHO(R.color.VERMELHO, "Vermelho"),
	ROXO(R.color.ROXO, "Roxo"),
	AZUL(R.color.AZUL, "Azul"),
	VERDE(R.color.VERDE, "Verde"),
	AMARELO(R.color.AMARELO, "Amarelo"),
	LARANJA(R.color.LARANJA, "Laranja"),
	ROSA(R.color.ROSA, "Rosa"),
	PRETO(R.color.PRETO, "Preto"),
	MARROM(R.color.MARROM, "Marrom"),
	CINZA(R.color.CINZA, "Cinza");
	
	private Color(int value, String descricao) {
		this.value = value;
		this.descricao = descricao;
	}
	
	private final int value;
	private final String descricao;
	
	public int getValue() {
		return value;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
}
