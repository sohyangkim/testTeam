package my_restaurant_list;

import java.util.Date;

public class RestaurantRegisterSerivce {

  private RestaurantDAO dao;

  public RestaurantRegisterSerivce() {
    this.dao = new RestaurantDAO();
  }

  public void regist(RequestDTO dto) {

    RestaurantVO vo = new RestaurantVO(dto.getName(), dto.getCategory(), dto.getStarpoint(), new Date());

    // 기존에 등록된 가게인지 확인
    if (dao.selectOne(dto.getName()) != null) {
      System.out.println("♥이미 등록된 상호명과 중복됩니다♥");
      return;
    }

    dao.insert(vo);// RestaurantDAO 메소드를 통해 DB에 등록
    System.out.println("♥등록했습니다♥");

  }// end of regist

}