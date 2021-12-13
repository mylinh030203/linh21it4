#include <iostream>
using namespace std;
int biggest(int n, int m){
	int max=0;
	int s;
	int k;
	int a;
	for(int i=n; i<=m; i++){
		a=i;
		s=0;
		while(a>0){
			int d=a%10;
			s=s+d;
			a=a/10;
		}
		if(s >= max){
			max = s;
			k = i;
		}
	}
	return k;
}
int main(){
	int n,m;
	cout<<"nhap lan luot n va m ";
	cin>>n>>m;
	cout<<biggest(n,m);
	return 0;
}
