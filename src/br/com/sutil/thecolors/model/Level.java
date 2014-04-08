package br.com.sutil.thecolors.model;

public enum Level {
	
	EASY(10000) {
		@Override
		public Level up() {
			return MEDIUM;
		}
	}, 
	MEDIUM(60000) {
		@Override
		public Level up() {
			return HARD;
		}
	},
	HARD(30000) {
		@Override
		public Level up() {
			return HARD;
		}
	};
	
	private int maxTime;
	
	private Level(int maxTime){
		this.maxTime = maxTime;
	}
	
	public abstract Level up();
	
	public int getMaxTime() {
		return maxTime;
	}

}
