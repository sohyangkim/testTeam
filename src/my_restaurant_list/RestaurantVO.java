package my_restaurant_list;

import java.util.Date;

//MemberRegisterSerivce를 정리
public class RestaurantVO {

  private String category;
  private String name;
  private String starpoint;
  private Date regDate;

  public RestaurantVO() {
  }

  public RestaurantVO(String category, String name, String starpoint, Date regDate) {
    this.category = category;
    this.name = name;
    this.starpoint = starpoint;
    this.regDate = regDate;
  }

  @Override
  public String toString() {
    return "restaurantVO [category=" + category + ", name=" + name + ", starpoint=" + starpoint + ", regDate=" + regDate
        + "]";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
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


