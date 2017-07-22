package com.tests;

import java.io.File;

import org.junit.Test;
import org.resource.manager.ResourceManager;
import org.resource.manager.impl.DefaultResourceManager;

public class TestDefaultResourceManager {
	
	@Test
	public void testFind(){
		ResourceManager resManager=new DefaultResourceManager();
		File file=resManager.find("F:/resource","dir_2","file_2_1_1.txt","dir_2_1");
		System.out.println(file.getAbsolutePath());
	}
	
	@Test
	public void testFindOrCreateDirectory(){
		ResourceManager resourceManager=new DefaultResourceManager();
		File file=resourceManager.findOrCreateDirectory("F:/resource","dir_2","dir_3_2","dir_3_2_2");
		System.out.println(file);
		System.out.println(file.getAbsolutePath());
	}
}
