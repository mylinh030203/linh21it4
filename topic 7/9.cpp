#include<iostream>
#include <algorithm>
using namespace std;
int main(){
	int a[100];
	int i, j, n, k;
	cout<<"nhap so phan tu cua mang: ";
	cin>>n;
	for (i = 0; i < n; i++)
	{
		cin>>a[i];
	}

	for (i = 1; i < n; i++)
	{
		for (j = 0; j <i; j++)
		{
			if (a[i] == a[j])
			{
				for (k = i; k < n; k++) 
				{
					a[k] = a[k + 1];
					n--;
					i--;
				}
			}
		}
	}
	cout<<"\nmang sau khi xoa la:\n";
	for (i = 0; i < n; i++) 
	{
		cout<<a[i];
	}
	return 0;
}
 
