package edu.hust.DynamicProxy;

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
 * 模拟JDK的Proxy源码：动态编译产生动态代理对象$Proxy
 *
 */
public class Proxy {
	public static Object newProxyInstance(Class interf) throws Exception {
		//获取接口的所有方法源码
		String methods = "";
		for (Method method : interf.getMethods()) {
			methods +=  "	@Override" + "\r\n" +
						"	public " + method.getReturnType() + " " + method.getName() + "() { "    + "\r\n" +
						"		System.out.println(\"start log...\"); //代理方法预处理部分"     		+ "\r\n" + 
						"		interf." + method.getName() + "(); " 								+ "\r\n" + 
						"		System.out.println(\"stop log...\");  //代理方法结束部分" 	   		+ "\r\n" + 
						"	} " 																	+ "\r\n" ;
		}
		
		//拼接代理类源码
		String src = 
				"package edu.hust.DynamicProxy; "                  					+ "\r\n" + 
				"public class $Proxy implements " + interf.getName() + "{ "  		+ "\r\n" + 
				"	" + interf.getName() + " interf; "                              + "\r\n" + 
				"	public $Proxy(" + interf.getName() + " interf) { "   			+ "\r\n" + 
				"		super(); "                                 					+ "\r\n" + 
				"		this.interf = interf; " 							   		+ "\r\n" + 
				"	} " 										  					+ "\r\n" + 
					methods 														+ "\r\n" + 
				"}";
		
		//生成临时源码文件
		String fileName = "d:/src/edu/hust/DynamicProxy/$Proxy.java"; 
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
		Class clazz = ucl.loadClass("edu.hust.DynamicProxy.$Proxy"); //注意和上面的package保持一致，路径其他部分无所谓
		
		Constructor con = clazz.getConstructor(interf);
		return con.newInstance(new Tank());
	}
}
