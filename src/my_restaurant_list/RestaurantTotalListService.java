package my_restaurant_list;

import java.util.Collection;

public class RestaurantTotalListService {

  private RestaurantDAO dao = new RestaurantDAO();

  // 전체 맛집 목록 출력 함수
  public void printRestaurantList() {

    Collection<RestaurantVO> list = dao.selectList();

    
    list.stream()
        .forEach(vo -> System.out.println("카테고리:" + vo.getCategory() + ", 상호명:" + vo.getName() + ", 별점 : " + vo.getStarpoint()) );
  }

}

