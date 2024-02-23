## Sorting(정렬)



sort : 정렬

293851
123589 -> 오름차순 정렬
985321 -> 내림차순 정렬

선택 정렬
2 - 9 -3 -8 -5

1.  2.
   ​ 2와 9 비교. 9와 3 비교.
   ​ 2와 3 비교. 9와 8 비교.
   ​ : :
   ​ : :
   ​ 2와 5 비교. 9와 5 비교.
   제일 작은 숫자 앞으로 제일 작은 숫자 앞으로

알고리즘 : shuffle, 탐색, tree



~~~java
package sample17_sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		/*
	 	Sorting : 숫자의 크기 순으로 정렬하는 방법
	 	낮은 숫자부터 정렬 -> 오름차순 정렬
	 	높은 숫자부터 정렬 -> 내림차순 정렬
	 */

	int number[] = { 3, 6, 4, 8, 1, 5, 2, 7 };
	/*
	 	오름차순
	 		첫 번째	 1, 6, 4, 8, 3, 5, 2, 7
	 		두 번째	 1, 4, 6, 8, 3, 6, 2, 7
	 				 1, 3, 6, 8, 4, 6, 2, 7
	 				 1, 2, 6, 8, 4, 6, 3, 7
	 				 이런 식
	 */
	int temp=0;
	for(int i=0; i<number.length - 1; i++) {	// 맨 끝 끼리 비교할 필요 없어 길이-1
		
		for (int j = i + 1; j < number.length; j++) {
			if(number[i] > number[j]) {
				temp = number[i];
				number[i] = number[j];
				number[j] = temp;
			}
		}
		
	}
	
	for(int i=0; i<number.length; i++) {
		System.out.println("number[" + i + "] = " + number[i]);
	}
	
	System.out.println(Arrays.toString(number));
	/////////////////////////////////////////////////////////////////////////////

	int num[] = null;
	int count, updown;
	
	// 변수의 초기화
	count = 0;
	updown = 0;
	
	/////////////////////////////////////////Input
	// 정렬하고 싶은 숫자의 갯수
	Scanner sc = new Scanner(System.in);
	System.out.print("정렬하고 싶은 수의 갯수 = ");
	count = sc.nextInt();
	
	// 배열에 그 갯수에 맞게 할당
	num = new int[count];
	
	// 숫자들을 입력
	for(int i=0; i<count; i++) {
		System.out.print((i + 1) + "번째 수 = ");
		num[i] = sc.nextInt();
	}
	
	// 오름(1) / 내림(2)
	System.out.print("오름(1) / 내림(2) : ");
	updown = sc.nextInt();
	//////////////////////////////////////////////
	
	// Sorting
	for(int i=0; i<num.length - 1; i++) {	// 맨 끝 끼리 비교할 필요 없어 길이-1
		
		for (int j = i + 1; j < num.length; j++) { // 오름차순
			
			if(updown == 1) {
			if(num[i] > num[j]) {
				swap(num, i, j);
			}
			} else{
				if(num[i] < num[j]){ // 내림차순
				swap(num, i, j);
				
			}
		}
		
	}
	}
	
	///////////////////////////////////////////////////////결과출력
	if(updown == 1) {
		System.out.println("오름차순 정렬입니다.");
	}
	else {
		System.out.println("내림차순 정렬입니다.");
	}
	for(int i=0; i<num.length; i++) {
		System.out.println("num[" + i + "] = " + num[i]);
	}
	
	System.out.println(Arrays.toString(num));
	
	
	}
	
	static void swap(int number[], int i, int j) {
		
		int temp;
		
		temp = number[i];
		number[i] = number[j];
		number[j] = temp;
	}
	
}
~~~



## OverLoad

~~~java
package sample18_OverLoad;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	OverLoad : 함수명은 같고 매개변수(parameter)의 갯수나 자료형이 다른 함수를 의미한다.
		 				-> 이름만 같고 다른 함수 -> 다른 함수
		 				구분 -> parameter로
		 				
		 	painting(); -> background image
		 	painting(int x, int y) -> character image
		 	
		 */
		
		// 함수명은 같지만 다른 값 호출
		func();
		func('a');	
		func(33);
		func('b', 3);
		func(3, 'b');
		
		int s = sum(1, 2, 3);
		System.out.println("합계 : " + s);
		
		s= sum(100, 90, 80, 70, 60);
		System.out.println("합계 : " + s);

	}
	
	static void func() {
		System.out.println("func() 호출");
	}
	
	// 자료형 변환 -> 다른 함수
	static void func(char c) { // 함수명이 같지만 자료형이 다름.
		System.out.println("func(char c) 호출");

	}
	
	// 자료형 변환 -> 다른 함수
	static void func(int i) {
		System.out.println("func(int i) 호출");
	}
	
	// 인풋 개수 바뀌어도 다른 함수
	static void func(char c, int i) {
		System.out.println("func(char c, int i) 호출");
	}
	
	// 인풋 순서 바뀌어도 다른 함수
	static void func(int i, char c) {
		System.out.println("func(int i, char c) 호출");
	}
		
	/*
	// 가상의 인수만 달라도 안된다.
	static void func(int ii, char cc) {
		System.out.println("func(int i, char c) 호출");
	 */
		
	/*
	 // 리턴 값이 다르면 오류 -> 이름이 같으면 컴터에선 같은 함수로 보긴 함.
	 static int func(){
	 	System.out.println("func() 호출");
	 	
	 	return;
	 	}
	 */
		
	// 가변인수 배열 형식으로 
	static int sum(int ...number) {
		int s= 0;
		for(int i =0; i < number.length; i++) {
			s= s + number[i];
		}
		return s;
	
	}
	
	

}
~~~





## Calendar

~~~java
package sample19_Calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	Calendar : 일정관리, 회원관리, 인사관리
		 	Date -> 구글에서 검색
		 	
		 */
		
		// Calendar cal = new GregorianCalendar(); // 누군가 만들어 놓은 코드, new는 동적 할당
		Calendar cal = Calendar.getInstance(); // 위와 같다.
		
		// 오늘 날짜 취득
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; // MONTH가 0 ~ 11 로 이뤄짐.
		int day = cal.get(Calendar.DATE);
		
		System.out.println(year + "/" + month + "/" + day);
		// pc 시간 기준이라 pc 세팅 변경 시 출력 값 바뀜.
		
		/*
		// 날짜 셋팅 (setter)
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, 3 -1); // 미리 1 빼둬야 설정한 월 나옴.
		cal.set(Calendar.DATE, 16);
		
		// 세팅을 새로 했으니 다시 값 얻어와야 한다.
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1; // -> 이러면 설정한 값에 +1월이 나옴.
		day = cal.get(Calendar.DATE);
		
		System.out.println(year + "/" + month + "/" + day);
		*/
		
		// 오전/오후
		String ampm = cal.get(Calendar.AM_PM) == 0 ? "오전":"오후";
		System.out.println(ampm); // 따로 세팅x -> 현재 시간 반영
		
		int weekday = cal.get(Calendar.DAY_OF_WEEK);	// 일(1) ~ 토(7)
		System.out.println(weekday);
		
		switch(weekday) {
			case 1:
				System.out.println("일요일");
				break;
			case 2:
				System.out.println("월요일");
				break;
			case 3:
				System.out.println("화요일");
				break;
			case 4:
				System.out.println("수요일");
				break;
			case 5:
				System.out.println("목요일");
				break;
			case 6:
				System.out.println("금요일");
				break;
			case 7:
				System.out.println("토요일");
				break;
		}
		// 날짜 임의 세팅
		/*
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, 1 -1);
		*/
		
		// 지정 달의 마지막 날(28, 29, 30, 31)
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(lastday);
		
		// 위의 빈 칸 : 요일 시작하기 전 빈 칸(30, 31 이런 거)
		cal.set(Calendar.DATE, 1); // 위 빈 칸을 알려면 1일 설정해야 함.
		
		weekday = cal.get(Calendar.DAY_OF_WEEK);
		int upEmpty = (weekday - 1) % 7;
		System.out.println(upEmpty);
		
		// 밑의 빈 칸
		lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DATE, lastday);	// 12.31
		
		// 요일
		weekday = cal.get(Calendar.DAY_OF_WEEK);
		
		int downEmpty = 7 - weekday;
		System.out.println("밑의 빈 칸의 수 : " + downEmpty);
		
		/*
		// 달력 만들기.
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, 3 -1);
		cal.set(Calendar.DATE, 1);
		
		int startDay = cal.get(Calendar.DAY_OF_WEEK);	// 1 ~ 7
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		
		
		System.out.println(year + "년 "+ month + "월");
		System.out.println("=======================================================");
		
		String week_day = "일월화수목금토";
		
		for (int i = 0; i < week_day.length(); i++) {
			char c = week_day.charAt(i);
			System.out.print(c + "\t");
		}
		System.out.println();
		System.out.println("=======================================================");
		
		// 위쪽 빈 칸
		for(int i = 1; i < startDay; i++) {
			System.out.print("*" + "\t");
		}
		
		// 날짜
		int _day = 1;
		for (int i = 0; i < lastDay; i++) {
			System.out.print(_day + "\t");
			
			if((_day + startDay - 1) % 7 == 0) {
				System.out.println("");
			}
			_day++;
		}
		
		// 밑쪽 빈 칸
		for(int i=0; i < (7 - (startDay + lastDay - 1) % 7); i++) {
			System.out.print("*" + "\t");
		}
		System.out.println("");
		
		System.out.println("=======================================================");
		*/
		calendarPrint(2022,12);
	}
	
	// 현재 시간 출력 함수
	static void calendarPrint(int year, int month) {
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month -1); 
		cal.set(Calendar.DATE, 1);
		
		int startDay = cal.get(Calendar.DAY_OF_WEEK);	// 1 ~ 7
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		
		
		System.out.println(year + "년 "+ month + "월");
		System.out.println("=======================================================");
		
		String week_day = "일월화수목금토";
		
		for (int i = 0; i < week_day.length(); i++) {
			char c = week_day.charAt(i);
			System.out.print(c + "\t");
		}
		System.out.println();
		System.out.println("=======================================================");
		
		// 위쪽 빈 칸
		for(int i = 1; i < startDay; i++) {
			System.out.print("*" + "\t");
		}
		
		// 날짜
		int _day = 1;
		for (int i = 0; i < lastDay; i++) {
			System.out.print(_day + "\t");
			
			if((_day + startDay - 1) % 7 == 0) {
				System.out.println("");
			}
			_day++;
		}
		
		// 밑쪽 빈 칸
		for(int i=0; i < (7 - (startDay + lastDay - 1) % 7); i++) {
			System.out.print("*" + "\t");
		}
		System.out.println("");
		
		System.out.println("=======================================================");
	}
		
	}
~~~





## Exception

~~~java
package sample20_Exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MainClass {

	public static void main(String[] args) {
		/*
		 	Exception : 예외 != 에러
		 	범위에서 벗어난 경우
		 	
		 	1 ~ 9 -> 'A' == 65 아스키 코드
		 	
		 	예)
		 		number -> string
		 		array -> index bound out [0 ~ 4] -> [5]
		 		class -> 없을 때
		 		file -> 없을 때
		 		
		 		형식 :
		 			// 코드에 적을 때
		 			* try/catch 에러를 처리할 때 로그를 남기는 용도
		 			try {
		 				// exception이 발생할 가능성이 있는 코드
		 			
		 			}catch(예외 클래스1 e){
		 				메세지 출력
		 			}catch(예외 클래스2 e){
		 				메세지 출력
		 			}catch 계속 쓸 수 있다.{
		 			}finally{
		 				예외가 발생하던 안하던 
		 				무조건 실행
		 				(복구 코드) - undo(되돌림, rollback)
		 			}
		 			
		 			// 함수에 적을 때
		 			static void func() throws 예외클래스{
		 				exception이 발생할 가능성이 있는 함수
		 			}
		 			
		 */
		
		int array[] = { 1, 2, 3 };
		
		System.out.println("start ---");
		
		try {
			
			for (int i = 0; i < 4; i++) {
				System.out.println(array[i]);
			}
			
			System.out.println("process ---"); // i=4일 때 exection으로 가버림.
			
		} catch (ArrayIndexOutOfBoundsException e) {
			// System.out.println("배열범위 초과");
			// e.toString() // 에러의 Exception 내용과 원인을 출력합니다.
			// e.printStackTrace(); // 에러의 발생근원지를 찾아서 단계별로 에러를 출력합니다.
			// System.out.println( e.getMessage() ); // 에러의 원인을 간단하게 출력합니다.
			// 셋 다 가능
			
			// return; // main 함수를 빠져나가 버림.
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 프로그램이 문제 발생했을 때도 finally는 무조건 실행
					// return으로 위에서 빠져나갈 때도 실행
					// finally 하고 나면 프로그램 끝. 밑에 실행 안되네.
			System.out.println("finally +++");
		}
		
		System.out.println("end ---");
			
		// func();
		
		// NullPointerException
		String str = null; // <- 비어 있다
		
		try {
		System.out.println( str.length() );
		} catch (NullPointerException e) {
			System.out.println("str이 null입니다.");
		}
		
		// ArrayIndexOutOfBoundsException
		int arr[] = { 1, 2, 3 };
		
		try {
			arr[3] = 4;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 초과");
		}
		
		// FileNotFoundException
		File f = new File("d:\\xxx");
		FileInputStream is;
		
		try {
			is = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}
		
		// StringIndexOutOfBoundsException
		String str1 = "java";
		try {
			str1.charAt(4);
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("글자가 없는 공간입니다.");
		}
		
		// NumberFormatException
		try {
			int i = Integer.parseInt("12a3");
		} catch (NumberFormatException e) {
			System.out.println("숫자가 아닌 글자가 있습니다.");
		}
		// 이 모든 걸 다 exception으로도 대체 가능하다.
		
		// 실제 사용 사례
		Scanner sc = new Scanner(System.in);
		
		int number=0;
		while(true) {
			
			System.out.print("숫자 입력 = ");
			String strNum = sc.next();
			
			try {
				number = Integer.parseInt(strNum);
			} catch (Exception e) {
				System.out.println("숫자가 아닌 글자가 있습니다.");
				continue;
			}
			
			break;
			}
		
		System.out.println("number = " + number);
	}
	
	/*
	static void func() throws IndexOutOfBoundsException {
		int num[] = { 1, 2, 3 };
		
		for(int i=0; i < 4; i++) {
			System.out.println(num[i]);
		}
	}
	*/

}
~~~



## File

~~~java
package sample21_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;

import javax.sql.RowSetWriter;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	file : 	저장매체 ==> 기능
		 		 	Database -> file(최적화)
		 		 	기록
		 		 	
		 	*.txt	->	dll, lib, jar
		 			 	
		 			 dll : dynamic link library(dll) -> 동적
		 			 library(;ib) -> 정적
		 			 
		 	동적 vs 정적 
		 	동적 : 실시간으로 시간이 됐을 때 읽는다.
		 		메모리 소모량이 더 적다.
		 	정적 : 일괄적으로 
		 		보안쪽에서는 정적이 유리.
		 */
		
		File file = new File("c:\\"); // c드라이브 경로
		
		/*
		// 파일을 조사
		String filelist[] = file.list();
		for (int i = 0; i < filelist.length; i++) {
			System.out.println(filelist[i]);
		}
		*/
		
		//	파일과 폴더를 구분해서 조사
		File filelist[] = file.listFiles();
		for (int i = 0; i < filelist.length; i++) {
			if(filelist[i].isFile()) {	// 파일
				System.out.println("[파일]" + filelist[i].getName());
			}
			else if(filelist[i].isDirectory()) {	// 폴더
				System.out.println("[폴더]" + filelist[i].getName());
			}
			else {	// 수상한 파일, 이전엔 바이러스라고도 부름
				System.out.println("[?]" + filelist[i].getName());
			}
		}
		
		// 파일을 생성
		File newfile = new File("c:\\tmp\\newfile.txt"); // 파일을 만드는 코드가 아님
		
		try {
		if(newfile.createNewFile()) { // createNewFile 에러 뜨는 건 예외 처리 때문임.
			// 여기서 파일 생성
			System.out.println("파일 생성 성공!");
		} else {
			System.out.println("파일 생성 실패");
		}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		// 파일의 존재 여부
		if(newfile.exists()) {
			System.out.println("파일이 존재합니다.");
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
		// 읽기 전용
		newfile.setReadOnly(); 
		
		// 삭제
		newfile.delete();
		
		// (문자열)쓰기
		File f = new File("c:\\tmp\\iofile.txt");
		
		try {
			// 파일이 없으면 생성한다.
			
			// 쓰기
			/*
			FileWriter fwriter = new FileWriter(f);
			fwriter.write("안녕하세요");
			fwriter.write("Hello");
			fwriter.close();
			*/
			
			// 추가 쓰기
			/*
			FileWriter fwriter = new FileWriter(f, true);
			fwriter.write("반갑습니다. \n"); // 개행이 어렵다.
			fwriter.close();
			*/
			
			FileWriter fwriter =new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fwriter);
			PrintWriter pw = new PrintWriter(bw);
			
			// 다른 추가 쓰기 (조금 더 발전된 ver.)
			/*
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			pw.println("hi"); // 파일에 출력,not console
			pw.print("헬로우");
			pw.println("world");
			pw.close();
			*/
			
			// (문자열)읽기
			// 한 글자씩 읽기 : 한 글자씩 읽기 때문에 잘 사용 안 함.
			FileReader fr = new FileReader(f); // f는 iofile 변수 선언한 것.
			int ch = fr.read();
			while(ch != -1) {
				System.out.print((char)ch);
				ch = fr.read();
			}
			
			// 한 문장씩 읽기
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			String str = "";
			while((str = br.readLine()) !=null) {
				System.out.println(str);
			}
			
			br.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
~~~



