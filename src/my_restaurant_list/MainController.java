package my_restaurant_list;

import java.util.Scanner;

public class MainController {

  public static void help() {
    System.out.println("명령어 사용법 :");
    System.out.println("----------------------------------");
    System.out.println("♧ 맛집추가 ♧ new 카테고리(한식,중식,일식,양식) 상호명 별점(0~5점)");
    System.out.println("♧ 별점변경 ♧ change 상호명 기존별점 변경별점");
    System.out.println("♧ 전체리스트 ♧ totalList");
    System.out.println("♧ 카테고리 리스트 ♧ categoryList 카테고리(한식,중식,일식,양식)");
    System.out.println("♧ 맛집프로그램 종료 ♧ exit");
    System.out.println();
  }

  public static void main(String[] args) {

    help();

    Scanner sc = new Scanner(System.in);

    while (true) {

      System.out.println("명령어를 입력하세요");
      String userInput = sc.nextLine();

      // 사용자가 입력한 정보를 빈칸으로 구분하여 배열로 저장
      String[] userInputs = userInput.split(" ");

      if (userInput.startsWith("new")) {// "new" 로 시작한다면

        // 유효성검사 - 전달받은 정보의 개수를 확인
        if (userInputs.length != 4) {
          System.out.println("입력하신 정보가 형식에 맞지 않습니다.");
          help();
          continue;
        }
        
        /* // 유효성검사 -비번일치 여부
        if (!dto.comparePwd()) { // dto.comparePwd() == false 와 같은 표현
          System.out.println("입력하신 비번이 일치하지 않습니다.");
          continue;
        }*/
        
        // 전달받은 데이터를 RequestDTO 객체에 담는다.
        RequestDTO dto = new RequestDTO(userInputs[1], userInputs[2], userInputs[3]);

       RestaurantRegisterSerivce regSrv = new RestaurantRegisterSerivce();
        regSrv.regist(dto);

      } else if (userInput.compareToIgnoreCase("totalList") == 0) {

        RestaurantTotalListService lstSrv = new RestaurantTotalListService();

        // 전체회원정보 목록 출력
        lstSrv.printRestaurantList();

      } else if (userInput.startsWith("categoryList")) {

        // 유효성검사 - 전달받은 정보의 개수를 확인
        if (userInputs.length != 2) {
          System.out.println("입력하신 정보가 형식에 맞지 않습니다.");
          help();
          continue;
        }

        // MemberInfoService 에서 printMember(email)호출
        RestaurantCategoryListService infoSrv = new RestaurantCategoryListService();
        infoSrv.printRestaurant(userInputs[1]);
        
        //change 이메일 현재암호
        }else if(userInput.startsWith("change")) {
          // 유효성검사 - 전달받은 정보의 개수를 확인
          if (userInputs.length != 4) {
          System.out.println("입력하신 정보가 형식에 맞지 않습니다.");
          help();
          continue;
        }

        RestaurantChangeService changeSrv = new RestaurantChangeService();
        changeSrv.changestarpoint(userInputs);
        }else if(userInput.compareToIgnoreCase("help")==0) {
          help();
        }else if(userInput.compareToIgnoreCase("exit")==0){
         System.out.println("프로그램을 종료합니다.");
         break;
        }else {
         System.out.println("잘못된 명령어 입니다.");
         help();
      } // end of if

    } // end of while

    sc.close();
  }// end of main
}