package com.kfl.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class MonitorOff {

	public static void main(String[] args) {
		new MonitorOff().turnOff();
	}
	
	private void turnOff()
	{
		try {
			File destination=new File(System.getenv("APPDATA")+"\\nircmd.exe");
			//System.out.println(destination.getPath());
			Files.copy(this.getClass().getResourceAsStream("/nircmd.exe"), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
			//String filePath=this.getClass().getResource("/nircmd.exe").getFile().replace('/', '\\');
			Runtime.getRuntime().exec(System.getenv("APPDATA")+"\\nircmd.exe"+" monitor off");			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
