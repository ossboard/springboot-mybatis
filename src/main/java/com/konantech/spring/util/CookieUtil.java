package com.konantech.spring.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CookieUtil {
	private static Logger log = LoggerFactory.getLogger(CookieUtil.class);
	/**
	 * 쿠키값 세팅
	 * 
	 * @sample CookieUtil.setCookie(response, "name", "value", "maxAge")
	 */
	public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue, int maxAge) {
		try {
			cookieValue = URLEncoder.encode(cookieValue, "UTF-8");
			Cookie cookie = new Cookie(cookieName, cookieValue);
			cookie.setPath("/");
			if(maxAge > 0) {
				cookie.setMaxAge(60 * 60 * 24 * maxAge);
			} else {
				cookie.setMaxAge(maxAge); //0-remove, -1 -browser close
			}
			cookie.setPath("/");
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
		}

	}

	public static void setDomainCookie(HttpServletResponse response, String cookieName, String cookieValue, String domain, int maxAge) {
		try {
			cookieValue = URLEncoder.encode(cookieValue, "UTF-8");
			Cookie cookie = new Cookie(cookieName, cookieValue);
			cookie.setDomain(domain);
			if(maxAge > 0) {
				cookie.setMaxAge(60 * 60 * 24 * maxAge);
			} else {
				cookie.setMaxAge(maxAge); //0-remove, -1 -browser close
			}
			cookie.setPath("/");
			response.addCookie(cookie);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * 쿠키값 가져오기
	 * 
	 * @sample CookieUtil.getCookie(request, "name")
	 */
	public static String getCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		String cookieValue = null;
		try {
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookieName.equals(cookies[i].getName())  ) {
						cookieValue = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
						break;
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
		}
		return cookieValue;
	}

	/**
	 * 쿠키값 가져오기
	 * 
	 * @sample CookieUtil.getCookieNoneDecode(request, "name")
	 */
	public static String getCookieNoneDecode(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		String cookieValue = null;
		try {
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookieName.equals(cookies[i].getName())) {
						cookieValue = cookies[i].getValue();
						break;
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return cookieValue;
	}

	/**
	 * 쿠키값 삭제
	 * 
	 * @sample CookieUtil.removeCookie"name")
	 */
	public static void removeCookie(HttpServletResponse response, String cookieName) {
		Cookie cookie = new Cookie(cookieName, "");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	public static void removeDomainCookie(HttpServletResponse response, String cookieName, String domain ) {
		Cookie cookie = new Cookie(cookieName, "");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		cookie.setDomain(domain);
		response.addCookie(cookie);
	}

	public static void removeAllCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		
		for( Cookie cookie : cookies ) {
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
	}

	
}
