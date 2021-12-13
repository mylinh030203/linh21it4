#include <iostream>
using namespace std;
int derivative(int x, int y){
	int p=y;
	for(int i=1; i<y; i++){
		p=p*x;
	}
	return p;
}
int main(){
	int x,y;
	cout<<"nhap vao lan luot a va b";
	cin>>x>>y;
	cout<<derivative(x,y);
	return 0;
}
