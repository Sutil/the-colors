package br.com.sutil.thecolors.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;



public class Partida {
	
	private Level level = Level.EASY;
	private int pontos = 0;
	private int vidas = 5;
	private ActivityPartidaInterface activity;
	
	private Color corAtual;
	private String palavraAtual;
	
	private List<Color> cores = new LinkedList<Color>(Arrays.asList(Color.values()));
	
	public Partida(ActivityPartidaInterface activity){
		this.activity = activity;
		sorteiaCor();
		dataChanged();
	}
	
	private void sorteiaCor() {
		Random r = new Random();
		this.corAtual = cores.get(r.nextInt(cores.size()));
		this.palavraAtual = cores.get(r.nextInt(cores.size())).getDescricao();
	}

	public void responder(RespostaInterface resposta){
		if(resposta.respostaOk(corAtual)){
			addPontos();
		}
		else{
			addErro();
		}
		sorteiaCor();
		dataChanged();
	}

	private void addPontos() {
		pontos+= 10;
		if(pontos % 300 == 0){
			level = level.up();
		}
	}

	private void addErro() {
		vidas--;
	}
	
	private void dataChanged(){
		String pontos = String.valueOf(this.pontos);
		String vidas = String.valueOf(this.vidas);
		activity.setDataChanged(pontos, vidas, palavraAtual, corAtual.getValue());
		if(fimDeJogo()){
			activity.finalizaPartida();
		}
	}

	private boolean fimDeJogo() {
		return vidas <= 0;
	}
	
}
