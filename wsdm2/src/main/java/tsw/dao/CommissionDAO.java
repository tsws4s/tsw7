package tsw.dao;

import java.util.Calendar;
import java.util.Set;
import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;
import tsw.domain.Commission;

/**
 * DAO to manage Commission entities.
 * 
 */
public interface CommissionDAO extends JpaDao<Commission> {

	/**
	 * JPQL Query - findAllCommissions
	 *
	 */
	public Set<Commission> findAllCommissions() throws DataAccessException;

	public Set<Commission> findAllCommissions4tsw(Integer tswAcctFk) throws DataAccessException;

	public Set<Commission> findCommissionByDate(Calendar salesDate) throws DataAccessException;

	public Commission findCommissionByPrimaryKey(Integer commissionId) throws DataAccessException;
	
	public Commission findCommissionByCommissionId(Integer commissionId) throws DataAccessException;
	
	public Set<Commission> findCommissionsBySalesRepId(Integer salesRepId) throws DataAccessException;
	
	public Integer getMaxCommissionId();
	
}