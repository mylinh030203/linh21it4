#include<iostream>
using namespace std;
void add(int x,int y){
	int sum;
	sum=x+y;
	cout<< sum;
}
void add(float a, float b){

	cout<<(a+b);
}
void add(double m, double n){

	cout<< (m+n);
}
int main(){
	int x,y;
	float a,b;
	double m,n;
	cout<<"nhap x va y ";
	cin>>x>>y;
	cout<<"nhap a va b ";
	cin>>a>>b;
	cout<<"nhap m va n ";
	cin>>m>>n;
	cout<<"tong so nguyen la ";add(x,y);cout<<endl;
	cout<<"tong so thuc(float) la ";add(a,b);cout<<endl;
	cout<<"tong so thuc(double) la ";add(m,n);cout<<endl;
	return 0;
}
