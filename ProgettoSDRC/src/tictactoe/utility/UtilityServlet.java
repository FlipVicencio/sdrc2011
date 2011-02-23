package tictactoe.utility;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class UtilityServlet {

	static public String getHead(String title){
	String docType =
		"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
		"Transitional//EN\">\n";
	
	return(docType +
			"<HTML>\n" +
			"<HEAD><TITLE>" + title + "</TITLE></HEAD>\n");
	}

	public static String getCookieValue	(HttpServletRequest request, String cookieName,
						String defaultValue) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for(Cookie cookie: cookies) {
				if (cookieName.equals(cookie.getName())) {
					return(cookie.getValue());
				}
			}
		}
		return(defaultValue);
	}
	
	static public String replaceIfMissing(String orig,String replacement) {
		if ((orig == null) || (orig.trim().equals(""))) {
		return(replacement);
		} else {
		return(orig);
		}
	}
	public static String filter(String input){
		if (!hasSpecialChars(input)) {
			return(input);
		}
		StringBuffer filtered =
			new StringBuffer(input.length());
		char c;
		for(int i=0; i<input.length(); i++) {
			c = input.charAt(i);
			switch(c) {
			case '<': filtered.append("&lt;"); break;
			case '>': filtered.append("&gt;"); break;
			case '"': filtered.append("&quot;"); break;
			case '&': filtered.append("&amp;"); break;
			default: filtered.append(c);
			}
		}
		return(filtered.toString());
	}
 
  private static boolean hasSpecialChars(String input){
		boolean flag = false;
		if ((input != null) && (input.length() > 0)) {
			char c;
			for(int i=0; i<input.length(); i++) {
				c = input.charAt(i);
				switch(c) {
				case '<': flag = true; break;
				case '>': flag = true; break;
				case '"': flag = true; break;
				case '&': flag = true; break;
				}
			}
		}
		return(flag);
	}
  
}
