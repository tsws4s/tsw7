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
 * Spring service that handles CRUD requests for GenGame entities
 * 
 */

@Service("GengameService")
@Transactional
public class GengameServiceImpl implements GengameService {

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
	 * Instantiates a new GengameServiceImpl.
	 *
	 */
	public GengameServiceImpl() {
	}

	/**
	 * Return a count of all GenGame entity
	 * 
	 */
	@Transactional
	public Integer countGengames() {
		return ((Long) gengameDAO.createQuerySingleResult("select count(o) from GenGame o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing GenGame entity
	 * 
	 */
	@Transactional
	public void deleteGengame(GenGame gengame) {
		gengameDAO.remove(gengame);
		gengameDAO.flush();
	}

	/**
	 */
	@Transactional
	public GenGame findGengameByPrimaryKey(Integer genGameId) {
		return gengameDAO.findGengameByPrimaryKey(genGameId);
	}

	/**
	 * Save an existing ProgGenGames entity
	 * 
	 */
	@Transactional
	public GenGame saveGengameProggengames(Integer genGameId, ProgGenGames related_proggengames) {
		GenGame gengame = gengameDAO.findGengameByPrimaryKey(genGameId, -1, -1);
		ProgGenGames existingproggengames = proggengamesDAO.findProggengamesByPrimaryKey(related_proggengames.getProgGenGamesId());

		// copy into the existing record to preserve existing relationships
		if (existingproggengames != null) {
			existingproggengames.setProgGenGamesId(related_proggengames.getProgGenGamesId());
			existingproggengames.setProgramId(related_proggengames.getProgramId());
			existingproggengames.setProgramName(related_proggengames.getProgramName());
			existingproggengames.setStartDate(related_proggengames.getStartDate());
			related_proggengames = existingproggengames;
		} else {
			related_proggengames = proggengamesDAO.store(related_proggengames);
			proggengamesDAO.flush();
		}

		gengame.setProggengames(related_proggengames);
		related_proggengames.getGengames().add(gengame);
		gengame = gengameDAO.store(gengame);
		gengameDAO.flush();

		related_proggengames = proggengamesDAO.store(related_proggengames);
		proggengamesDAO.flush();

		return gengame;
	}

	/**
	 * Load an existing GenGame entity
	 * 
	 */
	@Transactional
	public Set<GenGame> loadGengames() {
		return gengameDAO.findAllGengames();
	}

	/**
	 * Delete an existing ProgGenGames entity
	 * 
	 */
	@Transactional
	public GenGame deleteGengameProggengames(Integer gengame_genGameId, Integer related_proggengames_progGenGamesId) {
		GenGame gengame = gengameDAO.findGengameByPrimaryKey(gengame_genGameId, -1, -1);
		ProgGenGames related_proggengames = proggengamesDAO.findProggengamesByPrimaryKey(related_proggengames_progGenGamesId, -1, -1);

		gengame.setProggengames(null);
		related_proggengames.getGengames().remove(gengame);
		gengame = gengameDAO.store(gengame);
		gengameDAO.flush();

		related_proggengames = proggengamesDAO.store(related_proggengames);
		proggengamesDAO.flush();

		proggengamesDAO.remove(related_proggengames);
		proggengamesDAO.flush();

		return gengame;
	}

	/**
	 * Save an existing GenGame entity
	 * 
	 */
	@Transactional
	public void saveGengame(GenGame gengame) {
		GenGame existingGengame = gengameDAO.findGengameByPrimaryKey(gengame.getGenGameId());

		if (existingGengame != null) {
			if (existingGengame != gengame) {
				existingGengame.setGenGameId(gengame.getGenGameId());
				existingGengame.setGameNum(gengame.getGameNum());
				existingGengame.setGameDateTime(gengame.getGameDateTime());
				existingGengame.setHomeTeamId(gengame.getHomeTeamId());
				existingGengame.setHomeTeamName(gengame.getHomeTeamName());
				existingGengame.setVisitorTeamId(gengame.getVisitorTeamId());
				existingGengame.setVisitorTeamName(gengame.getVisitorTeamName());
				existingGengame.setResourceId(gengame.getResourceId());
				existingGengame.setResourceName(gengame.getResourceName());
				existingGengame.setRefereeId(gengame.getRefereeId());
				existingGengame.setRefereeName(gengame.getRefereeName());
			}
			gengame = gengameDAO.store(existingGengame);
		} else {
			gengame = gengameDAO.store(gengame);
		}
		gengameDAO.flush();
	}

	/**
	 * Return all GenGame entity
	 * 
	 */
	@Transactional
	public List<GenGame> findAllGengames(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<GenGame>(gengameDAO.findAllGengames(startResult, maxRows));
	}
}
