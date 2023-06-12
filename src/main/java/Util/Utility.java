package Util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Utility {

	public static String digest(String password) {
		//■平文の文字列をハッシュ値に変換する
		MessageDigest messageDigest;
		byte[] digest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			//MD5形式のハッシュ値を計算する => 128bit
			digest = messageDigest.digest(password.getBytes("UTF-8"));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//128bit => 32桁の16進数に変換する
		String hexDigest = DatatypeConverter.printHexBinary(digest);
		return hexDigest;
	}
}
