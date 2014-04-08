package br.com.sutil.thecolors.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import br.com.sutil.thecolors.R;

public class Main extends Activity  {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				chamaTelaPrincipal();
				finish();
			}
		}, 1500);
	}
	
	private void chamaTelaPrincipal(){
		Intent intent = new Intent(this, PrincipalActivity.class);
		startActivity(intent);
	}

	
	
	

}
