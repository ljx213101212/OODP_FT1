package sg.edu.nus.iss.vmcs.system;

public class FilePropertyFactory extends PropertyAbstractFactory {
	
	public FilePropertyLoader getLoader(String type,String filename) {
		
		  if(type=="cash") 
		   return new CashPropertyLoader(filename);
		  else
		   return new DrinkPropertyLoader(filename);
		 }

	

}
