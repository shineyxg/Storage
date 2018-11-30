package com.shine.storage.rest.web;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        listAllFile("D:/test");
        
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