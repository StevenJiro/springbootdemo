package com.michelle.spirng.boot.blog.springbootstart.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 提供对简单类的基本操作
 * @author sunzh
 */
public class BeanUtil {
    /**
     * 判断是否为空
     * @param object
     * @return
     */
    public static boolean isEmpty(Object object){
        if(object==null){
            return true;
        }
        String className = object.getClass().getName();
        //如果是字符串
        if(String.class.getName().equals(className)){
            if(object==null||"".equals(String.valueOf(object))){
                return true;
            }
            return false;
        }
        //如果是Long
        if(Long.class.getName().equals(className)){
            if(null==object){
                return true;
            }
            return false;
        }
        //如果是ArrayList
        if(ArrayList.class.getName().equals(className)){
            if(object==null||((List)object).size()==0){
                return true;
            }
            return false;
        }

        return false;

    }

    public static void main(String[] args) {
        Long i=null;
        System.out.println(isEmpty(i));
    }
}
