package my_restaurant_list;

public class RestaurantChangeService {

  private RestaurantDAO dao;

  public RestaurantChangeService() {
    this.dao = new RestaurantDAO();
  }

  // 별점 변경 요청함수
  public void changestarpoint(String[] userInputs) {
    String name = userInputs[1];
    String oldstarpoint = userInputs[2];
    String newstarpoint = userInputs[3];

    // 이메일에 해당하는 회원유무
    RestaurantVO vo = dao.selectOne(name);
    if (vo == null) {
      System.out.println("입력한 상호명과 일치하는 정보가 없습니다.");
      return;
    }

    // 가져온 vo객체의 pwd 값을 변경
    if (vo.getStarpoint().equals(oldstarpoint)) {
      vo.setStarpoint(newstarpoint);
      System.out.println("별점이 " + oldstarpoint + " 에서 " + newstarpoint + "으로 변경되었습니다.");
    } else {
      System.out.println("입력한 별점이 이전과 동일합니다.");
      return;
    }

    // 회원정보 수정요청
    dao.update(vo);

  }
}