package top.mqxu.cloud.common.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.HttpStatus;

@Slf4j
public class SentinelExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        String msg = "未知异常";
        int code = HttpStatus.SC_INTERNAL_SERVER_ERROR;

        log.error("Sentinel 异常：",e);

        if(e instanceof FlowException) {
            msg = "请求被限流了";
        }else if(e instanceof DegradeException) {
            msg = "请求被降级了";
        }else if(e instanceof ParamFlowException){
            msg = "请求被二点参数限流了";
        }else if(e instanceof AuthorityException){
            msg = "没有权限访问";
        }else if(e instanceof SystemBlockException){
            msg = "限流系统异常";
        }

        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setStatus(code);
        httpServletResponse.getWriter().println("{\"code\":\"" + code + "\",\"msg\":\"" + msg + "\"}");

    }
}
