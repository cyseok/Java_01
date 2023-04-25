package _07_xyz.itwill.io_0425;

import java.io.File;
import java.io.IOException;

// File 클래스 : 파일관련 정보를 저장하는 클래스

public class FileApp {
	public static void main(String[] args) throws IOException {
		
		// File 클래스의 File(String pathname) : 생성자를 이용하여 매개변수로 전달받은 시스템
		// OS 운영체제의 파일 경로를 전달받아 file 객체 생성
		// => 파일경로 : 시스템에 존재하는 피일위치를 표현하는 방법
		// └-> 절대경로 표현방법, 상대경로 표현방법
		// 절대경로 표현방법 : 파일경로를 최상위 디렉토리를 기준으로 파일 위치를 표현
		// 상대경로 표현방법 : 현재 실행 프로그램의 작업 디렉토리를 기준으로 파일 위치를 표현
		// => 이클립스에서는 프로젝트 폴터를 작업 디렉토리로 처리
		
		// Windows 운영체제에서는 폴더와 파일을 구분하기 위한 \ 기호사용
		// => Java에서는 \ 기호가 회피문자를 표현하는 용도로 사용
		// =>  따라서 \ 기호를 문자로 사용하기 위해 \\ 형태의 회피문자로 표현해준다.
		
		File fileOne = new File("c:\\data");
		
		
		// exists() : File 객체에 저장된 파일 경로의 파일이 존재할 경우 true 아니면 false
		if(fileOne.exists()) {
			System.out.println("c:\\data 폴더가 이미 존재");
		} else {
			fileOne.mkdir();
			System.out.println("c:\\data 폴더 생성");
		}
		System.out.println("===========================================================");
		
		// Windows 운영체제를 제외한 나머지 운영체제에서는 / 문자 사용
		// Java에서는 \ 문자 대신, / 문자사용가능
		File fileTwo = new File("c:\\data\\itwill.txt");
		
		if(fileTwo.exists()) {
			System.out.println("c:\\data\\itwill.txt 파일이 이미 존재");
		} else {
			fileTwo.createNewFile();
			System.out.println("c:\\data\\itwill.txt 파일 생성");
			
		}
		System.out.println("===========================================================");
			
		// File 클래스의  File(String parent, String child) 생성자를 이용하여 매개변수로
		// 부모(디렉토리)와 자식(파일)을 전달받아 파일경로가 저장된 File 객체 생성
		File fileThree = new File("c:/data", "itwill.txt");
		
		if(fileThree.exists()) {
			fileThree.delete();  //★★★
			System.out.println("c:\\data\\itwill.txt 파일 삭제");
		} else {
			System.out.println("c:\\\\data\\\\itwill.txt 파일 이미 삭제");
		}
		
		// 파일경로를 상대경로 표현방법으로 전달하여 File 객체 생성
		// => 현재 프로그램의 작업 디렉토리를 기준으로 파일경로 설정 
		// => 상대 경로 표현방법은[..] 기호를 사용하여 표현하고
		//     [파일]형식으로 작업 디렉토리에 존재하는 파일이나 하위디렉토리 표현
		
		System.out.println("===========================================================");
		
		File fileFour = new File("src");
		
		if(fileFour.exists()) {
			// file.toString() : File 객체에 저장된 파일경로를 문자로 반환
			// System.out.println("파일 경로 : " + fileFour.toString());
			System.out.println("파일 경로 : " + fileFour);
			
			// .getAbsolutePath() : 절대경로 반환 메소드
			System.out.println("파일 경로 : " + fileFour.getAbsolutePath());
			
		} else {
			System.out.println("작업디렉토리에 [src] 디렉토리가 없습니다.");
		}
		System.out.println("===========================================================");
		
		File fileFive = new File("c:/");
		
		// File.isDirectory() : File 객체에 저장된 파일경로의 파일이 디렉토리가 아닌경우 false, 맞는경우 true
		if(fileFive.isDirectory()) {
			
			// File.listFiles() : 파일객체에 저장된 파일경로의 디렉토리 파일이나 하위 디렉토리 목록을 객체 배열로 반환
			File[] subFiles = fileFive.listFiles();
			
			System.out.println("폴더의 하위 목록 -> ");
			for(File file : subFiles) {
				if(file.isFile()) {
					System.out.println("파일 : " + file);
				} else {
					System.out.println("폴더 : " + file);
				}
			}
			
		} 
		System.out.println("===========================================================");
		
		
	}

}

































