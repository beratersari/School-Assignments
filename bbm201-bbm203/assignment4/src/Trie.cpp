#include "Trie.h"
#include <bits/stdc++.h>
#include "utilities.h"
#include <utility>
#include <string>

void Trie::insert(string key,string value,ofstream& output)
{
    Trie* curr = this;
    for (int i = 0; i < key.length(); i++)
    {
        if (curr->character[key[i]] == nullptr) {
            curr->character[key[i]] = new Trie();
        }
        curr = curr->character[key[i]];
    }
    if(curr->isLeaf and curr->meaning == value){
        // if there is already a key with given key and value, it doesnt do anything
        output<<"\""<<key<<"\""<<" already exists."<<endl;
        return;
    }else if( curr->isLeaf){
        //if there is a key with given key but value is different. it updates the key.
        output<<"\""<<key<<"\" was updated."<<endl;
        curr->meaning= std::move(value);
        return;
    }
    //lastly if there is no same element with given key. It creates a new key
    curr->isLeaf = true;
    curr->meaning= std::move(value);
    output<<"\""<<key<<"\""<<" was added."<<endl;
}

bool Trie::search(string key,ofstream& output)
{
    if (this == nullptr) {
        return false;
    }

    Trie* curr = this;

    for (int i = 0; i < key.length(); i++)
    {
        curr = curr->character[key[i]];
        if (curr == nullptr and i==0) {
            //if the first char doesnt exists. it prints "no record"
            output<<"\"no record\""<<endl;
            return false;
        }else if(curr== nullptr){
            // if some of characters exists but remainders doesnt exists in trie, it prints "incorrect Dothraki word"
            output<<"\"incorrect Dothraki word\""<<endl;
            return false;
        }
    }

    if(curr->isLeaf){
        //if exists directly it prints mean of key.
        output<<"\"The english equivalent is "<<curr->meaning<<"\""<<endl;
        return curr->isLeaf;
    }else{
        //if all chars in the trie but there is no mean of last character, it prints not enough Dothraki word.
        output<<"\"not enough Dothraki word.\""<<endl;
    }
    return curr->isLeaf;
}

// this code block finds the mean of given key and writes it outputfile.
void Trie::mean(string key,ofstream& output)
{
    if (this == nullptr) {
        return;
    }
    Trie* curr = this;
    for (int i = 0; i < key.length(); i++)
    {
        curr = curr->character[key[i]];
        if (curr == nullptr and i==0) {
            return;
        }else if(curr== nullptr){
            return;
        }
    }
    if(curr->isLeaf){
        output<<"("<<curr->meaning<<")";
        return;
    }
}
//this code block checks  whether a character has a child
bool Trie::haveChildren(Trie const* curr)
{
    for (int i = 0; i < CHAR_SIZE; i++)
    {
        if (curr->character[i]) {
            return true;    // child found
        }
    }

    return false;
}
// this code block delete the key.
bool Trie::deletion(Trie*& curr, string key, string key1, bool control,ofstream& output)
{
    if(!control ){
        //if first character is different it prints no record
        if(curr->character[key[0]]== nullptr) {
            output << "\"no record\"" << endl;
            return false;
        }
        control= true;
    }
    if (key.length())
    {
        if (curr!= nullptr && curr->character[key[0]] != nullptr &&
            deletion(curr->character[key[0]], key.substr(1),key1,control, output) &&
            !curr->isLeaf)
        {

            if (!haveChildren(curr))
            {
                delete curr;
                curr = nullptr;
                return true;
            }
            else {
                return false;
            }
        }
    }
    if(key.length() != 0 && curr->character[key[0]] == nullptr){
        output<<"\""<<"incorrect Dothraki word"<<"\""<<endl;
        return false;
    }
    if (key.length() == 0)
    {
        if (!haveChildren(curr))
        {
            if(!curr->isLeaf){
                output<<"\""<<"not enough Dothraki word"<<"\""<<endl;
                return false;
            }
            else{
                output<<"\""<<key1<<"\""<<" deletion is successful"<<endl;
                delete curr;
                curr = nullptr;
                return true;
            }
        }
        else {
            if(!curr->isLeaf){
                output<<"\""<<"not enough Dothraki word"<<"\""<<endl;
                return false;
            }
            else{
                output<<"\""<<key1<<"\""<<" deletion is successful"<<endl;
                curr->isLeaf = false;
                return false;
            }
        }
    }

    return false;
}

//this code block fill all words in a vector.
void Trie::fill_all_words_in_aVector(Trie* root, char* wordArray, vector<string> &v, int pos = 0)
{
    if(root == NULL)
        return  ;
    if(root->isLeaf)
    {
        printWord(wordArray, pos,v);
    }
    for(int i=96; i<CHAR_SIZE; i++)
    {
        if(root->character[i] != NULL)
        {
            wordArray[pos] = i;
            fill_all_words_in_aVector(root->character[i], wordArray, v, pos + 1);
        }
    }
}

