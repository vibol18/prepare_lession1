#include<iostream>
using namespace std;
int main()
{
    //RGB Red Gren blue
    //RED 255;0;0m
    //Green 0;255;0m
    //Blue 0;0;255m
    //38 color text
    //48 backgrund-color
    cout<<"\033[38;2;255;0;0m Hello from Red Color "<<endl;
    cout<<"\033[38;2;0;255;0m Hello from Green Text";
}