//
// Created by Berat on 29.11.2021.
//

#include "TemporaryEmployee.h"



TemporaryEmployee::~TemporaryEmployee() {

}

TemporaryEmployee::TemporaryEmployee(const int employeeNumber, const int type, const string &name,
                                     const string &surname, const string &title, double salaryCoef, const Date &birthday,
                                     const Date &appDate, int appLength) : Employee(employeeNumber, type, name, surname,
                                                                                    title, salaryCoef, birthday,
                                                                                    appDate, appLength) {}
