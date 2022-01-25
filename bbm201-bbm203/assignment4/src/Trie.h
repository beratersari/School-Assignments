
#include <iostream>
using namespace std;
#include "string"
#include <bits/stdc++.h>
#define CHAR_SIZE 128

#ifndef ASSIGNMENT4_TRIE_H
#define ASSIGNMENT4_TRIE_H


class Trie
{
public:
    bool isLeaf;
    Trie* character[CHAR_SIZE];
    char x=' ';
    string meaning;

    // Constructor
    Trie()
    {
        this->isLeaf = false;

        for (int i = 0; i < CHAR_SIZE; i++) {
            this->character[i] = nullptr;
        }
    }

    void insert(string,string,ofstream& output);
    bool search(string,ofstream& output);
    bool deletion(Trie*&, string,string,bool,ofstream& output );
    bool haveChildren(Trie const*);
    void fill_all_words_in_aVector(Trie* root, char* wordArray, vector<string> &, int);
    void mean(string key,ofstream& output);

};

#endif //ASSIGNMENT4_TRIE_H
