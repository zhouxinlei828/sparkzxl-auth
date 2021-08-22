package com.github.sparkzxl.ids.interfaces.controller;

import com.fujieid.jap.ids.endpoint.DiscoveryEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @date 2021-04-14 11:49
 * @since 1.0.0
 */
@RequestMapping("/.well-known")
@RestController
public class DiscoveryController {

    @GetMapping("/openid-configuration")
    public Object configuration() {
        return new DiscoveryEndpoint().getOidcDiscoveryInfo(null);
    }

    @GetMapping("/jwks.json")
    public String jwks() {
        return new DiscoveryEndpoint().getJwksPublicKey(null);
    }
}
