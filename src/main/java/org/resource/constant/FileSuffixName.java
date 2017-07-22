package org.resource.constant;

public class FileSuffixName {
	/**
	 * 将一个名称转换成标准的后缀名
	 * @param suffix 自定义后缀名
	 * @return 返回标准的带点的后缀名
	 */
	public final static String createSuffix(String suffix){
		suffix=suffix.toLowerCase();
		if(suffix.startsWith(".")){
			return suffix;
		}else{
			return "."+suffix;
		}
	}
	/**
	 * 返回一个后缀名的真实名称（将点去掉）
	 * @param suffix 该名称一般传入FileSuffixName对象中的常量属性
	 * @return 传入的后缀名的真实名称
	 */
	public final static String valueOf(String suffix){
		if(suffix.startsWith(".")){
			return suffix.substring(1);
		}else{
			return suffix;
		}
	}
}
