package com.hzfh.rest_p2p.common.config.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="webInfo", locations = {"classpath:webInfo.yml"})
public class WebInfo {
	private static String webp2pwww;
	private static String webp2prestService;
	private static String webp2psignUrl;
	private static String webp2pupload;
	private static String webupload;
	private static String webimg;
	private static String webbackurl;
	private static String webtopdomain;
	private static String paymenturlgateway;
	private static String paymenturlconnection;
	private static String paymentsignname;
	private static String paymentsignpsw;
	private static String webuploadaction;
	private static String webPlatformUserNotype;
	private static String webredis;
	private static String paymenturlgatewayApp;
	private static String webYeepayPlatformNo;//易宝测试平台编号
	private static String webYeepayVerifySign;//是否验签标识
	private static String paymenturlgatewayTest;//是否验签标识
	private static String paymenturlconnectionTest;//是否验签标识
	private static String webP2pResourceImg;//图片路径地址	
	/**
	 * 网关请求地址
	 */
	private static String CGTrequestUrlGateway;
	/**
	 * 直连请求地址
	 */
	private static String CGTrequestUrlConnection;
	/**
	 * 平台编号
	 */
	private static String CGTplatformNo;
	/**
	 * 证书序号，用于多证书密钥切换，默认 1
	 */
	private static String CGTkeySerial;
	/**
	 * 公钥
	 */
	private static String CGTpublicKey1;
	/**
	 * 私钥
	 */
	private static String CGTprivateKey1;
	/**
	 * 存管通验签公Key
	 */
	private static String CGTpublicKeySign;//存管通验签公Key
	/**
	 * 网贷协会地址
	 */
	private static String wdxhUrl;
	/**
	 * 网贷协会用户名
	 */
	private static String wdxhUser;
	/**
	 * 网贷协会密码
	 */
	private static String wdxhPWD;
	
	/**
	 * 网贷协会平台编号
	 */
	private static String wdxhSouceCode;
	
	/**
	 * 后台地址
	 */
	private static String webp2pbackwww;
	
	/**
	 * 中关村  - 公钥
	 */
	private static String ZGCpublicKey;
	/**
	 * 中关村  - 私钥
	 */
	private static String ZGCprivateKey;
	/**
	 * 中关村协会  - 公钥
	 */
	private static String ZGCXHpublicKey;
	/**
	 * 中关村 对称加密密钥
	 */
	private static String ZGCdeskey;
	
	/**
	 * 客户号
	 */
	private static String ZGCplatform;
	
    /**
     * 本地公钥
     */
    private  static  String  rsaLocalPublicKey;
    /**
     * 本地私钥
     */
    private  static  String rsaLocalPrivateKey;
    /**
     * PC 公钥
     */
    private  static  String rsaPCPublicKey;
    /**
     * android 公钥
     */
    private  static  String rsaAndroidPublicKey;
    /**
     * iphone 公钥
     */
    private  static  String resaIphonePublicKey;
    
	public static String getWebp2pwww() {
		return webp2pwww;
	}
	public static void setWebp2pwww(String webp2pwww) {
		WebInfo.webp2pwww = webp2pwww;
	}
	public static String getWebp2prestService() {
		return webp2prestService;
	}
	public static void setWebp2prestService(String webp2prestService) {
		WebInfo.webp2prestService = webp2prestService;
	}
	public static String getWebp2pupload() {
		return webp2pupload;
	}
	public static void setWebp2pupload(String webp2pupload) {
		WebInfo.webp2pupload = webp2pupload;
	}
	public static String getWebupload() {
		return webupload;
	}
	public static void setWebupload(String webupload) {
		WebInfo.webupload = webupload;
	}
	public static String getWebimg() {
		return webimg;
	}
	public static void setWebimg(String webimg) {
		WebInfo.webimg = webimg;
	}
	public static String getWebbackurl() {
		return webbackurl;
	}
	public static void setWebbackurl(String webbackurl) {
		WebInfo.webbackurl = webbackurl;
	}
	public static String getWebtopdomain() {
		return webtopdomain;
	}
	public static void setWebtopdomain(String webtopdomain) {
		WebInfo.webtopdomain = webtopdomain;
	}
	public static String getPaymenturlgateway() {
		return paymenturlgateway;
	}
	public static void setPaymenturlgateway(String paymenturlgateway) {
		WebInfo.paymenturlgateway = paymenturlgateway;
	}
	public static String getPaymenturlconnection() {
		return paymenturlconnection;
	}
	public static void setPaymenturlconnection(String paymenturlconnection) {
		WebInfo.paymenturlconnection = paymenturlconnection;
	}
	public static String getPaymentsignname() {
		return paymentsignname;
	}
	public static void setPaymentsignname(String paymentsignname) {
		WebInfo.paymentsignname = paymentsignname;
	}
	public static String getPaymentsignpsw() {
		return paymentsignpsw;
	}
	public static void setPaymentsignpsw(String paymentsignpsw) {
		WebInfo.paymentsignpsw = paymentsignpsw;
	}
	public static String getWebuploadaction() {
		return webuploadaction;
	}
	public static void setWebuploadaction(String webuploadaction) {
		WebInfo.webuploadaction = webuploadaction;
	}
	public static String getWebPlatformUserNotype() {
		return webPlatformUserNotype;
	}
	public static void setWebPlatformUserNotype(String webPlatformUserNotype) {
		WebInfo.webPlatformUserNotype = webPlatformUserNotype;
	}
	public static String getWebredis() {
		return webredis;
	}
	public static void setWebredis(String webredis) {
		WebInfo.webredis = webredis;
	}
	public static String getPaymenturlgatewayApp() {
		return paymenturlgatewayApp;
	}
	public static void setPaymenturlgatewayApp(String paymenturlgatewayApp) {
		WebInfo.paymenturlgatewayApp = paymenturlgatewayApp;
	}
	public static String getWebp2psignUrl() {
		return webp2psignUrl;
	}
	public static void setWebp2psignUrl(String webp2psignUrl) {
		WebInfo.webp2psignUrl = webp2psignUrl;
	}
	public static String getWebYeepayPlatformNo() {
		return webYeepayPlatformNo;
	}
	public static void setWebYeepayPlatformNo(String webYeepayPlatformNo) {
		WebInfo.webYeepayPlatformNo = webYeepayPlatformNo;
	}
	public static String getWebYeepayVerifySign() {
		return webYeepayVerifySign;
	}
	public static void setWebYeepayVerifySign(String webYeepayVerifySign) {
		WebInfo.webYeepayVerifySign = webYeepayVerifySign;
	}
	public static String getPaymenturlgatewayTest() {
		return paymenturlgatewayTest;
	}
	public static void setPaymenturlgatewayTest(String paymenturlgatewayTest) {
		WebInfo.paymenturlgatewayTest = paymenturlgatewayTest;
	}
	public static String getPaymenturlconnectionTest() {
		return paymenturlconnectionTest;
	}
	public static void setPaymenturlconnectionTest(String paymenturlconnectionTest) {
		WebInfo.paymenturlconnectionTest = paymenturlconnectionTest;
	}
	public static String getWebP2pResourceImg() {
		return webP2pResourceImg;
	}
	public static void setWebP2pResourceImg(String webP2pResourceImg) {
		WebInfo.webP2pResourceImg = webP2pResourceImg;
	}
	public static String getCGTrequestUrlGateway() {
		return CGTrequestUrlGateway;
	}
	public static void setCGTrequestUrlGateway(String cGTrequestUrlGateway) {
		CGTrequestUrlGateway = cGTrequestUrlGateway;
	}
	public static String getCGTrequestUrlConnection() {
		return CGTrequestUrlConnection;
	}
	public static void setCGTrequestUrlConnection(String cGTrequestUrlConnection) {
		CGTrequestUrlConnection = cGTrequestUrlConnection;
	}
	public static String getCGTplatformNo() {
		return CGTplatformNo;
	}
	public static void setCGTplatformNo(String cGTplatformNo) {
		CGTplatformNo = cGTplatformNo;
	}
	public static String getCGTkeySerial() {
		return CGTkeySerial;
	}
	public static void setCGTkeySerial(String cGTkeySerial) {
		CGTkeySerial = cGTkeySerial;
	}
	public static String getCGTpublicKey1() {
		return CGTpublicKey1;
	}
	public static void setCGTpublicKey1(String cGTpublicKey1) {
		CGTpublicKey1 = cGTpublicKey1;
	}
	public static String getCGTprivateKey1() {
		return CGTprivateKey1;
	}
	public static void setCGTprivateKey1(String cGTprivateKey1) {
		CGTprivateKey1 = cGTprivateKey1;
	}
	public static String getCGTpublicKeySign() {
		return CGTpublicKeySign;
	}
	public static void setCGTpublicKeySign(String cGTpublicKeySign) {
		CGTpublicKeySign = cGTpublicKeySign;
	}
	public static String getWdxhUser() {
		return wdxhUser;
	}
	public static void setWdxhUser(String wdxhUser) {
		WebInfo.wdxhUser = wdxhUser;
	}
	public static String getWdxhPWD() {
		return wdxhPWD;
	}
	public static void setWdxhPWD(String wdxhPWD) {
		WebInfo.wdxhPWD = wdxhPWD;
	}
	public static String getWdxhUrl() {
		return wdxhUrl;
	}
	public static void setWdxhUrl(String wdxhUrl) {
		WebInfo.wdxhUrl = wdxhUrl;
	}
	public static String getWdxhSouceCode() {
		return wdxhSouceCode;
	}
	public static void setWdxhSouceCode(String wdxhSouceCode) {
		WebInfo.wdxhSouceCode = wdxhSouceCode;
	}
	public static String getWebp2pbackwww() {
		return webp2pbackwww;
	}
	public static void setWebp2pbackwww(String webp2pbackwww) {
		WebInfo.webp2pbackwww = webp2pbackwww;
	}
	public static String getZGCpublicKey() {
		return ZGCpublicKey;
	}
	public static void setZGCpublicKey(String zGCpublicKey) {
		ZGCpublicKey = zGCpublicKey;
	}
	public static String getZGCprivateKey() {
		return ZGCprivateKey;
	}
	public static void setZGCprivateKey(String zGCprivateKey) {
		ZGCprivateKey = zGCprivateKey;
	}
	public static String getZGCXHpublicKey() {
		return ZGCXHpublicKey;
	}
	public static void setZGCXHpublicKey(String zGCXHpublicKey) {
		ZGCXHpublicKey = zGCXHpublicKey;
	}
	public static String getZGCdeskey() {
		return ZGCdeskey;
	}
	public static void setZGCdeskey(String zGCdeskey) {
		ZGCdeskey = zGCdeskey;
	}
	public static String getZGCplatform() {
		return ZGCplatform;
	}
	public static void setZGCplatform(String zGCplatform) {
		ZGCplatform = zGCplatform;
	}
	public static String getRsaLocalPublicKey() {
		return rsaLocalPublicKey;
	}
	public static void setRsaLocalPublicKey(String rsaLocalPublicKey) {
		WebInfo.rsaLocalPublicKey = rsaLocalPublicKey;
	}
	public static String getRsaLocalPrivateKey() {
		return rsaLocalPrivateKey;
	}
	public static void setRsaLocalPrivateKey(String rsaLocalPrivateKey) {
		WebInfo.rsaLocalPrivateKey = rsaLocalPrivateKey;
	}
	public static String getRsaPCPublicKey() {
		return rsaPCPublicKey;
	}
	public static void setRsaPCPublicKey(String rsaPCPublicKey) {
		WebInfo.rsaPCPublicKey = rsaPCPublicKey;
	}
	public static String getRsaAndroidPublicKey() {
		return rsaAndroidPublicKey;
	}
	public static void setRsaAndroidPublicKey(String rsaAndroidPublicKey) {
		WebInfo.rsaAndroidPublicKey = rsaAndroidPublicKey;
	}
	public static String getResaIphonePublicKey() {
		return resaIphonePublicKey;
	}
	public static void setResaIphonePublicKey(String resaIphonePublicKey) {
		WebInfo.resaIphonePublicKey = resaIphonePublicKey;
	}

}
