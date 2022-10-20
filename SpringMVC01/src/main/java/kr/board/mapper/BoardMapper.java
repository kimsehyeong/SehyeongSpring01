package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.board.entity.Board;

@Mapper
public interface BoardMapper {

	public List<Board> getLists(); //전체 리스트
	
	public void boardInsert(Board vo); //리턴값은 따로 없다 
	
	public Board boardContent(int idx); //상세보기
}
