<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv ="Content-Type" content="text/html; charset=UTF-8">
<title>본격! 게시판 - 게시글 입력폼</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/board/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>

<!-- 입력값 체크 기본형 onsubmit="return formCheck();"-->
	<script type="text/javascript">
	function formCheck() {
		var title = document.forms[0].title.value;
		var writer = document.forms[0].writer.value;
		var regExp_writer = /^[_0-9a-zA-Z-]+@[0-9a-zA-Z-]+(.[_0-9a-zA-Z-]+)*$/
		var regdate = document.forms[0].regdate.value;
		var regExp_date =  /^[0-9]*$/;
		var content = document.forms[0].content.value;
	
		
		if(title == null || title == ""){
			alert('제목을 입력하세요');
			document.forms[0].title.focus();
			return false;		
		}		
		if(!regExp_writer.test(writer)){
			alert('작성자를 이메일 형식으로입력하세요');
			document.forms[0].writer.focus();
			return false;		
		}		
		if(!regExp_date.test(regdate)){
			alert('날짜는 숫자만 입력해 주십시오.');
			document.forms[0].regdate.focus();
			return false;		
		}			
		if(content == null || content == ""){
			alert('내용을 입력하세요');
			document.forms[0].content.focus();
			return false;		
		}			
	}
	$(function(){
		var oEditors = [];
	      nhn.husky.EZCreator.createInIFrame({
	          oAppRef: oEditors,
	          elPlaceHolder: "aa", //textarea에서 지정한 id와 일치해야 합니다. 
	          //SmartEditor2Skin.html 파일이 존재하는 경로
	          sSkinURI: "/board/smarteditor/SmartEditor2Skin.html",  
	          htParams : {
	              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
	              bUseToolbar : true,             
	              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
	              bUseVerticalResizer : true,     
	              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
	              bUseModeChanger : true,         
	              fOnBeforeUnload : function(){
	                   
	              }
	          }, 
	          fOnAppLoad : function(){
	              //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
	              oEditors.getById["aa"].exec("PASTE_HTML", ["기존 DB에 저장된 내용을 에디터에 적용할 문구"]);
	          },
	          fCreator: "createSEditor2"
	      });
	      
	      //저장버튼 클릭시 form 전송
	      $("#save").click(function(){
	          oEditors.getById["aa"].exec("UPDATE_CONTENTS_FIELD", []);
	          $("#frm").submit();
	      });    
	});
	
   </script> 
   </head>
<body>
	

	<form action="insert.do" method="post" >
		제목 : <input type="text" name="title" /><br/>
		작성자 : <input type="text" name="writer" /><br/>
		날짜 : <input type="text" name="regdate" /><br/>
		내용 <br/>
		<textarea cols="60" rows="10" name="content"></textarea>
		<br/>
		
		<input type="submit" />	
	</form>
	
	
	<textarea name="smarteditor" id="aa" rows="22" style="width:645px;"> 
	
	</textarea>

</body>
</html>