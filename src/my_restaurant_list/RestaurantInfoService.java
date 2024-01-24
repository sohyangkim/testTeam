package my_restaurant_list;

import java.text.SimpleDateFormat;

public class RestaurantInfoService {

  private RestaurantDAO dao;

  public RestaurantInfoService() {
    dao = new RestaurantDAO();
  }

  public void printRestaurant(String neme) {

    RestaurantVO vo = dao.selectOne(neme);

    if (vo == null) {
        System.out.println("일치하는 정보가 없습니다.");
        return;
      }

    
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String regDate = sdf.format(vo.getRegDate());

      System.out.printf( " 카테고리:%s, 별점:%s, 등록일:%s\n", vo.getCategory(), vo.getStarpoint(), regDate);
    
  }
}
