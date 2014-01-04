import com.sun.tools.javac.Main;

import java.io.File;

public class JCOOTest {
    public static void main(String[] args) throws Exception {
        compile("ValueOf");
        compile("Math");
        compile("Cmp");
        compile("ListIndexGet");
        compile("ListIndexSet");
        compile("MapIndex");
        compile("Vector");
        compile("CompAss", "../tests");
        compile("Boxing", "../tests");
    }
    public static void compile(String clas) throws  Exception {
        compile(clas, "../examples");
    }
    public static void compile(String clas, String path) throws Exception {
    	String file = path+"/"+clas+".java";
		System.out.print("Compiling " + file + ": ");
		boolean res = Main.compile(new String[]{file, "-d", "build/classes/"})==0;
		res &= (boolean)Class.forName(clas).getDeclaredMethod("test").invoke(null);
		System.out.println(res ? "ok" : "fail");
	}
}
