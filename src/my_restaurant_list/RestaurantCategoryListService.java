package my_restaurant_list;

import java.text.SimpleDateFormat;

public class RestaurantCategoryListService {

  private RestaurantDAO dao;

  public RestaurantCategoryListService() {
    dao = new RestaurantDAO();
  }

  public void printMember(String name) {

    RestaurantVO vo = dao.selectOne(name);

    if (vo == null) {
      System.out.println("입력한 상호명과 일치하는 정보가 없습니다.");
      return;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String regDate = sdf.format(vo.getRegDate());

    System.out.printf("상호명:%s, 별점:%s, 등록일:%s\n", vo.getName(), vo.getStarpoint(), regDate);
  }

}