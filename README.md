# ADS Assignment 3

## Overview
This Java project implements 2 data structures without recursion: Hash table and Binary Search Tree (BST)

## Project Structure
src/Main.java - Contains example usage and testing

src/MyHashTable.java - Custom hash table with separate chaining

src/MyTestingClass.java - Custom key class with manual hashCode

src/Student.java - Storing student data

src/BST.java - Generic binary search tree with inner Entry class

## Project's work
### Classes

#### Main
Demonstrates usage of MyHashTable and BST.

Tests insertion of 10,000 random elements and prints bucket distributions.


#### MyHashTable
Implements a generic hash table using separate chaining.

There are methods like hash, put, remove, get, contains, getKey, getNumberOfBuckets, getBucketSize


#### BST
Implements generic binary search tree

Provided:

size field to track number of elements,

Entry inner class for key-value storage,

In-order traversal iterator with access to both key and value.


#### MyTestingClass
Custom class used as keys for MyHashTable.

Implements its own hashCode() method (no use of Objects.hash()).

Tuned to ensure uniform distribution across buckets.


#### Student
Represents student data with fields id, name, age, grade.

Used as values in the hash table for testing purposes.


## Setup & Run
### Prerequisites

Install Java JDK 17+  

### Compile the Program

Navigate to the `src` folder and compile:
javac Main.java

### Run the Program (checking various functions)
java Main
