package com.chuyuqiao.c_sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

/**
 * 使用sax解析把 xml文档封装成对象
 * Created by chuyuqiao on 2016/7/2.
 */
public class Demo3 {
    public static void main(String[] args)throws Exception {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        MyDefaultHandler3 handler = new MyDefaultHandler3();
        parser.parse(new File("g:/XML/contact.xml"), handler);
        List<Contact> list = handler.getList();
        for (Contact contact : list) {
            System.out.println(contact);
        }
    }
}
