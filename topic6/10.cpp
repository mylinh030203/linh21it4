#include<iostream>
#include<math.h>
using namespace std;
int demsochuso(int n){
	int dem=0;
	while(n>0){
		n=n/10;
		dem=dem+1;
	}
	return dem;
}
bool Polydivisible(int n){
	int k = demsochuso(n);
	for(int i=2;i<=k; i++ ){
		if((int)(n/pow(10,(k-i))) % i!=0){
			return false;
		}
		
	}
	return true;
}
int main(){
	int n;
	cout<<"nhap vao so n ";
	cin>>n;
	if(Polydivisible(n))
		cout<<n<<" is a Polydivisible Number";
	else cout<<n<<" isn't a Polydivisible Number";
	return 0;
}
