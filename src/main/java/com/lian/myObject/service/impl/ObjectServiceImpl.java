package com.lian.myObject.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.lian.myObject.model.User;
import com.lian.myObject.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Ted
 * @date 2020/6/9 10:30
 */
@Service
public class ObjectServiceImpl implements ObjectService {
    @Autowired
    EntityManager entityManager;

    @Override
    public List originSqlExecute() {
        Query nativeQuery = entityManager.createNativeQuery("select * from giant_table");
        List resultList = nativeQuery.getResultList();
        for (Object row:resultList) {
            Object[] cells = (Object[])row;//为什么可以这样写，因为row里面用每个字段拼成了一个数组对象
            for (Object o:cells) {
                System.out.println(o);
            }
        }
        for (Object row : resultList){
            String s = ObjectUtil.toString(row);
            System.out.println(s);
        }
        return resultList;
    }

    public static void main(String[] args) {
        String originString = "test";
        Object originObject = originString;
        System.out.println((String)originObject);

        Object o = new Object[]{"1","2","3"} ;
        Object[] cells = (Object[]) o;
        for (Object k: cells){
            System.out.println(k);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hehe","haha");

        String json = ObjectUtil.toString(jsonObject);
        System.out.println(json);

        Object user = new User();
        System.out.println((User)user);

        Object userObject = new Object[]{"1","2","3"};


        String s = ObjectUtil.toString(userObject);
        System.out.println(s);

    }
}
