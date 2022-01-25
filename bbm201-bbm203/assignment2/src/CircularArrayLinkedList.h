//
// Created by Berat on 27.11.2021.
//

#ifndef ASS2LAST_CIRCULARARRAYLINKEDLIST_H
#define ASS2LAST_CIRCULARARRAYLINKEDLIST_H

#include "Employee.h"
#include "NodeTemporary.h"



class CircularArrayLinkedList {
private:
    NodeTemporary *temporaryarr=new NodeTemporary[20];
    int index_of_top=-1;
    int size=0;
    int free=0;
    int tail=-1;
    int tail_of_frees=19;
public:
    int getIndexOfTop() const;
    int getSize() const;
    int getFree() const;
    int getTail() const;
    int getTailOfFrees() const;
    NodeTemporary *getTemporaryarr() const;
    void fill_the_arr();
    bool check(int emp_num);
    void insert(NodeTemporary* node);
    void del_the_emp(int emp_number);
    void update_title_and_salaryco(int empnum,double salaryco,string title);
    bool display_info_of_anEmployee(int emp_num);
    void sortForAppDate();
    void sortForNumber();
    void sortForAppDateReverse();
};


#endif //ASS2LAST_CIRCULARARRAYLINKEDLIST_H
