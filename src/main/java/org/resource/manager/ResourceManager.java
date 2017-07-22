package org.resource.manager;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.resource.model.ExceptionModel;

public interface ResourceManager {
	
	/**
	 * 根据指定File对象创建一个文件,如果文件已经存在则创建失败
	 * @param file 指定要创建的File对象
	 * @return 创建成功或创建失败
	 */
	boolean create(File file);
	
	/**
	 * 根据指定的起始路径，文件名，若干目录创建一个文件，如果给定的起始路径不存在或给定
	 * 的文件已存在则创建失败。
	 * @param startPath 起始路径
	 * @param fileName 要创建的文件名
	 * @param dirs 指定若干目录
	 * @return 创建成功返回File对象，失败则返回null
	 */
	File create(String startPath,String fileName,String... dirs);
	/**
	 * 根据指定File对象创建一个文件，如果文件存在则覆盖原有文件
	 * @param file 指定要创建的File对象
	 * @return 创建成功或创建失败
	 */
	boolean createOrCover(File file);
	/**
	 * 根据指定的起始路径，文件名，若干目录创建一个文件，如果目录或文件已经存在就覆盖
	 * @param startPath 指定起始路径
	 * @param fileName 指定文件名称
	 * @param dirs 指定若干目录
	 * @return 创建或覆盖成功就返回创建的File对象，失败则返回null
	 */
	File createOrCover(String startPath,String fileName,String... dirs);
	/**
	 * 根据指定的File对象进行迭代删除（即如果要删除的是目录，且目录中还有子目录和文件时会将子目录也给删除掉）,如果File代表的文件或目录不存在<br>
	 * 则删除失败
	 * @param file 要删除的文件或目录的File代表对象。
	 * @return 删除成功或失败。
	 */
	boolean delete(File file);
	/**
	 * 根据起始路径按照给定的目录或文件进行搜索，查找出最终要删除的目录或文件后对该文件进行删除，如果删除该文件删除后所在的文件夹也为空则一并删除，
	 * 直到删除后所在文件夹不为空或所在目录路径已经和startPath相同为止。
	 * @param startPath 起始路径
	 * @param dirOrFile 给定的若干目录或文件
	 * @return 当且仅当startPath代表的路径不存在或startPath和dirOrFile共同指定的文件不存在时返回false
	 */
	boolean delete(String startPath,String...dirOrFile);
	/**
	 * 根据指定的File搜索文件或目录，如果搜索到则返回原对象，如果未搜索到则返回的路径具有以下特点：
	 * 1，例如传入的File对象路径为C:/java/sys/dir1/dir2/file1.txt，且该文件存在，则将此File对象进行返回；
	 * 2，还是上面的例子，如果确定指定的File路径不存在则返回最匹配路径，例如C:/java/sys/dir1/dir2/file1.txt，
	 * 但是真实的路径只存在C:/java/sys/dir1，则返回路径为C:/java/sys/dir1的File对象。
	 * @param file 传入要搜索的文件或目录的File对象
	 * @return 若搜索过程中出现异常，则返回null。
	 */
	File find(File file);
	/**
	 * 根据指定的startPath和若干目录或文件名进行搜索
	 * @param startPath 指定搜索起始路径
	 * @param dirOrFile 指定若干目录或文件
	 * @return 若未找到指定文件或若搜索过程中出现异常，则返回null
	 */
	File find(String startPath,String... dirsOrFiles);
	/**
	 * 根据给定的起始路径和若干目录名按照层级搜索目录，如果搜索过程中指定的目录不存在则创建一个
	 * @param startPath 起始路径
	 * @param dirs 指定的若干目录
	 * @return 搜索到或创建的对象
	 */
	File findOrCreateDirectory(String startPath,String... dirs);
	/**
	 * 根据给定的起始路径和若干目录名按照层级搜索目录，如果搜索过程中指定的目录不存在则创建一个
	 * @param startPath 起始路径
	 * @param dirs 指定的若干目录
	 * @return 搜索到或创建的对象
	 */
	File findOrCreateDirectory(File startPath,String... dirs);
	/**
	 * 根据给定的起始路径和若干目录名按照层级搜索文件，如果搜索过程中指定的目录或文件不存在则创建
	 * @param startPath 起始路径
	 * @param fileName 要搜索或要创建的文件名
	 * @param dirs 要搜索或创建的目录
	 * @return 搜索结果或创建出来的文件的File对象
	 */
	File findOrCreateFile(String startPath,String fileName,String... dirs);
	/**
	 * 根据给定的起始路径和若干目录名按照层级搜索文件，如果搜索过程中指定的目录或文件不存在则创建
	 * @param startPath 起始路径
	 * @param fileName 指定文件名
	 * @param FileSuffixName 指定文件后缀名
	 * @param dirs 要搜索或创建的目录
	 * @return 搜索结果或创建出来的文件的File对象
	 */
	File findOrCreateFile(String startPath,String fileName,String fileSuffixName,String... dirs);
	/**
	 * 根据给定的起始路径和若干目录名按照层级搜索文件，如果搜索过程中指定的目录或文件不存在则创建
	 * @param startPath 起始路径,以File对象的形式给出
	 * @param fileName 指定文件名
	 * @param FileSuffixName 指定文件后缀名
	 * @param dirs 要搜索或创建的目录
	 * @return 搜索结果或创建出来的文件的File对象
	 */
	File findOrCreateFile(File startPath,String fileName,String fileSuffixName,String... dirs);
	/**
	 * 将一个文件复制到指定的目录中
	 * @param sourceFile 源文件
	 * @param destinationFile 目的目录
	 * @return 复制成功返回true，失败则返回false
	 */
	public boolean copy(File sourceFile, File destinationFile);
}
