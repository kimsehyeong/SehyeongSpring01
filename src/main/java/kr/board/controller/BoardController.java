package kr.board.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {

	@Autowired
	BoardMapper boardMapper;
	
	@GetMapping("boardList.do")
	public String boardList(Model model) {
		
//		Board vo = new Board();
//		vo.setIdx(1);
//		vo.setTitle("TEST");
//		vo.setContent("this is a test server");
//		vo.setWriter("Jada");
//		vo.setIndate("20220113");
//		vo.setCount(0);
//		
//		List<Board> list = new ArrayList<Board>();
//		list.add(vo);
//		list.add(vo);
//		list.add(vo);
//		ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹaddAttribute("list", list);
		
		List<Board> list = boardMapper.getLists();
		model.addAttribute("list", list);
		log.debug("hello");
		
		return "boardList";
	}
	
	@GetMapping("boardForm.do")
	public String boardForm() {
		return "boardForm";
	}
	
	@PostMapping("boardInsert.do")
	public String boardInsert(Board vo) { //BoardVO로 파라미터 값을 받아준다
		
		boardMapper.boardInsert(vo);
		System.out.println("###글입력완료");
		return "redirect:/boardList.do";
	}
	
	@GetMapping("boardContent.do")
	public String boardContent(@RequestParam("num") int idx, Model model) {
		
		Board vo = boardMapper.boardContent(idx);
		
		//조회수 증가
		boardMapper.boardCount(idx);
		
		model.addAttribute("vo", vo); //객체바인딩 실시
		System.out.println("상세보기---->"+vo);
		
		
		
		
		return "boardContent";
	}
	/**
	 * 
	 * @PathVariable 과 @RequestParam 차이
	 * @pathVariable은 URI 창에 변수 명없이 바로 들어올수있다 
	 * ex: www.baordList.do/${idx}
	 * 대신 mapping 받을때 받는 값을 줘야한다
	 * ex) @getMapping("boardList.do/{num}")
	 * 
	 * 
	 * @RequestParam은 변수명까지 기입해줘야한다 -> 그후 컨트롤러에서 변수명을 받아준다
	 * ex: www.boardList.do?num=${idx}
	 */
	@GetMapping("boardDelete.do/{num}")
	public String boardDelete(@PathVariable("num") int idx) {
		
		boardMapper.boardDelete(idx);
		log.info("이 번호 삭제 ---->"+idx);
		return "redirect:/boardList.do";
		
	}
	
	@GetMapping("boardUpdateForm.do/{num}")
	public String boardUpdateForm(@PathVariable("num") int idx, Model model) {
		Board vo = boardMapper.boardContent(idx);
		model.addAttribute("vo", vo);
		
		return "boardUpdate";
	}
	
	@PostMapping("boardUpdate.do")
	public String boardUpdate(Board vo) {
		
		boardMapper.boardUpdate(vo);
		log.info("수정성공 -->" + vo);
		
		return "redirect:/boardList.do";
	}
	
	
	
	
	
	
	
	
}
