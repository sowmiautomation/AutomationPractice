package com.tap.test.util;

import java.util.List;
import com.tap.test.base.BaseTest;

/**
 * Utility class to write utility methods
 * @author Sowmiya
 *
 */
public class Utilities extends BaseTest {

	/**
	 * Page and Implicit Timeout
	 */
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	/**
	 * Method to validate two list matches count and elements
	 * @param actualList
	 * @param expectedList
	 * @return result
	 */
	public boolean validateList(List<String> actualList, List<String> expectedList){
		boolean b = false;
		if(actualList.size() == expectedList.size())
			for (int i = 0; i < actualList.size(); i++) {
				if(actualList.get(i).equals(expectedList.get(i))){
					b = true;
				}
				else {
					b = false;
					break;
				}
			}
		return b;		
	}
}
