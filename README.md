OrderSipRepeat is a desktop application that proposes to function as a coffee and milk tea ordering system.

I. Data Structures and Abstract Data Types
    - ArrayList for Menu Items (items): Stores available menu items.
    - Stacks for Order Management (MyStack).
    - Queue for Orders (MyQueue).
    - ArrayList for Orders for claim (ordersForClaim).

The program employs an array list named items to store the menu items, showcasing a fundamental data structure. 
It also utilizes two custom classes, MyStack and MyQueue, which implement the stack and queue abstract data types using linked lists.

II. Stack Implementation
    - The MyStack class is used to manage order items and their respective prices:
            > orderStack: Stores strings representing order items.
            > amountStack: Stores the corresponding prices for each item.
    - The stack's LIFO (Last In, First Out) structure is essential for:
            > Tracking the order in which items are added.
            > Implementing the undo functionality for removing the most recent item.

III. Queue Implementation
    - The MyQueue class is used to manage the order numbers of completed orders:
            > orderQueue: Enqueues order numbers when payment is processed.
    - The queue's FIFO (First In, First Out) structure ensures that orders are retrieved in the same sequence they were placed, 
        facilitating order tracking and claim processes.

IV. Sorting
    - The program dynamically sorts menu items within a dropdown menu (combo box) based on user-selected criteria (Category Name, or Price).

V. Searching
    - When an order is claimed, the program searches the ordersForClaim ArrayList for the matching order number to remove it from the arraylist. 


VI. Display of Data Structures
    - Order Stack and Amount Stack: Displayed in the "Orders" panel, showing items and prices in the order they were added.
    - Order Queue: Displayed in the "Order Queue" section, showing order numbers in FIFO order.
    - Orders for Claim ArrayList: Displayed in the "Orders for Claim" section, showing order numbers ready for claiming.

VII. Graphical User Interface (GUI)
    - Place Order Section: User selects items, customizes options, and adds to order.
    - Payment Window: Prompts for payment and calculates change.
    - Receipt Window: Displays order details and number.
    - Order Queue Display: Shows order numbers in the queue.
    - Orders for Claim Display: Shows order numbers ready for claiming.
