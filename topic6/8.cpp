#include <iostream>
using namespace std;
void bai8(int a)
{
	int b[100];
	int x = 0;
	while (a > 0)
	{
		int d = a % 10;
		b[x] = d;
		a = a / 10;
		x++;
	}
	int s;
	for (int i = 0; i < x; i++)
	{
		for (int j = i + 1; j < x; j++)
		{
			if (b[i] > b[j])
			{
				s = b[i];
				b[i] = b[j];
				b[j] = s;
			}
		}
		cout << b[i];
	}
	cout << endl;
}

void bai82(int a)
{
	int b[100];
	int x = 0;
	while (a > 0)
	{
		int d = a % 10;
		b[x] = d;
		a = a / 10;
		x++;
	}
	
	int s;
	for (int i = 0; i < x; i++)
	{
		for (int j = i + 1; j < x; j++)
		{
			if (b[i] < b[j])
			{
				s = b[i];
				b[i] = b[j];
				b[j] = s;
			}
		}
		cout << b[i];
	}
	cout << endl;
}

int main()
{
	int a;
	cout << "nhap a: ";
	cin >> a;
	bai8(a);
	bai82(a);
	return 0;
}
