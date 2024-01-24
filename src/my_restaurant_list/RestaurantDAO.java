package my_restaurant_list;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//데이터베이스와 상호작용하여 레스토랑 정보를 저장, 조회 및 수정하는 역할
public class RestaurantDAO {

  //데이터베이스 저장소 역할을 대행하는 Map 객체
  //카테고리를 기반으로 저장	, 데이터베이스의 역할을 대행
  private static Map<String, RestaurantVO> memMap = new HashMap<String, RestaurantVO>();

  
  // RestaurantVO 타입의 데이터를 받아 DB에 저장하는 함수
  public void insert(RestaurantVO vo) {
    memMap.put(vo.getName(), vo);
  }

  
  // 전달받은 상호명으로 등록 여부 확인함수
  public RestaurantVO selectOne(String name) {
    return memMap.get(name);// RestaurantVO 객체 리턴
  }

  // 전체 맛집 리스트 목록
  public Collection<RestaurantVO> selectList() {
    return memMap.values();
  }// end of selectList

  //카테고리수정
  public void update(RestaurantVO vo) {
   memMap.put(vo.getName(), vo);
   
    
  }

}