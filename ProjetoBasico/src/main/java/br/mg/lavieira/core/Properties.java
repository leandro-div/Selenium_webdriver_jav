package br.mg.lavieira.core;

public class Properties {
	
	public static boolean CLOSE_BROWSER = true;
	public static Browsers BROWSER = Browsers.FIREFOX;
	public static ExecutionTypes EXECUTION_TYPE = ExecutionTypes.GRID;
	//public static String NAME_ACCOUNT_EDITED = "Conta Alterada " + System.nanoTime();
	
	
	public enum Browsers {
		
		CHROME,
		FIREFOX,
		INTERNETEXPLORER
	}
	
	public enum ExecutionTypes{
		LOCAL,
		GRID
	}

}
