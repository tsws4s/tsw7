package tsw.service;

import java.util.List;
import java.util.Set;

import tsw.domain.Customer;
import tsw.domain.Participant;
import tsw.domain.Program;
import tsw.domain.Tswacct;

/**
 * Spring service that handles CRUD requests for Participant entities
 * 
 */
public interface ParticipantService {

	/**
	 * Save an existing Customer entity
	 * 
	 */
	public Participant saveParticipantCustomer(Integer participantId, Customer related_customer);

	/**
	 * Save an existing Participant entity
	 * 
	 */
	public void saveParticipant(Tswacct tswacct, Participant participant);

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public Participant deleteParticipantCustomer(Integer participant_participantId, Integer related_customer_customerId);

	/**
	 * Delete an existing Program entity
	 * 
	 */
	public Participant deleteParticipantProgram(Integer participant_participantId_1, Integer related_program_programId);

	/**
	 * Return a count of all Participant entity
	 * 
	 */
	public Integer countParticipants();

	/**
	 * Load an existing Participant entity
	 * 
	 */
	public Set<Participant> loadParticipants();

	/**
	 */
	public Participant findParticipantByPrimaryKey(Integer participantId_1);

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	public Participant saveParticipantTswacct(Integer participantId_2, Tswacct related_tswacct);

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	public Participant deleteParticipantTswacct(Integer participant_participantId_2, Integer related_tswacct_tswAcctId);

	/**
	 * Save an existing Program entity
	 * 
	 */
	public Participant saveParticipantProgram(Integer participantId_3, Program related_program);

	/**
	 * Delete an existing Participant entity
	 * 
	 */
	public void deleteParticipant(Participant participant_1);

	/**
	 * Return all Participant entity
	 * 
	 */
	public List<Participant> findAllParticipants(Integer startResult, Integer maxRows);
}