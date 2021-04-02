package com.tp.TP.ressource;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/*
 * Classe Static contenant les methodes responsables pour le Hash des mots de passe avant de les enregistrer dans la BDD 
 */

public class HashClass {
	
	public static String StringToSHA256Hash(String StringToHash) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] digest = md.digest(StringToHash.getBytes(StandardCharsets.UTF_8));
		return bytesToHex(digest);
	}
	
	private static String bytesToHex(byte[] hash) {
	    StringBuilder hexString = new StringBuilder(2 * hash.length);
	    for (int i = 0; i < hash.length; i++) {
	        String hex = Integer.toHexString(0xff & hash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
}
