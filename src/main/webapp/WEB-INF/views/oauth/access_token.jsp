<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 添加csrf标记，防止crsf安全过滤器无法识别ajax访问的crsf_token-->
<meta http-equiv="Content-Type" content="text/html; charset=utf8">  
<meta name="_csrf" content="${_csrf.token}"/>
	<!-- default header name is X-CSRF-TOKEN -->
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>Insert title here</title>
 

<script type="text/javascript">  
$(function () {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
	});

function getToken(){  
        $.ajax({  
        	 data:"client_id="+$("#client_id").val()+"&client_secret="+$("#client_secret").val()+"&redirect_url="+$("#redirect_url").val()+"&code="+$("#code").val()+"&grant_type="+$("#grant_type").val(),  
  	       //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
  	       type:"POST",  
  	       dataType:'json',  
  	        url:"https://login.cc98.org/OAuth/Token", 
  	        async:true,
  	        error:function(data){  
  	            alert("出错了！！:"+data[0].name);  
  	        },  
  	        success:function(data){  
  	        
  	           var htmlstr=data[0].access_token;
  	          
  	           $("#cloneTr0").html(htmlstr);
  	                        
  	                               
  	    }  
        })
   }
   </script>
   <script type="text/javascript">
   		
  // function ajaxTest(){  
	                                                               
	     
	  // alert("1");
	   
	//   alert("2");
	// 追加令牌
  //   var header = $("meta[name='Authorization']").attr("Bearer" + $("#api_token").val());
//	var headers={};
//	var headerstring="Bearer fMGPAju0pHxJaTjwupZ3NqHPoh5yQxeFpPu8GiUH0aVOSZkWjA5sqtHZME0hV6LuMML_sLTqIAM3KMNXm4Td8IZWv1OSWkqC0vfUwT30dvBEe8VxJj2QbBAx8Ly7pvIW-QLbnjW44BA5pp2FoVL5Y0PMXBcRYZnAfzYcfua5Ole0X4cC3frDa5SI4aGnoTmJhMhWB2tZrCwBATzgW0bac8YUPBkoEcvjdyeeEO1yB9XE7rx4dSpd3niApZLPklp8dWaSUpKJvET1Dq9hMUaypJ9lQ9sfGFkNO_OHvU7TO2Pny-7CYFupwF97r5z50NAIoRYVhTejGYS2Bw5k6vcXIeuQxMqeDZagy2f7hbg5FLdWuRUQl-BE36yjBXkuU24TEQH4Xq3-Kg5h0fEhHTqp_UcloJA7pJfjWGU-R03vATWmxm3H2p0z1iLtLGXLDLjk8TtgQDr8T1-7XlAmgnHu2tqB4x3cn-eL-WqLjG3VV9bP4QVvWvApMIKNfbCOUcUK09L_qWzlX-fLOagvgxiAzF8YrPJQZvVNez3aT7gBy-2CQP62DnCiSIBCC0HzIeLDRh6meStAcBPR5F6tsh7bDBG20uHYftdSejOLEJ-P7CMdLHk3kCGcC9rRy530zC9l3tW5LbRwcx5xkLRUOGTksltAbfTHFji8kRHU8Y4R64w";
	//headerstring=headstring+"31313";
//	 alert("2-2");
//	headers['Authorization'] =headerstring; 
//    alert("3");
	// 追加标头。

//$(document).ajaxSend(function(e, xhr, options) {
//		xhr.setRequestHeader(headers);
//	    });
//	  alert("4");
/* $.ajax({  
    	 //data:"name="+$("#name").val(),  
	       //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
	        type:"POST",  
	        dataType:'json',  
	        //url:"https://api.cc98.org/me", 
	        url:"autoajax",
	        async:true,
	       // beforeSend: function (xhr) { xhr.setRequestHeader ("Authorization", "Bearer fMGPAju0pHxJaTjwupZ3NqHPoh5yQxeFpPu8GiUH0aVOSZkWjA5sqtHZME0hV6LuMML_sLTqIAM3KMNXm4Td8IZWv1OSWkqC0vfUwT30dvBEe8VxJj2QbBAx8Ly7pvIW-QLbnjW44BA5pp2FoVL5Y0PMXBcRYZnAfzYcfua5Ole0X4cC3frDa5SI4aGnoTmJhMhWB2tZrCwBATzgW0bac8YUPBkoEcvjdyeeEO1yB9XE7rx4dSpd3niApZLPklp8dWaSUpKJvET1Dq9hMUaypJ9lQ9sfGFkNO_OHvU7TO2Pny-7CYFupwF97r5z50NAIoRYVhTejGYS2Bw5k6vcXIeuQxMqeDZagy2f7hbg5FLdWuRUQl-BE36yjBXkuU24TEQH4Xq3-Kg5h0fEhHTqp_UcloJA7pJfjWGU-R03vATWmxm3H2p0z1iLtLGXLDLjk8TtgQDr8T1-7XlAmgnHu2tqB4x3cn-eL-WqLjG3VV9bP4QVvWvApMIKNfbCOUcUK09L_qWzlX-fLOagvgxiAzF8YrPJQZvVNez3aT7gBy-2CQP62DnCiSIBCC0HzIeLDRh6meStAcBPR5F6tsh7bDBG20uHYftdSejOLEJ-P7CMdLHk3kCGcC9rRy530zC9l3tW5LbRwcx5xkLRUOGTksltAbfTHFji8kRHU8Y4R64w") }, 
	        error:function(data){  
	            alert("出错了！！:");  
	        },  
	        success:function(data){  
	        	alert("这是提示！！:");  
	       //    var htmlstr=""+data[0]; 
	       //    $("#cloneTr0").html(htmlstr);
	                        
	                               
	    }  
	      
    })
    alert("6");
   }
	*/		
	 function ajaxTest(){  
        $.ajax({  
        	 data:"name="+$("#name").val(),  
  	       //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
  	       type:"POST",  
  	       dataType:'json',  
  	        url:"autoajax", 
  	        async:true,
  	        error:function(data){  
  	            alert("出错了！！:"+data[0].name);  
  	        },  
  	        success:function(data){  
  	        	alert("这是提示！！:"+data[0].name);  
  	           var htmlstr="<table>手动异步刷新"+
  	           "<tr><th>number</th><th>name</th><th>adress</th><th>telephone</th><th>email</th><th>id</th></tr>";
  	           $.each(data,function(idx,obj){
  	        	 htmlstr=htmlstr+"<tr><td>";
  	        	 htmlstr=htmlstr+idx;
  	        	 htmlstr=htmlstr+"</td>"+"<td>"+obj.name+"</td><td>"+obj.address+"</td><td>"+obj.telephone+"</td><td>"
  	        	 +obj.email+"</td><td>"+obj.id+"</td>"+"</tr>";
  	           })
  	          // var htmlstr="</table>"
  	          // htmlstr=htmlstr+data.msg;
  	           htmlstr=htmlstr+"</table>";
  	           $("#cloneTr0").html(htmlstr);
  	                        
  	                               
  	    }  
        })
   }
   
   </script>
</head>
<body>

<form id="register" method="post"  action="https://login.cc98.org/OAuth/Token"  >
        <table id="customers">
        <tr><td class="blank"></td><td class="blank"></td></tr>
        <tr><td colspan="2">https://login.cc98.org/OAuth/Authorize?response_type=code&client_id=f14e8c26-d865-4584-bc54-48fd797b84fc&scope=getuserinfo setuserinfo getpost setpost getmessage setmessage manage&redirect_uri=https://www.baidu.com</td></tr>
        
        <tr>
         
          <td style="padding-left:30px" >client_id</td>
		 <td>		
		  		<input name="client_id" id="client_id" size="30" value="f14e8c26-d865-4584-bc54-48fd797b84fc"/><span style="color:red;">*</span>
		  		
          </td>
         </tr>
         <tr>
           <td style="padding-left:30px">client_secret</td>
		 <td>		
		  		<input   name="client_secret" id="client_secret" size="31" value="bc8bd180-f87a-4c9d-9adf-16bb0f7c5958"/><span style="color:red;">*</span>
		  		
          </td>
         </tr>
         <tr>
           <td style="padding-left:30px">code</td>
		 <td>		
		  		<input   name="code" id="code" size="31"  /><span style="color:red;">*</span>
		  		
          </td>
         </tr>        
         <tr>
           <td style="padding-left:30px">redirect_uri</td>
		 <td>		
		  		<input name="redirect_uri" id="redirect_url" size="30" value="https://www.baidu.com" /><span style="color:red;">*</span>
		  		
          </td>
          </tr>
          <tr>
           <td style="padding-left:30px">grant_type</td>
		 <td>		
		  		<input name="grant_type" id="grant_type" size="30" value="authorization_code" /><span style="color:red;">*</span>
		  		
          </td>
          </tr>
          <tr>
           <td style="padding-left:30px">access_token</td>	
            <td><div id="cloneTr0"></div></td>	
          </tr>        
          <tr>
           <td></td><td><input type="submit" class="button blue" value="获取"></td>
          </tr>
           <tr><td class="blank"></td><td class="blank"></td></tr>
        </table>
        </form>
        <form method="GET" action="https://api.cc98.org/me">
        <div>access_token</div><input type="text" name="api_token" id="api_token"/><input type="submit" value="提交" />
        </form>
        
</body>
</html>