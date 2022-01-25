//
// Created by Berat on 26.11.2021.
//

#ifndef BBM201ASSIGNMENT2_DOUBLEDYNAMICLINKEDLIST_H
#define BBM201ASSIGNMENT2_DOUBLEDYNAMICLINKEDLIST_H
#include "PermanentEmployee.h"
struct Node {
    PermanentEmployee* per_emp= new PermanentEmployee(1,2,"ber","er","car",5.4,Date(29,04,2001),Date(29,04,2020),50);
    Node *next=NULL;
    Node *prev=NULL;

    Node(PermanentEmployee *perEmp);

};
class DoubleDynamicLinkedList{
private:
    Node * head=NULL;
    int size=0;
public:
    DoubleDynamicLinkedList();
    bool insertEmployee( Node * newNode );
    void delete_emp(int emp_num);
    bool check(int emp_num);
    void update_title_and_salaryco(int empnum,double salaryco,string title);
    bool display_info_of_anEmployee(int emp_num);
    void bubbleSortForNumber();
    void bubbleSortForAppDate();
    void bubbleSortForAppDateReverse();
    Node *getHead() const;
    int getSize() const;
};



#endif //BBM201ASSIGNMENT2_DOUBLEDYNAMICLINKEDLIST_H
