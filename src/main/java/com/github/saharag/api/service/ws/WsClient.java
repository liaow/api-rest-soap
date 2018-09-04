package com.github.saharag.api.service.ws;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * @author liao
 * @date 2018/8/13
 */
//@Component
//@EnableScheduling
public class WsClient {

    public static void main(String[] args) throws Exception {
        try {
            JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
            org.apache.cxf.endpoint.Client c = dcf.createClient("http://localhost:8080/ws?wsdl");
            Object[] objects = c.invoke("getName", "boy");
            System.out.println("result=" + objects[0].toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
