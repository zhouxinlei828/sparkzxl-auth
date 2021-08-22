package com.github.sparkzxl.ids.infrastructure.handler;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.fujieid.jap.ids.endpoint.ErrorEndpoint;
import com.fujieid.jap.ids.exception.IdsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 统一异常处理类<br>
 * 捕获程序所有异常，针对不同异常，采取不同的处理方式
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 */
@RestControllerAdvice
public class AuthExceptionHandler {
    protected Log log = LogFactory.get();

    @Autowired
    private HttpServletResponse response;

    @ExceptionHandler(value = {IdsException.class})
    public void idsExceptionHandle(IdsException e) throws IOException {
        new ErrorEndpoint().showErrorPage(e.getError(), e.getErrorDescription(), response);
    }
}
