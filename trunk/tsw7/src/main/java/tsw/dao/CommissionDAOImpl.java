package tsw.dao;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tsw.domain.Authorities;
import tsw.domain.Commission;
import tsw.web.UsersController;

/**
 * DAO to manage Authorities entities.
 * 
 */
@Repository("CommissionDAO")
@Transactional
public class CommissionDAOImpl extends AbstractJpaDao<Commission> implements CommissionDAO {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Authorities.class }));

	/**
	 * EntityManager injected by Spring for persistence unit tsws4s_4
	 *
	 */
	@PersistenceContext(unitName = "tsws4s_4")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AuthoritiesDAOImpl
	 *
	 */
	public CommissionDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Commission entity) {
		return true;
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Set<Commission> findAllCommissions() throws DataAccessException {	
		Query query = createNamedQuery("findAllCommissions", -1, defaultMaxRows);
		return new LinkedHashSet<Commission>(query.getResultList());
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Set<Commission> findAllCommissions4tsw(Integer tswAcctFk) throws DataAccessException {
		Query query = createNamedQuery("findAllCommissions4tsw", -1, defaultMaxRows,tswAcctFk);
		return new LinkedHashSet<Commission>(query.getResultList());
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Commission> findCommissionsBySalesRepId(Integer salesRepId) throws DataAccessException {
		Query query = createNamedQuery("findCommissionsBySalesRepId", -1, defaultMaxRows, salesRepId);
		return new LinkedHashSet<Commission>(query.getResultList());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Set<Commission> findCommissionByDate(Calendar salesDate) throws DataAccessException {
		Query query = createNamedQuery("findAllCommissions4tsw", -1, defaultMaxRows,salesDate);
		return new LinkedHashSet<Commission>(query.getResultList());
	}

	@Override
	@Transactional
	public Commission findCommissionByPrimaryKey(Integer commissionId) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAuthoritiesByCommissionId", -1, defaultMaxRows, commissionId);
			return (tsw.domain.Commission) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}	
	}

	@Override
	@Transactional
	public Integer getMaxCommissionId() {
		Object obj = executeQuerySingleResult("select max(commissionId) from Commission");
		return (Integer)obj;
	}

	@Override
	@Transactional
	public Commission findCommissionByCommissionId(Integer commissionId) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAuthoritiesByCommissionId", -1, defaultMaxRows, commissionId);
			return (tsw.domain.Commission) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}	
	}

}
