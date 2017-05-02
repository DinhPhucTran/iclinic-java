package com.group4.cms.util;

public class Util {
	
	public static String getFileExtension(String fileName){
		String result = "";
		String[] arr = fileName.split("\\.");
		if(arr.length > 0)
			result = arr[arr.length - 1];
		//System.out.println(fileName + "/" + arr.length);
		return result;
	}
	
	public static boolean isValidImageFile(String type){
		if("image/jpeg".equals(type) || "image/png".equals(type))
			return true;
		return false;
	}
}
