package my_restaurant_list;

import java.util.Date;

  //레스토랑 정보를 담는 데이터 객체
  public class RestaurantVO {
	  
  private String name;	  
  private String category;
  private String starpoint;
  private Date regDate;

  //생성자
  public RestaurantVO() {}

  public RestaurantVO(String name, String category, String starpoint, Date regDate) {
	
	this.name = name;
	this.category = category;
	this.starpoint = starpoint;
    this.regDate = regDate;
  }

  @Override
  public String toString() {
	return "restaurantVO [name=" + name + "category = "+ category +", starpoint=" + starpoint + ", regDate=" + regDate
        + "]";
  }



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

  public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }
  
  
}


