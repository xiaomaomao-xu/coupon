package com.hsys.coupon.common.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hsys.coupon.utils.FileUpLoadUtil;

@RestController
@RequestMapping("/pload")
public class PictureUpLoadController {
	@Autowired
	HttpServletRequest req;
	
	/**
	 * 单张图片上传
	 * @param file
	 * @return
	 */
	@RequestMapping("/pictureUpLoad.do")
	public String pictureUpLoad(MultipartFile file){
		System.out.println("file"+file);
		String pictureUpLoad = "0";
		try {
			pictureUpLoad = FileUpLoadUtil.getInstance().pictureUpLoad(file, req);
		} catch (IOException e) {
			e.printStackTrace();
			return pictureUpLoad;
		}
	    return pictureUpLoad;
	}
	
	/**
	 * 多个图片上传
	 * @param files
	 * @return
	 */
	@RequestMapping("/picturesUpLoad.do")
	public String picturesUpLoad(MultipartFile[] files,String pic) {
		System.out.println("pic"+pic);
		System.out.println("files2243234234"+Arrays.toString(files));
		String pictureUpLoads = "0";
		try {
			pictureUpLoads = FileUpLoadUtil.getInstance().picturesUpLoad(files, req);
		} catch (IOException e) {
			e.printStackTrace();
			return pictureUpLoads;
		}
		return pictureUpLoads;
	}
}
