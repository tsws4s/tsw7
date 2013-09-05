package tsw.domain;

public class GeneratedPairing {
	Integer pairing;	
	Integer team1;
	Integer team2;
	
	public GeneratedPairing(Integer pairing, Integer team1, Integer team2) {
		this.pairing = pairing;
		this.team1 = team1;
		this.team2 = team2;
	}
	
	public Integer getTeam2() {
		return team2;
	}

	public void setTeam2(Integer team2) {
		this.team2 = team2;
	}

	public Integer getPairing() {
		return pairing;
	}

	public void setPairing(Integer pairing) {
		this.pairing = pairing;
	}

	public Integer getTeam1() {
		return team1;
	}

	public void setTeam1(Integer team1) {
		this.team1 = team1;
	}
	
	@Override
	public String toString() {
		return "\n GeneratedGame [(pairing=" + pairing + ") team1="
				+ team1 + ", team2=" + team2 + "]";
	}
}
