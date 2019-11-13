package com.hsys.coupon.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUpLoadUtil {
	/**
	 * 线程安全的变量
	 */
	private static ThreadLocal<FileUpLoadUtil> local = new ThreadLocal<FileUpLoadUtil>();
	
	/**
	 * 工具类的私有构造方法
	 */
	private FileUpLoadUtil(){}
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 获取工具类实例
	 * @return
	 */
	public static synchronized FileUpLoadUtil getInstance(){
		FileUpLoadUtil instance = local.get();
		if (instance == null) {
			instance = new FileUpLoadUtil();
			local.set(instance);
		}
		return local.get();
	}
	
	/**
	 * 上传单张图片
	 * @param file
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public String pictureUpLoad(MultipartFile file, HttpServletRequest req) throws IOException {
		if(file.isEmpty()) {
			return "0";
		}
		String format = sdf.format(new Date());
	    String realPath = req.getSession().getServletContext().getRealPath("/resources") +"\\"+ format;
	    System.out.println("realPath"+realPath);
	    File folder = new File(realPath);
	    if (!folder.exists()) {
	        folder.mkdirs();
	    }
	    String oldName = file.getOriginalFilename();
	    String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
		file.transferTo(new File(folder,newName));
	    String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/resources/" + format +"/"+ newName;
	    System.out.println(url);
	    return url;
	}
	
	/**
	 * 实现多图片上传
	 * @param files
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public String picturesUpLoad(MultipartFile[] files, HttpServletRequest req) throws IOException {
		if(files == null || files.length <= 0) {
			return "0";
		}
		System.out.println(Arrays.toString(files));
		for(MultipartFile file : files) {
			String pictureUpLoad = pictureUpLoad(file, req);
			System.out.println("子传递" + pictureUpLoad);
		}
		return "1";
	}
}
