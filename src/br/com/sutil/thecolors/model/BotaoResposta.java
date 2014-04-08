package br.com.sutil.thecolors.model;

import android.content.Context;
import android.widget.Button;

public class BotaoResposta extends Button implements RespostaInterface {
	
	private Color color;

	public BotaoResposta(Context context, Color color) {
		super(context);
		setBackgroundColor(context.getResources().getColor(color.getValue()));
		this.color = color;
	}

	@Override
	public boolean respostaOk(Color corAtual) {
		return color.equals(corAtual);
	}

}
