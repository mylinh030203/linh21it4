# include<iostream>
using namespace std;
int main(){
		int n;
		int arr[n];
		cout<<"Nhap n";
		cin>>n;
		for(int i=0; i<n; i++){
		cin>>arr[i];
		}
		int sc=0,sl=0;
		int dc=0,dl=0;
		for(int i = 0; i<n; i++){
			if(arr[i]%2==0){
				sc=sc+arr[i];
				dc=dc+1;
			}else{
				sl=sl+arr[i];
				dl=dl+1;
			}
		}
		cout<<"Trung binh phan tu chan la " <<(double)(sc/dc)<<endl;
		cout<<"Trung binh phan tu le la "<<(double)(sl/dl);
		return 0;
}
