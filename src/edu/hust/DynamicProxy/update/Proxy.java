package edu.hust.DynamicProxy.update;

import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * 模拟JDK的Proxy源码：动态编译产生动态代理对象$Proxy1
 * 
 * 最底层代码，永不随业务的变化而变化
 *
 */
public class Proxy {
	public static Object newProxyInstance(Class interf, InvocationHandler h) throws Exception {
		//获取接口的所有方法源码
		String methods = "";
		for (Method method : interf.getMethods()) {
			methods +=  "	@Override" + "\r\n" +
						"	public " + method.getReturnType() + " " + method.getName() + "() { "    						+ "\r\n" +
						"		try {"													 	 								+ "\r\n" +
						"			Method md = " + interf.getName() + ".class.getMethod(\"" + method.getName() + "\");"    + "\r\n" +
						"			h.invoke(this, md);" 	   																+ "\r\n" + 
						"		} catch(NoSuchMethodException e) {"															+ "\r\n" + 
						"			e.printStackTrace();"																	+ "\r\n" + 
						"		}"																				 			+ "\r\n" + 
						"	} " ;
		}
		
		//拼接代理类源码
		String src = 
				"package edu.hust.DynamicProxy.update; "                  			+ "\r\n" + 
				"import java.lang.reflect.Method; "									+ "\r\n" +
				"public class $Proxy1 implements " + interf.getName() + " { "  		+ "\r\n" + 
				"	edu.hust.DynamicProxy.update.InvocationHandler" + " h; "		+ "\r\n" + 
				"	public $Proxy1(InvocationHandler h) { "  			 			+ "\r\n" + 
				"		super(); "                                 					+ "\r\n" + 
				"		this.h = h; " 										   		+ "\r\n" + 
				"	} " 										  					+ "\r\n" + 
					methods 														+ "\r\n" + 
				"}";
		
		//生成临时源码文件
		String fileName = "d:/src/edu/hust/DynamicProxy/update/$Proxy1.java"; 
		FileWriter fw = new FileWriter(fileName);
		fw.write(src);
		fw.close();
		
		//动态编译生成类：Java Compiler 、 CGLIB、 ASM（后两种可以直接拼接生成Java二进制流，不需要先生成源文件，例如Spring）
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
		Iterable units = manager.getJavaFileObjects(fileName);
		CompilationTask task = compiler.getTask(null, manager, null, null, null, units);
		task.call();
		manager.close();
		
		//加载到内存并生成代理类实例
		URL[] urls = new URL[] {new URL("file:/" + "d:/src/")};
		URLClassLoader ucl = new URLClassLoader(urls);
		Class clazz = ucl.loadClass("edu.hust.DynamicProxy.update.$Proxy1"); //注意和上面的package保持一致，路径其他部分无所谓
		
		Constructor con = clazz.getConstructor(InvocationHandler.class);
		return con.newInstance(h);
	}
}
