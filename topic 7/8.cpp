#include<iostream>
using namespace std;
int main(){
	int arr[100];
	int n, i, index, value;
	cout<<"nhap vao so phan tu ";
	cin>>n;
	cout<<"nhap phan tu ";
	for(i=0; i<n; i++){
		cin>>arr[i];
	}
	cout<<"nhap phan tu muon chen ";
	cin>>value;

	cout<<"nhap vi tri chen phan tu ";
//dich chuyen cac phan tu tu vi tri can chen(index) lui ve sau, lam trong vi tri can chen
	cin>>index;
	for(i=n-1;i>=index-1; i--){
		arr[i+1]=arr[i];
	}
	arr[index -1]=value;
	cout<<"Mang sau khi chen ";
	for(i=0; i<=n; i++){
		cout<<arr[i]<<" ";
	}
	return 0;
}
