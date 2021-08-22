package com.github.sparkzxl.ids.interfaces.controller;

import com.fujieid.jap.ids.JapIds;
import com.fujieid.jap.ids.exception.IdsException;
import com.fujieid.jap.ids.exception.InvalidClientException;
import com.fujieid.jap.ids.exception.UnsupportedGrantTypeException;
import com.fujieid.jap.ids.model.ClientDetail;
import com.fujieid.jap.ids.model.enums.ErrorResponse;
import com.fujieid.jap.ids.model.enums.GrantType;
import com.fujieid.jap.ids.util.OauthUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 演示 PKCE 模式的应用方式
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @date 2021-04-20 9:58
 * @since 1.0.0
 */
@Controller
@RequestMapping("/oauth/pkce")
public class PkceController {

    /**
     * 模拟保存 CODE_VERIFIER，实际应该是存储到 DB 或者其他缓存媒介中
     */
    private static final Map<String, String> CODE_VERIFIER_CACHE = new HashMap<>();

    @RequestMapping("/authorize")
    public String pkce(String client_id, String state) {
        ClientDetail clientDetail = JapIds.getContext().getClientDetailService().getByClientId(client_id);
        if (null == clientDetail) {
            throw new InvalidClientException(ErrorResponse.INVALID_CLIENT);
        }
        if (!clientDetail.getGrantTypes().contains(GrantType.AUTHORIZATION_CODE.getType())) {
            throw new UnsupportedGrantTypeException(ErrorResponse.UNSUPPORTED_GRANT_TYPE);
        }
        if (null == clientDetail.getEnablePkce() || !clientDetail.getEnablePkce()) {
            throw new IdsException(ErrorResponse.AUTHORIZATION_FAILED);
        }
        String codeVerifier = OauthUtil.generateCodeVerifier();
        CODE_VERIFIER_CACHE.put(client_id, codeVerifier);
        String codeChallengeMethod = clientDetail.getCodeChallengeMethod();
        String codeChallenge = OauthUtil.generateCodeChallenge(codeChallengeMethod, codeVerifier);
        return String.format("redirect:/oauth/authorize?client_id=%s&response_type=code&scope=%s&redirect_uri=%s&state=%s&code_challenge=%s&code_challenge_method=%s",
                clientDetail.getClientId(),
                clientDetail.getScopes(),
                clientDetail.getRedirectUri(),
                state,
                codeChallenge,
                codeChallengeMethod
        );
    }

    @RequestMapping("/token")
    public String pkce(String client_id, String code, String state) {
        ClientDetail clientDetail = JapIds.getContext().getClientDetailService().getByClientId(client_id);
        if (null == clientDetail) {
            throw new InvalidClientException(ErrorResponse.INVALID_CLIENT);
        }
        if (!clientDetail.getGrantTypes().contains(GrantType.AUTHORIZATION_CODE.getType())) {
            throw new UnsupportedGrantTypeException(ErrorResponse.UNSUPPORTED_GRANT_TYPE);
        }
        if (null == clientDetail.getEnablePkce() || !clientDetail.getEnablePkce()) {
            throw new IdsException(ErrorResponse.AUTHORIZATION_FAILED);
        }
        return String.format("redirect:/oauth/token?grant_type=authorization_code&client_id=%s&redirect_uri=%s&code=%s&code_verifier=%s",
                clientDetail.getClientId(),
                clientDetail.getRedirectUri(),
                code,
                CODE_VERIFIER_CACHE.get(client_id)
        );
    }
}
