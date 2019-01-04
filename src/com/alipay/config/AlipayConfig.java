package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092300580105";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCHjGtBIMRGM35TaUqOLwa2p/brv81O6pudi8BNlLklVxrk1bBfZ8s1fOIw2P4SyJaFrgsBazTXap5POPiFxD6qVnbXKSdTbLFL4ZQgGJWLQtT3XBMO81vUftk/JMfPGiCsV0SAlQHbffFTEeyf7y2VrS1eLCkhDASfU0na0uLvEo2Qr1NXraYCDrGYsxJYFIQfv9MLG0dBFNKHnSauUT8FMX5c52N1pjZpnI2mv1ZoehUx2aW4J24gKg6loX8ldR93VMj8kmw9Uf5TsdK6lDZUBTk4yWgvxo1FPpjJy+hilUtHo6Z4wuPAlfYQV3jsPjeml4mTjePFIWB9yHMW6b+XAgMBAAECggEAEDFJGsWkTNKX87TvUB70CVv1VmJaT2QdZOut9Fag64IFV3Ljl/IZR3F8v+McLvhBawTIkcnRzS4SbVpb7fbsmYKsvbVP2lpwr6TqAg+Nxc4dDNO1/yI5RSBGKZHmQKpZXt0p9MZYK3VXH9pTTyPOaUP/2HEkFKuP3cygVQC+VVrOzfqRlgBXSuapcHn1G0dZZetTx1mH6zPHnsAicJI8TmF0Ug5L6dEp3i3djoO+D84TVArhzKSTUYWAqiysuK+CRsr3boU30fVFw8k/hPOxnLaoyKcNiL5enpkCAVtIxgU5eATa6T4NjfDM3XsqHu+Tzp0wFANbQf/dQjBDBVEHAQKBgQD1z2P0qRxnkAjyhM4VD0KHQKJuTCr4l2wJFtewb5aLQZiRnVEggy9JZu9vsBLXiyBuOAfZFWLKyFOmW0JQ6DAenge4QjPvy65z7lUwLWKa9xpZDoKCGcP6WLGugtESEQcPmURwoqJgucuefDVGBver0xYWIhA8EcxALNbLw8uwgQKBgQCNKuZYJ/sdDUdL8LKMbsTSF7FmGNnE2G29B8AX0fNXPRTtz4567Isk4bl0A8a75UqjmqBEAKJvrPVuviXMIXfJN9Nin3gkxbRsHWQc7+en+K+0/gpmTh/km2djxkzPJcWTkWPbF/vc6obj+ouy1+D937PZnvX6cyxXm737gWrkFwKBgFwWXfQChsmlhDSW3D23gcz5weBgWJjY4XhmPley9kslP+sNbJ8phkWRcpH8/JITZQrlossI4AHoGq5v8eAtnBlcSrgU1TA4thpoZzGtTwuPFyfV776duHXJVId0Kq8CAgst+B3aT8q80DOHhM2/Pnn4koWoLTzTzhkcszuTFnQBAoGAWnW/HYahN8Cmi1c2Ux84KJjeKNqL0cQOri8lPR5gnOqbWrjCSKsDjyLGQD2bQBRye9w+DtWJQZ7Ht6tJdUGNDPglEPG3f3jhYNaErLZe8BhAH+8aouw1K70Zx6nu1l8R+LoWDvOThcETp0uJ8ZS8rHKJQU7HuTHMnGdEmsIXyQkCgYAmK6gqawXQ3K9wS+jDhA+KDcmDuZPM0STIB7NRZ+rljkJqNeq+WanKLdgal7UX793BwiF1lhAdu2q8PH4bpKLpayHCOuOBTpQeIHkL4aOOp4a+588BPUK7sfpvJK+kBSQnvmJnXSqIN4Qa9OxFEflqxj1ItmYvIiCnE1PrIEcIKg==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2odbdiFuZhLxW3t0/v84hHGCCeBXIfRG1EWLf3FMjpXJeQ4/M0VY5TnMcVBh9MHdflpywh5vDlMYq3/E2GvNkjOVpZHDNl0Mw0EDXJn37SdapUyj2NIJqhL1gqpTsne1nDzch10OaLOziDmiSOQc6yoUFN2ADgn13UuPRLtspa+TSHTRB0QGU1eWvvdCbuTTGruQIeQNVkOjWFbjl8IJg/ZsqVw6HJwV/v4Rt/MEje+CHIEGkdnqpaGOiFZEGlCB0/crZyBPooAg7VHihLAKEGV2GUUnyQZTkH3+7Rq4gNrdks+d/W+oB5dygf3Sl0YZV2ExJ1nJVvGTFrUgVHfAQQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";
    
	
	//付款成功后跳转的页面
	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
	//public static String return_url = "http://localhost:8080/SSH/order_payFinished.action";
	public static String return_url = "http://localhost:8080/SSH/pay_paySuccessReturn.action";
    //http://localhost:8080/SSH/order_findOrderByUid.action?page=1
	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

