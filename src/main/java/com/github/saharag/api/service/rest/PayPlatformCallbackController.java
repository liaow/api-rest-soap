package com.github.saharag.api.service.rest;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付平台回调接口
 *
 * @author liao
 * @date 2018/8/10
 */
@Slf4j
@RestController
@RequestMapping("/pay/callback")
public class PayPlatformCallbackController {

    /**
     * 支付订单状态通知
     *
     * <pre>
     *     {
     *     "trxInf": {
     *         "couponAmt": "CNY0.00",
     *         "payAmt": "CNY0.01",
     *         "payDesc": {
     *             "payAcctTp": "101",
     *             "payAmt": "CNY0.01"
     *         },
     *         "payNum": "1",
     *         "paySta": "03",
     *         "pltDt": "20180814",
     *         "pltSsn": "20180814113101029289545597480960",
     *         "trxAmt": "CNY0.01",
     *         "trxDt": "20180814",
     *         "trxSsn": "fa63d780b2254dfebdc283ab12576193"
     *     }
     * }
     * </pre>
     *
     * @param body
     * @return
     */
    @PostMapping(value = "/payment")
    JSONObject payment(@RequestBody String body) {
        log.debug("接收到支付订单状态通知:{}", body);
        JSONObject ret = new JSONObject();
        ret.put("bizRtnCd", "000099");
        ret.put("bizRtnDesc", "业务处理失败");
        if (StringUtils.isEmpty(body)) {
            ret.put("bizRtnDesc", "业务处理失败[请求body空]");
            return ret;
        }
        JSONObject request = JSONObject.parseObject(body);
        if (!request.containsKey("trxInf")) {
            ret.put("bizRtnDesc", "业务处理失败[报文不正确，未找到trxInf]");
            return ret;
        }
//        final CallbackMicroService callbackMicroService = (HSFSpringConsumerBean) context.getBean("callbackMicroService");
        if (true) {
            ret.put("bizRtnCd", "000000");
            ret.put("bizRtnDesc", "业务处理成功");
        } else {
            ret.put("bizRtnDesc", "业务处理失败");
        }
        log.debug("返回结果:{}", ret.toJSONString());
        return ret;
    }

    /**
     * 退款订单状态通知
     *
     * <pre>
     *     {
     *     "trxInf": {
     *         "pltDt": "20180814",
     *         "pltSsn": "20180814113301029283221207576576",
     *         "rfndAmt": "CNY0.01",
     *         "rfndPayAmt": "CNY0.01",
     *         "rfndSta": "11",
     *         "trxDt": "20180814",
     *         "trxSsn": "3d763aef4fbe49c284f88a175d73b7b0"
     *     }
     * }
     * </pre>
     *
     * @param body
     * @return
     */
    @PostMapping(value = "/refund")
    JSONObject refund(@RequestBody String body) {
        log.debug("接收到退款订单状态通知:{}", body);
        JSONObject ret = new JSONObject();
        ret.put("bizRtnCd", "000099");
        ret.put("bizRtnDesc", "业务处理失败");
        if (StringUtils.isEmpty(body)) {
            ret.put("bizRtnDesc", "业务处理失败[请求body空]");
            return ret;
        }
        JSONObject request = JSONObject.parseObject(body);
        if (!request.containsKey("trxInf")) {
            ret.put("bizRtnDesc", "业务处理失败[报文不正确，未找到trxInf]");
            return ret;
        }
//        final CallbackMicroService callbackMicroService = (HSFSpringConsumerBean) context.getBean("callbackMicroService");
        if (true) {
            ret.put("bizRtnCd", "000000");
            ret.put("bizRtnDesc", "业务处理成功");
        } else {
            ret.put("bizRtnDesc", "业务处理失败");
        }
        log.debug("返回结果:{}", ret.toJSONString());
        return ret;
    }
}
