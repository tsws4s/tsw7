package tsw.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import tsw.dao.CustomerDAO;
import tsw.dao.ParticipantDAO;
import tsw.dao.ProgramDAO;
import tsw.dao.TswacctDAO;

import tsw.domain.Customer;
import tsw.domain.Participant;
import tsw.domain.Program;
import tsw.domain.Tswacct;
import tsw.web.UsersController;

/**
 * Spring service that handles CRUD requests for Participant entities
 * 
 */

@Service("ParticipantService")
@Transactional
public class ParticipantServiceImpl implements ParticipantService {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();

	/**
	 * DAO injected by Spring that manages Customer entities
	 * 
	 */
	@Autowired
	private CustomerDAO customerDAO;

	/**
	 * DAO injected by Spring that manages Participant entities
	 * 
	 */
	@Autowired
	private ParticipantDAO participantDAO;

	/**
	 * DAO injected by Spring that manages Program entities
	 * 
	 */
	@Autowired
	private ProgramDAO programDAO;

	/**
	 * DAO injected by Spring that manages Tswacct entities
	 * 
	 */
	@Autowired
	private TswacctDAO tswacctDAO;

	/**
	 * Instantiates a new ParticipantServiceImpl.
	 *
	 */
	public ParticipantServiceImpl() {
	}

	/**
	 * Save an existing Customer entity
	 * 
	 */
	@Transactional
	public Participant saveParticipantCustomer(Integer participantId, Customer related_customer) {
		Participant participant = participantDAO.findParticipantByPrimaryKey(participantId, -1, defaultMaxRows);
		Customer existingcustomer = customerDAO.findCustomerByPrimaryKey(related_customer.getCustomerId());

		// copy into the existing record to preserve existing relationships
		if (existingcustomer != null) {
			existingcustomer.setCustomerId(related_customer.getCustomerId());
			existingcustomer.setEmail(related_customer.getEmail());
			existingcustomer.setFirstname(related_customer.getFirstname());
			existingcustomer.setLastname(related_customer.getLastname());
			existingcustomer.setPhone(related_customer.getPhone());
			existingcustomer.setYearBorn(related_customer.getYearBorn());
			existingcustomer.setAddress(related_customer.getAddress());
			existingcustomer.setCity(related_customer.getCity());
			existingcustomer.setState(related_customer.getState());
			existingcustomer.setZipcode(related_customer.getZipcode());
			related_customer = existingcustomer;
		} else {
			related_customer = customerDAO.store(related_customer);
			customerDAO.flush();
		}

		participant.setCustomer(related_customer);
		related_customer.getParticipants().add(participant);
		participant = participantDAO.store(participant);
		participantDAO.flush();

		related_customer = customerDAO.store(related_customer);
		customerDAO.flush();

		return participant;
	}

	/**
	 * Save an existing Participant entity
	 * 
	 */
	@Transactional
	public void saveParticipant(Tswacct tswacct, Participant participant) {
		Participant existingParticipant = participantDAO.findParticipantByPrimaryKey(participant.getParticipantId());

		if (existingParticipant != null) {
			if (existingParticipant != participant) {
				existingParticipant.setParticipantId(participant.getParticipantId());
				existingParticipant.setAmtPaid(participant.getAmtPaid());
				existingParticipant.setNotes(participant.getNotes());
				existingParticipant.setGroup1(participant.getGroup1());
				existingParticipant.setSignedWaiverYn(participant.getSignedWaiverYn());
				existingParticipant.setActiveYn(participant.getActiveYn());
			}
			participant = participantDAO.store(existingParticipant);
		} else {
			int partId = participantDAO.getMaxParticipantID();
			participant.setParticipantId(partId+1);
			participant.setTswacct(tswacct);
			participant = participantDAO.store(participant);
		}
		participantDAO.flush();
	}

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	@Transactional
	public Participant deleteParticipantCustomer(Integer participant_participantId, Integer related_customer_customerId) {
		Participant participant = participantDAO.findParticipantByPrimaryKey(participant_participantId, -1, defaultMaxRows);
		Customer related_customer = customerDAO.findCustomerByPrimaryKey(related_customer_customerId, -1, defaultMaxRows);

		participant.setCustomer(null);
		related_customer.getParticipants().remove(participant);
		participant = participantDAO.store(participant);
		participantDAO.flush();

		related_customer = customerDAO.store(related_customer);
		customerDAO.flush();

		customerDAO.remove(related_customer);
		customerDAO.flush();

		return participant;
	}

	/**
	 * Delete an existing Program entity
	 * 
	 */
	@Transactional
	public Participant deleteParticipantProgram(Integer participant_participantId, Integer related_program_programId) {
		Participant participant = participantDAO.findParticipantByPrimaryKey(participant_participantId, -1, defaultMaxRows);
		Program related_program = programDAO.findProgramByPrimaryKey(related_program_programId, -1, defaultMaxRows);

		participant.setProgram(null);
		related_program.getParticipants().remove(participant);
		participant = participantDAO.store(participant);
		participantDAO.flush();

		related_program = programDAO.store(related_program);
		programDAO.flush();

		programDAO.remove(related_program);
		programDAO.flush();

		return participant;
	}

	/**
	 * Return a count of all Participant entity
	 * 
	 */
	@Transactional
	public Integer countParticipants() {
		return ((Long) participantDAO.createQuerySingleResult("select count(o) from Participant o").getSingleResult()).intValue();
	}

	/**
	 * Load an existing Participant entity
	 * 
	 */
	@Transactional
	public Set<Participant> loadParticipants() {
		return participantDAO.findAllParticipants();
	}

	/**
	 */
	@Transactional
	public Participant findParticipantByPrimaryKey(Integer participantId) {
		return participantDAO.findParticipantByPrimaryKey(participantId);
	}

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Participant saveParticipantTswacct(Integer participantId, Tswacct related_tswacct) {
		Participant participant = participantDAO.findParticipantByPrimaryKey(participantId, -1, defaultMaxRows);
		Tswacct existingtswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct.getTswAcctId());

		// copy into the existing record to preserve existing relationships
		if (existingtswacct != null) {
			existingtswacct.setTswAcctId(related_tswacct.getTswAcctId());
			existingtswacct.setAcctName(related_tswacct.getAcctName());
			existingtswacct.setSubscrType(related_tswacct.getSubscrType());
			existingtswacct.setAmtPaid(related_tswacct.getAmtPaid());
			existingtswacct.setEstablishDate(related_tswacct.getEstablishDate());
			existingtswacct.setExpireDate(related_tswacct.getExpireDate());
			existingtswacct.setActiveYn(related_tswacct.getActiveYn());
			related_tswacct = existingtswacct;
		} else {
			related_tswacct = tswacctDAO.store(related_tswacct);
			tswacctDAO.flush();
		}

		participant.setTswacct(related_tswacct);
		related_tswacct.getParticipants().add(participant);
		participant = participantDAO.store(participant);
		participantDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		return participant;
	}

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Participant deleteParticipantTswacct(Integer participant_participantId, Integer related_tswacct_tswAcctId) {
		Participant participant = participantDAO.findParticipantByPrimaryKey(participant_participantId, -1, defaultMaxRows);
		Tswacct related_tswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct_tswAcctId, -1, defaultMaxRows);

		participant.setTswacct(null);
		related_tswacct.getParticipants().remove(participant);
		participant = participantDAO.store(participant);
		participantDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		tswacctDAO.remove(related_tswacct);
		tswacctDAO.flush();

		return participant;
	}

	/**
	 * Save an existing Program entity
	 * 
	 */
	@Transactional
	public Participant saveParticipantProgram(Integer participantId, Program related_program) {
		Participant participant = participantDAO.findParticipantByPrimaryKey(participantId, -1, defaultMaxRows);
		Program existingprogram = programDAO.findProgramByPrimaryKey(related_program.getProgramId());

		// copy into the existing record to preserve existing relationships
		if (existingprogram != null) {
			existingprogram.setProgramId(related_program.getProgramId());
			existingprogram.setProgramName(related_program.getProgramName());
			existingprogram.setPrice(related_program.getPrice());
			existingprogram.setStartDate(related_program.getStartDate());
			existingprogram.setEndDate(related_program.getEndDate());
			existingprogram.setActiveYn(related_program.getActiveYn());
			existingprogram.setPublishYn(related_program.getPublishYn());
			existingprogram.setTotalPaid(related_program.getTotalPaid());
			existingprogram.setTotalParticipants(related_program.getTotalParticipants());
			existingprogram.setGamesPerTeam(related_program.getGamesPerTeam());
			existingprogram.setLeagueYn(related_program.getLeagueYn());
			related_program = existingprogram;
		} else {
			related_program = programDAO.store(related_program);
			programDAO.flush();
		}

		participant.setProgram(related_program);
		related_program.getParticipants().add(participant);
		participant = participantDAO.store(participant);
		participantDAO.flush();

		related_program = programDAO.store(related_program);
		programDAO.flush();

		return participant;
	}

	/**
	 * Delete an existing Participant entity
	 * 
	 */
	@Transactional
	public void deleteParticipant(Participant participant) {
		participantDAO.remove(participant);
		participantDAO.flush();
	}

	/**
	 * Return all Participant entity
	 * 
	 */
	@Transactional
	public List<Participant> findAllParticipants(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Participant>(participantDAO.findAllParticipants(startResult, maxRows));
	}
}
