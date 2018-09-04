package com.github.saharag.api.service.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author liao
 * @date 2018/8/10
 */
@WebService
//(
//serviceName： 对外发布的服务名，指定 Web Service 的服务名称：wsdl:service。缺省值为 Java 类的简单名称 + Service。（字符串）
//name：此属性的值包含XML Web Service的名称。在默认情况下，该值是实现XML Web Service的类的名称，wsdl:portType 的名称。缺省值为 Java 类的简单名称 + Service。（字符串）
//portName：  wsdl:portName。缺省值为 WebService.name+Port。
//targetNamespace：指定名称空间，缺省值是使用接口实现类的包名的反缀
//wsdlLocation：指定用于定义 Web Service 的 WSDL 文档的 Web 地址。Web 地址可以是相对路径或绝对路径。
//targetNamespace = InterfaceConstant.WS_TARGET_NAMESPACE,
//endpointInterface = "DemoEndpoint"
//)
@Deprecated
public class DemoEndpoint {

    //@WebMethod注释表示作为一项 Web Service 操作的方法，将此注释应用于客户机或服务器服务端点接口（SEI）上的方法，或者应用于 JavaBeans 端点的服务器端点实现类。
    //1、operationName：指定与此方法相匹配的wsdl:operation 的名称。缺省值为 Java 方法的名称。（字符串）
    //2、action：定义此操作的行为。对于 SOAP 绑定，此值将确定 SOAPAction 头的值。缺省值为 Java 方法的名称。（字符串）
    //3、exclude：指定是否从 Web Service 中排除某一方法。缺省值为 false。（布尔值）
    @WebMethod
    public String getName(@WebParam(name = "name") String name) {
        return "Your name is " + name;
    }

}