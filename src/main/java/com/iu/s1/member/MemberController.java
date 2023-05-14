package com.iu.s1.member;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.mail.MailSendController;
import com.iu.s1.mail.MailSendService;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	
	
	@Autowired
	private MailSendController mailSendController;

	@Autowired
	private MailSendService mailService;
	
	
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberIdFind")
	public ModelAndView getMemberIdFind()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberIdFind");
		return mv;
	}
	
	@PostMapping("memberIdFind")
	public ModelAndView getMemberIdFind(String email)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		
		List<String> names=memberService.getMemberIdFind(email);
		
		mv.addObject("name", names);
		mv.setViewName("common/memberId");
		return mv;
	}
	
	@GetMapping("memberPwFind")
	public ModelAndView getMemberPwFind()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberPwFind");
		return mv;
	}
	
	@PostMapping("memberPwFind")
	public ModelAndView getMemberPwFind(MemberDTO memberDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		System.out.println("Con em :"+memberDTO.getEmail());
		String pw=memberService.setMemberPwChange(memberDTO);
		
		
		
		mv.addObject("name", pw);
		mv.setViewName("common/memberId");
		return mv;
	}
	
	
	@PostMapping("memberCheck")
	public ModelAndView getMemberCheck(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		boolean check = memberService.getMemberCheck(memberDTO);
		
		mv.addObject("result", check);
		mv.setViewName("common/memberCheck");
		return mv;
	}
	
	@GetMapping("memberJoin")
	public ModelAndView setMemberAdd() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/memberJoin");
		return mv;
	}
	
	@PostMapping("memberJoin")
	public ModelAndView setMemberAdd(MemberDTO memberDTO,String emaildomain,String address1) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO.setAddress(memberDTO.getAddress()+address1);
		memberDTO.setEmail(memberDTO.getEmail()+emaildomain);
		int result = memberService.setMemberJoin(memberDTO);
		
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@GetMapping("memberDetail")
	public ModelAndView getMemberDetail(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO=new MemberDTO();
		memberDTO=(MemberDTO)session.getAttribute("member");
		
		memberDTO=memberService.getMemberDetail(memberDTO);
		
		mv.addObject("dto", memberDTO);
		mv.setViewName("member/memberDetail");
		return mv;
	}
	@GetMapping("memberLogin")
	public ModelAndView getMemberLogin() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberLogin");
		return mv;
	}
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberDTO memberDTO,HttpSession session,String remember,HttpServletResponse response,HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		String message="로그인 실패";
		
		// kakaoid를 to의 id로 세팅
		if(request.getParameter("kakaoemail") !="") {
			// ==================== 카카오 로그인 ========================
			System.out.println("카카오로그인");
			System.out.println(request.getParameter("kakaoemail"));
			/* System.out.println(request.getParameter("kakaoname")); */
			//System.out.println(request.getParameter("kakaobirth"));

			// kakaoemail을 kakaoid에 저장
			String kakaoid = request.getParameter("kakaoemail");

		memberDTO.setId(kakaoid);
		// 카카오계정으로 로그인한 적이 있는지 없는지 
		boolean result_lookup = memberService.getMemberCheck(memberDTO);
		System.out.println("boolean :"+result_lookup);
		
		if (result_lookup) { // 회원이 아닌경우 (카카오 계정으로 처음 방문한 경우) 카카오 회원정보 설정 창으로 이동
//		    System.out.println("카카오 회원 정보 설정");
//
//		    request.setAttribute("kakaoid",request.getParameter("kakaoemail"));
//		    request.setAttribute("kakaoname",request.getParameter("kakaoname"));
//			/* request.setAttribute("kakaobirth",request.getParameter("kakaobirth")); */
//		    request.setAttribute("kakaoemail",request.getParameter("kakaoemail"));
//
//		    // 회원가입창으로 이동
//		    mv.setViewName("member/memberAgree");
//		    return mv;
			
			int a = memberService.setKakaoLogin(memberDTO);
			memberDTO=memberService.getMemberDetail(memberDTO);
			
			session.setAttribute("member", memberDTO);
			
			if(memberDTO !=null) {
				message="로그인 성공";
				mv.addObject("url", "/");
			}else {
				System.out.println("실패해서 일로옴");
				mv.addObject("url", "./memberLogin");
			}

		} else { /*
//					 * // 이미 카카오로 로그인한 적이 있을 때 (최초 1회 로그인때 회원가입된 상태) // id, nick, profile을 가져와서
//					 * userTo = userDao.loginOkNick(userTo); // id를 세션에 저장
//					 * session.setAttribute("kakaoid", userTo.getId()); // nick을 세션에 저장
//					 * session.setAttribute("nick", userTo.getNick()); // 프로필 사진 (profile)을 세션에 저장
//					 * session.setAttribute("profile", userTo.getProfile());
//					 * 
//					 * request.setAttribute("flag", 0);
//					 * 
//					 * System.out.println("kakaoid : " + userTo.getId());
//					 * System.out.println("nick : " + userTo.getNick());
//					 * System.out.println("profile : " + userTo.getProfile());
//					 */
			System.out.println("카카오 회원 정보 설정 실패");
			memberDTO=memberService.getMemberDetail(memberDTO);
			
			session.setAttribute("member", memberDTO);
			
			if(memberDTO !=null) {
				message="로그인 성공";
				mv.addObject("url", "/");
			}else {
				System.out.println("실패해서 일로옴");
				mv.addObject("url", "./memberLogin");
			}
		}
		}
		
		else {
		System.out.println("카카오 회원 정보 설정 실패");
		memberDTO=memberService.getMemberLogin(memberDTO);
		if(remember != null && memberDTO !=null&& remember.equals("remember")) {
		Cookie cookie = new Cookie("remember",memberDTO.getId() );
		cookie.setMaxAge(60*60*24*7);
		response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("remember","");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		session.setAttribute("member", memberDTO);
		
		if(memberDTO !=null) {
			message="로그인 성공";
			mv.addObject("url", "/");
		}else {
			System.out.println("실패해서 일로옴");
			mv.addObject("url", "./memberLogin");
		}
		}
		mv.addObject("message", message);
		
		mv.setViewName("common/result");
		return mv;
	}
	@GetMapping("memberUpdate")
	public ModelAndView setMemberUpdate(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO=new MemberDTO();
		memberDTO=(MemberDTO)session.getAttribute("member");
		memberDTO=memberService.getMemberDetail(memberDTO);
		
		mv.addObject("dto", memberDTO);
		mv.setViewName("member/memberUpdate");
		return mv;
	}
	@PostMapping("memberUpdate")
	public ModelAndView setMemberUpdate(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result=memberService.setMemberUpdate(memberDTO);
	
		mv.setViewName("redirect:./memberDetail");
		return mv;
	}
	@GetMapping("memberLogout")
	public ModelAndView setMemberLogout(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		session.invalidate();
		mv.setViewName("redirect:../");
		return mv;
	}
	@GetMapping("memberAgree")
	public ModelAndView setMemberAgree() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("./member/memberAgree");
		return mv;
	}
	@GetMapping("memberPwCheck")
	public ModelAndView getMemberPwCheck()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberPwCheck");
		return mv;
	}
	
	@PostMapping("memberPwCheck")
	public ModelAndView getMemberPwCheck(MemberDTO memberDTO,HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		
		MemberDTO pwCheck =(MemberDTO)session.getAttribute("member");
				
		pwCheck=memberService.getMemberDetail(pwCheck);
		boolean check = false;
		mv.addObject("message", "확인");
		
		if(pwCheck.getPw().equals(memberDTO.getPw())) {
			check = true;
			mv.addObject("url", "./memberUpdate");
		}else {
			mv.addObject("url", "./memberPwcheck");
		}
		mv.setViewName("common/result");
		return mv;
	}
	@GetMapping("memberAuto")
	public ModelAndView setMemberAuto(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO auto =(MemberDTO)session.getAttribute("member");
		auto.setAutoStatus(1L);
		int a = memberService.setMemberAuto(auto);
		
		mv.setViewName("redirect:./memberDetail");
		return mv;
	}
	@GetMapping("memberStatus")
	public ModelAndView getMemberStatus() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<MemberDTO> ar = memberService.getMemberAuto();
		mv.addObject("list", ar);
		mv.setViewName("member/memberList");
		return mv;
	}
	
	@PostMapping("memberRole")
	public ModelAndView setMemberRole(String [] ids) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int a = memberService.setMemberRole(ids);
		mv.addObject("dto", a);
		mv.setViewName("common/sessionList");
		return mv;
	}
	@GetMapping("context")
	public ModelAndView getMember()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("context");
		return mv;
	}
}
