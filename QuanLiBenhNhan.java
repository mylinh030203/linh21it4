import java.util.ArrayList;
import java.util.Scanner;

public class QuanLiBenhNhan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<BenhNhan> list = new ArrayList<BenhNhan>();
		Scanner key = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.Nhap danh sach benh nhan noi tru ");
			System.out.println("2.Nhap danh sach benh nhan ngoai tru ");
			System.out.println("3.Hien thi danh sach benh nhan ");
			System.out.println("4.Hien thi danh sach benh nhan noi tru ");
			System.out.println("5.Hien thi danh sach benh nhan khu vuc Da Nang ");
			System.out.println("6.Check BHXH ");
			System.out.println("-------------------");
			
			int n = Integer.parseInt(key.nextLine());
			
			if (n == 1) {
				System.out.print("Nhap so benh nhan noi tru: ");
				int m = Integer.parseInt(key.nextLine());
				
				for(int i=0; i<m; i++ ) {
					BenhNhanNoiTru A = new BenhNhanNoiTru();
					A.input();
					System.out.println("-------------------");
					list.add(A);
				}	
			}
			if (n == 2) {
				System.out.print("Nhap so benh nhan ngoai tru: ");
				int m = Integer.parseInt(key.nextLine());
				
				for(int i=0; i<m; i++ ) {
					BenhNhanNgoaiTru A = new BenhNhanNgoaiTru();
					A.input();
					System.out.println("-------------------");
					list.add(A);
				}
		    }
			if (n == 3) {
				System.out.println("Danh sach benh nhan: ");
				for(BenhNhan A:list) {
			 		A.output();
			 		System.out.println();
			 	}
			}
			if (n == 4) {
				System.out.println("Danh sach benh nhan noi tru: ");
				for(BenhNhan A:list) {
					if (A instanceof BenhNhanNoiTru) {		
						A.output();
						System.out.println();
					}			 		
			 	}
			}
			if (n == 5) {
				System.out.println("Danh sach benh nhan khu vuc Da Nang: ");
				for(BenhNhan A:list) {
					if (A.diachi.indexOf("Da Nang")>=1) {		
						A.output();
						System.out.println();
					}			 		
			 	}
			}
			if (n == 6) {
				for(BenhNhan A:list) {
					try {
						MyException.checkBHXH(A.bhxh);
					} catch (MyException e) {
						e.printStackTrace();
					}
				}			
			}
			else break;
			
						
	}
	}
}
