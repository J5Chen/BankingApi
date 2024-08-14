# Banking Api

## Overview
This is a Banking Transactions API built with Spring Boot and Maven. Can be built using maven in your ide after cloning the repository. 

## Endpoints
Account Endpoints
    
    GET /api/accounts - Retrieve a list of all accounts.
    
    GET /api/accounts/{id} - Retrieve a specific account by its ID.
    
    POST /api/accounts - Create a new account.

Transaction Endpoints

    GET /api/transactions - Retrieve a list of all transactions.
    
    GET /api/transactions/{id} - Retrieve a specific transaction by its ID.

Additional Endpoints

    POST /api/accounts/transfer - Handles a Transactions.

## Assumptions

    - Value of transaction can't be negative
    - Each account needs a First and Last Name
