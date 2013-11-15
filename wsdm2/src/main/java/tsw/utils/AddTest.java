package tsw.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;

import tsw.domain.GenGame;
import tsw.domain.Program;
import tsw.domain.Team;


public class AddTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Calendar startDate = new GregorianCalendar();
		Program program = new Program();
		program.setStartDate(startDate);
		
		Team tm1=new Team();
		tm1.setProgram(program);
		tm1.setTeamId(1);
		tm1.setTeamName("team1");
		
		Team tm2=new Team();
		tm2.setProgram(program);
		tm2.setTeamId(2);
		tm2.setTeamName("team2");
		
		Team tm3=new Team();
		tm3.setProgram(program);
		tm3.setTeamId(3);
		tm3.setTeamName("team3");
		
		Integer resourceId=1;
		int gamesPerTeam=8;
		
		Set<Team> teams = new HashSet<Team>();
		teams.add(tm1);
		teams.add(tm2);
		teams.add(tm3);
		
		System.out.println("teams.size="+teams.size());
		System.out.println(teams);
		
		ArrayList<GenGame> games = GameGenerator.generateGamePairings(resourceId, teams, gamesPerTeam);
		
		System.out.println("games.size="+games.size());
		System.out.println(games);
		
		
	}
		
	public static void test1(){
		Calendar leagueCal = new GregorianCalendar();
		DateTime leagueDate = new DateTime(leagueCal.getTime());
		System.out.println(leagueDate);
		MutableDateTime mutleagueDate=leagueDate.toMutableDateTime();
		mutleagueDate.setHourOfDay(19); // default 7pm
		mutleagueDate.setMinuteOfHour(0); // default 7pm
		mutleagueDate.setSecondOfMinute(0); // default 7pm
		mutleagueDate.setMillisOfSecond(0); // default 7pm
		System.out.println(mutleagueDate);
		
	}

	
	
	public void testMath(){	
	MathContext mc = new MathContext(8);
	BigDecimal amtPaid = new BigDecimal("0.00",mc);
	BigDecimal amt2 = new BigDecimal("120.00");
	BigDecimal amt3 = new BigDecimal(230,mc);
	BigDecimal amt4 = new BigDecimal(20,mc);

	System.out.println("amt2:" + amt2);
	
	amtPaid = amtPaid.add(amt2,mc);
	System.out.println(amtPaid);

	System.out.println("amt3:" + amt3);

	amtPaid = amtPaid.add(amt3,mc);
	System.out.println(amtPaid);

	System.out.println("amt4:" + amt4);

	amtPaid = amtPaid.add(amt4,mc);
	System.out.println(amtPaid);

	
      // create 3 BigDecimal objects
      BigDecimal bg1,bg2,bg3;

      // assign value to bg1 and bg2
      bg1 = new BigDecimal("40.732");
      bg2 = new BigDecimal("30.12");

      // print bg1 and bg2 value
      System.out.println("Object Value is " + bg1);
      System.out.println("Augend value is " + bg2);

      // create MathContext object with 4 precision
      MathContext mc2 = new MathContext(4);

      // perform add operation on bg1 with augend bg2 and context mc
      bg3=bg1.add(bg2,mc2);

      // print bg3 value with
      System.out.println("Result is " + bg3);		
	 }
}
