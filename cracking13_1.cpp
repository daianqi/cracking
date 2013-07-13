/*
Write a method to print the last K lines of an input file using C++.
*/

#include <iostream>
#include <fstream>

using namespace std;

void printLastKLines (int k, const char* filename) {
    const int numLine = k;
    ifstream file(filename);
    string L[k];
    int size = 0;

    while(file.good()) {
        getline(file,L[size%k]);
        size++;
    }

    int start = size>k?(size%k):0;
    int count = min(k,size);

    for(int i =0;i<count;i++) {
        cout<<L[(start+i)%k]<<endl;
    }
}

int main() {
    string num;
    cin>>num;
    string fileName;
    cin>>fileName;
    printLastKLines(atoi(num.c_str()),fileName.c_str());
}


