package br.com.sutil.thecolors.adapter;

import java.util.List;

import br.com.sutil.thecolors.model.BotaoResposta;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class AdapterForView extends BaseAdapter{
	
	private List<BotaoResposta> views;
	
	public AdapterForView(List<BotaoResposta> views){
		this.views = views;
	}

	@Override
	public int getCount() {
		return views.size();
	}

	@Override
	public Object getItem(int position) {
		return views.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return views.get(position);
	}

}
