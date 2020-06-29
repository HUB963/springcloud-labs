package labx03.demo2.provider;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zhaohu
 * @date 2020/6/23 10:34 上午
 * @description
 */
@RestController
@RequestMapping("/demo2")
public class DemoController {

    /**
     * 流控测试
     *
     * @return
     */
    @SentinelResource(fallback = "flowFallback")
    @GetMapping("/flow")
    public String flow(@RequestParam(name = "arg", required = false) String arg) {
        if (arg == null) {
            throw new IllegalArgumentException("arg must be not null");
        }
        return "flow " + arg;
    }

    public String flowFallback(String arg, Throwable t) {
        return "fallback: " + t.getMessage();
    }

    /**
     * 降级测试
     *
     * @return
     */
    @SentinelResource(blockHandler = "sleepBlockHandler")
    @GetMapping("/sleep")
    public String sleep() {
        try {
            TimeUnit.MICROSECONDS.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sleep";
    }

    public String sleepBlockHandler(BlockException e) {
        return "blockHandler: " + e.getClass().getSimpleName();
    }

    /**
     * 热点参数测试
     *
     * @param id
     * @return
     */
    @SentinelResource(blockHandler = "paramBlockHandler", fallback = "paramFallback")
    @GetMapping("/param")
    public String param(@RequestParam(name = "id") int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id must be greater than zero");
        }
        return "param id is " + id;
    }

    /**
     * <ui>
     * <li>只能处理BlockException</li>
     * <li>方法必须同类中且是public，参数应与注解方法一致，最后加上BlockException</li>
     * </ui>
     *
     * @param id
     * @param e
     * @return
     */
    public String paramBlockHandler(int id, BlockException e) {
        return "blockHandler: " + e.getClass().getSimpleName();
    }

    /**
     * <ui>
     * <li>能处理所有异常，如与blockHandler同时配置，BlockException异常会优先被blockHandler处理</li>
     * <li>方法必须同类中且是public，参数应与注解方法一致，最后加上Throwable</li>
     * </ui>
     *
     * @param id
     * @param t
     * @return
     */
    public String paramFallback(int id, Throwable t) {
        return "fallback: " + t.getMessage();
    }
}
