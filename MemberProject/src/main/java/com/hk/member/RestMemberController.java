package com.hk.member;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hk.member.service.MemberService;
import com.hk.member.vo.Member;


@RestController // 데이터만 보내는것으로 자동설정, 화면 안준다
@RequestMapping(value="/member/rest",produces="text/plain;charset=UTF-8") //plain은 텍스트로 주겠다는 의미
public class RestMemberController {
	  private static final Logger logger = LoggerFactory.getLogger(RestMemberController.class);

	   @Autowired
	   MemberService memberService;
	   
	   @GetMapping("/list")
	   public String memberRestList(Locale locale, Model model) {
	      logger.info("/member/rest/list ----------");
	      return "이건 서버에서 보내준 /member/rest/list";
	   }
	   
	   @GetMapping(path = "/listJson", produces = MediaType.APPLICATION_JSON_VALUE) //json은 xml을 축약한방식 
	   public List<Member> memberRestListJson(Locale locale, Model model) {
	      logger.info("/member/rest/listJson ----------");
	      return memberService.memberList();
	   }   
	   
	   @GetMapping(path="/addJson" , produces = MediaType.APPLICATION_JSON_VALUE)
	   public List<Member> memberRestAddJSon(@RequestParam("name") String name , @RequestParam("pwd") String pwd) { //string name = request.getparameter("name")와 같은 의미
	      logger.info("-----------------");
	      logger.info("Client에서 보내온 값은 === " + name + ":::" + pwd);
	      
	      return memberService.memberList();
	   }
	   
	   @GetMapping(path = "/listXml", produces = MediaType.APPLICATION_XML_VALUE) 
	   public List<Member> memberRestListXML(Locale locale, Model model) {
	      logger.info("/member/rest/listJson ----------");
	      return memberService.memberList();
	   }   
}
