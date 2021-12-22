#include<iostream>
using namespace std;
int main(){
	int row, col;
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
	
return 0;
}
