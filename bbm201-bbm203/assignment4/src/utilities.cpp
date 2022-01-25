#include "iostream"
using namespace std;
#include "utilities.h"
#include "vector"
#include "string"
void printWord(char* str, int n,vector<string>& v)
{
    string s;
    for(int i=0; i<n; i++)
    {
        s+=str[i];
    }
    v.emplace_back(s);
}