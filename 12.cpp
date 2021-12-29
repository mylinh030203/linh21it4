#include<iostream>
using namespace std;
const int MAX =100;


int main(){
	int row, col=MAX;
	cout<<"Nhap vao hang ";
	cin>>row;
	cout<<"nhap vao cot ";
	cin>>col;
	int a[row][col];

	for (int i = 0; i < row; i++)
		for (int j = 0; j < col; j++)
			cin >> a[i][j];
			
	
	int i,j;
	int tonghang[row], tongcot[col];
	cout << "tong hang la: \n";
	for (i = 0; i < row; i++)
	{
		tonghang[i] = 0;
		for (int j = 0; j < col; j++)
			tonghang[i] = tonghang[i] + a[i][j];
	
		cout << tonghang[i] << endl;
	}

	cout << "tong cot la: \n";
	for (j = 0; j < col; j++)
	{
		tongcot[j] = 0;
		for (int i = 0; i < row; i++)
			tongcot[j] += a[i][j];
		cout << tongcot[j] << " ";
	}
	

		for(int i=0; i<col; i++){
		int max = a[0][i];
		int min = a[0][i];
		for(int j=1; j<row; j++){
			if(a[j][i]>= max){
				max=a[j][i];
			}
			if(a[j][i]< min){
				min =a[j][i];
			}
		
		}
		cout<<"max cot "<<i<<" la "<< max<<endl;
		cout<<"min cot "<<i<<" la "<< min<<endl;
	}
	
	
		for(int i=0; i<row; i++){
		int max = a[i][0];
		int min = a[i][0];
		for(int j=1; j<col; j++){
			if(a[i][j]>= max){
				max=a[i][j];
			}
			if(a[i][j]< min){
				min =a[i][j];
			}
		
		}
		cout<<"max hang "<<i<<" la "<< max<<endl;
		cout<<"min hang "<<i<<" la "<< min<<endl;
	}
	

return 0;
}

