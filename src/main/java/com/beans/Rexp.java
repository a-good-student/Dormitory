package com.beans;

public class Rexp {
	public static boolean login_name(String n) {
		if(n.matches(".{4,12}?")) {
			return true;
		}
		return false;
	}
	public static boolean login_pawd(String p) {
		if(p.matches("[\\w]{4,12}?")) {
			return true;
		}
		return false;
	}
}
