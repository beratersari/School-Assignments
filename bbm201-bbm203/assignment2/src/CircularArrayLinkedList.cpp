//
// Created by Berat on 27.11.2021.
//

#include <iostream>
#include "CircularArrayLinkedList.h"




void CircularArrayLinkedList::fill_the_arr() {
    for (int i=0;i<19;i++){
        temporaryarr[i].next=i+1;
    }
    temporaryarr[19].next=0;

}
void CircularArrayLinkedList::insert(NodeTemporary* node) {
    if(size==20){
        cout<<"Error! There is no more empty field."<<endl;
        return;
    }
    if(size==0){
        temporaryarr[0].data=node->data;
        temporaryarr[0].next=0;
        size=1;
        free=1;
        temporaryarr[tail_of_frees].next=free;
        index_of_top=0;
        tail=0;
    }else if(node->data->getEmployeeNumber()<temporaryarr[index_of_top].data->getEmployeeNumber()){
        int newIndex=free;
        temporaryarr[tail].next=newIndex;
        temporaryarr[newIndex].data=node->data;
        free=temporaryarr[free].next;
        temporaryarr[tail_of_frees].next=free;
        temporaryarr[newIndex].next=index_of_top;
        index_of_top=newIndex;
        size+=1;
        if(size==20){
            free=-1;
            tail_of_frees=-1;
        }
    }else{
        int temp=temporaryarr[index_of_top].next;
        if(node->data->getEmployeeNumber()<temporaryarr[temp].data->getEmployeeNumber()){
            int newIndex=free;
            free=temporaryarr[free].next;
            temporaryarr[tail_of_frees].next=free;
            temporaryarr[index_of_top].next=newIndex;
            temporaryarr[newIndex].next=temp;
            temporaryarr[newIndex].data=node->data;
            size+=1;
            if(size==20){
                free=-1;
                tail_of_frees=-1;
            }
        }else{
            bool control= false;
            while(temp!=index_of_top){
                if(node->data->getEmployeeNumber()<temporaryarr[temporaryarr[temp].next].data->getEmployeeNumber()){
                    int newIndex=free;
                    free=temporaryarr[free].next;
                    temporaryarr[tail_of_frees].next=free;
                    temporaryarr[newIndex].next=temporaryarr[temp].next;
                    temporaryarr[temp].next=newIndex;
                    temporaryarr[newIndex].data=node->data;
                    size+=1;
                    control= true;
                    if(size==20){
                        free=-1;
                        tail_of_frees=-1;
                    }
                    break;
                }
                temp=temporaryarr[temp].next;
            }
            if(!control){
                int newIndex=free;
                free=temporaryarr[free].next;
                temporaryarr[tail_of_frees].next=free;
                temporaryarr[newIndex].next=index_of_top;
                temporaryarr[tail].next=newIndex;
                tail=newIndex;
                temporaryarr[newIndex].data=node->data;
                size+=1;
                if(size==20){
                    free=-1;
                    tail_of_frees=-1;
                }


            }
        }

    }
}

NodeTemporary *CircularArrayLinkedList::getTemporaryarr() const {
    return temporaryarr;
}

int CircularArrayLinkedList::getIndexOfTop() const {
    return index_of_top;
}

int CircularArrayLinkedList::getSize() const {
    return size;
}

int CircularArrayLinkedList::getFree() const {
    return free;
}

int CircularArrayLinkedList::getTail() const {
    return tail;
}

int CircularArrayLinkedList::getTailOfFrees() const {
    return tail_of_frees;
}

void CircularArrayLinkedList::del_the_emp(int emp_number) {
    int temp0=temporaryarr[index_of_top].next;
    bool control1=true;
    if(size==0){
        return;
    }
    if(temporaryarr[index_of_top].data->getEmployeeNumber()==emp_number){
        control1= false;
    }
    while(temp0!=index_of_top){
        if(temporaryarr[temp0].data->getEmployeeNumber()==emp_number){
            control1= false;
            break;
        }
        temp0=temporaryarr[temp0].next;
    }
    if(control1){
        cout<<"Employee can not be found in Temporary Employees."<<endl;
        return;
    }
    bool control=false;
    if(size==1 && temporaryarr[index_of_top].data->getEmployeeNumber()==emp_number){
        delete temporaryarr[index_of_top].data;
        cout<<"Employee is deleted from the Temporary Employees."<<endl;
        size=0;
        free=index_of_top;
        temporaryarr[free].next=temporaryarr[tail_of_frees].next;
        temporaryarr[tail_of_frees].next=free;
        index_of_top=-1;
        tail=-1;
        control= true;
    //bastan silme
    }else if(temporaryarr[index_of_top].data->getEmployeeNumber()==emp_number){
        delete temporaryarr[index_of_top].data;
        cout<<"Employee is deleted from the Temporary Employees."<<endl;
        if(size==20){
            free=index_of_top;
            tail_of_frees=index_of_top;
            index_of_top=temporaryarr[index_of_top].next;
            temporaryarr[tail].next=index_of_top;
            temporaryarr[free].next=free;
            temporaryarr[tail_of_frees].next=free;
            size-=1;
            return;
        }
        size-=1;
        temporaryarr[tail].next=temporaryarr[index_of_top].next;
        free=index_of_top;
        index_of_top=temporaryarr[index_of_top].next;
        temporaryarr[free].next=temporaryarr[tail_of_frees].next;
        temporaryarr[tail_of_frees].next=free;
        control= true;
    }else if(temporaryarr[tail].data->getEmployeeNumber()==emp_number){
        //sondan silme
        int temp=index_of_top;
        while(temporaryarr[temp].next!=tail){
            temp=temporaryarr[temp].next;
        }
        delete temporaryarr[tail].data;
        cout<<"Employee is deleted from the Temporary Employees."<<endl;
        if(size==20){
            free=tail;
            tail_of_frees=tail;
            tail=temp;
            temporaryarr[tail].next=index_of_top;
            temporaryarr[free].next=free;
            size-=1;
            return;
        }
        size-=1;
        int nextoffree=free;
        free=tail;
        tail=temp;
        temporaryarr[tail].next=index_of_top;
        temporaryarr[tail_of_frees].next=free;
        temporaryarr[free].next=nextoffree;
        control= true;
    }
    else{
        //2.siradakini silme
        int temp=temporaryarr[index_of_top].next;
        if(temporaryarr[temp].data->getEmployeeNumber()==emp_number){
            delete temporaryarr[temp].data;
            cout<<"Employee is deleted from the Temporary Employees."<<endl;

            if(size==20){
                free=temp;
                tail_of_frees=temp;
                temporaryarr[index_of_top].next=temporaryarr[temp].next;
                temporaryarr[free].next=temp;
                temporaryarr[tail_of_frees].next=temp;
                size-=1;
                return;
            }

            int oldfree=free;
            temporaryarr[index_of_top].next=temporaryarr[temp].next;
            free=temp;
            temporaryarr[free].next=oldfree;
            temporaryarr[tail_of_frees].next=free;
            size-=1;
        }else{
            while(temp!=index_of_top){
                if(emp_number==temporaryarr[temporaryarr[temp].next].data->getEmployeeNumber()){
                    delete temporaryarr[temporaryarr[temp].next].data;
                    cout<<"Employee is deleted from the Temporary Employees."<<endl;
                    if(size==20){
                        free=temporaryarr[temp].next;
                        tail_of_frees=temporaryarr[temp].next;
                        temporaryarr[temp].next=temporaryarr[temporaryarr[temp].next].next;
                        temporaryarr[free].next=temporaryarr[temp].next;
                        temporaryarr[tail_of_frees].next=temporaryarr[temp].next;
                        size-=1;
                        return;
                    }
                    size-=1;
                    int oldfree=free;
                    free=temporaryarr[temp].next;
                    temporaryarr[temp].next=temporaryarr[temporaryarr[temp].next].next;
                    temporaryarr[free].next=oldfree;
                    temporaryarr[tail_of_frees].next=free;
                    break;
                }
                temp=temporaryarr[temp].next;
            }

            }
        }
    }

bool CircularArrayLinkedList::check(int emp_num) {
    if (size==0){
        return false;
    }
    int curr=index_of_top;
    if(temporaryarr[curr].data->getEmployeeNumber()==emp_num){
        return true;
    }else{
        curr=temporaryarr[curr].next;
        while(curr!=index_of_top){
            if(temporaryarr[curr].data->getEmployeeNumber()==emp_num)
                return true;
            curr=temporaryarr[curr].next;
        }
    }
    return false;
}
void CircularArrayLinkedList::update_title_and_salaryco(int empnum, double salaryco, string title) {

    int curr=index_of_top;
    if(temporaryarr[curr].data->getEmployeeNumber()==empnum){
        temporaryarr[curr].data->setSalaryCoef(salaryco);
        temporaryarr[curr].data->setTitle(title);
        cout<<"UPDATED"<<endl;
        return;
    }else{
        curr=temporaryarr[curr].next;
        while(curr!=index_of_top){
            if(temporaryarr[curr].data->getEmployeeNumber()==empnum){
                temporaryarr[curr].data->setSalaryCoef(salaryco);
                temporaryarr[curr].data->setTitle(title);
                cout<<"UPDATED"<<endl;
                return;
            }
            curr=temporaryarr[curr].next;
        }
    }
}

bool CircularArrayLinkedList::display_info_of_anEmployee(int emp_num) {
    if (size==0){
        return false;
    }
    int curr=index_of_top;
    if(temporaryarr[curr].data->getEmployeeNumber()==emp_num){
        cout<<*(temporaryarr[curr].data)<<endl;
        return true;
    }else{
        curr=temporaryarr[curr].next;
        while(curr!=index_of_top){
            if(temporaryarr[curr].data->getEmployeeNumber()==emp_num){
                cout<<*(temporaryarr[curr].data)<<endl;
                return true;
            }
            curr=temporaryarr[curr].next;
        }
    }
    return false;
}

void CircularArrayLinkedList::sortForAppDate() {
    if(size==0)
        return;
    int temp=index_of_top;
    while(temporaryarr[temp].next!=index_of_top)
    {
        int temp1;
        temp1=temporaryarr[temp].next;
        while(temp1!=index_of_top)
        {
            if(temporaryarr[temp1].data->getAppDate()<temporaryarr[temp].data->getAppDate())
            {
                swap(temporaryarr[temp].data,temporaryarr[temp1].data);
            }
            temp1=temporaryarr[temp1].next;
        }
        temp=temporaryarr[temp].next;
    }

}

void CircularArrayLinkedList::sortForNumber() {
    if(size==0)
        return;
    int temp=index_of_top;
    while(temporaryarr[temp].next!=index_of_top)
    {
        int temp1;
        temp1=temporaryarr[temp].next;
        while(temp1!=index_of_top)
        {
            if(temporaryarr[temp1].data->getEmployeeNumber()<temporaryarr[temp].data->getEmployeeNumber())
            {
                swap(temporaryarr[temp].data,temporaryarr[temp1].data);
            }
            temp1=temporaryarr[temp1].next;
        }
        temp=temporaryarr[temp].next;
    }

}

void CircularArrayLinkedList::sortForAppDateReverse() {
    if(size==0)
        return;
    int temp=index_of_top;
    while(temporaryarr[temp].next!=index_of_top)
    {
        int temp1;
        temp1=temporaryarr[temp].next;
        while(temp1!=index_of_top)
        {
            if(temporaryarr[temp1].data->getAppDate()>temporaryarr[temp].data->getAppDate())
            {
                swap(temporaryarr[temp].data,temporaryarr[temp1].data);
            }
            temp1=temporaryarr[temp1].next;
        }
        temp=temporaryarr[temp].next;
    }

}









