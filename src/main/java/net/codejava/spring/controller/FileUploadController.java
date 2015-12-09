package net.codejava.spring.controller;


import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.service.FileUploadService;



@Controller
public class FileUploadController {

	
	@RequestMapping(value="/file")	
		public ModelAndView selectfile(ModelAndView model) throws IOException{			
			model.setViewName("upload");
			return model;
		}
	
	
	
	@RequestMapping(value="/fileupload")
		public ModelAndView upload(HttpServletRequest request) throws Exception {

			Map<String, Object> map = new HashMap<String, Object>();

			 //别名
			String[] alaises = ServletRequestUtils.getStringParameters(request,
					"alais");
            System.out.print(alaises);
			String[] params = new String[] { "alais" };
			Map<String, Object[]> values = new HashMap<String, Object[]>();
			values.put("alais", alaises);

			List<Map<String, Object>> result = FileUploadService.upload(request,params, values);

			map.put("result", result);

			return new ModelAndView("sucess", map);
		}

		/**
		 * 下载
		 * 
		 * @param attachment
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value = "download")
		public ModelAndView download(HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			String storeName = "201205051340364510870879724.zip";
			String realName = "Java设计模式.zip";
			String contentType = "application/octet-stream";

			FileUploadService.download(request, response, storeName, contentType,
					realName);

			return null;
		}
	}

			      


	
	

