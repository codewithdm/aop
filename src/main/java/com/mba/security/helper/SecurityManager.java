package com.mba.security.helper;

import com.mba.security.beans.Credential;



public class SecurityManager {
	private static SecurityManager instance;
	private ThreadLocal<Credential> userCredentials;

	private SecurityManager() {
		userCredentials = new ThreadLocal<Credential>();
	}

	public synchronized static SecurityManager getInstance() {
		if (instance == null) {
			instance = new SecurityManager();
		}
		return instance;

	}

	public void login(String userName, String password) {
		Credential userCredential = null;

		userCredential = new Credential(userName, password);
		userCredentials.set(userCredential);
	}

	public void logout() {
		userCredentials.set(null);
	}

	public boolean isAuthenticated() {
		Credential userCredential = null;
		if (userCredentials.get() != null) {
			userCredential = userCredentials.get();
			if (userCredential.getUserName().equals("kiran") && userCredential.getPassword().equals("welcome")) {
				return true;
			}
		}
		return false;
	}

	public String getLoggedInUser() {
		Credential userCredential = null;
		if (userCredentials.get() != null) {
			userCredential = userCredentials.get();
			return userCredential.getUserName();
		}
		return null;
	}
}
