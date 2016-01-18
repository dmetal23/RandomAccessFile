# RandomAccessFile
Idea: We will be using external hashing to show the ability to insert and find items in a
RandomAccessFile.

Requirements: A BigInteger key (where key could be contained in a 23 byte integer) and a BigInteger value (where value could be contained in a 1000 byte integer).

We will store Items in an external hash table with 230 slots, each slot can hold 4 Items, and h(key) = key % 230

To elaborate, we will have a file called info.dat that consists of 230 pages where each page is 4096 bytes. In the
file, the presence of an item will be represented by a single byte that is zero and the item will follow (23 bytes for
the key and 1000 bytes for the value). Additionally write a driver that allows for user interaction (as shown below)
and a status.txt file.

Use Driver4.java to run the program. 
