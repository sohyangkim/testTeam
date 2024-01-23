package my_restaurant_list;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RestaurantDAO {

  //데이터베이스 저장소 역할을 대행하는 Map 객체
  private static Map<String, RestaurantVO> memMap = new HashMap<String, RestaurantVO>();

  // MemberVO 타입의 데이터를 받아 DB에 저장하는 함수
  public void insert(RestaurantVO vo) {
    memMap.put(vo.getCategory(), vo);
  }

  // 전달받은 상호명으로 등록 여부 확인함수
  public RestaurantVO selectOne(String category) {
    return memMap.get(category);// MemberVO 객체 리턴
  }

  // 전체회원 목록
  public Collection<RestaurantVO> selectList() {
    return memMap.values();
  }// end of selectList

  //회원정보수정
  public void update(RestaurantVO vo) {
   memMap.put(vo.getCategory(), vo);
   
    
  }

}