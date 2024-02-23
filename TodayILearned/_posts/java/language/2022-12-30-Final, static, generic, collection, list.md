![image-2022-12-30-2]({{site.url}}/images/2022-12-30/image-2022-12-30-2.png)

배열과 다르게 데이터를 지워주면 공간이 남는 게 아닌, 뺀다.

배열은 중간 데이터를 지우면 공간이 남음 -> 데이터들을 일일이 당겨줘야 한다.

![image-2022-12-30-3]({{site.url}}/images/2022-12-30/image-2022-12-30-3.png)

데이터를 추가할 때도, 배열은 해당 위치에 값을 넣고 뒤로 한 칸씩 미는 구조.

하지만!

![image-2022-12-30-4]({{site.url}}/images/2022-12-30/image-2022-12-30-4.png)

리스트는 공간을 알아서 생성함.

오늘의 과제g

![image-2022-12-30-AccountBook]({{site.url}}/images/2022-12-30/image-2022-12-30-AccountBook.png)



## final

~~~java
package sample34_final;

public class MainClass {
	public static void main(String[] args) {
		/*
		 	final : 변수, 클래스, 메소드
		 			== const, define
		 */
		
		final int NUMBER = 1;	// 상수(변경할 수 없는 수), 대입용, 대문자
		// number = 2;
		
		int num = NUMBER;
	}

}

// 클래스 앞에 final : 상속금지
/* final */ class MyClass{
	
	public /* final */ void method() { // Override 금지
		
	}
}

class YouClass extends MyClass{

	@Override
	public void method() {
		method();
	}
	
	
}
~~~



## static

~~~java
package sample35_static;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	static : 정적 != 동적(dynamic)
		 			 memory 공간이 확보. 유지
		 
		 변수 : 지역(local)변수, 멤버(class)변수, 매개(method) 변수, 정적(static)변수 == 전역(global)변수
		 			 
		 	memory
		 		stack		heap		static		system
		 	 	지역변수		멤버변수		정적변수		
		 	 	매개변수
		 	
		 */
		
		int localvar;	// 지역(local) 변수
		/*
		MyClass my = new MyClass();
		my.membervar = 12;
		
		my.method('A');
		*/
		
		// static 호출 시, 클래스명.변수 or 메소드
		MyClass.st_number = 11; // 객체 아님
		MyClass.st_method();
	}
	
	static void func() {
		
		int localvar;	// 지역(local) 변수
	}

}

class MyClass{
	int membervar = 1; // 멤버(class) 변수
	
	static int st_number; // 멤버 변수 형태로 사용, 프로그램 끝나야 변수 사라짐.
	// 프로그램 시작과 끝을 같이 함
	
	public void method(char c) {	// 매개(method) 변수
		int localvar;	// 지역(local) 변수
		
		int membervar = 2;
	}
	
	public void func() {
	//	static int stnumber = 1;	// static은 지역(local)로 사용할 수 없음.
		this.membervar = 12;
	}
	
	public static void st_method() {	// this, super 둘 다 안됨.
		System.out.println("MyClass st_method()");
	}
}
~~~



## generic

~~~java
package sample36_generic;

public class MainClass {
	public static void main(String[] args) {
		/*
		 	Generic == template(형태)
		 	: 자료형의 변수
		 	: 같은 클래스에서 다양한 자료형을 사용하고 싶은 경우에 사용하는 요소
		 	
		 	number -> int, string, double로 사용하고 싶을 때.
		 */
		Box<Integer> box = new Box<Integer>(100); // <>안은 무조건 일반 자료형으로 적어줘야 함.
		// Box class 안에 <T>가 모두 Int 값으로 바뀜
		System.out.println(box.getTemp()+100);
		
		Box<String> sbox = new Box<String>("Hello"); 
		System.out.println(sbox.getTemp());
		
		BoxMap<Integer, String> boxmap = new BoxMap<Integer, String>(1001, "홍길동");	
		System.out.println(boxmap.getKey());
		System.out.println(boxmap.getValue());
		
		BoxMap<String, String> boxmap2 = new BoxMap<String, String>("Hello", "World");		
	}

}

class Box<T>{	// <T> : template 약자, 원하는 대/소문자 입력해도 가능
	T temp;	// 여러 문자형 사용하고 싶을 때
	
	
	public Box(T temp) {
		this.temp = temp;
	}

	public T getTemp() {
		return temp;
	}

	public void setTemp(T
			temp) {
		this.temp = temp;
	}
	
}

class BoxMap<KEY, VALUE>{
	KEY key;
	VALUE value;
	
	public BoxMap(KEY key, VALUE value) {
		super();
		this.key = key;
		this.value = value;
	}

	public KEY getKey() {
		return key;
	}

	public void setKey(KEY key) {
		this.key = key;
	}

	public VALUE getValue() {
		return value;
	}

	public void setValue(VALUE value) {
		this.value = value;
	}
	
	
	
	
}
~~~



## Collection

### Main Class

~~~java
package sample37;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
	public static void main(String[] args) {
		/*
			Collection : 수집(데이터, Object)
			
			List : 목록
			 	ArrayList
			 		배열처럼 사용할 수 있는 리스트 == 유동적배열
			 		선형구조
			 		배열처럼 index로 접근하고 관리한다.	0 1 2 3 4	
			 		검색속도가 빠르다
			 	
			 	LinkedList		
			 		추가/삭제 속도 빠르다
			
			Map : 사전
				HashMap				
				TreeMap
		*/
		
		ArrayList<String> arrlist = new ArrayList<String>();
		
		// 추가
		arrlist.add("Tigers");
		arrlist.add("Eagles");
		arrlist.add("Bears");
		
		// 리스트의 크기(길이)
		System.out.println(arrlist.size());
		
		for(int i = 0;i < arrlist.size(); i++) {
			System.out.println(i + ":" + arrlist.get(i));    // == arrlist[i]
		}
		System.out.println();
		
		
		arrlist.add("Lions");  // 맨뒤에 추가	
		
		for(int i = 0;i < arrlist.size(); i++) {
			System.out.println(i + ":" + arrlist.get(i));    // == arrlist[i]
		}
		System.out.println();
		
		
		arrlist.add(2, "Giants");
		
		for(int i = 0;i < arrlist.size(); i++) {
			System.out.println(i + ":" + arrlist.get(i));    // == arrlist[i]
		}
		System.out.println();
		
		// 삭제
		arrlist.remove(1);	// 삭제하고 싶은 index
		
		for(int i = 0;i < arrlist.size(); i++) {
			System.out.println(i + ":" + arrlist.get(i));    // == arrlist[i]
		}
		System.out.println();
		
		// 검색
		int index = arrlist.indexOf("Giants");
		System.out.println("데이터가 있습니다 " + index);
		
		for(int i = 0;i < arrlist.size(); i++) {
			String s = arrlist.get(i);
			if("Giants".equals(s)) {
				index = i;
				break;
			}			
		}
		
		System.out.println("데이터가 있습니다 " + index);
		System.out.println();
		
		// 수정
		String updateStr = "Twins";
		
		arrlist.set(2, updateStr);
		for(int i = 0;i < arrlist.size(); i++) {
			System.out.println(i + ":" + arrlist.get(i));    // == arrlist[i]
		}
		System.out.println();
		
		
		
	//	ArrayList<Human> list = new ArrayList<Human>();
		List<Human> list = new ArrayList<Human>();
		
		// 추가 -> 3명
		Human hman = new Human("홍길동", 24);
		list.add(hman);
		
		hman = new Human("성춘향", 16);
		list.add(hman);
		
		list.add(new Human("일지매", 22));
		/*
		for (int i = 0; i < list.size(); i++) {
			Human h = list.get(i);
			System.out.println(h.toString());
		}*/
		
		for(Human h : list) {
			System.out.println(h.toString());
		}
		System.out.println();
		
		hman = new Human("홍두께", 23);
		list.add(1, hman);
		
		for(Human h : list) {
			System.out.println(h.toString());
		}
		System.out.println();
				
		// 삭제 -> 1명
		String name = "일지매";
		
		int findindex = -1;
		for (int i = 0; i < list.size(); i++) {
			Human h = list.get(i);
			if(name.equals(h.getName())) {
				findindex = i;
				break;
			}
		}
		list.remove(findindex);
		
		for(Human h : list) {
			System.out.println(h.toString());
		}
		System.out.println();
		
		// 검색 -> 이름
		name = "성춘향";		
		findindex = -1;
		for (int i = 0; i < list.size(); i++) {
			Human h = list.get(i);
			if(name.equals(h.getName())) {
				findindex = i;
				break;
			}
		}
		if(findindex != -1) {
			System.out.println(list.get(findindex).toString());
		}else {
			System.out.println("데이터가 없습니다");
		}
		System.out.println();
				
		// 수정 -> 1명
		Human updateHman = new Human("이몽룡", 17);		
		list.set(1, updateHman);
		
		for(Human h : list) {
			System.out.println(h.toString());
		}
		System.out.println();
	}
}
~~~



### Human

~~~java
package sample37;

public class Human {
	String name;
	int age;
	
	public Human() {
	}
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + "]";
	}
	
}
~~~



## Address Book (List)

### Main Class

~~~java
package main;

import java.util.Scanner;

import dao.AddressDao;

public class MainClass {

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		
		AddressDao dao = new AddressDao();
		
		boolean end = false;
		
		// menu
		out:while(true) {
			
			System.out.println(" << 주소록 >> ");
			System.out.println("1. 지인추가");
			System.out.println("2. 지인삭제");
			System.out.println("3. 지인검색");
			System.out.println("4. 지인수정");
			System.out.println("5. 모두출력");
			System.out.println("6. 데이터저장");
			System.out.println("7. 종료");
			
			System.out.print(">> ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					dao.insert();
					break;
				case 2:
					dao.delete();
					break;
				case 3:
					dao.select();
					break;
				case 4:
					dao.update();
					break;
				case 5:
					dao.allDataPrint();
					break;
				case 6:	
					dao.filesave();
					break;
				case 7:		
					end = true;					
					//System.exit(0);		// 강제종료
					break out;
				default:
					
			}
					
			/*
			if(end) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			*/
						
		}

	}

}
~~~



### Data

~~~java
package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

public class FileProc {

	// 파일 쓰기, 읽기
	private File file = null;
	
	public FileProc(String filename) {
		file = new File("c:\\tmp\\" + filename + ".txt");
		
		// 실제 파일이 생성되는 부분
		try {
			if(file.createNewFile()) {
				System.out.println("파일 생성 성공!");
			}else {
				System.out.println("기존의 파일이 있습니다");
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public String[] read() {	
		
		String datas[] = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			// 데이터의 총 갯수를 구한다
			int count = 0;
			String str = "";
			while((str = br.readLine()) != null) {
				count++;
			}
			br.close();
			
			// 배열 할당
			datas = new String[count];			
			
			// 파일로부터 배열에 저장
			br = new BufferedReader(new FileReader(file));
			
			int w = 0;
			while((str = br.readLine()) != null) {
				datas[w] = str;
				w++;
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		return datas;
	}
	
	public void write(String datas[]) {
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			for (int i = 0; i < datas.length; i++) {
				pw.println(datas[i]);
			}
			
			pw.close();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}	
		
		System.out.println("파일에 저장되었습니다");
	}
	
	
}
~~~



### dto

~~~java
package dto;

// Data Transfer Object : 쓰기, 읽기
// VO : Value Object : 읽기전용
// 주소록의 한명의 데이터를 담는 object
public class HumanDto {

	// 사람의 정보에 항목(column)
	// 이름, 나이, 전화번호, 주소, 메모
	private String name;
	private int age;
	private String phone;
	private String address;
	private String memo;
	
	public HumanDto() {
	}

	public HumanDto(String name, int age, String phone, String address, String memo) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.memo = memo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return name + ":" + age + ":" + phone + ":" + address + ":" + memo;
	}
	
}
~~~



### dao

~~~java
package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.FileProc;
import dto.HumanDto;

// Data Access Object
// 데이터를 접근하고 편집하는 object
// 추가, 삭제, 검색, 수정
public class AddressDao {
	
	Scanner sc = new Scanner(System.in);

	// 변수를 100개 생성 (변수들을 생성)
	private List<HumanDto> list = new ArrayList<HumanDto>();
	
	// private int count;
	
	private FileProc fileProc = null;  // composition(합성)
	
	public AddressDao() {
		// 변수들에 객체를 생성
		
		fileProc = new FileProc("address");
		
		fileload();
		/*
		humanArr[0] = new HumanDto("홍길동", 24, "123-4567", "서울시", "절친");
		humanArr[1] = new HumanDto("성춘향", 16, "234-5678", "남원시", "여사친");
		humanArr[2] = new HumanDto("일지매", 22, "345-6789", "부산시", "동호회");
		humanArr[3] = new HumanDto("홍길동", 20, "555-5555", "춘천시", "친구");
		*/
		
	}
		
	public void insert() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("지인을 추가합니다");
		
		System.out.print("이름 = ");
		String name = sc.next();
		
		System.out.print("나이 = ");
		int age = sc.nextInt();
		
		System.out.print("전화번호 = ");
		String phone = sc.next();
		
		System.out.print("주소 = ");
		String address = "";
		try {
			address = br.readLine(); 
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		System.out.print("메모 = ");
		String memo = sc.next();
				
		
		HumanDto dto = new HumanDto(name, age, phone, address, memo);
		list.add(dto);
	}
	
	public void delete() {
				
		System.out.print("삭제할 지인의 이름 = ");
		String name = sc.next();
		
		// 검색
		int index = search(name);
		/*
		int index = -1;
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null 
					&& name.equals(humanArr[i].getName())) {
				index = i;
				break;
			}
		}
		*/
		
		if(index == -1) {
			System.out.println("지인의 정보를 찾을 수 없습니다");
		}
		else {			
			// 삭제
			/*
			humanArr[index].setName("");
			humanArr[index].setAge(0);
			humanArr[index].setPhone("");
			humanArr[index].setAddress("");
			humanArr[index].setMemo("");
			*/
			list.remove(index);
			
			System.out.println("지정한 지인을 삭제하였습니다");
		}
	}
	
	public void select() { // 동명이인을 찾는다
		// 검색
		System.out.print("검색할 지인의 이름 = ");
		String name = sc.next();
		
		/*
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null 
					&& name.equals(humanArr[i].getName())) {
				System.out.println(humanArr[i].toString());
			}
		}
		*/
		
		// 찾을 사람이 몇명인지?
		/*
		int count = 0;
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null 
					&& name.equals(humanArr[i].getName())) {
				count++;
			}
		}
		
		if(count < 1) {
			System.out.println("검색한 지인은 찾을 수 없습니다");
			return;
		}
		
		// 찾은 데이터를 보관용 배열
		HumanDto hdto[] = new HumanDto[count]; // 2
		
		int n = 0;
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null 
					&& name.equals(humanArr[i].getName())) {
				hdto[n] = humanArr[i];
				n++;  // -> 1
			}
		}
		
		// 찾은 데이터의 배열
		for (int i = 0; i < hdto.length; i++) {
			System.out.println(hdto[i].toString());
		}
		*/
		
		for (HumanDto h : list) {
			if(name.equals(h.getName())) {
				System.out.println(h.toString());
			}
		}		
	}
	
	public void update() {
		System.out.print("수정할 지인의 이름 = ");
		String name = sc.next();
		// 검색
		int index = search(name);		
		if(index == -1) {
			System.out.println("지인의 정보를 찾을 수 없습니다");
			return;
		}
		
		// 수정
		// phone
		// address
		System.out.println("데이터를 찾았습니다");
		System.out.print("전화번호 = ");
		String phone = sc.next();
		
		System.out.print("주소 = ");
		String address = sc.next();
		
		//humanArr[index].setPhone(phone);
		//humanArr[index].setAddress(address);
		
		list.get(index).setPhone(phone);
		list.get(index).setAddress(address);
		/*
		HumanDto h = list.get(index);
		h.setAddress(address);
		h.setPhone(phone);
		*/
		System.out.println("정상적으로 수정되었습니다");
	}
	
	
	public int search(String name) {
	/*	int index = -1;
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null 
					&& name.equals(humanArr[i].getName())) {
				index = i;
				break;
			}
		}*/
		
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			HumanDto h = list.get(i);
			if(name.equals(h.getName())) {
				index = i;
				break;
			}
		}
		return index;
	}
		
	public void allDataPrint() {
		/*
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null 
					&& humanArr[i].getName().equals("") == false) {
				System.out.println(humanArr[i].toString());
			}			
		}*/
		
		for (HumanDto humanDto : list) {
			System.out.println(humanDto.toString());
		}
		
	}	
	
	
	public void filesave() {
		// 실제 배열에 들어 있는 데이터
		/*
		int count = 0;
		for (int i = 0; i < humanArr.length; i++) {
			// 생성된 객체를 검사          삭제한 데이터 검사 
			if(humanArr[i] != null && !humanArr[i].getName().equals("")) {
				count++;
			}
		}
		*/
		
		// String dataArr[] = new String[count];
		String dataArr[] = new String[list.size()];
		
		/*
			이름나이전화번호주소메모
			홍길동24123-4567서울시친구
			홍길동*24*123-4567*서울시*친구
		*/
		
		/*
		count = 0;
		for (int i = 0; i < humanArr.length; i++) {
			
			if(humanArr[i] != null && !humanArr[i].getName().equals("")) {
				//      0 1 2             0 1 3
				dataArr[count] = humanArr[i].toString();
				count++;
			}
		}*/
		for (int i = 0; i < list.size(); i++) {
		//	HumanDto h = list.get(i);
		//	dataArr[i] = h.toString();
			
			dataArr[i] = list.get(i).toString();
		}		
		
		fileProc.write(dataArr);
		
	}
	
	public void fileload() {
		
		String datas[] = fileProc.read();
		/*
		for (String s : datas) {
			System.out.println(s);
		}
		*/
		
		for (int i = 0; i < datas.length; i++) {
		
			String split[] = datas[i].split(":");
			//split[0] -> 이름
			//split[1] -> 나이
			/*
			humanArr[i] = new HumanDto(	split[0], 
										Integer.parseInt(split[1]), 
										split[2], 
										split[3], 
										split[4] );*/
			
			HumanDto h = new HumanDto(	split[0], 
										Integer.parseInt(split[1]), 
										split[2], 		
										split[3], 
										split[4] );			
			list.add(h);
		}
	}
}
~~~

