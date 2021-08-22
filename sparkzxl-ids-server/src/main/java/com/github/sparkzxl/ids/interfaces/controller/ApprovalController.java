package com.github.sparkzxl.ids.interfaces.controller;

import com.fujieid.jap.ids.JapIds;
import com.fujieid.jap.ids.endpoint.ApprovalEndpoint;
import com.fujieid.jap.ids.model.ClientDetail;
import com.fujieid.jap.ids.model.IdsResponse;
import com.fujieid.jap.ids.util.ObjectUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @date 2021-04-14 11:49
 * @since 1.0.0
 */
@RequestMapping("/oauth")
@RestController
public class ApprovalController {

    /**
     * 使用 jap-ids 内置的授权页面
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/confirm")
    public void confirm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ApprovalEndpoint approvalEndpoint = new ApprovalEndpoint();
        approvalEndpoint.showConfirmPage(request, response);
    }

    /**
     * 演示自定义授权页面实现方式 1， 手动拼装 html
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/confirm/customizeByHtml")
    public void confirmCustomize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ApprovalEndpoint approvalEndpoint = new ApprovalEndpoint();
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().append(createHtml(approvalEndpoint, request));
    }

    /**
     * 演示自定义授权页面实现方式 2， 自定义授权页面，需要通过 <code>JapIds.registerContext(new IdsContext().setIdsConfig(new IdsConfig().setConfirmPageUrl(host + "/oauth/confirm/customize")</code> 配置授权页面的入口
     *
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @GetMapping("/confirm/customize")
    public ModelAndView confirmCustomize(HttpServletRequest request, Model model) throws IOException {
        ApprovalEndpoint approvalEndpoint = new ApprovalEndpoint();

        IdsResponse<String, Map<String, Object>> getAuthClientInfo = approvalEndpoint.getAuthClientInfo(request);
        Map<String, Object> data = getAuthClientInfo.getData();
        ClientDetail clientDetail = (ClientDetail) data.get("appInfo");
        List<Map<String, Object>> scopeInfos = (List<Map<String, Object>>) data.get("scopes");
        String requestPath = ObjectUtils.appendIfNotEndWith(JapIds.getIdsConfig().getAuthorizeUrl(), "?") + request.getQueryString();
        model.addAttribute("clientDetail", clientDetail);
        model.addAttribute("scopeInfos", scopeInfos);
        model.addAttribute("requestPath", requestPath);
        return new ModelAndView("confirm");
    }

    public String createHtml(ApprovalEndpoint approvalEndpoint, HttpServletRequest request) {
        IdsResponse<String, Map<String, Object>> getAuthClientInfo = approvalEndpoint.getAuthClientInfo(request);
        Map<String, Object> data = getAuthClientInfo.getData();
        ClientDetail clientDetail = (ClientDetail) data.get("appInfo");
        List<Map<String, Object>> scopeInfo = (List<Map<String, Object>>) data.get("scopes");
        String requestPath = ObjectUtils.appendIfNotEndWith(JapIds.getIdsConfig().getAuthorizeUrl(), "?") + request.getQueryString();
        String html = "<!DOCTYPE html>\n" +
                "<html style=\"margin-right: 0px\">\n" +
                "  <head>\n" +
                "    <meta charset=\"utf-8\" />\n" +
                "    <meta content=\"width=device-width,initial-scale=1\" name=\"viewport\" />\n" +
                "    <meta\n" +
                "      content=\"符节科技，JAI，IDaaS，统一身份认证，企业级身份云，身份安全认证，单点登录，云端身份，安全审计，身份治理，零信任，SSO，OAuth，OIDC\"\n" +
                "      name=\"keywords\"\n" +
                "    />\n" +
                "    <meta\n" +
                "      content=\"JAI 是符节科技旗下自主研发的一款现代化企业级的统一身份认证和用户管理的系统，是基于行业 5A 标准规范和等保 2.0 规范研发的自主可控的身份系统。助力企业完成用户身份统一管理。\"\n" +
                "      name=\"description\"\n" +
                "    />\n" +
                "    <title>符节科技 - 统一身份认证_单点登录_企业身份云_IDAAS</title>\n" +
                "    <link href=\"https://portal.fujieid.com/static/favicon.ico\" rel=\"icon\" type=\"image/x-icon\" />\n" +
                "    <link href=\"https://portal.fujieid.com/static/fonts/feather/feather.css\" rel=\"stylesheet\" />\n" +
                "    <link href=\"https://portal.fujieid.com/static/css/theme.min.css\" rel=\"stylesheet\" />\n" +
                "    <style type=\"text/css\">\n" +
                "      .vue-notification-group{display:block;position:fixed;z-index:5000}.vue-notification-wrapper{display:block;overflow:hidden;width:100%;margin:0;padding:0}.notification-title{font-weight:600}.vue-notification-template{background:#fff}.vue-notification,.vue-notification-template{display:block;box-sizing:border-box;text-align:left}.vue-notification{font-size:12px;padding:10px;margin:0 5px 5px;color:#fff;background:#44a4fc;border-left:5px solid #187fe7}.vue-notification.warn{background:#ffb648;border-left-color:#f48a06}.vue-notification.error{background:#e54d42;border-left-color:#b82e24}.vue-notification.success{background:#68cd86;border-left-color:#42a85f}.vn-fade-enter-active,.vn-fade-leave-active,.vn-fade-move{transition:all .5s}.vn-fade-enter,.vn-fade-leave-to{opacity:0}body{font-family:Microsoft YaHei UI,Helvetica Neue,Helvetica,Arial,sans-serif;background-color:#fff;font-size:14px}.portal-container{background-color:#b1b1b1!important;display:block;padding-right:17px}@media (min-width:576px){.modal-content{-webkit-box-shadow:0 2px 10px 0 rgba(57,106,255,.05);box-shadow:0 2px 10px 0 rgba(57,106,255,.05)}}.title a:visited{color:#888}.nav-pills>li>a{position:relative;display:block;padding:0 5px}.social a[data-v-d8b8b742]{position:relative;display:-webkit-box;display:-ms-flexbox;display:flex;padding:0 0 0 58px;background:#f8f9fa;-ms-flex-align:center;-webkit-box-align:center;align-items:center;width:100%;height:48px;font-size:14px;border:1px solid #ececec;border-radius:3px;color:#333c4d;cursor:pointer;outline:0}.social a[data-v-d8b8b742]:hover{background:rgba(47,70,100,.08)}#login-nav li.nav-item[data-v-d8b8b742]{list-style:none;-ms-flex:1;-webkit-box-flex:1;flex:1;text-align:center;font-size:16px;text-decoration:none;cursor:pointer}#login-nav li.nav-item .nav-link[data-v-d8b8b742]{color:#aeb9d4;-webkit-transition:all .3s ease-in-out;transition:all .3s ease-in-out}#login-nav li.nav-item .nav-link.active[data-v-d8b8b742]{color:#335eea;font-weight:600;background-color:#fff;border-color:#fff #fff #b5b4b4}#login-nav li.nav-item .nav-link[data-v-d8b8b742]:hover{border-color:#fff #fff #b5b4b4}.captcha[data-v-d8b8b742]{height:48px;border:1px solid rgb(241 244 248)}.social-line[data-v-00bfb571]{font-size:12px;text-align:center}.social-line[data-v-00bfb571]:after,.social-line[data-v-00bfb571]:before{content:\"\\2014\\2014\";color:#eee;margin:0 11px}.modal[data-v-213f055b]{display:block!important}.fade-enter-active[data-v-213f055b],.fade-leave-active[data-v-213f055b]{-webkit-transition:opacity .15s;transition:opacity .15s}.fade-enter[data-v-213f055b],.fade-leave-to[data-v-213f055b]{opacity:0}.confirm-box[data-v-9330d096]{color:#555;margin:0 auto}.confirm-box input[data-v-9330d096]{font-size:medium!important;height:auto!important}.scope-list[data-v-9330d096]{overflow-y:scroll;max-height:250px}.social a[data-v-8ee1141e]{position:relative;display:-webkit-box;display:-ms-flexbox;display:flex;padding:0 0 0 58px;background:#f8f9fa;-ms-flex-align:center;-webkit-box-align:center;align-items:center;width:100%;height:48px;font-size:14px;border:1px solid #ececec;border-radius:3px;color:#333c4d;cursor:pointer;outline:0}.social a[data-v-8ee1141e]:hover{background:rgba(47,70,100,.08)}.social a img[data-v-8ee1141e]{position:absolute;display:inline-block;width:22px;height:22px;left:16px}#login-nav li.nav-item[data-v-8ee1141e]{list-style:none;-ms-flex:1;-webkit-box-flex:1;flex:1;text-align:center;font-size:16px;text-decoration:none;cursor:pointer}#login-nav li.nav-item .nav-link[data-v-8ee1141e]{color:#aeb9d4;-webkit-transition:all .3s ease-in-out;transition:all .3s ease-in-out}#login-nav li.nav-item .nav-link.active[data-v-8ee1141e]{color:#335eea;font-weight:600;background-color:#fff;border-color:#fff #fff #b5b4b4}#login-nav li.nav-item .nav-link[data-v-8ee1141e]:hover{border-color:#fff #fff #b5b4b4}.captcha[data-v-8ee1141e]{height:48px;border:1px solid rgb(241 244 248)}.social a[data-v-715ce313]{position:relative;display:-webkit-box;display:-ms-flexbox;display:flex;padding:0 0 0 58px;background:#f8f9fa;-ms-flex-align:center;-webkit-box-align:center;align-items:center;width:100%;height:48px;font-size:14px;border:1px solid #ececec;border-radius:3px;color:#333c4d;cursor:pointer;outline:0}.social a[data-v-715ce313]:hover{background:rgba(47,70,100,.08)}.social a img[data-v-715ce313]{position:absolute;display:inline-block;width:22px;height:22px;left:16px}#login-nav li.nav-item[data-v-715ce313]{list-style:none;-ms-flex:1;-webkit-box-flex:1;flex:1;text-align:center;font-size:16px;text-decoration:none;cursor:pointer}#login-nav li.nav-item .nav-link[data-v-715ce313]{color:#aeb9d4;-webkit-transition:all .3s ease-in-out;transition:all .3s ease-in-out}#login-nav li.nav-item .nav-link.active[data-v-715ce313]{color:#335eea;font-weight:600;background-color:#fff;border-color:#fff #fff #b5b4b4}#login-nav li.nav-item .nav-link[data-v-715ce313]:hover{border-color:#fff #fff #b5b4b4}.captcha[data-v-715ce313]{height:48px;border:1px solid rgb(241 244 248)}body[data-v-3db8ff8d]{font-family:Microsoft YaHei UI,Helvetica Neue,Helvetica,Arial,sans-serif;background-color:#fff;font-size:14px}.portal-container[data-v-3db8ff8d]{background-color:#dcdcdc!important;display:block;padding-right:17px}.title a[data-v-3db8ff8d]:visited{color:#888}.nav-pills>li>a[data-v-3db8ff8d]{position:relative;display:block;padding:0 5px}input[data-v-3db8ff8d]{font-size:14px!important;height:48px!important}.social a[data-v-3db8ff8d]{position:relative;display:-webkit-box;display:-ms-flexbox;display:flex;padding:0 0 0 58px;background:#f8f9fa;-ms-flex-align:center;-webkit-box-align:center;align-items:center;width:100%;height:48px;font-size:14px;border:1px solid #ececec;border-radius:3px;color:#333c4d;cursor:pointer;outline:0}.social a[data-v-3db8ff8d]:hover{background:rgba(47,70,100,.08)}#login-nav li.nav-item[data-v-3db8ff8d]{list-style:none;-ms-flex:1;-webkit-box-flex:1;flex:1;text-align:center;font-size:16px;text-decoration:none;cursor:pointer}#login-nav li.nav-item .nav-link[data-v-3db8ff8d]{color:#aeb9d4;-webkit-transition:all .3s ease-in-out;transition:all .3s ease-in-out}#login-nav li.nav-item .nav-link.active[data-v-3db8ff8d]{color:#335eea;font-weight:600;background-color:#fff;border-color:#fff #fff #b5b4b4}#login-nav li.nav-item .nav-link[data-v-3db8ff8d]:hover{border-color:#fff #fff #b5b4b4}.captcha[data-v-3db8ff8d]{height:48px;border:1px solid rgb(241 244 248)}.close[data-v-3938eb8f]{position:absolute;top:3px;right:0;font-size:15px}.message-fade-enter-active[data-v-3938eb8f],.message-fade-leave-active[data-v-3938eb8f]{-webkit-transition:all .3s ease;transition:all .3s ease}.message-fade-enter[data-v-3938eb8f],.message-fade-leave-to[data-v-3938eb8f]{-webkit-transform:translateY(-20px);transform:translateY(-20px);opacity:0}.message[data-v-3938eb8f]{position:fixed;top:55px;left:50%;-webkit-transform:translate(-50%,-50%);transform:translate(-50%,-50%);width:-webkit-fit-content;width:-moz-fit-content;width:fit-content;-webkit-box-sizing:content-box;box-sizing:content-box;border-radius:4px;color:#616060;font-size:17px;z-index:8888;max-width:250px}.message-close[data-v-3938eb8f]{position:absolute;top:25%;right:10px;color:rgba(153,152,152,.774);cursor:pointer;font-size:17px}.message-close[data-v-3938eb8f]:hover{color:#0c0c0c}.message_img[data-v-3938eb8f]{display:inline-block;border-radius:50%;width:17px;margin-right:3px}.message-success[data-v-3938eb8f]{background:rgba(220,255,239,.8274509803921568);color:#30c268;-webkit-box-shadow:0 3px 4px -4px rgba(0,0,0,.12),0 3px 10px 0 rgba(0,0,0,.08),0 9px 35px 3px rgba(0,0,0,.05);box-shadow:0 3px 4px -4px rgba(0,0,0,.12),0 3px 10px 0 rgba(0,0,0,.08),0 9px 35px 3px rgba(0,0,0,.05);pointer-events:all}.message-info[data-v-3938eb8f]{color:#fff;background:#2db7f5}.message-warning[data-v-3938eb8f]{color:#ecae51;background:#ffdec9}.message-error[data-v-3938eb8f]{background:#ffe2e2;color:#ff6c6c}.confirm-fade-enter-active[data-v-7e49e297],.confirm-fade-leave-active[data-v-7e49e297]{-webkit-transition:all .3s ease;transition:all .3s ease}.confirm-fade-enter[data-v-7e49e297],.confirm-fade-leave-to[data-v-7e49e297]{-webkit-transform:translateY(-20px);transform:translateY(-20px);opacity:0}.confirm[data-v-7e49e297]{position:fixed;top:36%;right:36%;width:22%;border-radius:4px;color:#616060;z-index:8888}\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div id=\"app\">\n" +
                "      <div\n" +
                "        class=\"vue-notification-group\"\n" +
                "        style=\"width: 500px; top: 0px; right: 0px\"\n" +
                "      >\n" +
                "        <span></span>\n" +
                "      </div>\n" +
                "      <div\n" +
                "        aria-labelledby=\"modalSignupVerticalTitle\"\n" +
                "        aria-modal=\"true\"\n" +
                "        role=\"dialog\"\n" +
                "        tabindex=\"-1\"\n" +
                "        class=\"modal fade show portal-container\"\n" +
                "      >\n" +
                "        <div\n" +
                "         \n" +
                "          role=\"document\"\n" +
                "          class=\"modal-dialog modal-dialog-centered\"\n" +
                "        >\n" +
                "          <div class=\"modal-content border-0\">\n" +
                "            <div class=\"card\">\n" +
                "              <div class=\"card-body confirm-box\">\n" +
                "                <div\n" +
                "                  class=\"d-block text-center\"\n" +
                "                >\n" +
                "                  <img\n" +
                "                    src=\"" + clientDetail.getLogo() + "\"\n" +
                "                    alt=\"...\"\n" +
                "                    class=\"card-img-top\"\n" +
                "                    style=\"width: 75px\"\n" +
                "                  />\n" +
                "                  <h3\n" +
                "                    id=\"signModalLabel\"\n" +
                "                    class=\"modal-title mt-4 mb-4 text-gray-800\"\n" +
                "                  >\n" +
                "                    " + clientDetail.getAppName() + "\n" +
                "                  </h3>\n" +
                "                </div>\n" +
                "                <form\n" +
                "                  action=\"" + requestPath + "\"\n" +
                "                  id=\"confirmationForm\"\n" +
                "                  method=\"post\"\n" +
                "                  name=\"confirmationForm\"\n" +
                "                  class=\"mb-6 mt-4\"\n" +
                "                >\n" +
                "                  <p>\n" +
                "                    <a\n" +
                "                     \n" +
                "                      target=\"_blank\"\n" +
                "                      href=\"" + clientDetail.getSiteDomain() + "\"\n" +
                "                      ><strong>" + clientDetail.getAppName() + "</strong></a\n" +
                "                    >\n" +
                "                    申请获取以下权限：\n" +
                "                  </p>\n" +
                "                  <ul class=\"list-group scope-list\">\n";


        StringBuilder builder = new StringBuilder(html);
        for (Map<String, Object> scope : scopeInfo) {
            String approved = (Boolean) scope.get("selected") ? " checked" : "";
            String denied = (Boolean) scope.get("selected") ? "" : " checked";

            builder.append("<li class=\"list-group-item p-2\">\n");
            builder.append("<input type=\"checkbox\" name=\"scopes\" readonly=\"readonly\" class=\"mr-2\"").append(" value=\"").append(scope.get("code")).append("\"").append(approved).append(" style=\"margin-right: 5px;\">")
                    .append("<label class=\"mb-0\">")
                    .append(scope.get("code")).append(" - ").append(scope.get("description"))
                    .append("</label>");
            builder.append(denied).append("</li>");
        }
        html = builder.toString();
        html +=
                "                  </ul>\n" +
                        "                  <p class=\"help-block mt-4 mb-2\">\n" +
                        "                    授权后表明你已同意 <a>服务协议</a>\n" +
                        "                  </p>\n" +
                        "                  <button\n" +
                        "                    type=\"submit\"\n" +
                        "                    class=\"btn btn-primary pull-right btn-block mt-4 mb-2\"\n" +
                        "                  >\n" +
                        "                    同意授权\n" +
                        "                  </button>\n" +
                        "                </form>\n" +
                        "              </div>\n" +
                        "            </div>\n" +
                        "          </div>\n" +
                        "        </div>\n" +
                        "      </div>\n" +
                        "    </div>\n" +
                        "    <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js\"></script>\n" +
                        "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js\"></script>\n" +
                        "  </body>\n" +
                        "</html>\n";
        return html;
    }

}
