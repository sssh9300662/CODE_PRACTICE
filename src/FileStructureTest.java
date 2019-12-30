import java.io.File;

public class FileStructureTest {
	
	static class FileManager{
		private static final String prefix_symbol = "-";
		
		public void print(File file, String prefix){
			if(!file.exists() || file == null){
				return;
			}
			
			System.out.println(prefix + file.getName());
			prefix = prefix + prefix_symbol;
			if(!file.isDirectory()|| file.listFiles()== null){
				return;
			}
			for(File subFile:file.listFiles()){
				print(subFile, prefix);
			}
		}
	}
	
	public static void main(String args[]){
		String filePath = "D:\\ems_configs";
		FileManager fileManager = new FileManager();
		fileManager.print(new File(filePath), "");
	}

}
