package programmaColloquio.model;

public class Risultato {
	
	String team;
	int segnati;
	int subiti;
	public Risultato(String team, int segnati, int subiti) {
		super();
		this.team = team;
		this.segnati = segnati;
		this.subiti = subiti;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getSegnati() {
		return segnati;
	}
	public void setSegnati(int segnati) {
		this.segnati = segnati;
	}
	public int getSubiti() {
		return subiti;
	}
	public void setSubiti(int subiti) {
		this.subiti = subiti;
	}
	
	
//	String team;
//	String segnati;
//	String subiti;
//	public Risultato(String team, String segnati, String subiti) {
//		super();
//		this.team = team;
//		this.segnati = segnati;
//		this.subiti = subiti;
//	}
//	public String getTeam() {
//		return team;
//	}
//	public void setTeam(String team) {
//		this.team = team;
//	}
//	public String getSegnati() {
//		return segnati;
//	}
//	public void setSegnati(String segnati) {
//		this.segnati = segnati;
//	}
//	public String getSubiti() {
//		return subiti;
//	}
//	public void setSubiti(String subiti) {
//		this.subiti = subiti;
//	}
	@Override
	public String toString() {
		return "Risultato [team=" + team + ", segnati=" + segnati + ", subiti=" + subiti + "]";
	}

}
