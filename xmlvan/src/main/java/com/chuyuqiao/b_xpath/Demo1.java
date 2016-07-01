package com.chuyuqiao.b_xpath;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 第一个XPath程序
 * Created by chuyuqiao on 2016/7/1.
 */
public class Demo1 {

    public static void main(String[] args) throws Exception{
        /**
         * 需求: 删除id值为2的学生标签
         */
        Document doc = new SAXReader().read(new File("g:/XML/student.xml"));

        //1.查询id为2的学生标签
        //使用xpath技术
        Element stuElem = (Element)doc.selectSingleNode("//Student[@id='2']");

        //2.删除标签
        stuElem.detach();

        //3.写出xml文件
        FileOutputStream out = new FileOutputStream("g:/XML/student.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(out,format);
        writer.write(doc);
        writer.close();
    }

}
