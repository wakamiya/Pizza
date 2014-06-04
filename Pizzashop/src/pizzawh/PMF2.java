package pizzawh;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
public class PMF2 {
	private static final PersistenceManagerFactory factory = 
	        JDOHelper.getPersistenceManagerFactory("transactions-optional");
	     
	    private PMF2(){}
	     
	    public static PersistenceManagerFactory get(){
	        return factory;
	    }
}

