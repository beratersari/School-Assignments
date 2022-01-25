//
// Created by Berat on 28.11.2021.
//

#ifndef ASS2LAST_NODETEMPORARY_H
#define ASS2LAST_NODETEMPORARY_H
#include "Employee.h"
#include "TemporaryEmployee.h"

class NodeTemporary {
public:
    NodeTemporary();

    TemporaryEmployee* data=NULL;
    int next=-1;

    NodeTemporary(TemporaryEmployee *data);

};

#endif //ASS2LAST_NODETEMPORARY_H
