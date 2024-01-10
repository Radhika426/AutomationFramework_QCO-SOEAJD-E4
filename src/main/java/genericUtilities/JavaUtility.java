package genericUtilities;

import java.util.Date;

/**
 * This class consists of reusable methods related to Java 
 * @author Radhika S
 *
 */

public class JavaUtility {
        
	    /**
	     * This method will return the current System Date in specified format
	     * @return currentDate
	     */
	    public String getSystemDate() {
	    	Date d = new Date();
	    	String[] dArr = d.toString().split(" ");
	    	String currentDate=dArr[2]+"-"+dArr[1]+"-"+dArr[5]+" "+dArr[3].replace(":","_");
	    	return currentDate;
	    }		
}
