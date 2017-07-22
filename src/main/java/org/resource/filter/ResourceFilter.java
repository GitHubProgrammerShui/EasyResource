package org.resource.filter;

import java.io.File;
import java.io.FileFilter;

public class ResourceFilter implements FileFilter{
	
	private String dirOrFileName;
	
	public ResourceFilter(String dirOrFileName){
		this.dirOrFileName=dirOrFileName;
	}
	
	@Override
	public boolean accept(File pathname) {
		if(pathname.getName().equals(dirOrFileName)){
			return true;
		}else{
			return false;
		}
	}
}
