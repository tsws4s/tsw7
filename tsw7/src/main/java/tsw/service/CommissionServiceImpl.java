package tsw.service;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsw.dao.CommissionDAO;
import tsw.domain.Commission;
import tsw.web.UsersController;

/**
 * Spring service that handles CRUD requests for Commission entities
 * 
 */

@Service("CommissionService")
@Transactional
public class CommissionServiceImpl implements CommissionService {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();
	
	/**
	 * DAO injected by Spring that manages Authorities entities
	 * 
	 */
	@Autowired
	private CommissionDAO commissionDAO;


	/**
	 * Instantiates a new AuthoritiesServiceImpl.
	 *
	 */
	public CommissionServiceImpl() {
	}


	@Override
	public void deleteCommission(Commission commission) {
		commissionDAO.remove(commission);
		commissionDAO.flush();	
	}

	@Override
	public Set<Commission> loadCommission() {
		return commissionDAO.findAllCommissions();
	}

	@Transactional
	public void saveCommission(Commission commission1) {
		Commission existingCommission = commissionDAO.findCommissionByPrimaryKey(commission1.getCommissionId());

			if (existingCommission != null) {
				if (existingCommission != commission1) {
					existingCommission.setCommissionId(commission1.getCommissionId());
				}
				commission1 = commissionDAO.store(existingCommission);
			} else {
				int commissionId = commissionDAO.getMaxCommissionId();
				commission1.setCommissionId(commissionId+1);
				commission1 = commissionDAO.store(commission1);
			}
			commissionDAO.flush();		
	}

	@Override
	public Commission findCommissionByPrimaryKey(Integer commissionId) {
		return commissionDAO.findCommissionByPrimaryKey(commissionId);
	}

	@Override
	public List<Commission>  findCommissionsBySalesRepId(Integer salesRepId) {
		return new java.util.ArrayList<Commission>(commissionDAO.findCommissionsBySalesRepId(salesRepId));
	}

	@Override
	public List<Commission> findAllCommission(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Commission>(commissionDAO.findAllCommissions());
	}
}
