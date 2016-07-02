# DOM解析原理：
一次性把xml文档加载进内存，然后在内存中构建Document树；对内存要求比较要。
缺点： 不适合读取大容量的xml文件，容易导致内存溢出。
# SAX解析原理：
加载一点，读取一点，处理一点；对内存要求比较低。

# SAX解析：
SAX解析工具：
SAX解析工具-Sun公司提供的。内置在jdk中。org.xml.sax.*；
核心的API：
SAXParser类： 用于读取和解析xml文件对象
parse（File f, DefaultHandler dh）方法： 解析xml文件
参数一： File：表示 读取的xml文件。
参数二： DefaultHandler： SAX事件处理程序。使用DefaultHandler的子类

# DOM解析 VS SAX解析
|DOM解析||SAX解析|
|---|
|原理： 一次性加载xml文档，不适合大容量的文件读取||原理： 加载一点，读取一点，处理一点；适合大容量文件的读取。|  
|DOM解析可以任意进行增删改成||SAX解析只能读取|
|DOM解析任意读取任何位置的数据，甚至往回读||SAX解析只能从上往下，按顺序读取，不能往回读|
|DOM解析面向对象的编程方法（Node，Element，Attribute）,Java开发者编码比较简单。||SAX解析基于事件的编程方法。java开发编码相对复杂。|

	
	
	
	
	
	


