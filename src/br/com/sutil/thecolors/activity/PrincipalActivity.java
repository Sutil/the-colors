package br.com.sutil.thecolors.activity;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.TextView;
import br.com.sutil.thecolors.R;
import br.com.sutil.thecolors.adapter.AdapterForView;
import br.com.sutil.thecolors.model.ActivityPartidaInterface;
import br.com.sutil.thecolors.model.BotaoResposta;
import br.com.sutil.thecolors.model.Color;
import br.com.sutil.thecolors.model.Partida;

public class PrincipalActivity extends Activity implements ActivityPartidaInterface{
	
	public GridView gridRespostas;
	public TextView textPontos;
	public TextView textVidas;
	public TextView textCor;
	private Partida partida;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal_acticity);
		init();
		iniciaPartida();
		montaRespostas();
	}
	
	private void init(){
		this.gridRespostas = (GridView) findViewById(R.id.respostas);
		this.textPontos = (TextView) findViewById(R.id.pontos);
		this.textVidas = (TextView) findViewById(R.id.vidas);
		this.textCor =  (TextView) findViewById(R.id.textViewCor);
		
		
	}
	
	@Override
	public void montaRespostas() {
		List<BotaoResposta> respostas = new LinkedList<BotaoResposta>();
		for(Color color : Color.values()){
			final BotaoResposta bt = new BotaoResposta(this, color);
			bt.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					partida.responder(bt);
				}
			});
			respostas.add(bt);
		}
		AdapterForView adapter = new AdapterForView(respostas);
		gridRespostas.setAdapter(adapter);
		
	}

	@Override
	public void setDataChanged(String pontos, String vidas, String palavra, int cor) {
		textPontos.setText(pontos);
		textVidas.setText(vidas);
		textCor.setText(palavra);
		textCor.setTextColor(getResources().getColor(cor));
	}
	
	@Override
	public void iniciaPartida() {
		partida = new Partida(this);
	}

	@Override
	public void finalizaPartida() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Fim de jogo");
		builder.setPositiveButton("Novo", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				iniciaPartida();
				
			}
		});
		builder.setNegativeButton("Sair", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}
	
	
	
	
	

}
