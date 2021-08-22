package com.github.sparkzxl.ids.infrastructure.config;

import com.fujieid.jap.ids.JapIds;
import com.fujieid.jap.ids.config.IdsConfig;
import com.fujieid.jap.ids.config.JwtConfig;
import com.fujieid.jap.ids.context.IdsContext;
import com.fujieid.jap.ids.filter.IdsAccessTokenFilter;
import com.fujieid.jap.ids.pipeline.IdsPipeline;
import com.fujieid.jap.ids.service.IdsClientDetailService;
import com.fujieid.jap.ids.service.IdsIdentityService;
import com.fujieid.jap.ids.service.IdsUserService;
import com.xkcoding.json.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @date 2021-04-14 10:25
 * @since 1.0.0
 */
@Configuration
public class JapIdsConfiguration implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    private IdsClientDetailService idsClientDetailService;
    @Autowired
    private IdsUserService idsUserService;
    @Autowired
    private IdsIdentityService idsIdentityService;
    @Value("${server.port}")
    private int port;

    /**
     * 程序启动完成后，注册 ids 的上下文
     *
     * @param applicationStartedEvent applicationStartedEvent
     */
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        // 注册 JAP IDS 上下文
        String issuer = "http://localhost:" + port;
        JapIds.registerContext(new IdsContext()
                        .setUserService(idsUserService)
                        .setClientDetailService(idsClientDetailService)
                        .setIdentityService(idsIdentityService)
                        .setFilterPipeline(new IdsPipeline<Object>() {
                            @Override
                            public void errorHandle(ServletRequest servletRequest, ServletResponse servletResponse, Throwable throwable) {
                                System.out.println("filter 抛异常了");
                            }
                        })
                        .setIdsConfig(new IdsConfig()
                                        .setIssuer(issuer)

                                        /*
                                        这儿作为演示，将 ConfirmPageUrl 配置为完整地址，意思等同于将 ConfirmPageUrl 托管到单独服务。
                                        此种情况（ConfirmPageUrl = https://xxxx.xxx.xxx） 时，必须配置 ExternalConfirmPageUrl=true

                                        如果确认授权页面（包含自定义的授权页或者 ids 内置的确认授权页）位于当前授权服务下（即共用一个域名），则必须保证 ExternalConfirmPageUrl=false

                                        注意：LoginPageUrl 的用法和 ConfirmPageUrl 一致

                                        本 demo 提供了自定义的确认授权页面和自定义的登录页面，也支持内置的确认授权和登录页面。如果想查看默认的登录和确认授权页面，可以将下方四条配置注释掉。

                                         */
//                        .setConfirmPageUrl(issuer + "/oauth/confirm/customize")
//                        .setExternalConfirmPageUrl(true)
//                        .setLoginPageUrl(issuer + "/oauth/login/customize")
//                        .setExternalLoginPageUrl(true)

                                        .setJwtConfig(new JwtConfig()
                                                .setJwksKeyId("jap-jwk-keyid")
                                                .setJwksJson("{\n" +
                                                        "    \"keys\": [\n" +
                                                        "        {\n" +
                                                        "            \"p\": \"v5G0QPkr9zi1znff2g7p5K1ac1F2KNjXmk31Etl0UrRBwHiTxM_MkkldGlxnXWoFL4_cPZZMt_W14Td5qApknLFOh9iRWRPwqlFgC-eQzUjPeYvxjRbtV5QUHtbzrDCLjLiSNyhsLXHyi_yOawD2BS4U6sBWMSJlL2lShU7EAaU\",\n" +
                                                        "            \"kty\": \"RSA\",\n" +
                                                        "            \"q\": \"s2X9UeuEWky_io9hFAoHZjBxMBheNAGrHXtWat6zlg2tf_SIKpZ7Xs8C_-kr9Pvj-D428QsOjFZE-EtNBSXoMrvlMk7fGDl9x1dHvLS9GSitkXH2-Wthg8j0j0nfAmyEt94jP-XEkYic1Ok7EfBOPuvL21HO7YuB-cOff9ZGvBk\",\n" +
                                                        "            \"d\": \"Rj-QBeBdx85VIHkwVY1T94ZeeC_Z6Zw-cz5lk5Msw0U9QhSTWo28-d2lYjK7dhQn-E19JhTbCVE11UuUqENKZmO__yRgO1UJaj2x6vWMtgJptah7m8lI-QW0w6TnVxAHWfRPpKSEfbN4SpeufYf5PYhmmzT0A954Z2o0kqS4iHd0gwNAovOXaxriGXO1CcOQjBFEcm0BdboQZ7CKCoJ1D6S0xZpVFSJg-1AtagY5dzStyekzETO2tQSmVw4ogIoJsIbu3aYwbukmCoULQfJ36D0mPzrTG5oocEbbuCps_vH72VjZORHHAl4hwritFT_jD2bdQHSNMGukga8C0L1WQQ\",\n" +
                                                        "            \"e\": \"AQAB\",\n" +
                                                        "            \"use\": \"sig\",\n" +
                                                        "            \"kid\": \"jap-jwk-keyid\",\n" +
                                                        "            \"qi\": \"Asr5dZMDvwgquE6uFnDaBC76PY5JUzxQ5wY5oc4nhIm8UxQWwYZTWq-HOWkMB5c99fG1QxLWQKGtsguXfOXoNgnI--yHzLZcXf1XAd0siguaF1cgQIqwRUf4byofE6uJ-2ZON_ezn6Uvly8fDIlgwmKAiiwWvHI4iLqvqOReBgs\",\n" +
                                                        "            \"dp\": \"oIUzuFnR6FcBqJ8z2KE0haRorUZuLy38A1UdbQz_dqmKiv--OmUw8sc8l3EkP9ctvzvZfVWqtV7TZ4M3koIa6l18A0KKEE0wFVcYlwETiaBgEWYdIm86s27mKS1Og1MuK90gz800UCQx6_DVWX41qAOEDWzbDFLY3JBxUDi-7u0\",\n" +
                                                        "            \"alg\": \"RS256\",\n" +
                                                        "            \"dq\": \"MpNSM0IecgapCTsatzeMlnaZsmFsTWUbBJi86CwYnPkGLMiXisoZxcS-p77osYxB3L5NZu8jDtVTZFx2PjlNmN_34ZLyujWbDBPDGaQqm2koZZSnd_GZ8Dk7GRpOULSfRebOMTlpjU3iSPPnv0rsBDkdo5sQp09pOSy5TqTuFCE\",\n" +
                                                        "            \"n\": \"hj8zFdhYFi-47PO4B4HTRuOLPR_rpZJi66g4JoY4gyhb5v3Q57etSU9BnW9QQNoUMDvhCFSwkz0hgY5HqVj0zOG5s9x2a594UDIinKsm434b-pT6bueYdvM_mIUEKka5pqhy90wTTka42GvM-rBATHPTarq0kPTR1iBtYao8zX-RWmCbdumEWOkMFUGbBkUcOSJWzoLzN161WdYr2kJU5PFraUP3hG9fPpMEtvqd6IwEL-MOVx3nqc7zk3D91E6eU7EaOy8nz8echQLl6Ps34BSwEpgOhaHDD6IJzetW-KorYeC0r0okXhrl0sUVE2c71vKPVVtueJSIH6OwA3dVHQ\"\n" +
                                                        "        }\n" +
                                                        "    ]\n" +
                                                        "}")
                                        )
                        )
        );
        System.out.println(JsonUtil.toJsonString(JapIds.getIdsConfig()));
        // 配置 ids 支持的 scope, 系统默认支持以下 scope： read、write、openid、email、phone
        // 如果需要追加 scope，可以使用 addScope
//        IdsScopeProvider.addScope(new IdsScope().setCode("test").setDescription("test"));
    }

    @Bean
    public FilterRegistrationBean<IdsAccessTokenFilter> registeraccessTokenFilter() {
        FilterRegistrationBean<IdsAccessTokenFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new IdsAccessTokenFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("ignoreUrl",
                "/," +
                        "/oauth/login," +
                        "/oauth/login/customize," +
                        "/oauth/logout," +
                        "/oauth/error," +
                        "/oauth/confirm," +
                        "/oauth/confirm/customize," +
                        "/oauth/authorize," +
                        "/oauth/authorize/auto," +
                        "/oauth/token," +
                        "/oauth/check_session," +
                        "/oauth/registration," +
                        "/oauth/pkce/**," +
                        "/.well-known/jwks.json," +
                        "/.well-known/openid-configuration"
        );
        registration.setName("IdsAccessTokenFilter");
        registration.setOrder(1);
        return registration;
    }
}
