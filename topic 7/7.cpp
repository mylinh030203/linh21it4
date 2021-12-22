#include<iostream>
#include <algorithm>
using namespace std;
int main(){
int n;
int a[n];
int i;
cout<<"Nhap vao so phan tu cua mang";
cin>>n;
	for( i=0; i<n;i++){
		cin>>a[i];
	}
	int temp =0;
	for( i =0; i<n; i++){
		for(int j=i+1; j<=n;j++){
			if(a[i]>=a[j]) {
                  temp = a[i];    
                  a[i] = a[j];    
                  a[j] = temp;  
            }
		}
	}
	//sort(a, a + n);
	int dem =0;
	for( i=1; i<=n; i++){
		if(a[i]==a[i-1]){
			dem=dem+1;
		}
		else{
			if(dem>=2){
				cout<<a[i-1]<<" ";
			}
			dem=1;
		}
	}

return 0;
}
