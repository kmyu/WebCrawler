/*	
 * file 		 : JsonTester.java
 * created by    : kmyu
 * creation-date : 2016. 11. 18.
 */

package com.km.test;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import com.km.util.HttpUtil;

public class JsonTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String targetSite = "http://www.naver.com";

		String targetSiteMainHtml = HttpUtil.toHtmlStr(targetSite);
		
		Document doc = Jsoup.parse(targetSiteMainHtml);
		
		//add targetSiteAddr
		List targetSiteList = new ArrayList();
		targetSiteList.add(targetSite);
		
		//find sub site linke and add subLinkAddr 
		Elements links = doc.select("a[href]");
		for (Element linkEle : links) {
			String linkAddr = linkEle.attr("href");
			if (linkAddr.startsWith("http")) {
				targetSiteList.add(linkAddr);
			}
		}
		
		List resultKeyword = new ArrayList();
		
		for (int i = 0; i < targetSiteList.size(); i++) {
			//System.out.println(targetSiteList.get(i));
			
			String html = HttpUtil.toHtmlStr((String)targetSiteList.get(i));
			
			String pageString = Jsoup.parse(html, "ISO-8859-1").select("body").text();
			
			String[] strings = StringUtils.tokenizeToStringArray(pageString, " ");
			
			StringBuffer strBuff = new StringBuffer();
			for (int j = 0; j < strings.length; j++) {
				//System.out.println(j + " : " + strings[j]);
				
				//if (!resultKeyword.contains(strings[j])) {
				//	resultKeyword.add(strings[j]);
				//}
				if (j%10 == 0) {
					strBuff.append(" " + strings[j]);
					resultKeyword.add(strBuff.toString());
					strBuff.setLength(0);
				} else {
					strBuff.append(" " + strings[j]);
				}
			}
		}
		
		for (int i = 0; i < resultKeyword.size(); i++) {
			System.out.println(i + " : " + resultKeyword.get(i)); 
		}
		
	}

}

