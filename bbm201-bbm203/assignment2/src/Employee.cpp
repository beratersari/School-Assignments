//
// Created by Berat on 27.11.2021.
//

#include "Employee.h"





const int Employee::getEmployeeNumber() const {
    return employee_number;
}


Employee::~Employee() {

}

Employee::Employee(const int employeeNumber, const int type, const string &name, const string &surname,
                   const string &title, double salaryCoef, const Date &birthday, const Date &appDate, int appLength)
        : employee_number(employeeNumber), type(type), name(name), surname(surname), title(title),
          salary_coef(salaryCoef), birthday(birthday), app_date(appDate), app_length(appLength) {}

const int Employee::getType() const {
    return type;
}

const string &Employee::getName() const {
    return name;
}

const string &Employee::getSurname() const {
    return surname;
}

const string &Employee::getTitle() const {
    return title;
}

double Employee::getSalaryCoef() const {
    return salary_coef;
}

const Date &Employee::getBirthday() const {
    return birthday;
}

const Date &Employee::getAppDate() const {
    return app_date;
}

int Employee::getAppLength() const {
    return app_length;
}

ostream &operator<<(ostream &os, const Employee &employee) {
    os<<"\nNumber: "<<employee.getEmployeeNumber()<<"\nTpye: "<<employee.getType()<<"\nName: "<<employee.getName()<<"\nSurname: "<<employee.getSurname()<<"\nTitle: "<<employee.getTitle()<<"\nSalaryco: "<<employee.getSalaryCoef()<<"\nBirthday: "<<employee.getBirthday()<<"\nAppointDate: "<<employee.getAppDate()<<"\nServicelen:"<<employee.getAppLength()<<endl;
    return os;
}

void Employee::setTitle(const string &title) {
    Employee::title = title;
}

void Employee::setSalaryCoef(double salaryCoef) {
    salary_coef = salaryCoef;
}
