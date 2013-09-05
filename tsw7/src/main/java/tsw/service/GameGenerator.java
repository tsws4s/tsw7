package tsw.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;

import tsw.domain.GenGame;
import tsw.domain.GeneratedPairing;
import tsw.domain.Team;

public class GameGenerator {

	public static ArrayList<GenGame> generateGamePairings(Integer resourceId, Set<Team> teams, int gamesPerTeam) {
		int pairing = 0;
		int numTeams = teams.size();
		int totGames = ((numTeams * gamesPerTeam)+1) / 2;
		ArrayList<Team> teamArray = new ArrayList<Team>(teams);
		 
		ArrayList<GeneratedPairing> pairings = new ArrayList<GeneratedPairing>();
		ArrayList<GenGame> games = new ArrayList<GenGame>();
		ArrayList<Integer> teamCounts = new ArrayList<Integer>();
		teamCounts.add(new Integer(0));
		teamCounts.add(new Integer(0));
		
		for(int i=1; i<numTeams; i++){
			teamCounts.add(new Integer(0));
			for(int j=(i+1); j<(numTeams+1); j++){
				if(pairing%2==0){
					pairings.add(pairing, new GeneratedPairing(pairing+1, i, j));
				} else {
					pairings.add(pairing, new GeneratedPairing(pairing+1, j, i));					
				}
				pairing++;
			}
		}
		int k=0;
		int gm=0;
		Calendar leagueCal = teamArray.get(1).getProgram().getStartDate();
		DateTime leagueDate = new DateTime(leagueCal.getTime());
		System.out.println(pairings);

		while((games.size()<(totGames)) || (k<(totGames*2))){
			GeneratedPairing game = pairings.get(k%pairing);
			
			int team1 = game.getTeam1().intValue();
			int team2 = game.getTeam2().intValue();	
			int team1Count = teamCounts.get(team1-1).intValue();
			int team2Count = teamCounts.get(team2-1).intValue();		
			MutableDateTime mutleagueDate=leagueDate.toMutableDateTime();
			mutleagueDate.setHourOfDay(19); // default 7pm
			mutleagueDate.setMinuteOfHour(0); // default 7pm
			mutleagueDate.setSecondOfMinute(0); // default 7pm
			mutleagueDate.setMillisOfSecond(0); // default 7pm
			
			if(team1Count<gamesPerTeam || team2Count<gamesPerTeam){
				
				Team tm1 = teamArray.get(team1-1);
				Team tm2 = teamArray.get(team2-1);
				GenGame genGame = new GenGame();
				genGame.setGameNum(gm++);
				genGame.setHomeTeamId(tm1.getTeamId());
				genGame.setHomeTeamName(tm1.getTeamName());
				genGame.setVisitorTeamId(tm2.getTeamId());
				genGame.setVisitorTeamName(tm2.getTeamName());
				
				mutleagueDate.addDays(gm);
				genGame.setGameDateTime(mutleagueDate.toDateTime().toGregorianCalendar());
				Calendar startTime = new GregorianCalendar();
				startTime.setTime(mutleagueDate.toGregorianCalendar().getTime());
				genGame.setStartTime(startTime);
				
				genGame.setResourceId(resourceId);
				games.add(genGame);
				teamCounts.set(team1-1, new Integer(team1Count+1));
				teamCounts.set(team2-1, new Integer(team2Count+1));
			}
			k++;
		}
		return games;
	}
}
