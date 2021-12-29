#include<iostream>
using namespace std; 
int main(){

	int mangA[50]={},soPhantu,mangdem[50]={};
	cout<<"Nhap so phan tu cua mang:";
	cin>>soPhantu;
	for(int i=0;i<soPhantu;i++){
		if(i==0)
			cout<<"Nhap gia tri cho cac phan tu trong mang:\n";
		cout<<" ";
		;
		cin>>mangA[i];
	}
	for(int i=0;i<soPhantu;i++){
		int dem =1;
		mangdem[i]=dem;
		for(int j=i+1;j<soPhantu;j++){
			if(mangA[i]==mangA[j]){
				mangdem[i]=++dem;
				for(int k=j;k<soPhantu;k++){
					mangA[k]=mangA[k+1];
				}
				soPhantu--;
				j--;
			}
		}
	}
	int max=0,vi_tri=0;
	for(int i=0;i<soPhantu;i++){
		if(mangdem[i]>max){
			max=mangdem[i];
			vi_tri=i;
		}
}
		cout<<"\nPhan tu thu "<<vi_tri+1<<"trong mang A xuat hien nhieu nhat ,cu the la .\n"<<max;
	return 0;
}
