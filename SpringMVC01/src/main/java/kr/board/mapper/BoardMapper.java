package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import kr.board.entity.Board;

@Mapper
public interface BoardMapper {

	/**
	 * return 값들은 model을 이용해서 뿌려줄때 쓴다 (객체바인딩)
	 */
	
	
	
	public List<Board> getLists(); //전체 리스트
	
	public void boardInsert(Board vo); //리턴값은 따로 없다 
	
	public Board boardContent(int idx); //상세보기
	
	public void boardDelete(int idx);
	
	public void boardUpdate(Board vo);
	
	
	@Update("update myboard set count= count + 1 where idx=#{idx}")
	public void boardCount(int idx); // 조회수 증가
}
