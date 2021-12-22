#include <iostream>
using namespace std;
int main(){
	int n;
	int i;
	int a[n],s[n];
	int t[n];
	cout<<"nhap vao so phan tu cua 2 mang ";
	cin>>n;
	cout<<"nhap vao phan tu mang a ";
	for(int i=0; i<n; i++){
		cin>>a[i];
	}
		cout<<"Nhap vao phan tu mang s ";
	for(int j=0; j<n; j++){
		cin>>s[j];
	}
	cout<<"Mang sau khi nhan ";
	for(i=0; i<n; i++){
		t[i]=s[i]*a[i]	;
		cout<<t[i]<<" ";
	}
	
	return 0;
}
