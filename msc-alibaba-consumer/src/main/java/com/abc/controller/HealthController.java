package com.abc.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: HealthController
 * @Author: 青衣醉
 * @Date: 2022/8/10 9:57 上午
 */
@RestController
public class HealthController {

    @GetMapping("/health.json")
    @ResponseBody
    public Object healthJson () throws JSONException {
        JSONObject jsonObject = new JSONObject ();
        return jsonObject.put ("status", "UP" ).toString ();
    }
}
