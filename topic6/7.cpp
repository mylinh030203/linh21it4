#include<iostream>
using namespace std;
int CandyParcel(int nsmall, int nbig, int n){
	for(int i=0; i<=nsmall; i++){
		for(int j=0; j<=nbig; j++){
			if(n==2*i+5*j){
				return i;
			}
			
		}
	}
	return -1;
}
int main(){
	int nsmall, nbig, n;
	cout<<"so goi keo nho ";
	cin>>nsmall;
	cout<<"so goi keo lon ";
	cin>>nbig;
	cout<<"so keo can ";
	cin>>n;
	cout<<CandyParcel(nsmall,nbig,n);
	return 0;
}
