#include<iostream>
using namespace std;

bool isPrime(int n){
	if(n<2) return false;
	for(int i=2; i*i<=n; i++)
		if (n%i==0) return false;
	return true;
}
int primorial(int n){
	int i=0;
	int k=2;
	int s=1;
	
	while(true){
		
		int dem=0;	
	/*	for(int j=2; j<=k;j++){
			if(k%j==0){
				dem=dem+1;
			}	
		}*/
		if(isPrime(k)){
			s=s*k;
		
			i++;
		}
		k++;
		
		if(i==n){
			break;
		}
	}
	return s;
}
int main(){
	int n;
	cout<<"nhap n ";
	cin>>n;
	cout<<"giai thua "<<n<<" so nguyen to la ";
	cout<<primorial(n);
/*	cout<<isPrime(13);
	cout<<isPrime(20);*/
	return 0;
	
}

