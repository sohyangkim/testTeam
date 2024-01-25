package my_restaurant_list;

import java.util.Scanner;

public class MainController {

  public static void help() {
    System.out.println("-----------명령어 사용법-----------");
    System.out.println("♧ 맛집추가 하기 ♧ new 카테고리 상호명 별점(0~5점)");
    System.out.println("♧ 별점 변경하기 ♧ change 상호명 기존별점 변경별점");
    System.out.println("♧ 맛집 삭제하기 ♧ delete 상호명");
    System.out.println("♧ 맛집 이름조회 ♧ search 상호명");
    System.out.println("♧ 전체 목록조회 ♧ totalList");
    System.out.println("♧ 맛집프로그램 종료 ♧ exit");
    System.out.println("--------------------------------");
    System.out.println("♥ 띄어쓰기 유의해주세요 ♥");
  }

  public static void main(String[] args) {

    help();

    Scanner sc = new Scanner(System.in);

    while (true) {

      System.out.println("♥ 명령어를 입력하세요! ♥");
      String userInput = sc.nextLine();

      //사용자가 입력한 정보를 빈칸으로 구분하여 배열로 저장
      String[] userInputs = userInput.split(" ");

      if (userInput.startsWith("new")) {// "new" 로 시작한다면

        // 유효성검사 - 전달받은 정보의 개수를 확인
        if (userInputs.length != 4) {
          System.out.println("♥입력하신 맛집정보가 형식에 맞지 않습니다♥");
          System.out.println("♧ 맛집추가 ♧ new 카테고리(한식,중식,일식,양식,분식,카페) 상호명 별점(0~5점)");
          help();
          continue;
        }
        
        // 전달받은 데이터를 RequestDTO 객체에 담는다.
        RequestDTO dto = new RequestDTO(userInputs[1], userInputs[2], userInputs[3]);

        RestaurantRegisterSerivce regSrv = new RestaurantRegisterSerivce();
        regSrv.regist(dto);

      } else if (userInput.compareToIgnoreCase("totalList") == 0) {

        RestaurantTotalListService lstSrv = new RestaurantTotalListService();

        // 맛집 목록 전체 출력
        lstSrv.printRestaurantList();

      } else if (userInput.startsWith("search")) {

        // 유효성검사 - 전달받은 정보의 개수를 확인
        if (userInputs.length != 2) {
          System.out.println("♥ 검색 양식에 맞게 입력하세요♥");
          System.out.println("info 상호명");
          
          help();
          continue;
        }

        // RestaurantCategoryListService 에서 printRestaurant(name)호출
        RestaurantInfoService infoSrv = new RestaurantInfoService(); 
        infoSrv.printRestaurant(userInputs[1]);
        
        //change 상호명 기존별점 변경별점
        }else if(userInput.startsWith("change")) {
          // 유효성검사 - 전달받은 정보의 개수를 확인
          if (userInputs.length != 4) {
          System.out.println("♥입력하신 정보가 형식에 맞게 다시 입력해주세요♥");
          help();
          continue;
          }

          RestaurantChangeService changeSrv = new RestaurantChangeService();
          changeSrv.changeStarpoint(userInputs);
          
          
        }else if (userInput.startsWith("delete")) {
            // 유효성검사 - 전달받은 정보의 개수를 확인
            if (userInputs.length != 2) {
                System.out.println("♥ 삭제할 상호명을 입력하세요 ♥");
                help();
                continue;
            }

          // 전달받은 상호명을 이용하여 삭제 요청
          String restaurantNameToDelete = userInputs[1];
          RestaurantDAO dao = new RestaurantDAO();
          
          dao.delete(restaurantNameToDelete);
          System.out.println(restaurantNameToDelete + " 맛집 정보가 삭제되었습니다.");
            
        } else if (userInput.compareToIgnoreCase("help") == 0) {
            help();
        } else if (userInput.compareToIgnoreCase("exit") == 0) {
            System.out.println("♥ 프로그램을 종료합니다 ♥");
            break;
        } else {
            System.out.println("♥ 잘못된 명령어 입니다 ♥");
            help();  
         
      } // end of if
    } // end of while
    sc.close();
  }// end of main
}