package com.caojiawangduocongdemo.utils.shejimoshi.adpter.springmvc;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:com.caojiawangduocongdemo.utils.shejimoshi.adpter.springmvc
 * @ClassName:DispatchServlet
 * @Description:
 * @Author:caojia
 * @Date:2021/9/723:21
 */
public class DispatchServlet {
    private static List<HandleAdapter> handleAdapters = new ArrayList<>();

    static {
        handleAdapters.add(new HttpHandleAdapter());
        handleAdapters.add(new SimpleHandleAdapter());
        handleAdapters.add(new AnnotationHandleAdapter());
    }

    public void doDispatch(){
        Controller controller = new SimpleController();
        HandleAdapter adapter = this.getHandler(controller);
        adapter.handle(controller);
    }

    /**
     * 遍历所有的适配器，找出当前处理器适配器
     * @param controller
     * @return
     */
    public HandleAdapter getHandler(Controller controller){
        for(HandleAdapter adapter : handleAdapters){
            if(adapter.supports(controller)){
                return adapter;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new DispatchServlet().doDispatch();
    }
}
