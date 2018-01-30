package Cookie.hostry;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtiles {
	public static Cookie getCookieByName(HttpServletRequest 
			request,String name){
		Cookie cookie =null;
		
		Cookie[] cookies=request.getCookies();
		
		if(cookies!=null){
			for(Cookie c: cookies){
				if(name.equals(c.getName())){
					cookie=c;
				}
			}
		}
		return cookie;
	}
	
}
