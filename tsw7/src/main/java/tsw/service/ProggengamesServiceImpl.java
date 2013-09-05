package tsw.service;

import tsw.dao.GengameDAO;
import tsw.dao.ProggengamesDAO;

import tsw.domain.GenGame;
import tsw.domain.ProgGenGames;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for ProgGenGames entities
 * 
 */

@Service("ProggengamesService")
@Transactional
public class ProggengamesServiceImpl implements ProggengamesService {

	/**
	 * DAO injected by Spring that manages GenGame entities
	 * 
	 */
	@Autowired
	private GengameDAO gengameDAO;

	/**
	 * DAO injected by Spring that manages ProgGenGames entities
	 * 
	 */
	@Autowired
	private ProggengamesDAO proggengamesDAO;

	/**
	 * Instantiates a new ProggengamesServiceImpl.
	 *
	 */
	public ProggengamesServiceImpl() {
	}

	/**
	 * Save an existing GenGame entity
	 * 
	 */
	@Transactional
	public ProgGenGames saveProggengamesGengames(Integer progGenGamesId, GenGame related_gengames) {
		ProgGenGames proggengames = proggengamesDAO.findProggengamesByPrimaryKey(progGenGamesId, -1, -1);
		GenGame existinggengames = gengameDAO.findGengameByPrimaryKey(related_gengames.getGenGameId());

		// copy into the existing record to preserve existing relationships
		if (existinggengames != null) {
			existinggengames.setGenGameId(related_gengames.getGenGameId());
			existinggengames.setGameNum(related_gengames.getGameNum());
			existinggengames.setGameDateTime(related_gengames.getGameDateTime());
			existinggengames.setHomeTeamId(related_gengames.getHomeTeamId());
			existinggengames.setHomeTeamName(related_gengames.getHomeTeamName());
			existinggengames.setVisitorTeamId(related_gengames.getVisitorTeamId());
			existinggengames.setVisitorTeamName(related_gengames.getVisitorTeamName());
			existinggengames.setResourceId(related_gengames.getResourceId());
			existinggengames.setResourceName(related_gengames.getResourceName());
			existinggengames.setRefereeId(related_gengames.getRefereeId());
			existinggengames.setRefereeName(related_gengames.getRefereeName());
			related_gengames = existinggengames;
		} else {
			related_gengames = gengameDAO.store(related_gengames);
			gengameDAO.flush();
		}

		related_gengames.setProggengames(proggengames);
		proggengames.getGengames().add(related_gengames);
		related_gengames = gengameDAO.store(related_gengames);
		gengameDAO.flush();

		proggengames = proggengamesDAO.store(proggengames);
		proggengamesDAO.flush();

		return proggengames;
	}

	/**
	 */
	@Transactional
	public ProgGenGames findProggengamesByPrimaryKey(Integer progGenGamesId) {
		return proggengamesDAO.findProggengamesByPrimaryKey(progGenGamesId);
	}

	/**
	 * Delete an existing GenGame entity
	 * 
	 */
	@Transactional
	public ProgGenGames deleteProggengamesGengames(Integer proggengames_progGenGamesId, Integer related_gengames_genGameId) {
		GenGame related_gengames = gengameDAO.findGengameByPrimaryKey(related_gengames_genGameId, -1, -1);

		ProgGenGames proggengames = proggengamesDAO.findProggengamesByPrimaryKey(proggengames_progGenGamesId, -1, -1);

		related_gengames.setProggengames(null);
		proggengames.getGengames().remove(related_gengames);

		gengameDAO.remove(related_gengames);
		gengameDAO.flush();

		return proggengames;
	}

	/**
	 * Save an existing ProgGenGames entity
	 * 
	 */
	@Transactional
	public void saveProggengames(ProgGenGames proggengames) {
		ProgGenGames existingProggengames = proggengamesDAO.findProggengamesByPrimaryKey(proggengames.getProgGenGamesId());

		if (existingProggengames != null) {
			if (existingProggengames != proggengames) {
				existingProggengames.setProgGenGamesId(proggengames.getProgGenGamesId());
				existingProggengames.setProgramId(proggengames.getProgramId());
				existingProggengames.setProgramName(proggengames.getProgramName());
				existingProggengames.setStartDate(proggengames.getStartDate());
			}
			proggengames = proggengamesDAO.store(existingProggengames);
		} else {
			proggengames = proggengamesDAO.store(proggengames);
		}
		proggengamesDAO.flush();
	}

	/**
	 * Return all ProgGenGames entity
	 * 
	 */
	@Transactional
	public List<ProgGenGames> findAllProggengamess(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<ProgGenGames>(proggengamesDAO.findAllProggengamess(startResult, maxRows));
	}

	/**
	 * Return a count of all ProgGenGames entity
	 * 
	 */
	@Transactional
	public Integer countProggengamess() {
		return ((Long) proggengamesDAO.createQuerySingleResult("select count(o) from ProgGenGames o").getSingleResult()).intValue();
	}

	/**
	 * Load an existing ProgGenGames entity
	 * 
	 */
	@Transactional
	public Set<ProgGenGames> loadProggengamess() {
		return proggengamesDAO.findAllProggengamess();
	}

	/**
	 * Delete an existing ProgGenGames entity
	 * 
	 */
	@Transactional
	public void deleteProggengames(ProgGenGames proggengames) {
		proggengamesDAO.remove(proggengames);
		proggengamesDAO.flush();
	}
}
