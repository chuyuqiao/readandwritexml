package com.chuyuqiao.b_xpath;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * 使用xpath技术读取一个规范的html文档
 * Created by chuyuqiao on 2016/7/1.
 */
public class Demo4 {
    public static void main(String[] args) throws Exception {
        Document doc = new SAXReader().read(new File("g:/XML/personList.html"));
        //System.out.println(doc);

        //读取title标签
        Element titleElem = (Element) doc.selectSingleNode("//title");
        String title = titleElem.getText();
        System.out.println(title);

        /**
         * 练习：读取联系人的所有信息
         * 按照以下格式输出：
         * 		 编号:001 姓名:张三 性别:男 年龄:18 地址：xxxx 电话： xxxx
         *       编号:002 姓名:李四 性别:女 年龄:20 地址：xxxx 电话： xxxx
         *       ......
         */
        //1.读取出所有tbody中的tr标签
        List<Node> list = doc.selectNodes("//tbody/tr");
        //2.遍历
        for (Node node : list) {
            Element elem=(Element)node;
            //编号
            //String id = ((Element)elem.elements().get(0)).getText();
            String id = elem.selectSingleNode("td[1]").getText();
            //姓名
            String name = ((Element) elem.elements().get(1)).getText();
            //性别
            String gender = ((Element) elem.elements().get(2)).getText();
            //年龄
            String age = ((Element) elem.elements().get(3)).getText();
            //地址
            String address = ((Element) elem.elements().get(4)).getText();
            //电话
            String phone = ((Element) elem.elements().get(5)).getText();

            System.out.println("编号：" + id + "\t姓名：" + name + "\t性别：" +
                    gender + "\t年龄：" +
                    age + "\t地址：" + address +
                    "\t电话：" + phone);
        }
    }
}