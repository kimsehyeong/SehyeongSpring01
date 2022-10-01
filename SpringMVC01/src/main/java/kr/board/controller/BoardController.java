package kr.board.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller
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
		model.addAttribute("vo", vo); //객체바인딩 실시
		System.out.println("상세보기::::::"+vo);
		
		return "boardContent";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
