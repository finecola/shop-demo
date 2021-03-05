package com.choco.order.config;

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
    public static String app_id = "2021000116695947";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDMleWuobuGSKlL38cqkphkq4luE5JExYUVrpykBVJ1WW8KSEaQl2FL/cqhh/WXGXq1S/0hS4AA8zcIGMrXppsjhBcCc//BSfAOVfAOE555BR9+Rxj5D24FqTE8DQPQsjIyQ2Fwp5iv7X+sOMdlkxQEJoGAu+Rz6nX5vXE4fPaw07x8/eJkRF9hCnjJ2NdT6MdKDsCGQczxwOgwiq1Yz3rlZ3G20ufzWEP0MyAaftVft45/Ksy3ooT4ZZkfui1J1fucQ/39awrd9mny5MI4dF+7XXte3yYCdm75lS8H3pcwLJON0SWEBUVpX34M1H0IB4KpGWyVmsRBomqDQNmwaGtzAgMBAAECggEBAI2LD9OYdgNb9jVWZ5dewSy1OWn9BG+sMH1lx137iKdD7v0wMBINifVna3ACfrnBmRIhtsn4UGFX5DUn4f79d8xEsR6zXrk+DGX+sw0qKbQVBUr6qZ53PGmSO0wOvRsAjpYT5DBq48qkCHcA+YOfFHQip+qHFHHWPzVACjtIyexf9Og1UE+GA1/wW/VOxSAAhi8021+gR5/UsjTUGNaITXvEr80+z9/D2+Jz57YNNOar9UveVjKaNe7muuTKg3DInbzkIRga+omCsG2kNdXa5DVtm4CHJ7hRjv4cfG4vrzbLNbp7QBiI822X4GNpi9nfJeMMamnGoZmlHgOkzxanx+ECgYEA7L6mN4OoJ8NXkoGicmi9zobKDDASvfXa3E45Wa9pQ9BTbawfiOGV1egCt0NZQuL/qRwp6TTfp+hOrmX2HrSMeaQq2aFhrxhns9MXO1qirsIMtA0dLuh7KzxDhQpM05ZIUvvTo9pE2+MfCeZh7d1esA0m0Sjz4pmD/FEsVkZnqDsCgYEA3TmmPswdDa2N4pSH3P4yYNHXJYZHOkEPX/GvL/yjHNQAbToOQQeNleJGR/hCyllkai5frEyRmt/Yte1Z0icOAeYFQcj4PHqbFnchmTFl6MEd0vMGlcdw/LcIRkdZs++98mudWio/iYubq5YgFkFw5R2Wxc1T5n/ZAmjaT3ldzikCgYA3ebE/XvV/Y9HYfdIQFyUrCQC9fGJX6w1/BEGCF42GG4IBOA0nqRzQRA6m3PxEpSadfQEBKaejE9ekHDZhGZO1SVfVKXDXc9ORGszd1q46XzRU2KHXBRkfl36G5VP9XMDT2TjNs27hS8ZRLpASCgaPIHXRG1SS68A21tqZ2OOfUwKBgQCivkpCYD3vVgHO8Z2RQZ8mArjXbhTwEfSRjGZoUt5b0soNkGv0Au5xmOhDAauA2Io6YqsXQazL1mjCTT2KkBiJ5QFxB7s2Iqv8tt8Mp35k38xk50us2++OucdojAy9hlyh/fDf57yeHwoCDIrGVJYMttu33/kc1Gh8kU4osQwFIQKBgFmbO/9m7eK4j+9gDk7a49MP8WIfuvHax+BQtzKCzo+oqKyPBoCEmbx2LwnwuaRyWcgtBQt/IPHNlp+H3YF6V5fgy7lTGavZ9Eeelw2NjTUike0/AI39g9Ox77D/hZXytm9rHXma8WdpCVp5gYI9W3k3GLrfyR98W+gxWZB7ToK+";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


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

