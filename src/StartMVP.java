
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



public class StartMVP {

	public static void main(String[] args) {
		
		Scanner kl =  new Scanner(System.in);
		System.out.print("请输入类名：");
		String name = kl.next();
		
		createFolder(name);
		
		createActivity(name);
		
		createView(name);
		
		createPresenter(name);
		
	}
	
	/**
	 * 创建主文件夹
	 * @param name
	 */
	private static void createFolder(String name) {
		File folder = new File(getLowName(name));
		if (!folder.exists()) {
			folder.mkdirs();
		}
		System.out.println(getLowName(name)+" 文件夹打开成功！");
	}

	
	/**
	 * 创建Presenter层
	 * @param name
	 */
	private static void createPresenter(String name) {
		File folder = new File(getLowName(name)+"/present");
		if((folder.exists() && folder.isDirectory()) ? true : folder.mkdirs()){
			System.out.println("present 文件夹打开成功！");
			
			File presentFile = new File(folder, "I"+name+"Presenter.java");
			String content = Contents.getInterface(name, getTime());
			
			File implFile = new File(folder, name+"PresenterImpl.java");
			String content2 = Contents.getImpl(name, getLowName(name), getTime());
			
			
			try {
				if (FileUtils.createFile(presentFile)) {
					FileUtils.writeTxtFile(content, presentFile);
					System.out.println(presentFile.getName()+" 创建成功！");
				};
				
				if (FileUtils.createFile(implFile)) {
					FileUtils.writeTxtFile(content2, implFile);
					System.out.println(implFile.getName()+" 创建成功！");
				};
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 创建View层
	 * @param name
	 */
	private static void createView(String name) {
		File folder = new File(getLowName(name)+"/view");
		if((folder.exists() && folder.isDirectory()) ? true : folder.mkdirs()){
			System.out.println("view 文件夹打开成功！");
			
			File viewFile = new File(folder, "I"+name+"View.java");
			String content = Contents.getView(name, getTime());
			
			try {
				if (FileUtils.createFile(viewFile)) {
					FileUtils.writeTxtFile(content, viewFile);
					System.out.println(viewFile.getName()+" 创建成功！");
				};
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	/**
	 * 创建Activity
	 * @param name
	 */
	private static void createActivity(String name) {
		File file = new File(getLowName(name)+"/"+name+"Activity.java");
		String contentString = Contents.getActivityString(name, getTime());
		
		try {
			if (FileUtils.createFile(file)) {
				FileUtils.writeTxtFile(contentString, file);
				System.out.println(file.getName()+" 创建成功！");
			};
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * 第一个字母小写
	 */
	public static String getLowName(String name){
		String a = String.valueOf(name.charAt(0));
		String bString = name.replace(a, a.toLowerCase());
		return bString;
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getTime() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

}
