//
// Created by Berat on 29.11.2021.
//

#ifndef ASS2LAST_TEMPORARYEMPLOYEE_H
#define ASS2LAST_TEMPORARYEMPLOYEE_H

#include "Employee.h"
class TemporaryEmployee:public Employee {
public:
    TemporaryEmployee(const int employeeNumber, const int type, const string &name, const string &surname,
                      const string &title, double salaryCoef, const Date &birthday, const Date &appDate, int appLength);

    virtual ~TemporaryEmployee();


};


#endif //ASS2LAST_TEMPORARYEMPLOYEE_H
