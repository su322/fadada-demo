package com.yulintu.fadada.demo.configs;

import com.fasc.open.api.v5_1.client.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 法大大 SDK 客户端配置类
 */
@Configuration
public class FadadaSdkConfig {

    @Bean
    public OpenApiClient openApiClient(FadadaConfig config) {
        //1.初始化客户端，注意填写正确的AppId和AppSecret
        OpenApiClient openApiClient = new OpenApiClient(config.getAppId(), config.getAppSecret(), config.getEndpoint());
        // http超时配置设置， 默认不设置超时时间
        // 如果不设置超时时间 该设置可忽略
//        HttpConfig httpConfig=new HttpConfig();
//        httpConfig.setConnectTimeout(1000000);
//        httpConfig.setReadTimeout(1000000);
//        openApiClient.setHttpConfig(httpConfig);
        // Json序列化策略，默认使用Jackson，如果要使用其他如FastJson,Gson等实现JsonStrategy接口即可
        // 如果使用默认该设置可以忽略
//        openApiClient.setJsonStrategy(new DefaultJsonStrategy());
        return openApiClient;
    }

    @Bean
    public ServiceClient serviceClient(OpenApiClient openApiClient) {
        return new ServiceClient(openApiClient);
    }

    @Bean
    public UserClient userClient(OpenApiClient openApiClient) {
        return new UserClient(openApiClient);
    }

    @Bean
    public CorpClient corpClient(OpenApiClient openApiClient) {
        return new CorpClient(openApiClient);
    }

    @Bean
    public SignTaskClient signTaskClient(OpenApiClient openApiClient) {
        return new SignTaskClient(openApiClient);
    }

    @Bean
    public DocClient docClient(OpenApiClient openApiClient) {
        return new DocClient(openApiClient);
    }

    @Bean
    public AppClient appClient(OpenApiClient openApiClient) {
        return new AppClient(openApiClient);
    }
}
