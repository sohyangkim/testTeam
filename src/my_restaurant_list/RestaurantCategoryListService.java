package my_restaurant_list;

import java.text.SimpleDateFormat;

public class RestaurantCategoryListService {

  private RestaurantDAO dao;

  public RestaurantCategoryListService() {
    dao = new RestaurantDAO();
  }

  public void printRestaurant(String category) {

    RestaurantVO vo = dao.selectOne(category);

    if (vo == null) {
      System.out.println("카테고리를 입력하세요.");
      System.out.println("♧ 카테고리 리스트 ♧ categoryList 카테고리(한식,중식,일식,양식 택1)");
      return;
      
    }
    
    /*
     
    if(){
    
      for() {
        
      }
      
    }
    
    */
    
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String regDate = sdf.format(vo.getRegDate());

      System.out.printf(" 상호명:%s, 별점:%s, 등록일:%s\n", vo.getName(), vo.getStarpoint(),
        regDate);
    
  }
}
