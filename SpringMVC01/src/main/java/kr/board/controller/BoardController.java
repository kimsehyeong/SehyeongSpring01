package kr.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
//		
//		model.addAttribute("list", list);
		
		List<Board> list = boardMapper.getLists();
		model.addAttribute("list", list);
		
		return "boardList";
	}
}
