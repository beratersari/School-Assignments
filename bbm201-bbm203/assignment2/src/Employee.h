//
// Created by Berat on 27.11.2021.
//

#ifndef ASS2LAST_EMPLOYEE_H
#define ASS2LAST_EMPLOYEE_H
#include "ostream"
#include "string"
#include "Date.h"
using namespace std;

class Employee {
private:
    const int employee_number;
    const int type;
    const string name;
    const string surname;
    string title;
    double salary_coef;
    const Date birthday;
    const Date app_date;
    int app_length=0;
public:
    Employee(const int employeeNumber, const int type, const string &name, const string &surname, const string &title,
             double salaryCoef, const Date &birthday, const Date &appDate, int appLength);
    virtual ~Employee();
    const int getEmployeeNumber() const;
    const int getType() const;
    const string &getName() const;
    const string &getSurname() const;
    const string &getTitle() const;
    double getSalaryCoef() const;
    const Date &getBirthday() const;
    const Date &getAppDate() const;
    int getAppLength() const;
    void setTitle(const string &title);
    void setSalaryCoef(double salaryCoef);
    friend ostream &operator<<(ostream &os, const Employee &employee);
};


#endif //ASS2LAST_EMPLOYEE_H
