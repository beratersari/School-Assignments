#include <iostream>
#include "vector"
#include "stack"
#include "sstream"
#include <fstream>
using namespace std;

void splitString(string s, vector<vector<string>> &final){
    //this function is to read and split dpda-input (operations). Then, collects them in an 2d vector.
    vector<string> v;
    string temp = "";
    for(int i=0;i<s.length();++i){

        if(s[i]==','){
            v.push_back(temp);
            temp = "";
        }
        else{
            temp.push_back(s[i]);
        }
    }
    v.push_back(temp);
    final.push_back(v);
}
void splitStringForQ(string s, vector<string> &v, vector<string> &b){
    // this function split the first line, and collects final states in a vector, collets other states in an other vector
    string temp = "";
    for(int i=0;i<s.length();++i){
        if(s[i]==',' || s[i]==' '){
            if(temp!=""){
                if(temp.front()=='[') {
                    b.push_back(temp.substr(1,temp.size()-2));
                }
                else
                    v.push_back(temp);
            }
            temp = "";
        }
        else if(s[i]!=':' && s[i]!='=' && s[i]!='>' && s[i]!='Q' && s[i]!=':' && s[i]!=' '){
            temp.push_back(s[i]);
        }
    }
    b.push_back(temp.substr(1,temp.size()-2));
}
void splitStringForA(string s, vector<string> &v){
    // I used this function while reading input alphabet. It splits and collect in an vector.
    string temp = "";
    for(int i=0;i<s.length();++i){
        if(s[i]==','){
            v.push_back(temp);
            temp = "";
        }
        else if(s[i]!=':' &&   s[i]!='A' ){
            temp.push_back(s[i]);
        }
    }
    v.push_back(temp);
}
void splitStringForZ(string s, vector<string> &v){
    // I used this function while reading stack alphabet. It splits and collect in an vector.
    string temp = "";
    for(int i=0;i<s.length();++i){
        if(s[i]==','){
            v.push_back(temp);
            temp = "";
        }
        else if(s[i]!=':' &&   s[i]!='Z' ){
            temp.push_back(s[i]);
        }
    }
    v.push_back(temp);
}
void splitStringForT(string s, vector<vector<string>> &final){
    // I used this function while reading transtitions. It splits and collect in an 2d vector.
    vector<string> v;
    string temp = "";
    for(int i=0;i<s.length();++i){
        if(s[i]==','){
            v.push_back(temp);
            temp = "";
        }
        else if(s[i]!=':' &&   s[i]!='T' ){
            temp.push_back(s[i]);
        }
    }
    v.push_back(temp);
    final.push_back(v);
}

void printStack(stack<string> s,ofstream& output,int stacksize,int stacksize2)
{
    // this function prints the stack.
    if (s.empty())
        return;
    string x = s.top();
    s.pop();
    printStack(s,output,stacksize-1,stacksize2);
    if(stacksize==stacksize2){
        // I used this if block to avoid last comma.
        output << x;
    }else {
        output << x << ",";
    }
    s.push(x);
}
void printTranstition(vector<string>v,stack<string> stack,ofstream& output){
    //this line prints the transtition which the program working on
    output<<v[0]<<","<<v[1]<<","<<v[2]<<" => "<<v[3]<<","<<v[4]<<" ";
    output<<"[STACK]:";
    printStack(stack,output,stack.size(),stack.size());
    output<<endl;
}
bool exists_in_vector(vector<string> &states,string s){
    // this function checks whether an element is inside a vector
    for(auto & state : states){
        if(state==s){
            return true;
        }
    }
    return false;
}
bool exists_in_transtitions(vector<vector<string>> &transtitions,string s1){
    // this function checks whether an statement is inside the transtitions
    for(int i=0; i<transtitions.size();i++){
        if(transtitions[i][0]==s1 ){
            return true;
        }
    }
    return false;
}
bool check_dpda(vector<vector<string>> trantitions, vector<vector<string>> operations,vector<string> symbols,vector<string> appendiable,vector<string> states){
    //I used this function to check dpda file is valid or not.
    for(int i=0;i<trantitions.size();i++){
        if(!exists_in_vector(states, trantitions[i][0]) || !exists_in_vector(states, trantitions[i][3])) {
            return false;
        }if(!exists_in_vector(symbols,trantitions[i][1]) && trantitions[i][1]!="e")
            return false;

        if((!exists_in_vector(appendiable,trantitions[i][2]) && trantitions[i][2]!="e")|| (!exists_in_vector(appendiable,trantitions[i][4]) && trantitions[i][4]!="e"))
            return false;
    }
    return true;
}
int main(int argc,char** argv) {
    vector<string> states;
    vector<string> finalStates;
    vector<string> symbols;
    vector<string> appendiable;
    vector<vector<string>> trantitions;
    vector<vector<string>> operations;
    ofstream output(argv[3]);
    ifstream file(argv[1]);

    //This code block reads dpdafile.
    if (file.is_open()) {
        string line;
        while (getline(file, line)) {
            stringstream ss(line);
            if(line.front()=='Q'){
                splitStringForQ(line, states, finalStates);
            }else if(line.front()=='A'){
                splitStringForA(line, symbols);
            //    printVector(symbols);
            }else if(line.front()=='Z'){
                splitStringForZ(line, appendiable);
            //    printVector(appendiable);
            }else if(line.front()=='T'){
                splitStringForT(line,trantitions);
            }
        }
        file.close();
    }

    //this code block reads dpda input file.
    ifstream file2(argv[2]);
    if (file2.is_open()){
        string line;
        while (getline(file2, line)){
            stringstream ss(line);
            splitString(line,operations);
        }
        file2.close();
    }

    //this code block checks dpda file valid or not with a function
    string start=states[states.size()-1].substr(1,states[states.size()-1].length()-2);
    if(!check_dpda(trantitions,operations,symbols,appendiable,states)){
        output << "Error [1]:DPDA description is invalid!" << endl;
        output.close();
        exit(0);
    }
    int i=0;


    //this code block does the all operations after all readings.
    while(i<operations.size()){
        stack<string> myStack;
        stack<string> mySecondStack;
        int j=0;
        int counter=0;
        string lasts[2];
        bool cntrl3=true;
        while(j<operations[i].size()){
            //this code block is used to checks wheter operations are empty or not.
            if(operations[i][0]==""){
                if(exists_in_vector(finalStates,start)){
                    output << "ACCEPT" << endl;
                }else{
                    output << "REJECT" << endl;
                }
                cntrl3=false;
                break;
            }
            //this code blocks is used to start.
            if(counter==0){
                myStack.push(trantitions[0][4]);
                printTranstition(trantitions[0], myStack, output);
                counter++;
                if(trantitions[0][1]==operations[i][j]){
                    j++;
                }
                lasts[0]=trantitions[0][3];
                continue;
            }
            bool cntrl= true;
            bool cntrl2=true;
            //this for loop is making all operations after the starting.
            for(int u=0;u<trantitions.size();u++){
                if(trantitions[u][0]==lasts[0] && trantitions[u][1]==operations[i][j] && trantitions[u][2]==myStack.top()){
                    if(!myStack.empty() && myStack.top()==trantitions[u][2]){
                        myStack.pop();
                    }
                    if(trantitions[u][4]!="e")
                        myStack.push(trantitions[u][4]);
                    printTranstition(trantitions[u], myStack, output);
                    lasts[0]=trantitions[u][3];
                    j++;
                    cntrl=false;
                    cntrl2=false;
                    break;
                }
            }
            if (cntrl){
                for(int u=0;u<trantitions.size();u++){
                    if(trantitions[u][0]==lasts[0] && trantitions[u][1]==operations[i][j] ){
                        if(!myStack.empty() && myStack.top()==trantitions[u][2]  ){
                            myStack.pop();
                        }
                        if(trantitions[u][4]!="e")
                            myStack.push(trantitions[u][4]);
                        printTranstition(trantitions[u], myStack, output);
                        lasts[0]=trantitions[u][3];
                        j++;
                        cntrl2=false;
                        break;
                    }
                }
            }
            if(cntrl2) {
                for (int u = 0; u < trantitions.size(); u++) {
                    if (trantitions[u][0] == lasts[0] && trantitions[u][1]=="e") {
                        if ( !myStack.empty() && myStack.top() == trantitions[u][2]) {
                            myStack.pop();
                        }
                        if(trantitions[u][4]!="e")
                            myStack.push(trantitions[u][4]);
                        printTranstition(trantitions[u], myStack, output);
                        lasts[0] = trantitions[u][3];
                        break;
                    }
                }
            }
            if(!exists_in_transtitions(trantitions,lasts[0])){
                output << "REJECT" << endl;
                cntrl3=false;
                break;
            }
        }

        // the last if block checks we are at the final state or not. Then prints the situation.

        if (cntrl3){
            for(int u=0;u<trantitions.size();u++) {
                if(trantitions[u][0]==lasts[0] && trantitions[u][1]=="e"){
                    if (!myStack.empty() && myStack.top() == trantitions[u][2] ) {
                        myStack.pop();
                    }
                    if (trantitions[u][4] != "e") {
                        myStack.push(trantitions[u][4]);
                    }
                    lasts[0] = trantitions[u][3];
                    printTranstition(trantitions[u], myStack, output);
                    if ((myStack.empty() || (myStack.size() == 1 && myStack.top() == "$")) && exists_in_vector(finalStates, lasts[0])) {
                        output << "ACCEPT" << endl;
                    } else {
                        output << "REJECT" << endl;
                    }
                    break;
                }
            }
        }
        output << endl;
        i++;
    }
    output.close();
    return 0;
}
