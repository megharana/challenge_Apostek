You are given an array of size N  in which the value of the elements are either 0 or 1. All the elements of array are numbered from position 0 to N-1 .You are given some queries which can be of following 2 types.

0 index : In this type of query you have to find the nearest left and nearest right element from position  in the array whose value is .
1 index : In this type of query you need to change the value at positon  to  if its previous value is 0 or else leave it unchanged.

#Important Note :
If there is no position with value 1 on the left side of any index in query then print -1 instead of left index and similarly if there is no value 1 in right side of the value index in that query then print -1 in place of the answer for right element.

#Sample Input
7 4
1 0 0 0 1 0 1
0 1
0 5
1 2
0 2

#Sample Output
0 4
4 6
0 4

#Explanation

The First query is 0 1. So the nearest 1 in left side from index 1 is element at index 0 and in right side the element is at index 4.

Similarly, the second query is 0 5. So the nearest 1 in left side from index 5 is element at index 4 and in right side the element is at index 6.

The third query is 1 2. So set the value equal to 1 of the element at index 2.

The Fourth query is 0 2. So the nearest 1 in left side from index 1 is element at index 2 and in right side the element is at index 4.