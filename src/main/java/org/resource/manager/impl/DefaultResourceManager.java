package org.resource.manager.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.resource.constant.FileSuffixName;
import org.resource.exception.ResourceException;
import org.resource.filter.ResourceFilter;
import org.resource.manager.ResourceManager;
import org.resource.model.ExceptionModel;

public class DefaultResourceManager implements ResourceManager{
	
	private List<ExceptionModel> exceptionModels;
	
	public DefaultResourceManager(){
		exceptionModels=new ArrayList<>();
	}
	
	//保护方法
	/**
	 * 根据给定的file对象搜索其中名称等于给定的文件名称的文件或文件夹
	 * @param file 给定的file对象
	 * @param fileName 给定的文件夹名称
	 * @return 如果找到就返回找到的文件或文件夹，如果没有找到则返回null
	 */
	protected File getFile(File file,String fileName) {
		File[] files=file.listFiles(new ResourceFilter(fileName));
		return files.length>0?files[0]:null;
	}
	
	/**
	 * 根据指定File对象创建一个文件,如果文件已经存在则创建失败
	 * @param file 指定要创建的File对象
	 * @return 创建成功或创建失败
	 */
	@Override
	public boolean create(File file) {
		try {
			//如果文件存在则创建失败
			if(file.exists()){
				return false;
			}else{
				//查看该File对象的上一个目录是否存在，如果不存在则新建
				File f=file.getParentFile();
				boolean isOK=false;
				if(!f.exists()){
					isOK=f.mkdirs();
				}
				//新建文件
				isOK=file.createNewFile();
				return isOK;
			}
		} catch (Exception e) {
			exceptionModels.add(new ExceptionModel(e,"文件创建失败",new Date()));
			System.out.println("文件创建失败");
			return false;
		}
	}
	
	/**
	 * 根据指定的起始路径，文件名，若干目录创建一个文件，如果给定的起始路径不存在或给定
	 * 的文件已存在则创建失败。
	 * @param startPath 起始路径
	 * @param fileName 要创建的文件名
	 * @param dirs 指定若干目录
	 * @return 创建成功返回File对象，失败则返回null
	 */
	@Override
	public File create(String startPath, String fileName, String... dirs){
		try {
			//根据传入的起始路径创建一个File对象
			File file=new File(startPath);
			//如果该File对象代表的文件或文件夹存在，就检测给定的若干子文件夹是否存在
			if(file.exists()){
				//按顺序搜索文件夹
				File f=null;
				for(String dir:dirs){
					//搜索指定名称的文件夹
					f=getFile(file, dir);
					//如果没有找到指定的文件夹
					if(f==null){
						//新建文件夹，如果失败则此次创建文件失败，返回null
						f=new File(file,dir);
						if(!f.mkdir()){
							return null;
						}
					}
					//如果搜索到文件夹或创建文件夹成功，则以此为起点继续向下搜索
					file=f;
				}
				//搜索文件
				f=getFile(file, fileName);
				//如果文件不存在，则创建文件，如果创建失败返回null
				if(f==null){
					f=new File(file,fileName);
					return f.createNewFile()?f:null;
				}else{
					return null;
				}
			}else{
				return null;
			}
		} catch (Exception e) {
			exceptionModels.add(new ExceptionModel(e, "创建文件失败",new Date()));
			return null;
		}
	}
	/**
	 * 根据指定File对象创建一个文件，如果文件存在则覆盖原有文件
	 * @param file 指定要创建的File对象
	 * @return 创建成功或创建失败
	 */
	@Override
	public boolean createOrCover(File file){
		try {
			//如果文件存在
			if(file.exists()){
				if(file.delete()){
					return file.createNewFile();
				}else{
					return false;
				}
			}else{
				if(file.getParentFile().exists()){
					return file.createNewFile();
				}else{
					if(file.getParentFile().mkdirs()){
						return file.createNewFile();
					}else{
						return false;
					}
				}
			}
		} catch (Exception e) {
			exceptionModels.add(new ExceptionModel(e,"创建文件失败", new Date()));
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据指定的起始路径，文件名，若干目录创建一个文件，如果目录或文件已经存在就覆盖
	 * @param startPath 指定起始路径
	 * @param fileName 指定文件名称
	 * @param dirs 指定若干目录
	 * @return 创建或覆盖成功就返回创建的File对象，失败则返回null
	 */
	@Override
	public File createOrCover(String startPath, String fileName, String... dirs) {
		File file=this.findOrCreateFile(startPath,fileName,dirs);
		return file;
	}
	/**
	 * 根据指定的File对象进行迭代删除（即如果要删除的是目录，且目录中还有子目录和文件时会将子目录也给删除掉）,如果File代表的文件或目录不存在<br>
	 * 则删除失败
	 * @param file 要删除的文件或目录的File代表对象。
	 * @return 删除成功或失败。
	 */
	@Override
	public boolean delete(File file) {
		boolean deleteOK=false;
		//如果文件对象不为空，则继续下一步
		if(file!=null){
			deleteOK=true;
			File[] files=null;
			//如果传入的文件对象是一个文件，就直接删除
			if(file.isFile()){
				deleteOK=file.delete();
			}else{
				//如果传入的文件对象是一个目录，就搜索下面所有的文件和文件夹并进行迭代删除，若迭代删除中失败，
				//则立即停止迭代删除
				files=file.listFiles();
				for(File f:files){
					deleteOK&=delete(f);
					if(!deleteOK){
						return deleteOK;
					}
				}
				deleteOK=file.delete();
			}
		}
		return deleteOK;
	}
	/**
	 * 根据起始路径按照给定的目录或文件进行搜索，查找出最终要删除的目录或文件后对该文件进行删除，如果删除该文件删除后所在的文件夹也为空则一并删除，
	 * 直到删除后所在文件夹不为空或所在目录路径已经和startPath相同为止。
	 * @param startPath 起始路径
	 * @param dirOrFile 给定的若干目录或文件
	 * @return 当且仅当startPath代表的路径不存在或startPath和dirOrFile共同指定的文件不存在时返回false
	 */
	@Override
	public boolean delete(String startPath, String... dirOrFile){
		File file=this.find(startPath, dirOrFile);
		if(file!=null&&file.getAbsolutePath().endsWith(startPath)){
			File parent=file.getParentFile();
			while (true) {
				this.delete(file);
				if(this.isEmptyDirectory(parent)){
					file=parent;
					parent=file.getParentFile();
				}
			}
		}
		return false;
	}
	/**
	 * 将一个文件复制到指定的目录中
	 * @param sourceFile 源文件
	 * @param destinationFile 目的目录
	 * @return 复制成功返回true，失败则返回false
	 */
	@Override
	public boolean copy(File sourceFile, File destinationFile) {
		//如果要移动的文件或文件夹存在，则开始移动文件或文件夹
		if(sourceFile.exists()){
			//如果目标文件夹不存在，就先创建目标文件夹
			if(!destinationFile.exists()){
				//如果创建目标文件夹失败，则复制失败并直接返回
				if(!destinationFile.mkdirs()){
					return false;
				}
			}
			
		}
		return false;
	}
	/**
	 * 根据指定的File搜索文件或目录，如果搜索到则返回原对象，如果未搜索到则返回的路径具有以下特点：
	 * 1，例如传入的File对象路径为C:/java/sys/dir1/dir2/file1.txt，且该文件存在，则将此File对象进行返回；
	 * 2，还是上面的例子，如果确定指定的File路径不存在则返回最匹配路径，例如C:/java/sys/dir1/dir2/file1.txt，
	 * 但是真实的路径只存在C:/java/sys/dir1，则返回路径为C:/java/sys/dir1的File对象。
	 * @param file 传入要搜索的文件或目录的File对象
	 * @return 若搜索过程中出现异常，则返回null。
	 */
	@Override
	public File find(File file) {
		return file.exists()?file:file.getParent()!=null?find(file.getParentFile()):null;
	}
	/**
	 * 根据指定的startPath和若干目录或文件名进行搜索
	 * @param startPath 指定搜索起始路径
	 * @param dirOrFile 指定若干目录或文件
	 * @return 若未找到指定文件或若搜索过程中出现异常，则返回null
	 */
	@Override
	public File find(String startPath, String... dirsOrFiles){
		File file=new File(startPath);
		//如果起始路径存在，则开始搜索，否则搜索结束，返回null
		if(file.exists()){
			File f=null;
			for(String dirNameOrFileName:dirsOrFiles){
				f=getFile(file, dirNameOrFileName);
				if(f!=null){
					file=f;
					if(file.isFile()){
						break;
					}
				}else{
					return null;
				}
			}
			return file;
		}else{
			return null;
		}
	}
	/**
	 * 根据给定的起始路径和若干目录名按照层级搜索目录，如果搜索过程中指定的目录不存在则创建一个
	 * @param startPath 起始路径
	 * @param dirs 指定的若干目录
	 * @return 搜索到或创建的对象
	 */
	@Override
	public File findOrCreateDirectory(String startPath, String... dirs) {
		File file=new File(startPath);
		file=this.findOrCreateDirectory(file, dirs);
		return file!=null?file:null;
	}
	/**
	 * 根据给定的起始路径和若干目录名按照层级搜索文件，如果搜索过程中指定的目录或文件不存在则创建
	 * @param startPath 起始路径
	 * @param fileName 要搜索或要创建的文件名
	 * @param dirs 要搜索或创建的目录
	 * @return 搜索结果或创建出来的文件的File对象
	 */
	@Override
	public File findOrCreateFile(String startPath, String fileName,
			String... dirs) {
		try {
			File file=this.findOrCreateDirectory(startPath, dirs);
			file=new File(file,fileName);
			if(!file.exists()){
				boolean isOK=file.createNewFile();
				return isOK?file:null;
			}
			return file;
		} catch (IOException e) {
			exceptionModels.add(new ExceptionModel(e,"创建文件异常",new Date()));
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 根据给定的起始路径和若干目录名按照层级搜索文件，如果搜索过程中指定的目录或文件不存在则创建
	 * @param startPath 起始路径
	 * @param fileName 指定文件名
	 * @param FileSuffixName 指定文件后缀名
	 * @param dirs 要搜索或创建的目录
	 * @return 搜索结果或创建出来的文件的File对象
	 */
	@Override
	public File findOrCreateFile(String startPath, String fileName,
			String fileSuffixName, String... dirs) {
		try {
			File file=this.findOrCreateDirectory(startPath, dirs);
			file=new File(file,fileName+FileSuffixName.createSuffix(fileSuffixName));
			if(!file.exists()){
				boolean isOK=file.createNewFile();
				return isOK?file:null;
			}
			return file;
		} catch (IOException e) {
			exceptionModels.add(new ExceptionModel(e,"创建文件异常",new Date()));
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 根据给定的起始路径和若干目录名按照层级搜索文件，如果搜索过程中指定的目录或文件不存在则创建
	 * @param startPath 起始路径,以File对象的形式给出
	 * @param fileName 指定文件名
	 * @param FileSuffixName 指定文件后缀名
	 * @param dirs 要搜索或创建的目录
	 * @return 搜索结果或创建出来的文件的File对象
	 */
	@Override
	public File findOrCreateFile(File startPath, String fileName,
			String fileSuffixName, String... dirs) {
		File file=this.findOrCreateDirectory(startPath, dirs);
		if(file!=null&&file.exists()){
			file=new File(file, fileName+FileSuffixName.createSuffix(fileSuffixName));
			if (file!=null&&file.exists()) {
				try {
					boolean createOK=file.createNewFile();
					return createOK?file:null;
				} catch (IOException e) {
					exceptionModels.add(new ExceptionModel(e, "创建文件异常",new Date()));
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public List<ExceptionModel> getExceptionModels() {
		return exceptionModels;
	}
	/**
	 * 根据给定的起始路径和若干目录名按照层级搜索目录，如果搜索过程中指定的目录不存在则创建一个
	 * @param startPath 起始路径
	 * @param dirs 指定的若干目录
	 * @return 搜索到或创建的对象
	 */
	@Override
	public File findOrCreateDirectory(File startPath, String... dirs) {
		String msg=null;
		try {
			//如果传入的起始路径为空或不存在，则停止搜索并抛出异常
			if(startPath!=null&&startPath.exists()){
				//如果起始路径不存在或不是目录，则停止搜索并抛出资源异常
				if(startPath.exists()&&startPath.isDirectory()){
					for(String dir:dirs){
						if(this.getFile(startPath, dir)!=null){
							startPath=this.getFile(startPath, dir);
						}else{
							startPath=new File(startPath,dir);
							startPath.mkdir();
						}
					}
					return startPath;
				}else{
					msg="起始路径不存在或不是目录";
					throw new ResourceException(msg);
				}
			}else{
				msg="起始路径不能为空";
				throw new ResourceException(msg);
			}
		} catch (Exception e) {
			exceptionModels.add(new ExceptionModel(e, msg, new Date()));
			return null;
		}
	}
	/**
	 * 清空文件夹，如果传入的File不存在或不是文件夹时则清空失败
	 * @param file 要清空的文件夹
	 * @return 清空成功或失败
	 */
	public boolean clear(File file){
		//当传入的文件存在且为目录时，开始清空文件
		boolean clearOK=true;
		if(file.exists()&&file.isDirectory()){
			File[] files=file.listFiles();
			for (File f : files) {
				clearOK&=this.delete(f);
			}
			return clearOK;
		}else{
			return !clearOK;
		}
	}
	
	/**
	 * 判断一个文件夹是否为空，如果传入的File对象不是文件夹或文件夹不存在或null则返回false
	 * @param file
	 * @return
	 */
	private boolean isEmptyDirectory(File file){
		return file!=null?file.exists()?file.isDirectory()?file.list().length==0:false:false:false;
	}
}
