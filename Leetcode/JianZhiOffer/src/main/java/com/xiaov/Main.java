package com.xiaov;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * @Author: Xiaov
 * @Date: 2024/8/5 03:33
 */
public class Main {
    @Getter
    @Setter
    public static class Demo{
        private String name;
        private Integer age;
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.setName("xiaov");
        demo.setAge(100);

        ArrayList<Demo> list = Lists.newArrayList(demo);
        System.out.println("list = " + JSON.toJSONString(list));
    }
}