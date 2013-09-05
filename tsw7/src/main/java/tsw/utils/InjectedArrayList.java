package tsw.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ListFactoryBean;

public class InjectedArrayList {

		  private List<String> myList;
		  //... any other attributes of AnyClass.
		  
		  //... any methods of AnyClass.

		  public List<String> getMyList() {
		    return myList;
		  }
		  
		  @SuppressWarnings("unchecked")
		@Autowired
		  public void setMyList(ListFactoryBean myList) {
		    if(this.myList == null) {
		      try{
		        this.myList = (List<String>)myList.getObject();
		      }catch(Exception e) {
		         e.printStackTrace();
		      }
		    }
		  }

}
