package com.chuyuqiao.c_sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * 读取contact.xml文件，完整输出文档内容
 * Created by chuyuqiao on 2016/7/2.
 */
public class Demo2 {

    public static void main(String[] args) throws Exception {
        //1.创建SAXParser
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        //2.读取xml文件
        MyDefaultHandler2 handler = new MyDefaultHandler2();
        parser.parse(new File("g:/XML/contact.xml"), handler);
        String content = handler.getContent();
        System.out.println(content);
    }
}
