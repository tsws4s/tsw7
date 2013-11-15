package tsw.service;


/**
 * Spring MVC controller that handles CRUD requests for Users entities
 * 
 */

public class UsersController {

	static int defaultMaxRows = 100;
    
	public static int getDefaultMaxRows() {
		return defaultMaxRows;
	}

	public static void setDefaultMaxRows(int defaultMaxRows) {
		UsersController.defaultMaxRows = defaultMaxRows;
	}

}