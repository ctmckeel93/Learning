#include <iostream>

using namespace std;

int main()
{
    float ySalary;

    cout << "What is your yearly salary? "; 
    cin >> ySalary;
    float mSalary = ySalary / 12;
    cout << "Your monthly salary is " << mSalary << endl;
}