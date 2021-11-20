package com.atiguigu.test;

import com.atiguigu.Person;
import com.atiguigu.Student;
import com.atiguigu.utils.JdbcUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    @org.junit.Test
    public void testConnection() {
        Connection conn = JdbcUtils.getConnection();
        System.out.println(conn);
    }
    @org.junit.Test
    public void test1(){
        Gson gson=new Gson();
        Student student=new Student(1,"fan");
        String s1 = gson.toJson(student);
//        System.out.println(s1);
//        System.out.println(gson.fromJson(s1,Student.class));



    }
    @org.junit.Test
    public void test2(){
        Gson gson=new Gson();
        List<Student> list=new ArrayList<Student>();
        list.add(new Student(1,"fan"));
        list.add(new Student(2,"chun"));
        String s2=gson.toJson(list);
        System.out.println(s2);

        List<Student> list1=gson.fromJson(s2,new StudentListType().getType());


    }
    @org.junit.Test
    public void test3(){
        Gson gson=new Gson();
        Map<Integer,Student> map=new HashMap<Integer,Student>();
        map.put(1,new Student(1,"fan"));
        map.put(2,new Student(2,"chun"));
     String s= gson.toJson(map);
//        System.out.println(s);
        Map<Integer,Student> map1=gson.fromJson(s,new TypeToken<HashMap<Integer,Student>>(){}.getType());
        System.out.println(map1.get(1));

    }
}
