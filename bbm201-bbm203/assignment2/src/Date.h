//
// Created by Berat on 26.11.2021.
//

#ifndef BBM201ASSIGNMENT2_DATE_H
#define BBM201ASSIGNMENT2_DATE_H


#include <ostream>

class Date {
private:
    int day;
    int month;
    int year;
public:
    Date();

    Date(int day, int month, int year);
    Date(Date const &date1);

    int getDay() const;

    int getMonth() const;

    int getYear() const;

    friend std::ostream &operator<<(std::ostream &os, const Date &date);

    bool operator<(const Date &rhs) const;

    bool operator>(const Date &rhs) const;

    bool operator==(const Date &rhs) const;

    bool operator!=(const Date &rhs) const;


};


#endif //BBM201ASSIGNMENT2_DATE_H
