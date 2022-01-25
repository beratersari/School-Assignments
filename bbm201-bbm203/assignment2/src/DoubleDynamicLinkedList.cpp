//
// Created by Berat on 26.11.2021.
//

#include <iostream>
#include "DoubleDynamicLinkedList.h"

using namespace std;
bool DoubleDynamicLinkedList::insertEmployee(Node *newNode) {
    if(head==NULL){
        head=newNode;
        size=1;
        return false;
    }

    if(head->next==NULL){
        if(newNode->per_emp->getAppDate()< head->per_emp->getAppDate()) {
            Node *temp;
            temp = newNode;
            temp->next = head;
            head->prev=temp;
            head = temp;
            size+=1;
        }else{
            head->next=newNode;
            newNode->prev=head;
            size+=1;
        }
        return false;
    }
    Node* iter=head;
    while(iter->next != NULL && iter->next->per_emp->getAppDate() < newNode->per_emp->getAppDate()){
        iter=iter->next;
    }
    Node* temp=newNode;
    temp->next=iter->next;
    temp->prev=iter;
    iter->next=temp;
    size+=1;
    return false;
}


void DoubleDynamicLinkedList::delete_emp(int emp_num) {
    Node* temp;
    Node* iter=head;
    if(head==NULL){
        cout<<"There is no one in Permanent Employees with this number.";
        return;
    }
    if(head->per_emp->getEmployeeNumber()==emp_num){
        temp=head;
        head=head->next;
        free(temp);
        size-=1;
        return;
    }
    while(iter->next!=NULL && iter->next->per_emp->getEmployeeNumber()!=emp_num){
        iter=iter->next;
    }if(iter->next==NULL){
        cout<<"Employee did not be found in Permanent Employees."<<endl;
        return;
    }
    temp=iter->next;
    iter->next=iter->next->next;
    free(temp);
    size-=1;
    if(iter->next!=NULL){
        iter->next->prev=iter;
    }

}

bool DoubleDynamicLinkedList::check(int emp_num) {
    Node* temp=head;
    while(temp!=NULL){
        if(temp->per_emp->getEmployeeNumber()==emp_num){
            return true;
        }
        temp=temp->next;
    }

    return false;
}

void DoubleDynamicLinkedList::update_title_and_salaryco(int empnum, double salaryco, string title) {
    Node* temp=head;
    while(temp!=NULL){
        if(temp->per_emp->getEmployeeNumber()==empnum){
            temp->per_emp->setTitle(title);
            temp->per_emp->setSalaryCoef(salaryco);
            cout<<"UPDATED.";
            return;
        }
        temp=temp->next;
    }
}

bool DoubleDynamicLinkedList::display_info_of_anEmployee(int emp_num) {
    Node* temp=head;
    while(temp!=NULL){
        if(temp->per_emp->getEmployeeNumber()==emp_num){
            cout<<*(temp->per_emp)<<endl;
            return true;
        }
        temp=temp->next;
    }
    return false;

}

void DoubleDynamicLinkedList::bubbleSortForNumber() {
    int swapp, i;
    struct Node *ptr1;
    struct Node *lptr = NULL;
    if (head == NULL)
        return;
    do
    {
        swapp = 0;
        ptr1 = head;
        while (ptr1->next != lptr)
        {
            if (ptr1->per_emp->getEmployeeNumber() > ptr1->next->per_emp->getEmployeeNumber())
            {
                swap(ptr1->per_emp, ptr1->next->per_emp);
                swapp = 1;
            }
            ptr1 = ptr1->next;
        }
        lptr = ptr1;
    }
    while (swapp);

}

void DoubleDynamicLinkedList::bubbleSortForAppDate() {
    int swapp, i;
    struct Node *ptr1;
    struct Node *lptr = NULL;
    if (head == NULL)
        return;
    do
    {
        swapp = 0;
        ptr1 = head;
        while (ptr1->next != lptr)
        {
            if (ptr1->per_emp->getAppDate() > ptr1->next->per_emp->getAppDate())
            {
                swap(ptr1->per_emp, ptr1->next->per_emp);
                swapp = 1;
            }
            ptr1 = ptr1->next;
        }
        lptr = ptr1;
    }
    while (swapp);

}

void DoubleDynamicLinkedList::bubbleSortForAppDateReverse() {
    int swapp, i;
    struct Node *ptr1;
    struct Node *lptr = NULL;
    if (head == NULL)
        return;
    do
    {
        swapp = 0;
        ptr1 = head;
        while (ptr1->next != lptr)
        {
            if (ptr1->per_emp->getAppDate() < ptr1->next->per_emp->getAppDate())
            {
                swap(ptr1->per_emp, ptr1->next->per_emp);
                swapp = 1;
            }
            ptr1 = ptr1->next;
        }
        lptr = ptr1;
    }
    while (swapp);

}
Node *DoubleDynamicLinkedList::getHead() const {
    return head;
}

int DoubleDynamicLinkedList::getSize() const {
    return size;
}

DoubleDynamicLinkedList::DoubleDynamicLinkedList() = default;

Node::Node(PermanentEmployee *perEmp) : per_emp(perEmp) {}
