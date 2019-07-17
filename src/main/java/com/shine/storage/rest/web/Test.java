package com.shine.storage.rest.web;

import jdk.nashorn.internal.runtime.options.Option;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年11月06日 11:29
 */
public class Test {
    public static void main(String[] args){
        //listAllFile("D:/test");
        // System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));
        // System.out.println(Instant.now());
        // HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // hashedCredentialsMatcher.setHashAlgorithmName("md5");
        // hashedCredentialsMatcher.setHashIterations(2);
        // hashedCredentialsMatcher.
        /*List<String> list = new ArrayList<>();
        Collections.addAll(list,"a","b","c");
        String[] strs = new String[]{"1","2","3"};
        System.out.println(String.join("-",strs));


        Optional<String> stringOptional = Optional.empty();
        stringOptional = Optional.of("shine");
        System.out.println(stringOptional.orElse("sunny"));*/
        Map map = new HashMap();
        map.put("Rajib Sarma","100");
        map.put("Rajib Sarma","200");//The value "100" is replaced by "200".
        map.put("Sazid Ahmed","200");

        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println("key: "+key+"  --  "+"value: "+ val);
        }


    }

    public static List<File> listAllFile(String folderPath){
        File file = new File(folderPath);
        List<File> pathList = new ArrayList<>();

        return findFilePath(file,pathList);


    }

    public static List findFilePath(File folder,List<File> pathList){
        File[] files = folder.listFiles();
        File file = null;
        for (int i = 0; i < files.length ; i++) {
            file = files[i];
            if (file.isDirectory()){
                findFilePath(file,pathList);
            }
            if (file.isFile())
                pathList.add(file);
        }
        return pathList;
    }
}