package it.wexpo.auth;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class TokenGenerator {
	public static String generaToken(){
	    Random random = new SecureRandom();
	    String token = new BigInteger(130, random).toString(32);
	    return token;
	}
	
	public static void main(String[] args){
		System.out.println(generaToken());
		System.out.println(generaToken());
		System.out.println(generaToken());
		System.out.println(generaToken());
		System.out.println(generaToken());
		System.out.println(generaToken());
		System.out.println(generaToken());
	}
}
