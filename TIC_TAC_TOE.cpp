#include <bits/stdc++.h>
using namespace std;

int num[3][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

bool Draw(string arr[][3], int step)
{
    if (step > 9)
    {
        return true;
    }
    return false;
}
//checking if entered position is already occupied or not
bool Overwrite(int i, int j,string arr[][3])
{
    if (arr[i][j] == "X" || arr[i][j] == "O")
    {
        cout << "Position already occupied !!" << endl;
        cout << "Try another one" << endl;
        return true;
    }
    return false;
}


//checking for a winner
bool check(string arr[][3], string n)
{
    if (arr[0][0] == n && arr[0][1] == n && arr[0][2] == n)
    {
        return true;
    }
    else if (arr[0][0] == n && arr[1][0] == n && arr[2][0] == n)
    {
        return true;
    }
    else if (arr[2][0] == n && arr[2][1] == n && arr[2][2] == n)
    {
        return true;
    }
    else if (arr[2][2] == n && arr[1][2] == n && arr[0][2] == n)
    {
        return true;
    }
    else if (arr[0][0] == n && arr[1][1] == n && arr[2][2] == n)
    {
        return true;
    }
    else if (arr[2][0] == n && arr[1][1] == n && arr[0][2] == n)
    {
        return true;
    }
    else if (arr[1][0] == n && arr[1][1] == n && arr[1][2] == n)
    {
        return true;
    }
    else if (arr[0][1] == n && arr[1][1] == n && arr[2][1] == n)
    {
        return true;
    }

    return false;
}
//Dislaying the board
void Display(string arr[][3])
{
    cout << endl;
    cout << "---------------------------" << endl;
    cout << endl;
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            cout << "   " << arr[i][j] << "   ";
        }
        cout << endl;
        cout << endl;
    }
    cout << "---------------------------" << endl;
    cout << endl;
}
//Finding the index to place the X or O from given user position
void indexFinder(int x, int &i, int &j, int num[][3])
{
    i = 0, j = 2;
    while (i < 3 && j < 3)
    {
        if (num[i][j] > x)
        {
            j--;
        }
        else if (num[i][j] < x)
        {
            i++;
        }
        else
        {
            break;
        }
    }
}
//Taking input from player 1
void inputp1(int &p1, string arr[][3], string pl1)
{
    Display(arr);
    cout << pl1 << "'s turn -> (X)" << endl;
    cout << "Enter the position : ";
    cin >> p1;
    if (p1 < 1 || p1 > 9)
    {
        cout << "Entered position is out of range!!" << endl;
        inputp1(p1, arr, pl1);
    }
    int i, j;
    indexFinder(p1, i, j, num);
    if(Overwrite(i,j,arr)){
        inputp1(p1, arr, pl1);
    }
    else{
        arr[i][j] = 'X';
    }
}

// Taking input from player 2
void inputp2(int &p2, string arr[][3], string pl2)
{
    Display(arr);
    cout << pl2 << "'s turn -> (O)" << endl;
    cout << "Enter the position : ";
    cin >> p2;
    if (p2 < 1 || p2 > 9)
    {
        cout << "Entered position is out of range!!" << endl;
        inputp2(p2, arr, pl2);
    }
    int i, j;
    indexFinder(p2, i, j, num);
    if(Overwrite(i,j,arr)){
        inputp2(p2, arr, pl2);
    }
    else{
        arr[i][j] = 'O';
    }
}

int main()
{
    string arr[3][3];
    int count = 1;
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            arr[i][j] = to_string(count);
            count++;
        }
    }
    string player1;
    string player2;
    cout << "Player 1 enter your name : ";
    cin >> player1;
    cout << "Player 2 enter your name : ";
    cin >> player2;
    cout << endl;
    cout << player1 << " has been alloted X!" << endl;
    cout << player2 << " has been alloted O!" << endl;
    int p1, p2;
    int step = 1;
    while (true)
    {
        if (Draw(arr, step))
        {
            Display(arr);
            cout << "Game drawn! No one wins" << endl;
            break;
        }
        if (step % 2)
        {
            inputp1(p1, arr, player1);
        }
        else
        {
            inputp2(p2, arr, player2);
        }
        if (check(arr, "X"))
        {
            Display(arr);
            cout << player1 << " has won the game!!!" << endl;
            break;
        }
        if (check(arr, "O"))
        {
            Display(arr);
            cout << player2 << " has won the game!!!" << endl;
            break;
        }
        step++;
    }
    return 0;
}