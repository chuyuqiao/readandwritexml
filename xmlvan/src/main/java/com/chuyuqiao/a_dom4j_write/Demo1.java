package com.chuyuqiao.a_dom4j_write;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 写出内容到XML文档
 * Created by chuyuqiao on 2016/6/29.
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        //1.读取或创建一个Document对象
        Document doc = new SAXReader().read(new File("g://contact.xml"));

        //2.修改Document对象内容

        //3.把修改后的Document对象写出到XML文档中
        //指定文件输出的位置
        FileOutputStream out = new FileOutputStream("g://contact.xml");
        //1.创建写出对象
        XMLWriter write = new XMLWriter(out);
        //2.写出对象
        write.write(doc);
        //3.关闭流
        write.close();
        System.out.println(MD5Utils.crateMD5(new File("g://contact.xml")));
    }
}
