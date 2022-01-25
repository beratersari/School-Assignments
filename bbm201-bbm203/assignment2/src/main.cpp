#include <iostream>
using namespace std;
#include "CircularArrayLinkedList.h"
#include "DoubleDynamicLinkedList.h"

void command6(CircularArrayLinkedList circularArrayLinkedList,DoubleDynamicLinkedList doubleDynamicLinkedList){
    int size0=circularArrayLinkedList.getSize();
    int size1=doubleDynamicLinkedList.getSize();
    int firstPos = 0, secondPos = 0;
    int currCir = circularArrayLinkedList.getIndexOfTop();
    Node* currDouble=doubleDynamicLinkedList.getHead();

    for (int i = 0; i < size0+size1; i++) {
        if (firstPos < size0 && secondPos < size1) {
            if (currDouble->per_emp->getEmployeeNumber() < circularArrayLinkedList.getTemporaryarr()[currCir].data->getEmployeeNumber()) {
                cout<<*(currDouble->per_emp);
                currDouble=currDouble->next;
                secondPos++;
            }
            else {
                cout<<*(circularArrayLinkedList.getTemporaryarr()[currCir].data);
                currCir=circularArrayLinkedList.getTemporaryarr()[currCir].next;
                firstPos++;
            }
        }
        else if (secondPos < size1) {
            cout<<*(currDouble->per_emp);
            currDouble=currDouble->next;
            secondPos++;
        }
        else {
            cout<<*(circularArrayLinkedList.getTemporaryarr()[currCir].data);
            currCir=circularArrayLinkedList.getTemporaryarr()[currCir].next;
            firstPos++;
        }
    }

}
void command7(CircularArrayLinkedList circularArrayLinkedList,DoubleDynamicLinkedList doubleDynamicLinkedList){
    int size0=circularArrayLinkedList.getSize();
    int size1=doubleDynamicLinkedList.getSize();
    int firstPos = 0, secondPos = 0;
    int currCir = circularArrayLinkedList.getIndexOfTop();
    Node* currDouble=doubleDynamicLinkedList.getHead();

    for (int i = 0; i < size0+size1; i++) {
        if (firstPos < size0 && secondPos < size1) {
            if (currDouble->per_emp->getAppDate() < circularArrayLinkedList.getTemporaryarr()[currCir].data->getAppDate()) {
                cout<<*(currDouble->per_emp);
                currDouble=currDouble->next;
                secondPos++;
            }
            else {
                cout<<*(circularArrayLinkedList.getTemporaryarr()[currCir].data);
                currCir=circularArrayLinkedList.getTemporaryarr()[currCir].next;
                firstPos++;
            }
        }
        else if (secondPos < size1) {
            cout<<*(currDouble->per_emp);
            currDouble=currDouble->next;
            secondPos++;
        }
        else {
            cout<<*(circularArrayLinkedList.getTemporaryarr()[currCir].data);
            currCir=circularArrayLinkedList.getTemporaryarr()[currCir].next;
            firstPos++;
        }
    }
}

void command8(CircularArrayLinkedList circularArrayLinkedList,DoubleDynamicLinkedList doubleDynamicLinkedList,const Date& year){
    int size0=circularArrayLinkedList.getSize();
    int size1=doubleDynamicLinkedList.getSize();
    int firstPos = 0, secondPos = 0;
    int currCir = circularArrayLinkedList.getIndexOfTop();
    Node* currDouble=doubleDynamicLinkedList.getHead();

    for (int i = 0; i < size0+size1; i++) {
        if (firstPos < size0 && secondPos < size1) {
            if (currDouble->per_emp->getAppDate() > circularArrayLinkedList.getTemporaryarr()[currCir].data->getAppDate()) {

                if(currDouble->per_emp->getAppDate()>year)
                    cout<<*(currDouble->per_emp);
                currDouble=currDouble->next;
                secondPos++;
            }
            else {
                if(circularArrayLinkedList.getTemporaryarr()[currCir].data->getAppDate()>year)
                    cout<<*(circularArrayLinkedList.getTemporaryarr()[currCir].data);
                currCir=circularArrayLinkedList.getTemporaryarr()[currCir].next;
                firstPos++;
            }
        }
        else if (secondPos < size1) {
            if(currDouble->per_emp->getAppDate()>year)
                cout<<*(currDouble->per_emp);
            currDouble=currDouble->next;
            secondPos++;
        }
        else {
            if(circularArrayLinkedList.getTemporaryarr()[currCir].data->getAppDate()>year)
                cout<<*(circularArrayLinkedList.getTemporaryarr()[currCir].data);
            currCir=circularArrayLinkedList.getTemporaryarr()[currCir].next;
            firstPos++;
        }
    }
}

void command9(CircularArrayLinkedList circularArrayLinkedList,DoubleDynamicLinkedList doubleDynamicLinkedList,int year){
    int size0=circularArrayLinkedList.getSize();
    int size1=doubleDynamicLinkedList.getSize();
    int firstPos = 0, secondPos = 0;
    int currCir = circularArrayLinkedList.getIndexOfTop();
    Node* currDouble=doubleDynamicLinkedList.getHead();

    for (int i = 0; i < size0+size1; i++) {
        if (firstPos < size0 && secondPos < size1) {
            if (currDouble->per_emp->getAppDate() < circularArrayLinkedList.getTemporaryarr()[currCir].data->getAppDate()) {

                if(currDouble->per_emp->getAppDate().getYear()==year)
                    cout<<*(currDouble->per_emp);
                currDouble=currDouble->next;
                secondPos++;
            }
            else {
                if(circularArrayLinkedList.getTemporaryarr()[currCir].data->getAppDate().getYear()==year)
                    cout<<*(circularArrayLinkedList.getTemporaryarr()[currCir].data);
                currCir=circularArrayLinkedList.getTemporaryarr()[currCir].next;
                firstPos++;
            }
        }
        else if (secondPos < size1) {
            if(currDouble->per_emp->getAppDate().getYear()==year)
                cout<<*(currDouble->per_emp);
            currDouble=currDouble->next;
            secondPos++;
        }
        else {
            if(circularArrayLinkedList.getTemporaryarr()[currCir].data->getAppDate().getYear()==year)
                cout<<*(circularArrayLinkedList.getTemporaryarr()[currCir].data);
            currCir=circularArrayLinkedList.getTemporaryarr()[currCir].next;
            firstPos++;
        }
    }
}

void command10(CircularArrayLinkedList circularArrayLinkedList,DoubleDynamicLinkedList doubleDynamicLinkedList,const Date& date){
    int size0=circularArrayLinkedList.getSize();
    int size1=doubleDynamicLinkedList.getSize();
    int firstPos = 0, secondPos = 0;
    int currCir = circularArrayLinkedList.getIndexOfTop();
    Node* currDouble=doubleDynamicLinkedList.getHead();

    for (int i = 0; i < size0+size1; i++) {
        if (firstPos < size0 && secondPos < size1) {
            if (currDouble->per_emp->getBirthday() < circularArrayLinkedList.getTemporaryarr()[currCir].data->getAppDate()) {

                if(currDouble->per_emp->getBirthday() < date)
                    cout<<*(currDouble->per_emp);
                currDouble=currDouble->next;
                secondPos++;
            }
            else {
                if(circularArrayLinkedList.getTemporaryarr()[currCir].data->getBirthday() < date)
                    cout<<*(circularArrayLinkedList.getTemporaryarr()[currCir].data);
                currCir=circularArrayLinkedList.getTemporaryarr()[currCir].next;
                firstPos++;
            }
        }
        else if (secondPos < size1) {
            if(currDouble->per_emp->getBirthday() < date)
                cout<<*(currDouble->per_emp);
            currDouble=currDouble->next;
            secondPos++;
        }
        else {
            if(circularArrayLinkedList.getTemporaryarr()[currCir].data->getBirthday() < date)
                cout<<*(circularArrayLinkedList.getTemporaryarr()[currCir].data);
            currCir=circularArrayLinkedList.getTemporaryarr()[currCir].next;
            firstPos++;
        }
    }
}

void command11(CircularArrayLinkedList circularArrayLinkedList,DoubleDynamicLinkedList doubleDynamicLinkedList,int month){
    int size0=circularArrayLinkedList.getSize();
    int size1=doubleDynamicLinkedList.getSize();
    int firstPos = 0, secondPos = 0;
    int currCir = circularArrayLinkedList.getIndexOfTop();
    Node* currDouble=doubleDynamicLinkedList.getHead();

    for (int i = 0; i < size0+size1; i++) {
        if (firstPos < size0 && secondPos < size1) {
            if (currDouble->per_emp->getEmployeeNumber() < circularArrayLinkedList.getTemporaryarr()[currCir].data->getEmployeeNumber()) {

                if(currDouble->per_emp->getAppDate().getMonth()==month)
                    cout<<*(currDouble->per_emp);
                currDouble=currDouble->next;
                secondPos++;
            }
            else {
                if(circularArrayLinkedList.getTemporaryarr()[currCir].data->getAppDate().getMonth()==month)
                    cout<<*(circularArrayLinkedList.getTemporaryarr()[currCir].data);
                currCir=circularArrayLinkedList.getTemporaryarr()[currCir].next;
                firstPos++;
            }
        }
        else if (secondPos < size1) {
            if(currDouble->per_emp->getAppDate().getMonth()==month)
                cout<<*(currDouble->per_emp);
            currDouble=currDouble->next;
            secondPos++;
        }
        else {
            if(circularArrayLinkedList.getTemporaryarr()[currCir].data->getAppDate().getMonth()==month)
                cout<<*(circularArrayLinkedList.getTemporaryarr()[currCir].data);
            currCir=circularArrayLinkedList.getTemporaryarr()[currCir].next;
            firstPos++;
        }
    }
}

void command12(CircularArrayLinkedList circularArrayLinkedList,DoubleDynamicLinkedList doubleDynamicLinkedList,string title){
    int size0=circularArrayLinkedList.getSize();
    int size1=doubleDynamicLinkedList.getSize();
    int firstPos = 0, secondPos = 0;
    int currCir = circularArrayLinkedList.getIndexOfTop();
    Node* currDouble=doubleDynamicLinkedList.getHead();

    for (int i = 0; i < size0+size1; i++) {
        if (firstPos < size0 && secondPos < size1) {
            if (currDouble->per_emp->getAppDate() > circularArrayLinkedList.getTemporaryarr()[currCir].data->getAppDate()) {

                if(currDouble->per_emp->getTitle()==title) {
                    cout << *(currDouble->per_emp);
                    break;
                }
                currDouble=currDouble->next;
                secondPos++;
            }
            else {
                if (circularArrayLinkedList.getTemporaryarr()[currCir].data->getTitle() == title) {
                    cout << *(circularArrayLinkedList.getTemporaryarr()[currCir].data);
                    break;
                }
                currCir=circularArrayLinkedList.getTemporaryarr()[currCir].next;
                firstPos++;
            }
        }
        else if (secondPos < size1) {
            if(currDouble->per_emp->getTitle()==title) {
                cout << *(currDouble->per_emp);
                break;
            }
            currDouble=currDouble->next;
            secondPos++;
        }
        else {
            if(circularArrayLinkedList.getTemporaryarr()[currCir].data->getTitle()==title) {
                cout << *(circularArrayLinkedList.getTemporaryarr()[currCir].data);
                break;
            }
            currCir=circularArrayLinkedList.getTemporaryarr()[currCir].next;
            firstPos++;
        }
    }
}

int main() {
    CircularArrayLinkedList circularArrayLinkedList;
    circularArrayLinkedList.fill_the_arr();
    DoubleDynamicLinkedList doubleDynamicLinkedList;

    while(true) {
        cout<<"__ Employee Recording System __"<<endl;
        cout<<"Please select for the following Menu Operation:"<<endl;
        cout<<"0) To exit press 0."<<endl;
        cout<<"1) Appointment of a new employee"<<endl;
        cout<<"2) Appointment of a transferred employee"<<endl;
        cout<<"3) Updating the title and salary coefficient of an employee"<<endl;
        cout<<"4) Deletion of an employee"<<endl;
        cout<<"5) Listing the information of an employee"<<endl;
        cout<<"6) Listing employees ordered by employee number"<<endl;
        cout<<"7) Listing employees ordered by appointment date"<<endl;
        cout<<"8) Listing employees appointed after a certain date"<<endl;
        cout<<"9) Listing employees assigned in a given year"<<endl;
        cout<<"10) Listing employees born before a certain date"<<endl;
        cout<<"11) Listing employess born in a particular month"<<endl;
        cout<<"12) Listing the information of the last assigned employee with a given title"<<endl;
        int n;
        cin >> n;
        if (n == 1) {
            int number, type;
            string name, surname, title;
            float salary_coef;

            cout << "Please type the employee number" << endl;
            cin >> number;
            if(circularArrayLinkedList.check(number) || doubleDynamicLinkedList.check(number)){
                cout<<"Sorry, there is an employee with this number."<<endl;
                continue;
            }

            cout << "Please type the employee type" << endl;
            cin >> type;

            cout << "Please type the employee name" << endl;
            getline(cin,name);
            getline(cin,name);

            cout << "Please type the employee surname" << endl;
            getline(cin,surname);

            cout << "Please type the employee title" << endl;
            getline(cin,title);

            cout << "Please type the employee salary coefficient" << endl;
            cin >> salary_coef;

            cout << "Please type the employee birthday" << endl;
            int day, month, year;
            cin >> day >> month >> year;
            Date birthday(abs(day), abs(month), abs(year));

            cout << "Please type the employee appointment date" << endl;
            cin >> day >> month >> year;
            Date appointmentday(abs(day), abs(month), abs(year));

            if (type == 1) {
                auto *newEmp = new PermanentEmployee(number, type, name, surname, title, salary_coef, birthday,
                                                     appointmentday,0);
                Node *newNode = new Node(newEmp);
                doubleDynamicLinkedList.insertEmployee(newNode);
            } else if (type == 0) {
                auto *newEmp = new TemporaryEmployee(number, type, name, surname, title, salary_coef, birthday,
                                                     appointmentday,0);
                auto *newNode = new NodeTemporary(newEmp);
                circularArrayLinkedList.insert(newNode);
            }
        } else if (n == 2) {
            int number, type;
            string name, surname, title;
            float salary_coef;
            int servicedays;

            cout << "Please type the employee number" << endl;
            cin >> number;

            if(circularArrayLinkedList.check(number) || doubleDynamicLinkedList.check(number)){
                cout<<"Sorry, there is an employee with this number."<<endl;
                continue;
            }

            cout << "Please type the employee type" << endl;
            cin >> type;

            cout << "Please type the employee name" << endl;
            getline(cin,name);
            getline(cin,name);

            cout << "Please type the employee surname" << endl;
            getline(cin,surname);

            cout << "Please type the employee title" << endl;
            getline(cin,title);

            cout << "Please type the employee salary coefficient" << endl;
            cin >> salary_coef;

            cout << "Please type the employee birthday" << endl;
            int day, month, year;
            cin >> day >> month >> year;
            Date birthday(abs(day), abs(month), abs(year));

            cout << "Please type the employee appointment date" << endl;
            cin >> day >> month >> year;
            Date appointmentday(abs(day), abs(month), abs(year));

            cout << "Please type the employee service_days" << endl;
            cin >> servicedays;
            if (type == 1) {
                PermanentEmployee *newEmp = new PermanentEmployee(number, type, name, surname, title, salary_coef, birthday,
                                                     appointmentday, servicedays);
                Node *newNode = new Node(newEmp);
                doubleDynamicLinkedList.insertEmployee(newNode);
            } else if (type == 0) {
                TemporaryEmployee *newEmp = new TemporaryEmployee(number, type, name, surname, title, salary_coef, birthday,
                                                     appointmentday, servicedays);
                NodeTemporary *newNode = new NodeTemporary(newEmp);
                circularArrayLinkedList.insert(newNode);
            }
        } else if (n == 3) {
            int emp_num;
            cout<<"Type the employee number which you want to update title and salary coefficient."<<endl;
            cin >> emp_num;
            bool control1=circularArrayLinkedList.check(emp_num);
            bool control2=doubleDynamicLinkedList.check(emp_num);
            if(!circularArrayLinkedList.check(emp_num) && !doubleDynamicLinkedList.check(emp_num)){
                cout<<"Sorry, there is no employee with this number."<<endl;
                continue;
            }
            if(control1){
                cout<<"Employee is found. Type the new salary coefficient and title."<<endl;
                double salaryco;
                cout<<"Type the salary coefficient."<<endl;
                cin>>salaryco;
                string title;
                cout<<"Type the title."<<endl;
                getline(cin,title);
                getline(cin,title);
                circularArrayLinkedList.update_title_and_salaryco(emp_num,salaryco,title);
            }else if(control2){
                cout<<"Employee is found. Type the new salary coefficient and title."<<endl;
                double salaryco;
                cout<<"Type the salary coefficient."<<endl;
                cin>>salaryco;
                string title;
                cout<<"Type the title."<<endl;
                getline(cin,title);
                getline(cin,title);
                doubleDynamicLinkedList.update_title_and_salaryco(emp_num,salaryco,title);
            }
        }else if (n == 4){
            int emp_num;
            cout<<"Type the number of employee which you want to delete."<<endl;
            cin>>emp_num;
            if(!circularArrayLinkedList.check(emp_num) && !doubleDynamicLinkedList.check(emp_num)){
                cout<<"Sorry, there is no employee with this number."<<endl;
                continue;
            }
            circularArrayLinkedList.del_the_emp(emp_num);
            doubleDynamicLinkedList.delete_emp(emp_num);
        }
        else if (n == 5){
            int emp_num;
            cout<<"Type the number of employee which you want to list."<<endl;
            cin>>emp_num;
            bool control1=circularArrayLinkedList.display_info_of_anEmployee(emp_num);
            bool control2= false;
            if(!control1)
                control2=doubleDynamicLinkedList.display_info_of_anEmployee(emp_num);
            if(!control1&&!control2)
                cout<<"There is no employee with this number."<<endl;
        }
        else if (n == 6){
            doubleDynamicLinkedList.bubbleSortForNumber();
            command6(circularArrayLinkedList,doubleDynamicLinkedList);
            doubleDynamicLinkedList.bubbleSortForAppDate();
        }
        else if (n == 7){
            circularArrayLinkedList.sortForAppDate();
            command7(circularArrayLinkedList,doubleDynamicLinkedList);
            circularArrayLinkedList.sortForNumber();

        }
        else if (n == 8){
            int day,month,year;
            cout<<"Please type the date."<<endl;
            cin >> day >> month >> year;
            Date appointmentday(abs(day), abs(month), abs(year));

            circularArrayLinkedList.sortForAppDateReverse();
            doubleDynamicLinkedList.bubbleSortForAppDateReverse();
            command8(circularArrayLinkedList,doubleDynamicLinkedList,appointmentday);
            doubleDynamicLinkedList.bubbleSortForAppDate();
            circularArrayLinkedList.sortForNumber();
        }
        else if (n == 9){
            int year;
            cout<<"Please type the year."<<endl;
            cin>>year;

            circularArrayLinkedList.sortForAppDate();
            command9(circularArrayLinkedList,doubleDynamicLinkedList,year);
            circularArrayLinkedList.sortForNumber();
        }
        else if (n == 10){
            int day,month,year;
            cout<<"Please type the date."<<endl;
            cin >> day >> month >> year;
            Date birthday(abs(day), abs(month), abs(year));

            doubleDynamicLinkedList.bubbleSortForNumber();
            command10(circularArrayLinkedList,doubleDynamicLinkedList,birthday);
            doubleDynamicLinkedList.bubbleSortForAppDate();
        }
        else if (n == 11){
            int month;
            cout<<"Please type the month."<<endl;
            cin>>month;

            doubleDynamicLinkedList.bubbleSortForNumber();
            command11(circularArrayLinkedList,doubleDynamicLinkedList,month);
            doubleDynamicLinkedList.bubbleSortForAppDate();

        }
        else if (n == 12){
            string title;
            cout<<"Please type the title."<<endl;
            getline(cin,title);
            getline(cin,title);

            doubleDynamicLinkedList.bubbleSortForAppDateReverse();
            circularArrayLinkedList.sortForAppDateReverse();
            command12(circularArrayLinkedList,doubleDynamicLinkedList,title);
            circularArrayLinkedList.sortForNumber();
            doubleDynamicLinkedList.bubbleSortForAppDate();
        }
        else if (n == 0){
            break;
        }
        cout<<"\nSelect a new option."<<endl;
    }



    return 0;
}
