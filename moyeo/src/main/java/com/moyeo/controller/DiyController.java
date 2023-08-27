package com.moyeo.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moyeo.dto.Diy;
import com.moyeo.dto.Userinfo;
import com.moyeo.exception.DiyNotFoundException;
import com.moyeo.service.DiyService;
import com.moyeo.service.UserinfoService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/diy")
@RequiredArgsConstructor
public class DiyController {
	// @Autowired
	// private final WebApplicationContext context;
	
	@Autowired
	private final DiyService diyService;
	
	@Autowired
	private final UserinfoService userinfoService;
	
	// diy 페이지 요청
	@GetMapping("/diy")
	public String diyList() {
		return "diy/diy";
	}
	
	// 목록으로 이동
	@PostMapping("/diy")
	public String diyList(Model model) {
		// return "diy/diy_form";
		model.addAttribute("diy_List", diyService.selectDiyList());
		
		return "diy/diy_list";
	}
	
	//================================================================
	@GetMapping("/diy_add")
	public String diyAdd() {
		return "diy/diy_add";
	}
		
	// 글작성 + diy를 등록하면 diy 디테일 요청
	// @Autowired(required = false)
	@Test
	/*
	@PostMapping("/diy_add")
	public String diyAdd (@RequestParam List<MultipartFile> uploadImgList, Diy diy, Model model, String userinfoId) throws Exception {
		
		List<String> imgIdxList = new ArrayList<String>();
		// model.addAttribute(null, model);
		
		for(MultipartFile multipartFile : uploadImgList) {
			if(!multipartFile.getContentType().equals("image/jpeg")) {
				// return "사진 파일을 jpeg로 변경해주세요 ";  
			}
		
		String uploadPath = context.getServletContext().getRealPath("/WEB-INF/img");
		String imgIdx = UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
		File file = new File(uploadPath, imgIdx);
		
		multipartFile.transferTo(file);
		
		imgIdxList.add(imgIdx);
		
		}
		
		diyService.insertDiy(diy);
		//model.addAttribute("imgIdxList",imgIdxList);
		model.addAttribute("diy_detail", diyService.selectDiy(userinfoId));
	
		return "/diy_detail";
		}
	 */
	
	@PostMapping("/diy_add")
	public String diyAdd (Diy diy, Model model, Userinfo id) throws Exception {
		
		//model.addAttribute("imgIdxList",imgIdxList);
		// String userinfoId = diyService.getUserinfoId(Userinfo id);
		Diy userinfoId = diyService.getUserinfoId(id);
		model.addAttribute("userinfoId", userinfoId);
		
		diyService.insertDiy(diy);
	
		return "/diy_detail";
		}
	//==================================================================
	/*
	@GetMapping("/diy_detail")
	public String diyDetail() {
		return "diy/diy_detail";
	}
	*/
	//수정 후 다시 detail 페이지 보여주기
	@RequestMapping("/diy_detail")
	public String diyDetail(Diy diy, Model model) {
		diyService.insertDiy(diy);
		model.addAttribute("diy_detail", diy);
		return "diy/diy_detail";
	}
	
	//==========================================
	@RequestMapping("/diy_modify")
	public String diyUpdate(Diy diy, Model model, String userinfoId) {
		diyService.updateDiy(diy);
		model.addAttribute("diy_detail", diy);
		return "diy/diy_detail";
	}
	//================================================
	@GetMapping("/diy_list")
	public String selectDiyList(Model model) {
		
		return "diy/diy_list";
	}
	//=======================================================================
	@PostMapping("/diy_delete")
	public String diyDelete(String userinfoId, Model model) throws DiyNotFoundException {
		diyService.deleteDiy(userinfoId);
		List<Diy> selectDiyList = diyService.selectDiyList();
		model.addAttribute("diy_List", selectDiyList);
		return "diy/diy_list";
	}
	
	//============================================

	
	/*
	// 파일 업로드 구현
	@PostMapping("/uploadFile")
	public String uploadFile(@RequestParam String uploaderName, 
			@RequestParam List<MultipartFile> uploadList, Model model) throws IOException{
		
	}
		// 사진..?
	*/
}









































