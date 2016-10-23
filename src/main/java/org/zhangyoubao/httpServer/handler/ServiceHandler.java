package org.zhangyoubao.httpServer.handler;

import org.zhangyoubao.httpServer.Request;
import org.zhangyoubao.httpServer.ServiceBase;
import org.zhangyoubao.httpServer.ServiceManager;
import org.zhangyoubao.httpServer.response.AbstractResponse;
import org.zhangyoubao.httpServer.response.PlainResponse;

import java.lang.reflect.Method;

/**
 * @author: rudy
 * @date: 2016/10/22
 *
 * service 服务处理handler
 */
public class ServiceHandler extends AbstractHandler {
    @Override
    public AbstractResponse execute(Request request) throws Exception {
        String api = request.getRequestParam("api");
        boolean check = false;
        Class classPointer = null;
        Method methodPointer = null;
        // 过滤请求
        do{
            if (api.equals("") || !ServiceManager.getInstance().containsKey(api)){
                break;
            }
            String className = ServiceManager.getInstance().get(api).getKey();
            classPointer = Class.forName(className);
            if (!ServiceBase.class.isAssignableFrom(classPointer)){
                throw new Exception(String.format(" class (%s) is not subclass of %s",className, ServiceBase.class.getName()));
            }

            String methodName = "action" + ServiceManager.getInstance().get(api).getValue();
            methodPointer = classPointer.getMethod(methodName,Request.class);
            check = true;
        }while (false);

        AbstractResponse response = null;
        if(check){
            // 通过,执行相应方法
            ServiceBase service = (ServiceBase) classPointer.newInstance();
            if (service.beforeAction(request)){
                response = (AbstractResponse) methodPointer.invoke(service,request);
            }
            AbstractResponse afterResponse =  service.afterAction(request, null);
            if (afterResponse != null){
                response = afterResponse;
            }
        }else{
            // 没通过,http.code = 404
            response = PlainResponse.createResponse();
            response.httpCodeSet(404);
        }
        return response;
    }
}
