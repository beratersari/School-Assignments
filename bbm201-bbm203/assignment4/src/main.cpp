#include <iostream>
using namespace std;

#include "Trie.h"
#include "queue"
#include <deque>

int main(int argc,char** argv)
{
    Trie* head = new Trie();
    ifstream inputfile(argv[1]);


    if(inputfile.is_open()){
        string line;
        ofstream output(argv[2]);
        while (getline(inputfile,line)){
            char firstChar=line[0];
            //if the first character of line is i, it inserts an element in trie
            if(firstChar=='i'){
                line=line.substr(7,line.length()-8);
                istringstream in;
                in.str(line);
                string key,value;
                int control=0;
                for(string temp;getline(in,temp,',');){
                    if(control == 0)
                        key=temp;
                    else{
                        value=temp;
                    }
                    control++;
                }
                head->insert(key,value,output);
            }
                //if the first character of line is s, it searchs given key
            else if(firstChar=='s'){
                line=line.substr(7,line.length()-8);
                head->search(line,output);
            }
                //if the first character of line is d, it deletes given key
            else if(firstChar=='d'){
                line=line.substr(7,line.length()-8);
                string line2=line;
                head->deletion(head,line,line2,false,output);
            }   //if it is not all of above, it lists all elements in trie.
            else{
                int level = 0;
                char str[0];
                // i fill all elements in a vector first.
                vector<string> v;
                head->fill_all_words_in_aVector(head, str, v, level);
                // i used deques, while printing
                deque<int> sequence;
                deque<string> words;
                for (int i=0;i<v.size()-1;i++){
                    int j=0;
                    int counter=0;
                    while (true) {

                        if ( (v[i].substr(j,1)==v[i+1].substr(j,1))){
                            counter++;
                        }else{
                            break;
                        }
                        j++;
                    }
                    sequence.push_front(counter);
                    words.push_front(v[i]);
                    if(sequence.size()==1 && sequence.front()==0){
                        output<<"-"<<words.back();
                        head->mean(words.back(),output);
                        output<<endl;
                        sequence.pop_back();
                        words.pop_back();
                    }
                    else if(sequence.front()==0){
                        sequence.pop_front();

                        int old=-1;
                        int u=1;
                        int l=0;
                        while(!sequence.empty()){
                            if(sequence.back()>0 && sequence.back()!=old){
                                if(l>1)
                                    l=1;
                                for(int k=0;k<l;k++)
                                    output<<"\t";
                                output<<"-"<<words.back().substr(0,sequence.back())<<endl;
                                if(u>2)
                                    u=2;
                                for(int k=0;k<u;k++)
                                    output<<"\t";
                                l+=1;
                                u+=1;
                                output<<words.back();
                                head->mean(words.back(),output);
                                output<<endl;
                                old=sequence.back();
                                sequence.pop_back();
                                words.pop_back();
                            }else if(sequence.back()>0){
                                if(l>1)
                                    l=1;
                                for(int k=0;k<l;k++)
                                    output<<"\t";
                                output<<words.back();
                                head->mean(words.back(),output);
                                output<<endl;
                                old=sequence.back();
                                words.pop_back();
                                sequence.pop_back();
                            }

                        }
                        if(!words.empty()){
                            if(l>2)
                                l=2;
                            for(int k=0;k<l;k++)
                                output<<"\t";
                            output<<words.back();
                            head->mean(words.back(),output);
                            output<<endl;
                            words.pop_back();
                        }
                        if(i==(v.size()-2)){
                            j=0;
                            counter=0;
                            while (true) {

                                if ( (v[i].substr(j,1)==v[i+1].substr(j,1))){
                                    counter++;
                                }else{
                                    break;
                                }
                                j++;
                            }
                            if(counter>0){
                                if(l>1)
                                    l=1;
                                for(int k=0;k<l;k++)
                                    output<<"\t";
                                output<<"-"<<v[i+1];
                                head->mean(v[i+1],output);
                                output<<endl;
                            }else{
                                output<<"-"<<v[i+1];
                                head->mean(v[i+1],output);
                                output<<endl;
                            }
                        }
                    }else if(!sequence.empty() && i==v.size()-2){
                        int old=-1;
                        int u=1;
                        int l=0;
                        while(!sequence.empty()){
                            if(sequence.back()>0 && sequence.back()!=old){
                                if(l>1)
                                    l=1;
                                for(int k=0;k<l;k++)
                                    output<<"\t";
                                output<<"-"<<words.back().substr(0,sequence.back())<<endl;
                                if(u>1)
                                    u=1;
                                for(int k=0;k<u;k++)
                                    output<<"\t";
                                l+=1;
                                u+=1;
                                output<<words.back();
                                head->mean(words.back(),output);
                                output<<endl;
                                old=sequence.back();
                                sequence.pop_back();
                                words.pop_back();
                            }else if(sequence.back()>0){
                                if(l>1)
                                    l=1;
                                for(int k=0;k<l;k++)
                                    output<<"\t";
                                output<<words.back();
                                head->mean(words.back(),output);
                                output<<endl;
                                old=sequence.back();
                                words.pop_back();
                                sequence.pop_back();
                            }

                        }

                        if(words.size()>0){
                            if(l>1)
                                l=1;
                            for(int k=0;k<l;k++)
                                output<<"\t";
                            output<<words.back();
                            head->mean(words.back(),output);
                            output<<endl;
                            words.pop_back();
                        }


                        if(i==(v.size()-2)){
                            j=0;
                            counter=0;
                            while (true) {

                                if ( (v[i].substr(j,1)==v[i+1].substr(j,1))){
                                    counter++;
                                }else{
                                    break;
                                }
                                j++;
                            }
                            if(counter>0){
                                if(l>1)
                                    l=1;
                                for(int k=0;k<l;k++)
                                    output<<"\t";
                                output<<"-"<<v[i+1];
                                head->mean(v[i+1],output);
                                output<<endl;
                            }else{
                                output<<"-"<<v[i+1];
                                head->mean(v[i+1],output);
                                output<<endl;
                            }
                        }
                    }
                }
            }
        }
        output.close();
    }

    inputfile.close();

    return 0;
}