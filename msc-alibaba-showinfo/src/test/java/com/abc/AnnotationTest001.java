package com.abc;

import lombok.Data;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: AnnotationTest001
 * @Author: 青衣醉
 * @Date: 2023/6/27 3:24 下午
 */
public class AnnotationTest001 {

 @Data
 class AnnotationQ{
  String name;
  String value;
  Integer age;
 }

 @Test
 public  void test() {
  AnnotationQ build = new AnnotationQ();
  build.setAge (12);
  build.setName("Annotation");
  build.setValue ("dddd");
  Class<AnnotationQ> annotationQClass = AnnotationQ.class;
  Field[] declaredFields = annotationQClass.getDeclaredFields ();
  List<Object> collect = Arrays.stream (declaredFields).map (field -> {
   try {
    return field.get (build);
   } catch (IllegalAccessException e) {
    e.printStackTrace ();
   }
   return null;
  }).collect (Collectors.toList ());

  Map<String, Object> collect1 = Arrays.stream (declaredFields).collect (Collectors.toMap (field -> field.getName (), field -> {
   try {
    return field.get (build);
   } catch (IllegalAccessException e) {
    e.printStackTrace ();
   }
   return null;
  }));
  System.out.println ("build="+build);
  System.out.println ("collect1="+collect1);


  System.out.println (collect);
 }

}
