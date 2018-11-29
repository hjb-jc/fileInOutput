package com.nf2.practice2_dome.test;


import java.io.*;

public class FileTest {
    public static void main(String[] args) {
        createFile();
        bufferedInputStream();
        int count=0;  //统计文件字节长度
        InputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("f:\\fileName.txt"));
            while (fileInputStream.read() !=-1){
                count++;
            }
            System.out.println("--长度是"+count+"字节");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void createFile(){
        File file = new File("f:\\fileName.txt");
        try {
            file.createNewFile();
            System.out.println("该分区大小"+file.getTotalSpace()/(1024*3)+"G");
            file.mkdir();
            System.out.println("文件名"+file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bufferedInputStream(){
        byte[] buffer = new byte[512]; //一次性取出的字节数大小，缓冲区大小
        int numberRead = 0;
        FileInputStream input = null ;
        FileOutputStream out = null;
        try {
            input = new FileInputStream("f:\\\\fileName.txt");
            //如果文件不存在会自动创建
            out = new FileOutputStream("f:\\\\fileName1.txt");
            //numberRead的目的在于防止最后一次读取的字节小于buffer长度
            while((numberRead = input.read(buffer))!=-1){//
                out.write(buffer,0,numberRead);//否则会自动被填充0
                System.out.println("复制成功！");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                input.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
