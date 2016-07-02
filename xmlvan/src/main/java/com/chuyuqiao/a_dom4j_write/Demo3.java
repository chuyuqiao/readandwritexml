package com.chuyuqiao.a_dom4j_write;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 修改xml内容
 * 增加：文档，标签 ，属性
 * 修改：属性值，文本
 * 删除：标签，属性
 * Created by chuyuqiao on 2016/6/29.
 */
public class Demo3 {

    public static void main(String[] args) throws Exception {
        test1();
    }

        /**
         * 增加：文档，标签 ，属性
         */

    private static void test1() throws Exception {
        /**
         * 1.创建文档
         */
        Document doc = DocumentHelper.createDocument();
        /**
         * 2.增加标签
         */
        Element rootElem = doc.addElement("contactList");
        //doc.addElement("contactList");
        Element contactElem = rootElem.addElement("Contact");
        contactElem.addElement("name");
        /**
         * 3.增加属性
         */
        contactElem.addAttribute("id", "001");
        contactElem.addAttribute("name", "eric");

        //把修改后的Document对象写出到xml文档中
        FileOutputStream out = new FileOutputStream("g:/Contact.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(out, format);
        writer.write(doc);
        writer.close();
    }

    private static void test2() throws Exception {
        Document doc = new SAXReader().read(new File("./src/Contact.xml"));

        /**
         * 方案一： 修改属性值   1.得到标签对象 2.得到属性对象 3.修改属性值
         */
        //1.1  得到标签对象
        /*
		Element contactElem = doc.getRootElement().element("Contact");
		//1.2 得到属性对象
		Attribute idAttr = contactElem.attribute("id");
		//1.3 修改属性值
		idAttr.setValue("003");
		*/
        /**
         * 方案二： 修改属性值
         */
        //1.1  得到标签对象
		/*
		Element contactElem = doc.getRootElement().element("Contact");
		//1.2 通过增加同名属性的方法，修改属性值
		contactElem.addAttribute("id", "004");
		*/

        /**
         * 修改文本 1.得到标签对象 2.修改文本
         */
        Element nameElem = doc.getRootElement().
                element("Contact").element("name");
        nameElem.setText("李四");


        FileOutputStream out = new FileOutputStream("g:/Contact.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(out, format);
        writer.write(doc);
        writer.close();
    }


    /**
     * 删除：标签，属性
     *
     * @throws Exception
     */

    private static void test3() throws Exception {
        Document doc = new SAXReader().read(new File("./src/Contact.xml"));

        /**
         * 1.删除标签     1.1 得到标签对象  1.2 删除标签对象
         */
        // 1.1 得到标签对象
		/*
		Element ageElem = doc.getRootElement().element("Contact")
					.element("age");

		//1.2 删除标签对象
		ageElem.detach();
		//ageElem.getParent().remove(ageElem);
		*/
        /**
         * 2.删除属性   2.1得到属性对象  2.2 删除属性
         */
        //2.1得到属性对象
        //得到第二个contact标签
        Element contactElem = (Element) doc.getRootElement().
                elements().get(1);
        //2.2 得到属性对象
        Attribute idAttr = contactElem.attribute("id");
        //2.3 删除属性
        idAttr.detach();
        //idAttr.getParent().remove(idAttr);

        FileOutputStream out = new FileOutputStream("e:/Contact.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(out, format);
        writer.write(doc);
        writer.close();
    }
}
