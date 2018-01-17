package com.hl.controller;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.hl.model.FileUploadReturn;

@Controller
public class UpLoadController {
	
	private static final Logger logger = Logger.getLogger(UpLoadController.class);
	
	
	@RequestMapping(value="upLoad/file.do" )
	public String upLoad (HttpServletRequest request, HttpServletResponse response,@RequestParam("file") MultipartFile mf) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
			
		JSONObject resultObj = new JSONObject();
		Integer code = 1;
		String mssage ="";	 
		
		String fileType = request.getParameter("fileType");
		String file = request.getParameter("file");
		if(!StringUtils.isEmpty(fileType)){
			
	        String filepath = "D:/fhwork/personpublicserver/WebContent/resources/upload/";//上传文件路径
	        
	            if (mf != null) {  
                    // 取得当前上传文件的文件名称  
                    String myFileName = mf.getOriginalFilename();  
                    if (myFileName.trim() != "") {  
              	
                    	if(fileType.equals("file")){
                    		filepath = filepath+"file/"+myFileName;
                    	}else if(fileType.equals("images")){
                    		filepath = filepath+"images/"+myFileName;
                    	}else{
                    		filepath = filepath+"unkonwfile/"+myFileName;
                    	}
                        //创建文件保存名
                        File localFile = new File(filepath);
                        try {
                        	//上传文件
                        	mf.transferTo(localFile); 
                        	code = 0;
                        	mssage ="上传成功";
						} catch (Exception e) {
							mssage ="文件上传异常"+e.toString();
							logger.info("文件上传异常错误:"+e.toString());
							e.getStackTrace();
							// TODO: handle exception
						}            
                    }else{
                    	mssage ="文件名为空,请校验";
                    }
                }else{
                	mssage ="未检测到上传文件";          	
                }                  
	        }else{
	        	mssage ="文件类型为空，请求拒绝";
	        }
			
		resultObj.put("code",code);
		resultObj.put("Result","" );
		resultObj.put("msg", mssage);
		
		logger.info("upLoad/file.do:"+resultObj.toString());
		response.getWriter().write(resultObj.toString());
		
		return null;
		
	}
	
	/**
	 * 文件上传实现类
	 * @param request
	 * @param fileType
	 * @return 
	 */
	private FileUploadReturn upLoadFile(HttpServletRequest request ,String fileType,String file){
		
		FileUploadReturn flieReturn = new FileUploadReturn();	
			Integer  uploadCode = 1;
			String uploadMsg ="";
			String uploadFilepath = "";
			String uploadFilename = "";
		
			String filepathimages = "../resources/uploadimages/";//图片
	        String filepath = "../resources/uploadfile/";//文件
	        String filepathUnknown = "../resources/unknownfile/";//未知类型
	        //创建一个多分解的容器
	        CommonsMultipartResolver cmr = new CommonsMultipartResolver(request.getSession().getServletContext());
	        //设置编码
	        cmr.setDefaultEncoding("utf-8");
	        //判断是否有文件上传
	        if(cmr.isMultipart(request)){
	            //将request转换成多分解请求
	            MultipartHttpServletRequest mhs = cmr.resolveMultipart(request);
	            //根据input中存在的name来获取是否存在上传文件
	            MultipartFile mf = mhs.getFile("file");//这里可以用getFiles("file")的方式来处理多个文件。返回的是一个list.然后一个一个处理就可以了
	            
	            if (mf != null) {  
                    // 取得当前上传文件的文件名称  
                    String myFileName = mf.getOriginalFilename();  
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                    if (myFileName.trim() != "") {  
                    	uploadFilename = myFileName.trim();
                    	
                    	String path ="";
                        // 定义上传路径  
                    	if(fileType.equals("file")){
                    		 path = filepath+myFileName;
                    		 uploadFilepath = filepath;
                    	}else if(fileType.equals("images")){
                    	     path = filepathimages+myFileName;
                    	     uploadFilepath = filepathimages;
                    	}else{
                    		 path = filepathUnknown+myFileName;
                    		 uploadFilepath = filepathUnknown;
                    	}
                        //创建文件保存名
                        File localFile = new File(path);
                        try {
                        	//上传文件
                        	mf.transferTo(localFile); 
                        	uploadCode = 0;
                        	uploadMsg ="上传成功";
						} catch (Exception e) {
							uploadMsg ="文件上传异常"+e.toString();
							logger.info("文件上传异常错误:"+e.toString());
							e.getStackTrace();
							// TODO: handle exception
						}            
                    }  
                }else{
                	uploadMsg ="上传文件名称为空";          	
                }                  
	        }else{
            	uploadMsg ="未找到上传文件";
            	
            }
	        flieReturn.setUploadCode(uploadCode);
            flieReturn.setUploadMsg(uploadMsg);
            flieReturn.setUploadFilepath(uploadFilepath);
            flieReturn.setUploadFilename(uploadFilename);
	        return flieReturn;
	    }	
	
	/**
	 * 文件上传实现类
	 * @param request
	 * @param fileType
	 * @return 
	 */
	@RequestMapping(value="upLoad/213file.do")
	public FileUploadReturn upLoadFile213(HttpServletRequest request,@RequestParam("file") MultipartFile mf){
		
		FileUploadReturn flieReturn = new FileUploadReturn();	
			Integer  uploadCode = 1;
			String uploadMsg ="";
			String uploadFilepath = "";
			String uploadFilename = "";
			
			String fileType ="file";
		
			String filepathimages = "../resources/uploadimages/";//图片
	        String filepath = "../resources/uploadfile/";//文件
	        String filepathUnknown = "../resources/unknownfile/";//未知类型
    
	        request.getParameter("fileType");
	        
	            if (mf != null) {  
                    // 取得当前上传文件的文件名称  
                    String myFileName = mf.getOriginalFilename();  
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                    if (myFileName.trim() != "") {  
                    	uploadFilename = myFileName.trim();
                    	
                    	String path ="";
                        // 定义上传路径  
                    	if(fileType.equals("file")){
                    		 path = filepath+myFileName;
                    		 uploadFilepath = filepath;
                    	}else if(fileType.equals("images")){
                    	     path = filepathimages+myFileName;
                    	     uploadFilepath = filepathimages;
                    	}else{
                    		 path = filepathUnknown+myFileName;
                    		 uploadFilepath = filepathUnknown;
                    	}
                        //创建文件保存名
                        File localFile = new File(path);
                        try {
                        	//上传文件
                        	mf.transferTo(localFile); 
                        	uploadCode = 0;
                        	uploadMsg ="上传成功";
						} catch (Exception e) {
							uploadMsg ="文件上传异常"+e.toString();
							logger.info("文件上传异常错误:"+e.toString());
							e.getStackTrace();
							// TODO: handle exception
						}            
                    }  
                }else{
                	uploadMsg ="无文件上传";          	
                }                  
	        flieReturn.setUploadCode(uploadCode);
            flieReturn.setUploadMsg(uploadMsg);
            flieReturn.setUploadFilepath(uploadFilepath);
            flieReturn.setUploadFilename(uploadFilename);
	        return flieReturn;
	    }	
	@RequestMapping(value="213/upload.do",method=RequestMethod.POST)
	public String uploadfileUpload(@RequestParam("file") MultipartFile file,Model model,HttpServletRequest request){
		 // 判断文件是否为空  
        if (!file.isEmpty()) {  
            try {  
                // 文件保存路径  
                //String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/" + file.getOriginalFilename();
            	String string =  file.getOriginalFilename();
            	String string213 = request.getSession().getServletContext().getRealPath("/");
            	logger.info("21"+System.getProperty("user.dir")) ;
            	String filePath = "D:/fhwork/personpublicserver/WebContent/resources/unknowfile/" + string ;
                // 转存文件  
                file.transferTo(new File(filePath));
                logger.debug(filePath+"文件保存成功！");
            } catch (Exception e) {  
                e.printStackTrace();
                logger.error("文件保存失败！");
            }  
        }  
        // 重定向  
        //return "redirect:/list.html";
        return "index2";
	}
}
