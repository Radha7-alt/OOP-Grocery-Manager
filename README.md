📦 OOP Grocery Manager

A group project for CS 3354 – Object-Oriented Programming demonstrating teamwork, Git branching workflow, and implementation of a grocery inventory manager using parallel arrays in Java.

👥 Team Members

Radha Kumari Yadav – Task 1 (Inventory Display), Repository Owner

Justin Andrade – Task 2 (Restock & Search)

Snow Karki – Task 3 (Menu System)

🧩 Project Overview

This project uses three parallel arrays to store grocery item data:

String[] itemNames = new String[10];
double[] itemPrices = new double[10];
int[] itemStocks = new int[10];

Each index represents one item (name, price, stock).

The project includes:

✔ Task 1 – Inventory Display

Branch: feature-display
Method:

printInventory(String[] names, double[] prices, int[] stocks)
✔ Task 2 – Restock & Search

Branch: feature-restock
Method:

restockItem(String[] names, int[] stocks, String target, int amount)
✔ Task 3 – Menu System

Branch: feature-menu
Implements user input and integrates Tasks 1 & 2:

1 – View Inventory
2 – Restock Item
3 – Exit
🧪 How to Run

Clone the repository:

git clone https://github.com/Radha7-alt/OOP-Grocery-Manager.git

Compile:

javac GroceryManager.java

Run:

java GroceryManager
📄 Documentation (Javadoc)

Javadoc is generated inside the docs/ folder:

docs/
   index.html
   GroceryManager.html

To view documentation, open docs/index.html in any browser.
