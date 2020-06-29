package labx03.demo2.provider;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaohu
 * @date 2020/6/23 10:47 上午
 * @description
 */
@Component
@ControllerAdvice
public class CustomExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = BlockException.class)
    public String blockExceptionHandler(BlockException blockException) {
        return "请求被拦截，拦截类型为" + blockException.getClass().getSimpleName();
    }
}
