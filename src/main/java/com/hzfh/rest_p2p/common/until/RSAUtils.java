package com.hzfh.rest_p2p.common.until;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class RSAUtils {
	
	public static final String KEY_ALGORITHM = "RSA";
	/**
	 * 算法/模式/填充
	 */
	public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";
	/**
	 * 还原公钥，X509EncodedKeySpec 用于构建公钥的规范
	 * @param keyBytes
	 * @return
	 */
	private static PublicKey restorePublicKey(String publickey) {
		try {
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(new BASE64Decoder().decodeBuffer(publickey));
			KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
			PublicKey publicKey = factory.generatePublic(x509EncodedKeySpec);
			return publicKey;
		} catch (NoSuchAlgorithmException | IOException |InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * 还原私钥，PKCS8EncodedKeySpec 用于构建私钥的规范
	 * @param keyBytes
	 * @return
	 */
	private static PrivateKey restorePrivateKey(String keyBytes) {
		try {
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(new BASE64Decoder().decodeBuffer(keyBytes));
			KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
			PrivateKey privateKey = factory.generatePrivate(pkcs8EncodedKeySpec);
			return privateKey;
		} catch (NoSuchAlgorithmException | IOException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 加密
	 * @param key
	 * @param plainText
	 * @return
	 */
	public static String RSAEncode(String plainText,String publicKey) {
		PublicKey pk = restorePublicKey(publicKey);
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, pk);
			 byte[] res = cipher.doFinal(plainText.getBytes());
			return new BASE64Encoder().encode(res);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 解密
	 * @param key
	 * @param encodedText
	 * @return
	 */
	public static String RSADecode(String encodedText,String privateKey) {
		PrivateKey pk = restorePrivateKey(privateKey);
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, pk);
			return new String(cipher.doFinal(new BASE64Decoder().decodeBuffer(encodedText)));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException  | IOException  e) {
			e.printStackTrace();
		}
		return null;
	}
}
