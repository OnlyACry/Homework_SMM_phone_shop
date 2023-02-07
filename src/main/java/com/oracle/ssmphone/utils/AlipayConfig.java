package com.oracle.ssmphone.utils;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
	// ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000122605874";

	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCfE8VQWb6yIqDWniRsK76RdjKHLiWk/C4IZWGJvP36guI8JoT6DxKoWsNQWsGXDB8WUXPJOLtlarY1cRpGK3BdoB5LImpJ2gK50EQTHJHPfz8HhgFWb55hz7L7geu1Bw3gdnNGo50NrPpMMpfF7iTz5FFRK7drFQ646nsSM7Yf18no9RYOSUa/nxnlmd2Ftyzl5q0CWMv0ZWrPpegdvNUxt2ZGy4D9ROc3M7KMh2yYVqAsQMni1VoWarRAXFfBDJkl0a0sXsrBTB9gH8qYINy9hRv8Wg7ejAQBEEVi7vqLAbu5mP8PZS9UdUQC+54b9WhoGcuza2tyA5uK/BYmmsc9AgMBAAECggEABaGdioqixYuURgSzJWEnDd8xSrfHfV+wAXwVR9r44rVfbOGwM2n1LyCHaYDM+ZvkPdYEU0s+1whACwRF+dXv1GCmseI2AQdGsW09+683OjE2+f00burkoHHJ1D11KqNlSlznF8kS9jj5Y1knJkqX5Epg1o7Fn3TPYJxsXuiVuerLG1rTJRIuJYJ7+PVvL/0U3dcdOeE6SyuCx8jfz0SScngOaHAA2Gtw7ZHK4xFXHrgDniY58bSDlT11/8EIuBqxJj2dJ9oaGeB+Jd31BagJeQ2hIO+Rs5rPvHCLeFDGkupny7i/9lzVzeJAxeO4thjmEdrpclVg7mgDQ4otrBkpwQKBgQD1VkAYP7sLcGvGOdnzNAC/WnVEI0LF/JyTwEr8j6SFqIbTSbKPIR7PxTZF6/T+3Aj65XBO+2pNxnxKLoh2xKucrgkItNPj44XldTz1rE22n0AdoaAcPBxQJhAqWrXrBMX9i5lellJX7V0JIXxEuMDPmyGUrlTwTtSzm3J+284qqwKBgQCl/b/ABnbsxy+h20NuInSRald4psKVX08+3KJ35eMn6uZTYCRHcNyshRxFP+KErkZTYfn1nW/C2YbGLxC8qsnlacvMeIHb1YsUI8/5mSuFVft73Uwx18lgE3dJuTBbCMYJa7s/d6lVVlDf8OQjVqtPOlLGVKpsmHxniy9qdi7VtwKBgF5NW++2N4hrGxIj1JH2MD9dXuvk/dqqgekNJgW0lRHHOKPolRkNKxHEBVuVGiQIoe8G2EeTvkXNAKNnBY9Zg3mDL/fHwha7sxEDIn5wT6LdzcBWCvwvYtav+tC882Y1/IC78yT3dQlVNMi4tVKZDYv/XkYPSJjiREIRg04d4T5nAoGAEnTXeEt/t64iHrYZlkpgebbASRsJscAqOIwhyIEYM90LhSPAhO0IrGoUjaKf1i7mhOj0+RlrTtgPA0RCcSfwUQDldzPDBKWG1FNzEYa1bxrzXn9ptHUQ4AzqC5l6xfSAyJVg+Zqdim6RiYToaQF/BM0wXPsXBAIkewLf38+KP5sCgYEAs4zMlJopw3+lCwPAHDm16hyqZhwzkvbJrV3aBfFGY3VJOcwXZDCsdcOPqIWVx3oDQTfC8Qp3qk9sRSc7CQqE8Aw5xPboZZvNnL61xkVHomaS40A8qW1C87Kxa0goklOcFHYcfoxGodX0VcnjHFKV4NSJCkasfHuT/cydmixF300=";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
	// 对应APPID下的支付宝公钥(不是应用公钥)。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA13QO5yH4vRZIlnDi0DYQ1g8B3EgWPwmOUnU4llvgHI07QG7Tay3QDF+4wwwakM6/GemXnJPt/BqMmWEVUMd8cfEQz0tOn8rgg4oAnq5msSm1XYGfF4JIfT5vbGr72IN9sUWIUvpa2QnaMoSQCSeHDxWnhN8K/lDYV6sUVUJiOb19cYUIkSzRSPG7gwLR93r+MijSBOQc4U79/fLiiaExr0mADRU6GivID1f9hhYnZkwEQeRHc9elflc0N14kY9k6N84BpuRwdfFgfGC3Fma7m3HMlkTeJgs4VrPP6gkZ4EhxxudFRE03/3IFn1F6ED5Rvhvmg3izgOyz4AZEjghlewIDAQAB";
	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8088/ssmphone_war_exploded/userOrder/payresult";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8088/ssmphone_war_exploded/userOrder/payresult";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关 //
	// public static String gatewayUrl ="https://openapi.alipay.com/gateway.do";// 正式
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";// 测试

	// 支付宝网关 日志
	public static String log_path = "D:\\alipay\\";

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	/**
	 * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	 * 
	 * @param sWord
	 *            要写入日志里的文本内容
	 */
	public static void logResult(String sWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
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