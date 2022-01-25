#include <iostream>
#include <fstream>
#include <sstream>
using namespace std;
int static counter=0;

// this function prints the grid
void print_table(int** matrix,int n,ofstream& output){
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            output<<matrix[i][j]<<" ";
        }
        output << endl;
    }
}
//this function create a 2d pointer array(size[9][2] because the length of the longest link can be 9.)
void create_links(int** links,int n){
    for (int i = 0; i < 9; i++) {
        links[i] = new int[2];
    }
    for(int i=0;i<9;i++){
        links[i][0]=n+1;
        links[i][1]=n+1;
    }
}
// this function checks if an element has been added to the list of links
bool check_whether_element_exists_or_not(int** links, int x, int y, int n ){
    for(int i=0;i<9;i++){
        if(links[i][0]==x and links[i][1]==y){
            return true;
        }
    }
    return false;
}

// this is a recursive funtion to find which elements are linked each other.
void find_links(int** table,int** links, int x, int y,int n){
    int currval=table[x][y];
    if(counter==0){
        links[counter][0]=x;
        links[counter][1]=y;
        counter++;
    }
    if(x-1>-1 and !check_whether_element_exists_or_not(links, x - 1, y, n) and table[x - 1][y] == currval and table[x - 1][y] != 0){
        links[counter][0]=x-1;
        links[counter][1]=y;
        counter++;
        find_links( table,links, x-1,  y,n);
    }
    if(x+1<n and !check_whether_element_exists_or_not(links, x + 1, y, n) and table[x + 1][y] == currval and table[x + 1][y] != 0){
        links[counter][0]=x+1;
        links[counter][1]=y;
        counter++;
        find_links( table,links, x+1,  y,n);
    }
    if(y-1>-1 and !check_whether_element_exists_or_not(links, x, y - 1, n) and table[x][y - 1] == currval and table[x][y - 1] != 0){
        links[counter][0]=x;
        links[counter][1]=y-1;
        counter++;
        find_links( table,links, x,  y-1,n);
    }
    if(y+1<n and !check_whether_element_exists_or_not(links, x, y + 1, n) and table[x][y + 1] == currval and table[x][y + 1] != 0){
        links[counter][0]=x;
        links[counter][1]=y+1;
        counter++;
        find_links( table,links, x,  y+1,n);
    }
}

int main(int argc,char** argv) {
    ofstream output(argv[3]);
    ifstream input(argv[1]);

    //this code block creates the grid.
    int n;
    input>>n;
    int **matrix = new int *[n];
    for (int i = 0; i < n; i++) {
        matrix[i] = new int[n];
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            matrix[i][j]=0;
        }
    }

    while(input.good()){
        //this code block takes the input
        int x = 0;
        int y = 0;
        int z = 0;
        input>>x>>y>>z;
        matrix[y][z]=x;
        int **links=new int*[2*(n-1)];
        create_links(links,n);
        find_links(matrix,links, y, z, n);

        if(counter>2){
            //if length of the link is greater than 2, increment the major element and this code block changes other elements to 0
            matrix[links[0][0]][links[0][1]]=x+1;
            for(int i=1;i<9;i++){
                if(links[i][0]!=n+1){
                    matrix[links[i][0]][links[i][1]]=0;
                }
            }

            //this code blocks checks whether there is a another links after the increment
            int control=3;
            while(control--){
                counter=0;
                int **links1=new int*[2*(n-1)];
                create_links(links1,n);
                find_links(matrix,links1, y, z, n);
                if(counter>2){
                    matrix[links1[0][0]][links1[0][1]]=matrix[links1[0][0]][links1[0][1]]+1;
                    for(int i=1;i<9;i++){
                        if(links1[i][0]!=n+1){
                            matrix[links1[i][0]][links1[i][1]]=0;
                        }
                    }
                }
            }
        }
        counter=0;
    }
    output<<"PART 1: "<<endl;
    print_table(matrix,n,output);
    input.close();
    output<<endl;


    // PART 2
    output<<"PART 2:"<<endl;
    //this code block create the grid
    ifstream input2(argv[2]);
    input2>>n;
    int table[n][n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            int k;
            input2>>k;
            table[i][j]=k;
        }
    }
    int totalpuan=0;
    while(input2.good()){

        //this code block takes the position of the bomb.
        int x,y,counter1=0;
        input2>>x>>y;
        int val=table[x][y];
        int counter10=1;

        //this for loop finds the same elements which are in same row or column or diagonal position
        for(int i=0;i<n;i++){
            if(table[i][y]==val){
                table[i][y]=0;
                counter1++;
            }
            if(table[x][i]==val){
                table[x][i]=0;
                counter1++;
            }
            if(x-counter10>-1 and y+counter10<n and table[x-counter10][y+counter10]==val){
                table[x-counter10][y+counter10]=0;
                counter1++;
            }
            if(x-counter10>-1 and y-counter10>-1 and table[x-counter10][y-counter10]==val){
                table[x-counter10][y-counter10]=0;
                counter1++;
            }
            if(x+counter10<n and y-counter10>-1 and table[x+counter10][y-counter10]==val){
                table[x+counter10][y-counter10]=0;
                counter1++;
            }
            if(x+counter10<n and y+counter10<n and table[x+counter10][y+counter10]==val){
                table[x+counter10][y+counter10]=0;
                counter1++;
            }
            counter10++;
        }
        totalpuan+= counter1*val;
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            output<< table[i][j]<<" ";
        }
        output<< endl;
    }
    output<<"Final Point: "<<totalpuan<<"p";
}