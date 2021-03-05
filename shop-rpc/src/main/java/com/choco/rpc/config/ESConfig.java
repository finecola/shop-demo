package com.choco.rpc.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by choco on 2021/1/5 10:22
 */
@Configuration
public class ESConfig {
//    @Value("${elasticsearch.address}")
//    private HttpHost[] address;

    //ES服务器连接方式
    private final static String SCHEME = "http";

    /*@Bean
    public HttpHost bulidHttpHost(String s) {
        String[] address = s.split(":");
        if (2 != address.length) {
            return null;
        }
        String host = address[0];
        Integer port = Integer.valueOf(address[1]);
        return new HttpHost(host, port, SCHEME);
    }*/

  /*  @Bean
    public RestClientBuilder restClientBuilder(){
        HttpHost[] hosts = {

        return RestClient.builder(hosts);
    }
*/

    /**
     * 以RestClientBuilder为基础,创建RestHighLevelClient
     */
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        return new RestHighLevelClient(RestClient.builder(
                new HttpHost("114.215.183.44",9200,SCHEME),
                new HttpHost("114.215.183.44",9201,SCHEME),
                new HttpHost("114.215.183.44",9202,SCHEME)
        ));
    }
}
