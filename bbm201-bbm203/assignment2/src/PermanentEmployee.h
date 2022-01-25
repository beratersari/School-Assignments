//
// Created by Berat on 26.11.2021.
//

#ifndef BBM201ASSIGNMENT2_PERMANENTEMPLOYEE_H
#define BBM201ASSIGNMENT2_PERMANENTEMPLOYEE_H

#include "Employee.h"
class PermanentEmployee: public Employee {
public:
    PermanentEmployee(int employeeNumber, int employeeType, const string &name, const string &surname,
                      const string &title, double salaryCo, const Date &birtdhay, const Date &appointmentDate,
                      int lengthOfService);


};


#endif //BBM201ASSIGNMENT2_PERMANENTEMPLOYEE_H
