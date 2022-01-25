//
// Created by Berat on 26.11.2021.
//
#include "iostream"
#include "Date.h"
using namespace std;
Date::Date(const int day, const int month, const int year) : day(day), month(month), year(year) {}

std::ostream &operator<<(std::ostream &os, const Date &date) {
    if( date.day/10==0)
        os <<"0"<<date.day<<"-";
    else
        os<<date.day<<"-";
    if(date.month/10==0)
        os<<"0"<<date.month<<"-";
    else
        os<<date.month<<"-";
    os<<date.year;
    return os;
}


bool Date::operator<(const Date &rhs) const {
    if( year<rhs.year){
        return true ;
    }else if(year>rhs.year){
        return false;
    }else{
        if(month<rhs.month){
            return true;
        }

        else if(month>rhs.month)
            return false;
        else{
            if(day<rhs.day){
                return true;
            }

            else if (day>rhs.day)
                return false;
        }
    }
    return false;
}

bool Date::operator==(const Date &rhs) const {
    return day == rhs.day &&
           month == rhs.month &&
           year == rhs.year;
}

bool Date::operator!=(const Date &rhs) const {
    return !(rhs == *this);
}

Date::Date(const Date &date1) : day(date1.day), month(date1.month),year(date1.year) {
}

Date::Date() {}

bool Date::operator>(const Date &rhs) const {
    if( year>rhs.year){
        return true ;
    }else if(year<rhs.year){
        return false;
    }else{
        if(month>rhs.month){
            return true;
        }

        else if(month<rhs.month)
            return false;
        else{
            if(day>rhs.day){
                return true;
            }

            else if (day<rhs.day)
                return false;
        }
    }
    return false;
}

int Date::getDay() const {
    return day;
}

int Date::getMonth() const {
    return month;
}

int Date::getYear() const {
    return year;
}

