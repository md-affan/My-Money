Solution for Geektrust Backend Challenge - [MyMoney](https://github.com/md-affan/My-Money/edit/main/README.md#:~:text=Geektrust%20Backend%20Challenge%20%2D-,MyMoney,-Problem%20Statement%20MyMoney)

Problem Statement
MyMoney platform lets investors consolidated portfolio value across equity, debt, and gold. We need to ensure that the desired allocation percentages are equal to the actual percentages invested. The desired allocation percentage should be derived from the initial allocation made.

The program should take as input:

The money allocated in equity, debt and gold funds.
Monthly SIP payments.
Monthly change rate (loss or growth) for each type of fund.
The output should be:

Balanced amount of each fund for a certain month.
Rebalanced amount of each month if applicable.
The supported commands are:
ALLOCATE, SIP, CHANGE, BALANCE, REBALANCE

[Complete problem statement](https://github.com/md-affan/My-Money/edit/main/README.md#:~:text=Geektrust%20Backend%20Challenge%20%2D-,MyMoney,-Problem%20Statement%20MyMoney)

Assumptions
From Problem Statement
The money allocated in equity, debt and gold funds.
Monthly SIP payments.
Monthly change rate (loss or growth) for each type of fund.
Additional Assumptions Made
Only 3 allocation class are currently available.
The default input order for asset class is - EQUITY, DEBT, GOLD.
All the inputs must be explicitly provided, no default value as 0 is used.
SIP, Change percentages can be declared only once for a month.
The system only works for 1-year (Jan-Dec) as there is no way to distinguish between years from input.
