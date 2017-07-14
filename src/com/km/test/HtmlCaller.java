/*	
 * file 		 : HtmlCaller.java
 * created by    : kmyu
 * creation-date : 2016. 11. 18.
 */

package com.km.test;

import com.km.util.HttpUtil;
import com.km.util.HttpUtil2;

public class HtmlCaller {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//String content = HttpUtil.toHtmlStr("http://great.smartworks.net");
		
		String content = HttpUtil2.toHtmlString("http://great.smartworks.net");
		
		
		System.out.println(content);
		
	}

}

