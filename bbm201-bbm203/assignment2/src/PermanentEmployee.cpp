//
// Created by Berat on 26.11.2021.
//

#include "PermanentEmployee.h"


PermanentEmployee::PermanentEmployee(int employeeNumber, int employeeType, const string &name, const string &surname,
                                     const string &title, double salaryCo, const Date &birtdhay,
                                     const Date &appointmentDate, int lengthOfService) : Employee(employeeNumber,
                                                                                                  employeeType, name,
                                                                                                  surname, title,
                                                                                                  salaryCo, birtdhay,
                                                                                                  appointmentDate,
                                                                                                  lengthOfService) {}

