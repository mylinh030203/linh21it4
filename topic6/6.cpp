#include <iostream>
#include <string.h>
#include <math.h>
using namespace std;

void check(int n){
    int count, m = n;
    int t = 1;
    string s = "", s1;
    
    for(int i = 2; i <= m; i++){
        count = 0;
        while(m % i == 0){
            ++count;
            m /= i;
        }
        if(count){
            t *= i;
            s1 = to_string(i);
            s += s1;
            // if(count > 1) cout << i <<"^" << count;
            // else cout << i << endl;
            // if(n > i){
            //     cout << "*";
            // }
        }

    }
    int tmp = s.length();
    string s2 = to_string(n);
    int temp = s2.length();
    if((tmp == temp)){
        cout << "Equidigital";
        cout << tmp << " " << temp;
    } else if ((temp > tmp)){
        cout << "Frugal";
        cout << tmp << " " << temp;
    } else if ((temp < tmp)) {
         cout << "Wasteful";
         cout << tmp << " " << temp;
    }



  
}

int main(){
    int n;
    cout << "\nNhap n = ";
    cin >> n;
    check(n);
}
