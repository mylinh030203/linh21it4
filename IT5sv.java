package OOPs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;


class Sinhvien{
	private String hoten;
	private String namsinh;
	private double diemtoan;
	private double diemanhvan;
	private double diemtinhoc;
	public Sinhvien() {
		
	}
	
	public Sinhvien(String hoten, String namsinh, double diemtoan, double diemanhvan, double diemtinhoc) {
		
		this.hoten = hoten;
		this.namsinh = namsinh;
		this.diemtoan = diemtoan;
		this.diemanhvan = diemanhvan;
		this.diemtinhoc = diemtinhoc;
	}

	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getNamsinh() {
		return namsinh;
	}
	public void setNamsinh(String namsinh) {
		this.namsinh = namsinh;
	}
	public double getDiemtoan() {
		return diemtoan;
	}
	public void setDiemtoan(double diemtoan) {
		this.diemtoan = diemtoan;
	}
	public double getDiemanhvan() {
		return diemanhvan;
	}
	public void setDiemanhvan(double diemanhvan) {
		this.diemanhvan = diemanhvan;
	}
	public double getDiemtinhoc() {
		return diemtinhoc;
	}
	public void setDiemtinhoc(double diemtinhoc) {
		this.diemtinhoc = diemtinhoc;
	}
	public void nhapThongtin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name ");
		this.hoten =sc.nextLine();
		System.out.println("Enter Year of Birth ");
		this.namsinh = sc.nextLine();
		System.out.println("Enter mark Math ");
		this.diemtoan = sc.nextDouble();
		System.out.println("Enter mark English ");
		this.diemanhvan = sc.nextDouble();
		System.out.println("Enter mark Information technology");
		this.diemtinhoc = sc.nextDouble();
		sc.nextLine();
	}
	public double diemTB() {
		double diemTB;
		diemTB= (this.diemanhvan+this.diemtinhoc+this.diemtoan)/3;
		return diemTB;
	}
	public void inThongtin() {
		System.out.println("Name is "+this.hoten);
		System.out.println("Year of Birth is "+this.namsinh);
		System.out.println("Average is "+diemTB());
	}
	public String toString() {
		return ("Name is "+this.hoten+"\n"+"Year of Birth is "+this.namsinh+"\n"+"Average is "+diemTB());
	}
	
}
class hocsinh extends Sinhvien{
	private int mahs;

	public int getMahs() {
		return mahs;
	}

	public void setMahs(int mahs) {
		this.mahs = mahs;
	}
	public void nhapThongtin() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter msv ");
		
		this.mahs = sc.nextInt();
		sc.nextLine();
		super.nhapThongtin();
	}
	
	
}

public class IT5sv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] d = new int[10];
		Sinhvien[] sv = new Sinhvien[6];
		for(int i=0; i<2; i++) {
		sv[i]=new hocsinh();
		sv[i].nhapThongtin();
		}
	
		for(int i=0; i<4;i++) {
			
			sv[i]= new Sinhvien();
			sv[i].nhapThongtin();
			
			
		}
		for(int i=0; i<3; i++) {
			sv[i].inThongtin();
		}
		for(int i=0;i<3;i++) {
			if(sv[i].getDiemanhvan()>0 && sv[i].getDiemtinhoc()>0 && sv[i].getDiemtoan()>0&&sv[i].diemTB()>5) {
				sv[i].inThongtin();
				System.out.println("Is eligible for class");
			}else {
				sv[i].inThongtin();
				System.out.println("Isn't eligible for class");
			}
		}
		
		Arrays.sort(sv, new Comparator<Sinhvien>() {
			public int compare(Sinhvien a, Sinhvien b) {
				/*double diem1 = a.diemTB();
				double diem2 = b.diemTB();*/
				return (int)(b.diemTB()-a.diemTB());
			}
		});
		System.out.println("Sinh vien co diem trung binh cao nhat la "+sv[0]);
		System.out.println("Cac sinh vien co ho la Phan ");
		Arrays.stream(sv).filter(t->t.getHoten().split(" ")[0].equals("Phan"))
		.collect(Collectors.toList()).forEach(System.out::print);
		//sap xem theo ten a->b
		Arrays.sort(sv,new Comparator<Sinhvien>() {
			public int compare(Sinhvien o1, Sinhvien o2) {
				String ten1 = o1.getHoten();
				String ten2 = o2.getHoten();
				return (int)(ten1.compareTo(ten2));
			}
		});
		System.out.println("Ten cac sinh vien theo thu tu tang dan ");
		for(int i=0; i<3; i++) {
			System.out.println(sv[i]);
		}
		
		
	}
	
	
	
	


}
