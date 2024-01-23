package my_restaurant_list;

//사용자로부터 전달받은 데이터를 저장할 클래스 - Data Transfer Object
public class RequestDTO {

//카테고리 상호명 별점 
private String category;
private String name;
private String starpoint;


// 생성자함수
public RequestDTO(String category, String name, String starpoint) {
  this.category = category;
  this.name = name;
  this.starpoint = starpoint;
}

//게터세터
public String getCategory() {
  return category;
}


public void setCategory(String category) {
  this.category = category;
}


public String getName() {
  return name;
}


public void setName(String name) {
  this.name = name;
}


public String getStarpoint() {
  return starpoint;
}


public void setStarpoint(String starpoint) {
  this.starpoint = starpoint;
}

}
