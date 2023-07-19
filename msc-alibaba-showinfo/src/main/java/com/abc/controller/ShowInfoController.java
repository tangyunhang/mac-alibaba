package com.abc.controller;

import com.tyh.batch.batchTask.BatchTaskService;
import com.tyh.batch.batchTask.Task;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: ShowInfoController
 * @Author: 青衣醉
 * @Date: 2023/3/2 9:02 下午
 */
@RestController
@RequestMapping("showInfo")
public class ShowInfoController {
    BatchTaskService batchTaskService = new BatchTaskService();
    @RequestMapping("header")
    public String header(HttpServletRequest httpServletRequest){
        return "header x-reqyest-red:"+ httpServletRequest.getHeader ("x-reqyest-red");
    }
    @RequestMapping("time")
    public String context(HttpServletRequest httpServletRequest){
        return "time"+ System.currentTimeMillis ();
    }
    @RequestMapping("test")
    public String test(HttpServletRequest httpServletRequest){
        String vvv = httpServletRequest.getParameter ("vvv");
        batchTaskService.doBatchTask (test45(Integer.valueOf (vvv)));
        return "time"+ System.currentTimeMillis ();
    }

    public List<Task> test45(int nn){
        int dd=0;
        List<Task> list = new ArrayList<> ();
        while (dd++<20){
            String title = "测试task-"+dd;
            Integer param = dd;
            int finalDd = dd;
            list.add (new Task (null,"code-"+finalDd,title,param,
                    (d)-> {
                        long l = Long.valueOf (finalDd) * 100;
                        try {
                            if(finalDd==nn){
                                l=2200;
                            }
                            Thread.sleep (l);
                        } catch (InterruptedException e) {
                            System.out.println ("================错误");
                        }
                        //System.out.println ("======今天花了："+d+"元,用时："+l);
                    }
            ));

        }
        return list;
    }
}
