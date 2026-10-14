#include<iostream>
#include <thread>
#include <chrono>
#include<cmath>


using namespace std;
int main(){
    cerr<<"Hello from error"<<endl;
    clog<<"Hello from log"<<endl;
    cout<<cerr.rdbuf()<<endl;
}