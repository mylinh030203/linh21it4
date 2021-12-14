package OOPs;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BTgk {
    public static void main(String agrs[]) {
        List<BenhNhan> lBN = new ArrayList<BenhNhan>();
        BenhNhanngoaitru BNNgoaitru = new BenhNhanngoaitru();
        BenhNhannoitru BNNoitru = new BenhNhannoitru();
        Scanner sc= new Scanner(System.in);
        System.out.println("nhap vao so luong benh nhan noi tru ");
        int n= sc.nextInt();
        for(int i=1; i< n;i++){
            BNNoitru.nhap();
            lBN.add(BNNoitru);
        }
        System.out.println("nhap vao so luong benh nhan ngoai tru ");
        int d= sc.nextInt();
        for(int i=1; i<d; i++) {
            BNNgoaitru.nhap();
            lBN.add(BNNgoaitru);

        }
        for(BenhNhan list:lBN){
            list.in();
        }

        System.out.println("Danh sach benh nhan noi tru la");
        for(BenhNhan listnoitru:lBN){
            if(listnoitru.getClass() == BenhNhannoitru.class) {
                listnoitru.in();
            }
        }
        System.out.println("Danh sach benh nhan co dia chi la Da Nang");
        for(BenhNhan listnoitru:lBN){
            if(listnoitru.getDiadiem().equals("Da Nang")){
                listnoitru.in();
            }
        }
    }



}
class BenhNhan {
    SimpleDateFormat dt = new SimpleDateFormat("yyyy/mm/dd");
    private String Hoten;
    private String SoBHXH;
    private Date Ngaysinh;
    private String Diadiem;
    private Date Ngaydenkham;


    public String getHoten() {
        return Hoten;
    }

    public String getSoBHXH() {
        return SoBHXH;
    }

    public void setHoten(String hoten) {
        Hoten = hoten;
    }

    public void setSoBHXH(String soBHXH) {
        SoBHXH = soBHXH;
    }

    public void setNgaysinh(Date ngaysinh) {
        Ngaysinh = ngaysinh;
    }

    public void setDiadiem(String diadiem) {
        Diadiem = diadiem;
    }

    public void setNgaydenkham(Date ngaydenkham) {
        Ngaydenkham = ngaydenkham;
    }

    public Date getNgaysinh() {
        return Ngaysinh;
    }

    public String getDiadiem() {
        return Diadiem;
    }

    public Date getNgaydenkham() {
        return Ngaydenkham;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao ho ten");
        this.Hoten = sc.nextLine();
        System.out.println("nhap vao so bao hiem xa hoi");
        this.SoBHXH = sc.nextLine();
        try {
            System.out.println("nhap vao ngay sinh");
            this.Ngaysinh = dt.parse(sc.nextLine());
            System.out.println("nhap vao ngay den kham ");
            this.Ngaydenkham = dt.parse(sc.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("nhap vao dia diem");
            this.Diadiem = sc.nextLine();
        }

    }
    public void in(){
        System.out.println("Ho ten "+this.Hoten);
        System.out.println("So bao hiem xa hoi "+this.SoBHXH);
        System.out.println("ngay sinh "+dt.format(this.Ngaysinh));
        System.out.println("dia diem "+this.Diadiem);
        System.out.println("ngay den kham "+dt.format(this.Ngaydenkham));

    }

}
class BenhNhanngoaitru extends BenhNhan{
    public void nhap(){
        super.nhap();
    }
    public void in(){
        super.in();
    }
}
class BenhNhannoitru extends BenhNhan {

    SimpleDateFormat dt = new SimpleDateFormat("yyyy/mm/dd");
    private Date Ngaynhapvien;
    private Date Ngayxuatvien;

    public Date getNgaynhapvien() {
        return Ngaynhapvien;
    }

    public Date getNgayxuatvien() {
        return Ngayxuatvien;
    }

    public void setNgaynhapvien(Date ngaynhapvien) {
        Ngaynhapvien = ngaynhapvien;
    }

    public void setNgayxuatvien(Date ngayxuatvien) {
        Ngayxuatvien = ngayxuatvien;
    }
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("nhap vao ngay nhao vien ");
            this.Ngaynhapvien = dt.parse(sc.nextLine());
            System.out.println("nhap vao ngay xuat vien ");
            this.Ngayxuatvien = dt.parse(sc.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    public void in(){
        super.in();
        System.out.println("ngay nhap vien "+dt.format(this.Ngaynhapvien));
        System.out.println("ngay xuat vien "+dt.format(this.Ngayxuatvien));
    }

}


